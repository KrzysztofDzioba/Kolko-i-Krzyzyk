package edu.dzioba;

import edu.dzioba.Board.Board;
import edu.dzioba.Board.BoardDimensions;
import edu.dzioba.Board.BoardPrinter;
import edu.dzioba.Board.Coordinates;
import edu.dzioba.Game.Game;
import edu.dzioba.Game.GameSessionManager;
import edu.dzioba.Game.Games;
import edu.dzioba.Messaging.Journalist;
import edu.dzioba.Messaging.Language;
import edu.dzioba.Messaging.Messages;
import edu.dzioba.Players.Player;
import edu.dzioba.Players.Players;
import edu.dzioba.Players.Sign;
import edu.dzioba.UserInputHandling.InputConverter;
import edu.dzioba.UserInputHandling.InputValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class ApplicationTest {

    private Sign sampleSign = Sign.X;
    private InputValidator validator;
    private Players players;
    private BoardDimensions sampleBoardDimensions;
    private Journalist sampleJournalist;

    @BeforeMethod
    private void setUp() {
        players = new Players(Arrays.asList(new Player("foo", Sign.X), new Player("bar", Sign.O)), Sign.X);
        sampleBoardDimensions = new BoardDimensions(3,3);
        sampleJournalist = new Journalist(Locale.ENGLISH, System.out::println);
        validator = new InputValidator();
    }

    @Test
    public void games_returns_true_if_there_is_end_of_gameSession_because_3_games_were_played() {
        //given
        Games games = new Games(Games.initializeGames(sampleBoardDimensions));
        games.setBoardDimensions(sampleBoardDimensions);
        games.addNewGame();
        games.addNewGame();
        //when
        boolean gameSessionEnded = games.threeGamesWerePlayed();
        //then
        assertTrue(gameSessionEnded);
    }

    @Test
    public void can_give_name_to_the_player() {
        //given
        Player player = new Player("Foo", sampleSign);
        String playerName = "Foo";
        //when
        player.setName(playerName);
        //then
        assertEquals(player.getName(), playerName);
    }

    @Test
    public void can_add_player_to_Players_in_Game() {
        //given
        Player player = new Player("Foo", sampleSign);
        Players players = new Players(new ArrayList<>(), null);
        //when
        boolean playerAdded = players.addPlayer(player);
        //then
        assertTrue(playerAdded);
    }

    @Test
    public void game_session_manager_has_its_own_journalist() {
        //given
        GameSessionManager manager = new GameSessionManager(new Scanner(System.in)::nextLine,
                                                            new String[]{},
                                                            new InputConverter(), new InputValidator(),
                                                            System.out::println);
        //when
        Journalist journalist = manager.getJournalist();
        //then
        assertTrue(journalist instanceof Journalist);
    }

    @Test
    public void players_knows_current_player() {
        //given
        Player player1 = new Player("foo", Sign.X);
        Player player2 = new Player("bar", Sign.O);
        //when
        Players players = new Players(Arrays.asList(player1, player2), Sign.X);
        //then
        assertSame(players.getCurrentPlayer(), player1);
    }

    @Test
    public void it_is_possible_to_create_board_with_specific_width() {
        //given
        int exampleWidth = 3;
        int exampleHeight = 5;
        BoardDimensions dimensions = new BoardDimensions(exampleWidth, exampleHeight);
        //when
        Board board = new Board(dimensions);
        //then
        assertEquals(board.getDimensions().width, exampleWidth);
    }

    @Test
    public void it_is_possible_to_create_board_with_specific_height() {
        //given
        int exampleWidth = 3;
        int exampleHeight = 5;
        //when
        Board board = new Board(new BoardDimensions(exampleWidth, exampleHeight));
        //then
        assertEquals(board.getDimensions().height, exampleHeight);
    }

    @Test
    public void returns_false_if_provided_board_dimensions_are_incorrect() {
        //given
        String exampleBoardSize = "a, b";
        //when
        boolean correctDimensions = validator.properBoardSizeInput(exampleBoardSize);
        //then
        assertFalse(correctDimensions);
    }

    @Test
    public void returns_true_if_provided_board_dimensions_are_correct() {
        //given
        String exampleBoardSize = "1,55";
        //when
        boolean correctDimensions = validator.properBoardSizeInput(exampleBoardSize);
        //then
        assertTrue(correctDimensions);
    }

    @Test
    public void players_returns_next_player() {
        //given
        Player player1 = new Player("foo", Sign.X);
        Player player2 = new Player("bar", Sign.O);
        Players players = new Players(Arrays.asList(player1, player2), Sign.O);
        //when
        Player currentPlayer = players.getNextPlayer();
        //then
        assertEquals(currentPlayer, player1);
    }

    @Test
    public void it_is_possible_to_set_up_current_player() {
        //given
        Player player1 = new Player("foo", Sign.X);
        Player player2 = new Player("bar", Sign.O);
        Players players = new Players(Arrays.asList(player1, player2), null);
        //when
        players.setCurrentPlayer(Sign.X);
        //then
        assertEquals(players.getCurrentPlayer(), player1);
    }

    @Test
    public void journalist_says_proper_message_if_arguments_are_provided() {
        //given
        Journalist journalist = sampleJournalist;
        String parameter = "Foo";
        //when
        String output = journalist.sayMessageWithParameters(Messages.test_message, parameter);
        //then
        assertEquals(output, "This is my name: Foo");
    }

    @Test
    public void journalist_says_proper_message_if_arguments_are_not_provided_to_say_message_with_parameters_method() {
        //given
        Journalist journalist = sampleJournalist;
        //when
        String output = journalist.sayMessageWithParameters(Messages.test_message, null);
        //then
        assertEquals(output, "This is my name: ");
    }

    @Test
    public void input_validator_returns_true_if_provided_user_coordinates_are_correct() {
        //given
        InputValidator validator = new InputValidator();
        String userInput = "1 1";
        //when
        boolean validCoordinates = validator.properCoordinatesSchema(userInput);
        //then
        assertTrue(validCoordinates);
    }

    @Test
    public void input_validator_returns_false_if_provided_user_coordinates_are_correct() {
        //given
        InputValidator validator = new InputValidator();
        String userInput = "ac2";
        //when
        boolean validCoordinates = validator.properCoordinatesSchema(userInput);
        //then
        assertTrue(!validCoordinates);
    }

    @Test
    public void input_converter_gives_proper_coordinates() {
        //given
        InputConverter converter = new InputConverter();
        String userInput = "1 2";
        //when
        Coordinates cords = converter.getCoordinates(userInput);
        //then
        assertEquals(cords.getRow(), 1);
        assertEquals(cords.getCol(), 2);
    }

    @Test
    public void insert_coordinates_puts_given_sign_into_a_board() {
        //given
        Board board = new Board(sampleBoardDimensions);
        int sampleRow = 2;
        int sampleCol = 2;
        Coordinates cords = new Coordinates(sampleRow, sampleCol);
        //when
        board.insertCoordinates(cords, sampleSign);
        //then
        assertEquals(board.getField(cords), Sign.X);
    }

    @Test
    public void players_can_return_currents_player_sign() {
        //given
        players.setCurrentPlayer(Sign.X);
        //when
        Sign sign = players.getCurrentsPlayerSign();
        //then
        assertEquals(sign, Sign.X);
    }

    @Test
    public void validator_returns_true_if_provided_coordinates_are_inside_a_board() {
        //given
        BoardDimensions dimensions = new BoardDimensions(2, 2);
        Coordinates cords = new Coordinates(2, 2);
        //when
        boolean cordsInsideABoard = validator.coordinatesInBoard(dimensions, cords);
        //then
        assertTrue(cordsInsideABoard);
    }

    @Test
    public void validator_returns_false_if_provided_null_to_check_coordinates_schema() {
        //given
        String userInput = null;
        //when
        boolean wrongSchema = validator.properCoordinatesSchema(userInput);
        //then
        assertTrue(!wrongSchema);
    }

    @Test
    public void validator_returns_false_if_provided_1_word_to_check_coordinates_schema() {
        String userInput = "Foo";
        //when
        boolean wrongSchema = validator.properCoordinatesSchema(userInput);
        //then
        assertFalse(wrongSchema);
    }

    @Test
    public void validator_returns_true_if_in_given_coord_there_is_no_sign() {
        //given
        Coordinates sampleCoords1 = new Coordinates(1, 1);
        //when
        boolean fieldIsEmpty = validator.coordsAreEmptyInBoard(new Board(sampleBoardDimensions), sampleCoords1);
        //then
        assertTrue(fieldIsEmpty);
    }

    @Test
    public void validator_returns_false_if_in_given_coord_there_is_a_sign() {
        //given
        Coordinates sampleCoords1 = new Coordinates(1, 1);
        Board board = new Board(sampleBoardDimensions);
        board.insertCoordinates(sampleCoords1, sampleSign);
        //when
        boolean fieldIsEmpty = validator.coordsAreEmptyInBoard(board, sampleCoords1);
        //then
        assertTrue(!fieldIsEmpty);
    }

    @Test
    public void manager_is_able_to_add_given_number_of_points_to_the_player() {
        //given
        int wonPoints = 3;
        Player playerWhoWon = new Player("foo", Sign.X);
        //when
        playerWhoWon.addPoints(wonPoints);
        //then
        assertEquals(playerWhoWon.getPoints(), 3);
    }

    @Test
    public void get_winner_method_returns_player_with_more_points() {
        //given
        Player player1 = new Player("foo", Sign.X);
        Player player2 = new Player("bar", Sign.O);
        Players players = new Players(Arrays.asList(player1, player2), Sign.X);

        player1.addPoints(3);
        player1.addPoints(3);
        player2.addPoints(3);
        //when
        Player winner = players.getWinner();
        //then
        assertEquals(winner, player1);
    }

    @Test
    public void get_winner_method_returns_null_if_both_players_have_same_amount_of_points() {
        //given
        Player player1 = new Player("foo", Sign.X);
        Player player2 = new Player("bar", Sign.O);
        Players players = new Players(Arrays.asList(player1, player2), Sign.X);

        player1.addPoints(3);
        player2.addPoints(3);
        //when
        Player winner = players.getWinner();
        //then
        assertNull(winner);
    }

    @Test
    public void board_is_draw_returns_true_if_there_is_a_draw_in_current_game() {
        //given
        Board board = new Board(new BoardDimensions(2, 2));
        board.insertCoordinates(1, 1, Sign.X);
        board.insertCoordinates(1, 2, Sign.X);
        board.insertCoordinates(2, 1, Sign.O);
        board.insertCoordinates(2, 2, Sign.O);
        //when
        boolean isDraw = board.isDraw();
        //then
        assertTrue(isDraw);
    }

    @Test
    public void board_is_draw_returns_false_if_there_is_a_draw_in_current_game() {
        //given
        Board board = new Board(new BoardDimensions(2, 2));
        board.insertCoordinates(1, 1, Sign.X);
        board.insertCoordinates(1, 2, Sign.X);
        board.insertCoordinates(2, 1, Sign.O);
        //when
        boolean isDraw = board.isDraw();
        //then
        assertFalse(isDraw);
    }

    @Test
    public void board_printer_prints_board_with_proper_amount_of_X_signs() {
        //given
        Board board = new Board(new BoardDimensions(5, 10));
        board.insertCoordinates(1, 1, Sign.X);
        board.insertCoordinates(2, 1, Sign.X);
        board.insertCoordinates(3, 3, Sign.O);
        BoardPrinter boardPrinter = new BoardPrinter(board, sampleJournalist);
        //when
        String boardStr = boardPrinter.printBoard();
        //then
        long xSignsInBoard = boardStr.chars().filter(myChar -> myChar =='X').count();
        assertEquals(xSignsInBoard, 2);
    }

    @Test
    public void test_coordinates_equals_returns_false_if_object_is_not_type_of_coordinates() {
        //given
        Coordinates coords = new Coordinates(1, 1);
        Integer sampleObject = 1;
        //when
        boolean areEqual = coords.equals(sampleObject);
        //then
        assertFalse(areEqual);
    }

    @Test
    public void manager_createJournalistMethod_still_returns_journalist_if_wrong_language_is_provided() {
        //given
        String wrongLanguage = "xyz";
        String[] programArguments = {wrongLanguage};
        //when
        GameSessionManager manager = new GameSessionManager(new Scanner(System.in)::nextLine,
                                                            programArguments,
                                                            new InputConverter(), new InputValidator(),
                                                            System.out::println);
        Journalist journalist = manager.getJournalist();
        //then
        assertNotNull(journalist);
    }

    @Test
    public void InputConverter_parseToInteger_method_parses_String_to_Integer_correctly() {
        //given
        InputConverter converter = new InputConverter();
        //when
        Integer parsed = converter.parseToInteger("1");
        //then
        assertNotNull(parsed);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void InputConverter_parseToInteger_method_throws_NumberFormatException_if_wrong_string_provided() {
        //given
        InputConverter converter = new InputConverter();
        String strangeString = "xyz";
        //when
        Integer parsed = converter.parseToInteger(strangeString);
        //then
        // exception thrown
    }

    @Test
    public void InputValidator_properWinningNumberMethod_returns_false_if_user_provided_not_convertible_Integer() {
        //given
        String userInputWinningNumber = "xyz";
        InputValidator validator = new InputValidator();
        //when
        boolean properIntFormat = validator.properWinningNumber(userInputWinningNumber, sampleBoardDimensions);
        //then
        assertFalse(properIntFormat);
    }

    @Test
    public void InputValidator_properWinningNumberMethod_returns_false_if_user_provided_to_big_Integer() {
        //given
        String userInputWinningNumber = "10";
        InputValidator validator = new InputValidator();
        int maxWidth = 5;
        int maxHeight = 5;
        BoardDimensions dimensions = new BoardDimensions(maxWidth, maxHeight);
        //when
        boolean properIntFormat = validator.properWinningNumber(userInputWinningNumber, dimensions);
        //then
        assertFalse(properIntFormat);
    }

    @Test
    public void InputValidator_properCoordinatesSchemaMethod_returns_false_if_cannot_parse_user_input_to_coordinates() {
        //given
        String userInputCoords = "1 b";
        InputValidator validator = new InputValidator();
        //when
        boolean properCoords = validator.properCoordinatesSchema(userInputCoords);
        //then
        assertFalse(properCoords);
    }

    @Test
    public void setting_games_new_board_creates_board_in_game() {
        //given
        Game game = new Game();
        BoardDimensions dimensions = new BoardDimensions(3,3);
        //when
        game.setNewBoard(dimensions);
        //then
        assertNotNull(game.getBoard());
    }

    @Test
    public void Language_english_getLocale_returns_Locale_English() {
        //given
        Locale locale = Locale.ENGLISH;
        //when
        Locale testLocale = Language.en.getLocale();
        //then
        assertEquals(testLocale, locale);
    }

    @Test
    public void Language_polish_getLocale_returns_Locale_Polish() {
        //given
        Locale locale = new Locale("pl", "PL");
        //when
        Locale testLocale = Language.pl.getLocale();
        //then
        assertEquals(testLocale, locale);
    }

    @Test
    public void Players_swap_current_player_makes_current_player_opposite_one_to_actual() {
        //given
        // currentPlayer: Sign.X
        //when
        this.players.swapCurrentPlayer();
        //then
        assertEquals(players.getCurrentPlayer().getSign(), Sign.O);
    }

    @Test
    public void Players_set_game_beginner_sets_current_player_as_game_beginner() {
        //given
        //currentPlayer: Sign.X
        //when
        players.setGameBeginner();
        //then
        assertEquals(players.getGameBeginner().getSign(), Sign.X);

    }

}

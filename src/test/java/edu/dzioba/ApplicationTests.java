package edu.dzioba;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.testng.Assert.*;

public class ApplicationTests {

    private GameSessionManager gameSessionManager;
    private GameSession session;
    private Sign sampleSign = Sign.X;
    private InputValidator validator;
    private GameState basicRunningState;
    private Players players;
    BoardDimensions sampleBoardDimensions;


    @BeforeMethod
    private void setUp() {
//        Sign[][] fields = new Sign[3][3];
        players = new Players(Arrays.asList(new Player("foo", Sign.X), new Player("bar", Sign.O)), Sign.X);
        sampleBoardDimensions = new BoardDimensions(3,3);
        basicRunningState = new RunningState(new Journalist(Language.ENGLISH), new Scanner(System.in)::nextLine,
                                             new Board(sampleBoardDimensions), players);
        gameSessionManager = new GameSessionManager(new Scanner(System.in)::nextLine,
                                                    new Journalist(Language.ENGLISH),
                                                    new InputConverter(), new InputValidator(new InputConverter()));
        session = new GameSession(gameSessionManager, new RunningState(basicRunningState));
        validator = new InputValidator(new InputConverter());
    }

    @Test
    public void gameSessionManager_returns_player_object_on_get_winner_method() {
        //given
        //when
        Player winner = gameSessionManager.getWinner();
        //then
        assertNotNull(winner);
    }


    @Test
    public void games_returns_true_if_there_is_end_of_gameSession_because_3_games_were_played() {
        //given
        Games games = new Games(new ArrayList<>());
        games.add(new Game());
        games.add(new Game());
        games.add(new Game());
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
    public void it_is_possible_to_set_up_journalists_language() {
        //given
        Journalist journalist;
        //when
        journalist = new Journalist(Language.ENGLISH);
        //then
        assertEquals(journalist.getLanguage(), Language.ENGLISH);
    }

    @Test
    public void game_session_manager_has_its_own_journalist() {
        //given
        GameSessionManager manager = new GameSessionManager(new Scanner(System.in)::nextLine,
                                                            new Journalist(Language.ENGLISH),
                                                            new InputConverter(), new InputValidator(new InputConverter()));
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
        assertSame(players.currentPlayer, player1);
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
        assertEquals(board.width, exampleWidth);
    }

    @Test
    public void it_is_possible_to_create_board_with_specific_height() {
        //given
        int exampleWidth = 3;
        int exampleHeight = 5;
        //when
        Board board = new Board(new BoardDimensions(exampleWidth, exampleHeight));
        //then
        assertEquals(board.height, exampleHeight);
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
        assertEquals(players.currentPlayer, player1);
    }

    @Test
    public void journalist_says_proper_message_if_arguments_are_provided() {
        //given
        Journalist journalist = new Journalist(Language.ENGLISH);
        String parameter = "Foo";
        String message = "This is my name: %s";
        //when
        String output = journalist.sayMessageWithParameters(message, parameter);
        //then
        assertEquals(output, "This is my name: Foo");
    }

    @Test
    public void journalist_says_proper_message_if_arguments_are_not_provided_to_say_message_with_parameters_method() {
        //given
        Journalist journalist = new Journalist(Language.ENGLISH);
        String parameter = "Foo";
        String message = "This is my name: %s";
        //when
        String output = journalist.sayMessageWithParameters(message, null);
        //then
        assertEquals(output, "This is my name: ");
    }

    @Test
    public void input_validator_returns_true_if_provided_user_coordinates_are_correct() {
        //given
        InputValidator validator = new InputValidator(new InputConverter());
        String userInput = "1 1";
        //when
        boolean validCoordinates = validator.properCoordinates(userInput);
        //then
        assertTrue(validCoordinates);
    }

    @Test
    public void input_validator_returns_false_if_provided_user_coordinates_are_correct() {
        //given
        InputValidator validator = new InputValidator(new InputConverter());
        String userInput = "ac2";
        //when
        boolean validCoordinates = validator.properCoordinates(userInput);
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
    public void testName() {
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

}

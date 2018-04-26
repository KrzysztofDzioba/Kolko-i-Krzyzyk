package edu.dzioba;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApplicationTests {

    private GameSessionManager gameSessionManager;
    private GameSession session;
    private Sign exampleSign = Sign.X;

    @BeforeMethod
    private void setUp() {
        gameSessionManager = new GameSessionManager(new Scanner(System.in)::nextLine,
                                                    new Journalist(Language.ENGLISH));
        session = new GameSession(new ArrayList<>(), new ArrayList<>(), gameSessionManager);
    }

    @Test
    public void gameSessionManager_returns_player_object_on_get_winner_method() {
        //given
        //when
        Player winner = gameSessionManager.getWinner();
        //then
        assertTrue(winner != null);
    }


    @Test
    public void gameSessionManager_returns_true_if_there_is_end_of_gameSession_because_3_games_were_played() {
        //given
        GameSession session = new GameSession(new ArrayList<>(), new ArrayList<>(), gameSessionManager);
        session.addGame(new Game());
        session.addGame(new Game());
        session.addGame(new Game());
        //when
        boolean gameSessionEnded = gameSessionManager.isEndOfGameSession(session);
        //then
        assertTrue(gameSessionEnded);
    }

    @Test
    public void can_give_name_to_the_player() {
        //given
        Player player = new Player("Foo", exampleSign);
        String playerName = "Foo";
        //when
        player.setName(playerName);
        //then
        assertEquals(player.getName(), playerName);
    }

    @Test
    public void can_add_player_to_game_session() {
        //given
        Player player = new Player("Foo", exampleSign);
        //when
        session.addPlayer(player);
        //then
        Assert.assertEquals(session.getPlayers().size(), 1);
    }

    @Test
    public void players_sign_is_assigned_to_player_after_adding_him_to_GameSession() {
        //given
        Player player = new Player("Foo", Sign.X);
        //when
        session.addPlayer(player);
        //then
        Assert.assertEquals(session.getPlayers().get(0).sign, Sign.X);
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
        GameSessionManager manager = new GameSessionManager(new Scanner(System.in)::nextLine, new Journalist(Language.ENGLISH));
        //when
        Journalist journalist = manager.getJournalist();
        //then
        assertTrue(journalist instanceof Journalist);
    }

    @Test
    public void game_session_knows_current_player() {
        //given
        Player player = new Player("foo", exampleSign);
        //when
        gameSessionManager.setCurrentPlayer(player);
        //then
        assertTrue(gameSessionManager.getCurrentPlayer() == player);
    }


}

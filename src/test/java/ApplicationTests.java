import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApplicationTests {

    @Test
    public void gameSessionManagerIsPresentInApplicationObject() {
        //given
        Application ap = new Application();
        //when
        GameSessionManager gameSessionManager= ap.getGameSessionManager();
        //then
        assertTrue(gameSessionManager instanceof GameSessionManager);
    }

    @Test
    public void gameSessionManager_returns_player_object_on_get_winner_method() {
        //given
        GameSessionManager gsMgr = new GameSessionManager(new ArrayList<>());
        //when
        Player winner = gsMgr.getWinner();
        //then
        assertTrue(winner != null);
    }


    @Test
    public void gameSessionManager_returns_true_if_there_is_end_of_gameSession_because_3_games_were_played() {
        //given
        GameSessionManager gsMgr = new GameSessionManager(new ArrayList<>());
        gsMgr.addGame(new Game());
        gsMgr.addGame(new Game());
        gsMgr.addGame(new Game());
        //when
        boolean gameSessionEnded = gsMgr.isEndOfGameSession();
        //then
        assertTrue(gameSessionEnded);
    }

    @Test
    public void can_give_name_to_the_player() {
        //given
        Player player = new Player();
        String playerName = "Foo";
        //when
        player.setName(playerName);
        //then
        assertEquals(player.getName(), playerName);
    }


}

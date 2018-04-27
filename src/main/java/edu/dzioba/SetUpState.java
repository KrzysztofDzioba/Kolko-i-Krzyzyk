package edu.dzioba;

public class SetUpState extends GameState {

    public SetUpState(GameSessionManager manager) {
        super(manager);
    }

    @Override
    GameState getNextState() {
//        setUp();
        return new RunningState(this);
    }

    private void setUp() {
        players = manager.setUpPlayers();
        players.currentPlayer = manager.setUpFirstPlayer(players);
        int[] dimensions = manager.getBoardsDimensions(new InputValidator(new InputConverter()));
        board = new Board(dimensions);
        this.winningNumber = manager.getWinningNumber(new InputValidator(new InputConverter()), dimensions);
    }

}

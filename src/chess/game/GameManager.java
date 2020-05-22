package chess.game;

public class GameManager {
    
    // TODO: Make a list of games to be stored
    private Game game;

    public GameManager() {

        // TODO: Temporary, makes a game to be played
        game = new Game();
    }

    public Game getGame() {
        return game;
    }
}
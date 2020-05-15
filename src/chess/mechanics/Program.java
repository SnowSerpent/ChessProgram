package chess.mechanics;

import chess.mechanics.display.Window;
import chess.mechanics.engine.Engine;

public class Program {
    
    private Window window;
    private Engine engine;

    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    private static final String WINDOW_TITLE = "Chess Program";

    public Program() {

        window = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TITLE);
        engine = new Engine(window);

        // TODO: Maybe do what I did here for the engine also. Create the two instances and THEN connect them
        window.setEngine(engine);
    }
}
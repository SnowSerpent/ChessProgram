package chess.mechanics.engine;

import java.awt.Canvas;

import chess.game.GameManager;
import chess.mechanics.display.Window;

public class Engine extends Canvas implements Runnable {

    private static final long serialVersionUID = 4460496126924080588L;

    private Window window;
    public GameManager gameManager;
    
    private double tps = 60;
    private boolean running;

    private int tickCount;
    private int frameCount;
    private long timer;

    public Engine(Window window) {
        this.window = window;
        gameManager = new GameManager();
    }

    public void start() {
        running = true;
        run();
    }

    public void stop() {
        running = false;
    }

    public void run() {

        // TODO: Save data when it stops running

        timer = System.currentTimeMillis();
        long prevTime = System.nanoTime();
        long currTime;

        double delta = 0;

        int ticks = 0;
        int frames = 0;

        while (running) {

            // Sets new current time
            currTime = System.nanoTime();
            delta += (currTime - prevTime) / (1000000000 / tps);
            prevTime = currTime;
            
            // Runs ticks
            if (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }

            // Draws the screen
            render();
            frames++;

            // Edits the data variables
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;

                tickCount = ticks;
                ticks = 0;

                frameCount = frames;
                frames = 0;
            }
        }
    }

    public void tick() {
        // TODO: Maybe make something here
    }

    public void render() {
        window.render();
    }
}
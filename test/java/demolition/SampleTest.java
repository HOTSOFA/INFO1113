package demolition;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {
    
    @Test
    public void dieTest1() {
        // Create an instance of your application
        App app = new App();

        // Set the program to not loop automatically
        app.noLoop();

        // Set the path of the config file to use
        app.setConfig("src/test/resources/config1.json");

        // Tell PApplet to create the worker threads for the program
        PApplet.runSketch(new String[] {"App"}, app);

        // Call App.setup() to load in sprites
        app.setup();

        // Set a 1 second delay to ensure all resources are loaded
        app.delay(1000);

        app.testKeyPressed("RIGHT");
        app.keyReleased();

        app.testKeyPressed("RIGHT");
        app.keyReleased();

        app.testKeyPressed("RIGHT");
        app.keyReleased();

        app.testKeyPressed("RIGHT");
        app.keyReleased();

        app.testKeyPressed("DOWN");
        app.keyReleased();

        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.draw();
        assertEquals(true, app.lost);
    }

    public void dieTest2() {
        // Create an instance of your application
        App app = new App();

        // Set the program to not loop automatically
        app.noLoop();

        // Set the path of the config file to use
        app.setConfig("src/test/resources/config.json");

        // Tell PApplet to create the worker threads for the program
        PApplet.runSketch(new String[] {"App"}, app);

        // Call App.setup() to load in sprites
        app.setup();

        // Set a 1 second delay to ensure all resources are loaded
        app.delay(1000);

        int i = 0;
        while (i < 60){
            app.draw();
            i += 1;
        }
        assertEquals(true,app.lost);
    }
}

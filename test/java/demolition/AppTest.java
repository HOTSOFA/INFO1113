package demolition;

import processing.core.PApplet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void basicTest() {
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

        assertEquals(480, app.HEIGHT);
        assertEquals(480, app.WIDTH);
        assertEquals(180, app.remainingTime);
        assertEquals(100, app.getPlayer().getLife());
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals(1, app.getCurrentFrame());

        // Call draw to update the program.
        app.draw();

        // Call keyPressed() or similar
        assertEquals("WWWWWWWWWWWWWWW\n" +
                            "WP    BBB BBBBW\n" +
                            "W W W W W W W W\n" +
                            "W         B B W\n" +
                            "WBW W W W WBW W\n" +
                            "W       R  B  W\n" +
                            "W W W W W W W W\n" +
                            "WB   B   B    W\n" +
                            "WBW W W WBW W W\n" +
                            "W    YBB   B BW\n" +
                            "W WBW W W W W W\n" +
                            "W        B   GW\n" +
                            "WWWWWWWWWWWWWWW", app.getMapData());


        app.testKeyPressed("UP");
        // Call draw again to move onto the next frame
        app.draw();

        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        assertEquals("up", app.getPlayer().getDirection());

        app.testKeyPressed("UP");
        // Call draw again to move onto the next frame
        app.draw();
        assertEquals("up", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        app.testKeyPressed("RIGHT");
        // Call draw again to move onto the next frame
        app.draw();
        assertEquals("up", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        app.testKeyPressed("LEFT");
        // Call draw again to move onto the next frame
        app.draw();
        assertEquals("up", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        app.testKeyPressed("DOWN");
        // Call draw again to move onto the next frame
        app.draw();
        assertEquals("up", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.draw();
        assertEquals("right", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W P   BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.draw();
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W P   BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("LEFT");

        app.draw();
        assertEquals("left", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.draw();
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "WPW W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.draw();
        assertEquals("right", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "WPW W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.draw();
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "WP        B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.keyReleased();

        app.testKeyPressed("RIGHT");
        app.draw();
        assertEquals("right", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W        PB B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("RIGHT");

        app.draw();
        assertEquals("right", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W        PB B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("UP");

        app.keyReleased();

        app.testKeyPressed("UP");

        app.keyReleased();

        app.testKeyPressed("LEFT");

        app.draw();
        assertEquals("left", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBBPBBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("LEFT");

        app.draw();
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals(99,app.getPlayer().getLife());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

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

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("DOWN");

        app.keyReleased();

        app.testKeyPressed("LEFT");

        app.keyReleased();

        app.testKeyPressed("LEFT");

        app.keyReleased();

        app.testKeyPressed("UP");

        app.draw();
        assertEquals("up", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "WP      R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");

        app.draw();
        assertEquals("right", app.getPlayer().getDirection());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W      PR  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();
        app.testKeyPressed("RIGHT");

        app.draw();
        assertEquals("down", app.getPlayer().getDirection());
        assertEquals(98,app.getPlayer().getLife());
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        int i = app.getCurrentFrame();
        while (i < 60){
            app.draw();
            i += 1;
        }

        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W        R B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W   Y BB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();
        app.testKeyPressed("RIGHT");

        int n = 0;
        while (n < 60){
            app.draw();
            if (n % 12 ==0){
                assertEquals("right", app.getPlayer().getDirection());
                assertEquals("WWWWWWWWWWWWWWW\n" +
                        "W P   BBB BBBBW\n" +
                        "W W W W W W W W\n" +
                        "W         B B W\n" +
                        "WBW W W W WBW W\n" +
                        "W        R B  W\n" +
                        "W W W W W W W W\n" +
                        "WB   B   B    W\n" +
                        "WBW W W WBW W W\n" +
                        "W   Y BB   B BW\n" +
                        "W WBW W W W W W\n" +
                        "W        B   GW\n" +
                        "WWWWWWWWWWWWWWW", app.getMapData());
            }
            n += 1;
        }

        app.keyReleased();
        app.testKeyPressed("LEFT");
        int m = 0;
        while (m < 60){
            app.draw();
            if (m % 12 ==0){
                assertEquals("left", app.getPlayer().getDirection());
                assertEquals("WWWWWWWWWWWWWWW\n" +
                        "WP    BBB BBBBW\n" +
                        "W W W W W W W W\n" +
                        "W         B B W\n" +
                        "WBW W W W WBW W\n" +
                        "W         RB  W\n" +
                        "W W W W W W W W\n" +
                        "WB   B   B    W\n" +
                        "WBW W W WBW W W\n" +
                        "W  Y  BB   B BW\n" +
                        "W WBW W W W W W\n" +
                        "W        B   GW\n" +
                        "WWWWWWWWWWWWWWW", app.getMapData());
            }
            m += 1;
        }

        app.keyReleased();
        app.testKeyPressed("UP");
        int j = 0;
        while (j < 60){
            app.draw();
            if (j % 12 ==0){
                assertEquals("up", app.getPlayer().getDirection());
                assertEquals("WWWWWWWWWWWWWWW\n" +
                        "WP    BBB BBBBW\n" +
                        "W W W W W W W W\n" +
                        "W         B B W\n" +
                        "WBW W W W WBW W\n" +
                        "W        R B  W\n" +
                        "W W W W W W W W\n" +
                        "WB   B   B    W\n" +
                        "WBW W W WBW W W\n" +
                        "W Y   BB   B BW\n" +
                        "W WBW W W W W W\n" +
                        "W        B   GW\n" +
                        "WWWWWWWWWWWWWWW", app.getMapData());
            }
            j += 1;
        }

        app.keyReleased();
        app.testKeyPressed("DOWN");
        int k = 0;
        while (k < 60){
            app.draw();
            if (k % 12 ==0){
                assertEquals("down", app.getPlayer().getDirection());
                assertEquals("WWWWWWWWWWWWWWW\n" +
                        "W     BBB BBBBW\n" +
                        "WPW W W W W W W\n" +
                        "W         B B W\n" +
                        "WBW W W W WBW W\n" +
                        "W       R  B  W\n" +
                        "W W W W W W W W\n" +
                        "WB   B   B    W\n" +
                        "WBW W W WBW W W\n" +
                        "WY    BB   B BW\n" +
                        "W WBW W W W W W\n" +
                        "W        B   GW\n" +
                        "WWWWWWWWWWWWWWW", app.getMapData());
            }
            k += 1;
        }
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();

        int l = 0;
        while (l < 150){
            app.draw();
            l += 1;
        }
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.draw();
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        assertEquals(97,app.getPlayer().getLife());

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

        int h = 0;
        while (h < 1000){
            app.draw();
            h += 1;
        }
        app.keyReleased();
        app.testKeyPressed("UP");
        app.draw();
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        assertEquals(96,app.getPlayer().getLife());

        app.keyReleased();
        app.testKeyPressed(" ");
        app.delay(3000);
        app.draw();
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "WP    BBB BBBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        assertEquals(95,app.getPlayer().getLife());

        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("UP");
        app.keyReleased();
        app.testKeyPressed("UP");

        app.keyReleased();
        app.testKeyPressed(" ");

        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.delay(3000);
        app.draw();
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BB   BBBW\n" +
                "W W W W W W W W\n" +
                "W       P B B W\n" +
                "WBW W W W WBW W\n" +
                "W       R  B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W    YBB   B BW\n" +
                "W WBW W W W W W\n" +
                "W        B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());

        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("UP");
        app.keyReleased();
        app.testKeyPressed("UP");
        app.keyReleased();
        app.testKeyPressed(" ");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("LEFT");

        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed(" ");
        app.keyReleased();
        app.testKeyPressed("UP");
        app.keyReleased();
        app.testKeyPressed("UP");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed(" ");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
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
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed(" ");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("LEFT");
        app.keyReleased();
        app.testKeyPressed("UP");
        assertEquals("WWWWWWWWWWWWWWW\n" +
                "W     BB b BBBW\n" +
                "W W W W W W W W\n" +
                "W         B B W\n" +
                "WBW W W W WBW W\n" +
                "W       Rb B  W\n" +
                "W W W W W W W W\n" +
                "WB   B   B    W\n" +
                "WBW W W WBW W W\n" +
                "W  b YBB   B BW\n" +
                "W WBWPW W W W W\n" +
                "W      b B   GW\n" +
                "WWWWWWWWWWWWWWW", app.getMapData());
        assertEquals(0,app.getMapNumber());

        app.delay(3000);
        app.draw();
        app.keyReleased();
        app.testKeyPressed("DOWN");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.keyReleased();
        app.testKeyPressed("RIGHT");
        app.draw();
        assertEquals(1,app.getMapNumber());
    }

}

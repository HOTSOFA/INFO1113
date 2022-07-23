package demolition;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;


public class App extends PApplet {
    public boolean lost;
    public boolean win;
    public PFont font;
    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;
    public int remainingTime;
    private String path = "config.json";
    private List<gameMap> mapList;
    private PImage wall;
    private PImage empty;
    private PImage broken;
    private PImage goal;
    private PImage clock;
    private PImage life;
    private PImage explodeCentre;
    private PImage explodeHorizon;
    private PImage explodeVertical;
    private PImage explodeTop;
    private PImage explodeBottom;
    private PImage explodeLeft;
    private PImage explodeRight;
    private ArrayList<PImage> playerLeft;
    private ArrayList<PImage> playerRight;
    private ArrayList<PImage> playerDown;
    private ArrayList<PImage> playerUp;
    private ArrayList<PImage> redEnemyLeft;
    private ArrayList<PImage> redEnemyRight;
    private ArrayList<PImage> redEnemyUp;
    private ArrayList<PImage> redEnemyDown;
    private ArrayList<PImage> yellowEnemyLeft;
    private ArrayList<PImage> yellowEnemyRight;
    private ArrayList<PImage> yellowEnemyDown;
    private ArrayList<PImage> yellowEnemyUp;
    private ArrayList<PImage> bomb;
    private bombGuy player;
    private gameMap map;
    private int currentFrame;
    private int bombFrame;
    private boolean released;
    private int mapNumber;

    public static final int FPS = 60;

    public App() {
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setConfig(String path){
        this.path = path;
    }

    public void setup() {
        this.lost = false;
        this.win = false;
        this.mapNumber=0;
        mapList = new ArrayList<>();
        JSONObject object = loadJSONObject(path);
        int life = object.getInt("lives");
        JSONArray arr = object.getJSONArray("levels");
        for (int i = 0; i < arr.size(); i++) {

            JSONObject o = arr.getJSONObject(i);

            gameMap map = new gameMap(o.getString("path"),o.getInt("time"));

            mapList.add(map);
        }

        this.released = true;
        this.map = mapList.get(mapNumber);
        this.player = new bombGuy(map,life);
        map.setPlayer(player);
        this.currentFrame = 0;
        font = createFont("PressStart2P-Regular.ttf",20);
        textFont(font);



        this.wall = loadImage("wall/solid.png");
        this.empty = loadImage("empty/empty.png");
        this.broken = loadImage("broken/broken.png");
        this.goal = loadImage("goal/goal.png");
        this.clock = loadImage("icons/clock.png");
        this.life = loadImage("icons/player.png");
        this.explodeCentre = loadImage("explosion/centre.png");
        this.explodeLeft = loadImage("explosion/end_left.png");
        this.explodeRight = loadImage("explosion/end_right.png");
        this.explodeTop = loadImage("explosion/end_top.png");
        this.explodeBottom = loadImage("explosion/end_bottom.png");
        this.explodeHorizon = loadImage("explosion/horizontal.png");
        this.explodeVertical = loadImage("explosion/vertical.png");

        this.bomb = new ArrayList<>();
        this.bomb.add(loadImage("bomb/bomb1.png"));
        this.bomb.add(loadImage("bomb/bomb2.png"));
        this.bomb.add(loadImage("bomb/bomb3.png"));
        this.bomb.add(loadImage("bomb/bomb4.png"));
        this.bomb.add(loadImage("bomb/bomb5.png"));
        this.bomb.add(loadImage("bomb/bomb6.png"));
        this.bomb.add(loadImage("bomb/bomb7.png"));
        this.bomb.add(loadImage("bomb/bomb8.png"));

        this.playerLeft = new ArrayList<>();
        this.playerLeft.add(loadImage("player/player_left1.png"));
        this.playerLeft.add(loadImage("player/player_left2.png"));
        this.playerLeft.add(loadImage("player/player_left3.png"));
        this.playerLeft.add(loadImage("player/player_left4.png"));

        this.playerRight = new ArrayList<>();
        this.playerRight.add(loadImage("player/player_right1.png"));
        this.playerRight.add(loadImage("player/player_right2.png"));
        this.playerRight.add(loadImage("player/player_right3.png"));
        this.playerRight.add(loadImage("player/player_right4.png"));

        this.playerUp = new ArrayList<>();
        this.playerUp.add(loadImage("player/player_Up1.png"));
        this.playerUp.add(loadImage("player/player_Up2.png"));
        this.playerUp.add(loadImage("player/player_Up3.png"));
        this.playerUp.add(loadImage("player/player_Up4.png"));

        this.playerDown = new ArrayList<>();
        this.playerDown.add(loadImage("player/player1.png"));
        this.playerDown.add(loadImage("player/player2.png"));
        this.playerDown.add(loadImage("player/player3.png"));
        this.playerDown.add(loadImage("player/player4.png"));

        this.redEnemyLeft = new ArrayList<>();
        this.redEnemyLeft.add(loadImage("red_enemy/red_left1.png"));
        this.redEnemyLeft.add(loadImage("red_enemy/red_left2.png"));
        this.redEnemyLeft.add(loadImage("red_enemy/red_left3.png"));
        this.redEnemyLeft.add(loadImage("red_enemy/red_left4.png"));

        this.redEnemyRight = new ArrayList<>();
        this.redEnemyRight.add(loadImage("red_enemy/red_right1.png"));
        this.redEnemyRight.add(loadImage("red_enemy/red_right2.png"));
        this.redEnemyRight.add(loadImage("red_enemy/red_right3.png"));
        this.redEnemyRight.add(loadImage("red_enemy/red_right4.png"));

        this.redEnemyUp = new ArrayList<>();
        this.redEnemyUp.add(loadImage("red_enemy/red_Up1.png"));
        this.redEnemyUp.add(loadImage("red_enemy/red_Up2.png"));
        this.redEnemyUp.add(loadImage("red_enemy/red_Up3.png"));
        this.redEnemyUp.add(loadImage("red_enemy/red_Up4.png"));

        this.redEnemyDown = new ArrayList<>();
        this.redEnemyDown.add(loadImage("red_enemy/red_Down1.png"));
        this.redEnemyDown.add(loadImage("red_enemy/red_Down2.png"));
        this.redEnemyDown.add(loadImage("red_enemy/red_Down3.png"));
        this.redEnemyDown.add(loadImage("red_enemy/red_Down4.png"));

        this.yellowEnemyLeft = new ArrayList<>();
        this.yellowEnemyLeft.add(loadImage("yellow_enemy/yellow_left1.png"));
        this.yellowEnemyLeft.add(loadImage("yellow_enemy/yellow_left2.png"));
        this.yellowEnemyLeft.add(loadImage("yellow_enemy/yellow_left3.png"));
        this.yellowEnemyLeft.add(loadImage("yellow_enemy/yellow_left4.png"));

        this.yellowEnemyRight = new ArrayList<>();
        this.yellowEnemyRight.add(loadImage("yellow_enemy/yellow_right1.png"));
        this.yellowEnemyRight.add(loadImage("yellow_enemy/yellow_right2.png"));
        this.yellowEnemyRight.add(loadImage("yellow_enemy/yellow_right3.png"));
        this.yellowEnemyRight.add(loadImage("yellow_enemy/yellow_right4.png"));

        this.yellowEnemyUp = new ArrayList<>();
        this.yellowEnemyUp.add(loadImage("yellow_enemy/yellow_Up1.png"));
        this.yellowEnemyUp.add(loadImage("yellow_enemy/yellow_Up2.png"));
        this.yellowEnemyUp.add(loadImage("yellow_enemy/yellow_Up3.png"));
        this.yellowEnemyUp.add(loadImage("yellow_enemy/yellow_Up4.png"));

        this.yellowEnemyDown = new ArrayList<>();
        this.yellowEnemyDown.add(loadImage("yellow_enemy/yellow_Down1.png"));
        this.yellowEnemyDown.add(loadImage("yellow_enemy/yellow_Down2.png"));
        this.yellowEnemyDown.add(loadImage("yellow_enemy/yellow_Down3.png"));
        this.yellowEnemyDown.add(loadImage("yellow_enemy/yellow_Down4.png"));

        frameRate(FPS);

        // Load images during setup
    }

    public void draw() {
        currentFrame += 1;
        remainingTime = map.getTime()-(currentFrame/60);
        background(255, 140, 2);
        image(life,130,20);
        image(clock,280,20);
        fill(0);
        text(player.getLife(),170,48);
        text(remainingTime,320,48);
        String[][] mapData = map.getMap();

        int i = 0;
        while (i < mapData.length){
            int j = 0;
            while (j < mapData[i].length){
                image(empty, j * 32, i * 32 + 64);
                String str = map.getMap()[i][j];
                for(int k=str.length() - 1;k>=0;k--){
                    char ch = str.charAt(k);
                    if (ch == 'W'){
                        image(wall, j * 32, i * 32 + 64);
                    }else if (ch == 'P'){
                        String direction = map.getPlayer().getDirection();
                        if (direction.equals("down")){
                            if (currentFrame % 48 < 12){
                                image(playerDown.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(playerDown.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(playerDown.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(playerDown.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("up")){
                            if (currentFrame % 48 < 12){
                                image(playerUp.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(playerUp.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(playerUp.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(playerUp.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("left")){
                            if (currentFrame % 48 < 12){
                                image(playerLeft.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(playerLeft.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(playerLeft.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(playerLeft.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("right")){
                            if (currentFrame % 48 < 12){
                                image(playerRight.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(playerRight.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(playerRight.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(playerRight.get(3),j * 32, i * 32 + 50);
                            }
                        }
                    }else if (ch == 'R'){
                        String direction = "right";
                        for (RedEnemy red : map.getRed()){
                            if (red.getXLocation() == j && red.getYLocation() == i){
                                direction = red.getDirection();
                            }
                        }
                        if (direction.equals("down")){
                            if (currentFrame % 48 < 12){
                                image(redEnemyDown.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(redEnemyDown.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(redEnemyDown.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(redEnemyDown.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("up")){
                            if (currentFrame % 48 < 12){
                                image(redEnemyUp.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(redEnemyUp.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(redEnemyUp.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(redEnemyUp.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("left")){
                            if (currentFrame % 48 < 12){
                                image(redEnemyLeft.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(redEnemyLeft.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(redEnemyLeft.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(redEnemyLeft.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("right")){
                            if (currentFrame % 48 < 12){
                                image(redEnemyRight.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(redEnemyRight.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(redEnemyRight.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(redEnemyRight.get(3),j * 32, i * 32 + 50);
                            }
                        }
                    }else if (ch == 'Y'){
                        String direction = "left";
                        for (YellowEnemy yellow : map.getYellow()){
                            if (yellow.getXLocation() == j && yellow.getYLocation() == i){
                                direction = yellow.getDirection();
                            }
                        }
                        if (direction.equals("down")){
                            if (currentFrame % 48 < 12){
                                image(yellowEnemyDown.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(yellowEnemyDown.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(yellowEnemyDown.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(yellowEnemyDown.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("up")){
                            if (currentFrame % 48 < 12){
                                image(yellowEnemyUp.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(yellowEnemyUp.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(yellowEnemyUp.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(yellowEnemyUp.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("left")){
                            if (currentFrame % 48 < 12){
                                image(yellowEnemyLeft.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(yellowEnemyLeft.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(yellowEnemyLeft.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(yellowEnemyLeft.get(3),j * 32, i * 32 + 50);
                            }
                        }
                        if (direction.equals("right")){
                            if (currentFrame % 48 < 12){
                                image(yellowEnemyRight.get(0),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 24){
                                image(yellowEnemyRight.get(1),j * 32, i * 32 + 50);
                            }else if (currentFrame % 48 < 36){
                                image(yellowEnemyRight.get(2),j * 32, i * 32 + 50);
                            }else{
                                image(yellowEnemyRight.get(3),j * 32, i * 32 + 50);
                            }
                        }
                    }else if (ch == 'G'){
                        image(goal, j * 32, i * 32 + 64);
                    }else if (ch == 'b'){
                        int m = currentFrame;
                        List<Integer> overTimeBomb = new ArrayList<>();
                        if (!map.getBombMap().isEmpty()) {
                            for (int n : map.getBombMap().keySet()) {
                                if (m - n > 120) {
                                    overTimeBomb.add(n);
                                } else if (map.getBombMap().get(n).getX() == j && map.getBombMap().get(n).getY() == i) {
                                    bombFrame = m - n;
                                }
                            }
                        }
                        for (int a : overTimeBomb) {
                            map.removeBomb(a);
                        }
                        if (bombFrame < 15){
                            image(bomb.get(0),j * 32, i * 32 + 64);
                        }else if (bombFrame < 30){
                            image(bomb.get(1),j * 32, i * 32 + 64);
                        }else if (bombFrame < 45){
                            image(bomb.get(2),j * 32, i * 32 + 64);
                        }else if (bombFrame < 60){
                            image(bomb.get(3),j * 32, i * 32 + 64);
                        }else if (bombFrame < 75){
                            image(bomb.get(4),j * 32, i * 32 + 64);
                        }else if (bombFrame < 90){
                            image(bomb.get(5),j * 32, i * 32 + 64);
                        }else if (bombFrame < 105){
                            image(bomb.get(6),j * 32, i * 32 + 64);
                        }else if (bombFrame < 120) {
                            image(bomb.get(7), j * 32, i * 32 + 64);
                        }

                    }else if (ch == 'B'){
                        image(broken, j * 32, i * 32 + 64);
                    }else if (ch == 'u' || ch == 'd'){
                        image(explodeVertical,j * 32, i * 32 + 64);
                    }else if (ch == 'l' || ch == 'r'){
                        image(explodeHorizon,j * 32, i * 32 + 64);
                    }else if (ch == 'x'){
                        image(explodeRight,j * 32, i * 32 + 64);
                    }else if (ch == 'U'){
                        image(explodeTop,j * 32, i * 32 + 64);
                    }else if (ch == 'L'){
                        image(explodeLeft,j * 32, i * 32 + 64);
                    }else if (ch == 'D'){
                        image(explodeBottom,j * 32, i * 32 + 64);
                    }else if (ch == 'C'){
                        image(explodeCentre,j * 32, i * 32 + 64);
                    }
                }
                j += 1;
            }
            i += 1;
        }

        if (currentFrame % 60 == 0){
            for (RedEnemy red : map.getRed()){
                if(!red.isKilled()){
                    red.move();
                }
            }
            for (YellowEnemy yellow : map.getYellow()){
                if(!yellow.isKilled()) {
                    yellow.move();
                }
            }

        }

        if(map.win()){
            mapNumber += 1;
            map.resetBomb();
            currentFrame = 0;
            if (mapNumber == mapList.size() || win){
                win = true;
                map.resetBomb();
                background(255, 140, 2);
                textAlign(CENTER);
                text("YOU WIN",240,240);
            }else {
                map = mapList.get(mapNumber);
                map.setPlayer(player);
                player.changeMap(map);
            }
        }


        if (remainingTime == 0){
            map.lose();
        }

        if(map.isLose()){
            lost = true;
            background(255, 140, 2);
            textAlign(CENTER);
            text("GAME OVER",240,240);
        }

        if (player.isKilled()){
            map.resetBomb();
            map.reset();
            player.changeMap(map);
            player.revive();

        }
    }

    public void keyPressed(KeyEvent e) {
        if (released) {
            switch (e.getKeyCode()) {
                case UP:
                    released = false;
                    player.move("up");
                    break;
                case DOWN:
                    released = false;
                    player.move("down");
                    break;
                case LEFT:
                    released = false;
                    player.move("left");
                    break;
                case RIGHT:
                    released = false;
                    player.move("right");
                    break;
                case ' ':
                    released = false;
                    player.deployBomb(currentFrame);
                    bombFrame = currentFrame;
                    break;
            }
        }
    }

    public void keyReleased(){
        released = true;
    }
    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }

    public int getMapNumber(){
        return mapNumber;
    }

    public bombGuy getPlayer() {
        return player;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public String getMapData(){
        StringBuffer sb = new StringBuffer();
        int m = 0;
        while (m < map.getMap().length) {
            int n = 0;
            while (n < map.getMap()[m].length) {
                sb.append(map.getMap()[m][n]);
                n += 1;
            }
            if(m == map.getMap().length - 1){
                break;
            }
            sb.append("\n");
            m += 1;
        }
        return sb.toString();
    }

    public void testKeyPressed(String key){
        if (released) {
            switch (key) {
                case "UP":
                    released = false;
                    player.move("up");
                    break;
                case "DOWN":
                    released = false;
                    player.move("down");
                    break;
                case "LEFT":
                    released = false;
                    player.move("left");
                    break;
                case "RIGHT":
                    released = false;
                    player.move("right");
                    break;
                case " ":
                    released = false;
                    player.deployBomb(currentFrame);
                    bombFrame = currentFrame;
                    break;
            }
        }
    }

}
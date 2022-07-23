package demolition;

import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gameMap {
    public String[][] mapData = new String[13][15];
    private int mapType;
    private bombGuy player;
    private List<RedEnemy> red;
    private List<YellowEnemy> yellow;
    private boolean win;
    private boolean lost;
    private HashMap<Integer,bomb> bombMap;
    private String path;
    private int time;

    public gameMap(String path, int time){
        this.win = false;
        this.red = new ArrayList<>();
        this.yellow = new ArrayList<>();
        this.path = path;
        this.time = time;
        this.bombMap = new HashMap<>();
        this.win = false;
        this.lost = false;
        this.mapType = 1;
        try {
            String file = path;
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = null;
            int i = 0;
            while ((s = br.readLine()) != null) {
                this.mapData[i] = s.split("");
                i += 1;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setPlayer(bombGuy player){
        this.player = player;
        int i = 0;
        while (i < mapData.length){
            int j = 0;
            while (j < mapData[i].length){
                if (mapData[i][j].equals("R")){
                    RedEnemy r = new RedEnemy(this, j,i);
                    red.add(r);
                }
                if (mapData[i][j].equals("Y")){
                    YellowEnemy y = new YellowEnemy(this, j,i);
                    yellow.add(y);
                }
                j += 1;
            }
            i += 1;
        }
    }

    public void delete(String object, int x, int y){
        if (x >= 0 && x < mapData[mapData.length - 1].length && y >= 0 && y < mapData.length) {
            if (mapData[y][x].contains(object)) {
                StringBuffer sb = new StringBuffer(mapData[y][x]);
                sb.deleteCharAt(sb.indexOf(object));
                if (sb.toString().length() == 0) {
                    mapData[y][x] = " ";
                } else {
                    mapData[y][x] = sb.toString();
                }
            }
        }
    }

    public void add(String object, int x, int y){
        if (mapData[y][x].equals(" ")){
            mapData[y][x] = object;
        }else{
            StringBuffer sb = new StringBuffer(mapData[y][x]);
            sb.insert(0,object);
            mapData[y][x] = sb.toString();
        }

    }

    public String[][] getMap(){
        return mapData;
    }

    public boolean win(){
        if (win){
            return true;
        }else {
            int i = 0;
            while (i < mapData.length) {
                int j = 0;
                while (j < mapData[i].length) {
                    if (mapData[i][j].contains("PG")) {
                        win = true;
                        return true;
                    }
                    j += 1;
                }
                i += 1;
            }
        }
        return false;
    }


    public void lose(){
        lost = true;
    }

    public boolean isLose(){
        if (lost){
            return true;
        }else if(player.getLife() <= 0){
            return true;
        }else{
            return false;
        }
    }

    public bombGuy getPlayer() {
        return player;
    }

    public List<RedEnemy> getRed() {
        return red;
    }

    public List<YellowEnemy> getYellow() {
        return yellow;
    }

    public void delete(int x, int y) {
        mapData[y][x] = " ";
    }

    public void addBomb(int frame, bomb b){
        bombMap.put(frame, b);
    }

    public void resetBomb(){
        if (!bombMap.isEmpty()) {
            for (int key : bombMap.keySet()){
                bombMap.get(key).cancel();
            }
        }
    }


    public void removeBomb(int key){
        bombMap.remove(key);
    }

    public HashMap<Integer, bomb> getBombMap(){
        return bombMap;
    }

    public void reset(){
        try {
            String file = path;
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = null;
            int i = 0;
            while ((s = br.readLine()) != null) {
                this.mapData[i] = s.split("");
                i += 1;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        red.clear();
        yellow.clear();
        int i = 0;
        while (i < mapData.length){
            int j = 0;
            while (j < mapData[i].length){
                if (mapData[i][j].equals("R")){
                    RedEnemy r = new RedEnemy(this, j,i);
                    red.add(r);
                }
                if (mapData[i][j].equals("Y")){
                    YellowEnemy y = new YellowEnemy(this, j,i);
                    yellow.add(y);
                }
                j += 1;
            }
            i += 1;
        }
    }


    public int getTime(){
        return time;
    }
}


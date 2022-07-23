package demolition;

public class bombGuy{
    private gameMap map;
    private static int life;
    private String direction;
    private int xLocation;
    private int yLocation;
    private static boolean killed;

    public bombGuy(gameMap map, int life){
        this.killed = false;
        this.map = map;
        this.life = life;
        this.direction = "down";
        int i = 0;
        String[][] mapData = map.getMap();
        while(i < mapData.length){
            int j = 0;
            while (j < mapData[i].length){
                if (mapData[i][j].equals("P")){
                    this.xLocation = j;
                    this.yLocation = i;
                }
                j += 1;
            }
            i += 1;
        }
    }

    public void move(String action){
        direction = action;

        if (action.equals("up")){
            if (yLocation - 1 >= 0){
                String str = map.getMap()[yLocation - 1][xLocation];
                for (int k = 0; k < str.length(); k++){
                    char ch = str.charAt(k);
                    if(ch != 'W' && ch != 'B'){
                        if (ch == 'Y' || ch == 'R' || ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            bombGuy.kill();
                            continue;
                        }else{
                            map.delete("P",xLocation,yLocation);
                            map.add("P",xLocation,yLocation - 1);
                            yLocation -= 1;
                            break;
                        }
                    }
                }
            }
        }

        if (action.equals("down")){
            if (yLocation + 1 <= map.getMap().length){
                String str = map.getMap()[yLocation + 1][xLocation];
                for (int k = 0; k < str.length(); k++){
                    char ch = str.charAt(k);
                    if(ch != 'W' && ch != 'B'){
                        if (ch == 'Y' || ch == 'R' || ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            bombGuy.kill();
                            continue;
                        }else{
                            map.delete("P",xLocation,yLocation);
                            map.add("P",xLocation,yLocation + 1);
                            yLocation += 1;
                            break;
                        }
                    }
                }
            }
        }

        if (action.equals("left")){
            if (xLocation - 1 >= 0){
                String str = map.getMap()[yLocation][xLocation - 1];
                for (int k = 0; k < str.length(); k++){
                    char ch = str.charAt(k);
                    if(ch != 'W' && ch != 'B'){
                        if (ch == 'Y' || ch == 'R' || ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            bombGuy.kill();
                            continue;
                        }else{
                            map.delete("P",xLocation,yLocation);
                            map.add("P",xLocation - 1,yLocation);
                            xLocation -= 1;
                            break;
                        }
                    }
                }
            }
        }

        if (action.equals("right")){
            if (xLocation + 1 <= map.getMap()[yLocation].length){
                String str = map.getMap()[yLocation][xLocation + 1];
                for (int k = 0; k < str.length(); k++){
                    char ch = str.charAt(k);
                    if(ch != 'W' && ch != 'B'){
                        if (ch == 'Y' || ch == 'R' || ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            bombGuy.kill();
                            continue;
                        }else{
                            map.delete("P",xLocation,yLocation);
                            map.add("P",xLocation + 1,yLocation);
                            xLocation += 1;
                            break;
                        }
                    }
                }
            }
        }
    }

    public bomb deployBomb(int frame){
        bomb bomb = new bomb(map,xLocation,yLocation);
        map.addBomb(frame,bomb);
        return bomb;
    }

    public String getDirection(){
        return direction;
    }

    public static void kill(){
        life -= 1;
        killed = true;
    }
    public int getLife(){
        return life;
    }

    public static void revive(){
        killed = false;
    }

    public boolean isKilled(){
        return killed;
    }

    public void changeMap(gameMap map){
        this.map = map;
        this.direction = "down";
        int i = 0;
        String[][] mapData = map.getMap();
        while(i < mapData.length){
            int j = 0;
            while (j < mapData[i].length){
                if (mapData[i][j].equals("P")){
                    this.xLocation = j;
                    this.yLocation = i;
                }
                j += 1;
            }
            i += 1;
        }
    }
}
package demolition;


public class Enemy {
    private gameMap map;
    private int xLocation;
    private int yLocation;
    private boolean killed;
    private String enemyType;

    public Enemy(gameMap map, String enemyType, int xLocation, int yLocation){
        this.enemyType = enemyType;
        this.killed = false;
        this.map = map;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }


    public void move(String action){

        if (action.equals("up")){
            if (yLocation - 1 >= 0){
                String str = map.getMap()[yLocation - 1][xLocation];
                for (int k = 0; k < str.length(); k++){
                    char ch = str.charAt(k);
                    if(ch != 'W' && ch != 'B'){
                        if (ch == 'P') {
                            map.getPlayer().kill();
                        }else if (ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            map.delete(enemyType,xLocation,yLocation);
                            this.kill();
                            continue;
                        }else{
                            map.delete(enemyType,xLocation,yLocation);
                            map.add(enemyType,xLocation,yLocation - 1);
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
                        if (ch == 'P') {
                            map.getPlayer().kill();
                        }else if (ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            map.delete(enemyType,xLocation,yLocation);
                            this.kill();
                            continue;
                        }else{
                            map.delete(enemyType,xLocation,yLocation);
                            map.add(enemyType,xLocation,yLocation + 1);
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
                        if (ch == 'P') {
                            map.getPlayer().kill();
                        }else if (ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            map.delete(enemyType,xLocation,yLocation);
                            this.kill();
                            continue;
                        }else{
                            map.delete(enemyType,xLocation,yLocation);
                            map.add(enemyType,xLocation - 1,yLocation);
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
                        if (ch == 'P') {
                            map.getPlayer().kill();
                        }else if (ch == 'C'|| ch == 'u'|| ch == 'U'|| ch == 'd'|| ch == 'D'|| ch == 'l'|| ch == 'L'|| ch == 'r'|| ch == 'x'){
                            map.delete(enemyType,xLocation,yLocation);
                            this.kill();
                            continue;
                        }else{
                            map.delete(enemyType,xLocation,yLocation);
                            map.add(enemyType,xLocation + 1,yLocation);
                            xLocation += 1;
                            break;
                        }
                    }
                }
            }
        }
    }

    public String getFutureBlock(String direction){
        if (direction.equals("right")){
            return map.getMap()[yLocation][xLocation + 1];
        }
        if (direction.equals("left")){
            return map.getMap()[yLocation][xLocation - 1];
        }
        if (direction.equals("up")){
            return map.getMap()[yLocation - 1][xLocation];
        }
        if (direction.equals("down")){
            return map.getMap()[yLocation + 1][xLocation];
        }
        return direction;
    }


    public int getXLocation(){
        return xLocation;
    }

    public int getYLocation(){
        return yLocation;
    }

    public void kill(){
        this.killed = true;
    }

    public boolean isKilled(){
        return killed;
    }



}
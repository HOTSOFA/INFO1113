package demolition;

public class YellowEnemy extends Enemy{
    private String direction;

    enum direct{
        left,up,right,down;
    }

    public YellowEnemy(gameMap map,int xLocation, int yLocation) {
        super(map,"Y", xLocation, yLocation);
        direction = "left";
    }

    public void move(){
        while (super.getFutureBlock(direction).equals("W") || super.getFutureBlock(direction).equals("B")){
            direct[] arr = direct.values();
            int i = 0;
            while (i < arr.length){
                if (direction.equals(arr[i].toString())){
                    break;
                }
                i += 1;
            }
            if (i == 3){
                i = -1;
            }
            direction = arr[i + 1].toString();
        }
        super.move(direction);
    }

    public String getDirection(){
        return direction;
    }


}
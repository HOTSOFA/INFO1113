package demolition;

public class RedEnemy extends Enemy{
    private String direction;
    enum direct{
        left,up,right,down;
    }

    public RedEnemy(gameMap map,int xLocation, int yLocation) {
        super(map,"R",xLocation, yLocation);
        direction = "right";
    }

    public void move(){
        direct[] arr = direct.values();
        while (super.getFutureBlock(direction).equals("W") || super.getFutureBlock(direction).equals("B")){
            direct[] newArr = new direct[arr.length - 1];
            int i = 0;
            while (i < arr.length){
                if (direction.equals(arr[i].toString())){
                    break;
                }
                i += 1;
            }
            for(int n=0;n<newArr.length; n++) {

                if(n<i) {
                    newArr[n] = arr[n];
                }
                else {
                    newArr[n] = arr[n+1];
                }
            }
            arr = newArr;
            int number = (int) (Math.random() * arr.length - 1);
            direction = arr[number].toString();
        }
        super.move(direction);
    }

    public String getDirection(){
        return direction;
    }


}
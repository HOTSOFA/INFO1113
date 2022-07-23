package demolition;

import java.util.Timer;
import java.util.TimerTask;

public class bomb{
    private Timer timer;
    private int x;
    private int y;

    public bomb(gameMap map, int x, int y){
        this.x = x;
        this.y = y;

        map.add("b",x,y);
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                bomb.explode(map,x,y);
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                map.delete("C",x,y);
                map.delete("u",x,y - 1);
                map.delete("U",x,y - 2);
                map.delete("d",x,y + 1);
                map.delete("D",x,y + 2);
                map.delete("l",x - 1,y);
                map.delete("L",x - 2,y);
                map.delete("r",x + 1,y);
                map.delete("x",x + 2,y);
            }
        };
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                map.delete("C",x,y);
                map.delete("u",x,y - 1);
                map.delete("U",x,y - 2);
                map.delete("d",x,y + 1);
                map.delete("D",x,y + 2);
                map.delete("l",x - 1,y);
                map.delete("L",x - 2,y);
                map.delete("r",x + 1,y);
                map.delete("x",x + 2,y);
                timer.cancel();
            }
        };
        timer.schedule(task,1000*2);
        timer.schedule(task2, 2500);
        timer.schedule(task3, 2600);
    }

    public void cancel(){
        timer.cancel();
    }

    public static void explode(gameMap map, int x, int y){
        String string = map.getMap()[y][x];
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch != 'G' && ch != ' ') {
                String s = String.valueOf(ch);
                map.delete(s, x, y);
                map.add("C",x,y);
            }
            if (ch == 'P'){
                map.getPlayer().kill();
            }
            if (ch == 'Y'){
                for (YellowEnemy yellow : map.getYellow()){
                    if (yellow.getXLocation() == x && yellow.getYLocation() == y){
                        yellow.kill();
                    }
                }
            }
            if (ch == 'R'){
                for (RedEnemy red : map.getRed()){
                    if (red.getXLocation() == x && red.getYLocation() == y){
                        red.kill();
                    }
                }
            }
        }
        int n = 1;
        boolean upContinue = true;
        boolean downContinue = true;
        boolean leftContinue = true;
        boolean rightContinue = true;

        while (n <= 2){
            if (y + n <= map.getMap().length && downContinue) {
                if (!map.getMap()[y + n][x].equals("W")) {
                    if (map.getMap()[y + n][x].equals("B")) {
                        downContinue = false;
                        map.delete(x, y + n);
                        if(n == 1){
                            map.add("d",x,y + n);
                        }else{
                            map.add("D",x,y + n);
                        }
                    } else if (map.getMap()[y + n][x].equals("b") || map.getMap()[y + n][x].equals("G")) {
                        if(n == 1){
                            map.add("d",x,y + n);
                        }else{
                            map.add("D",x,y + n);
                        }
                    } else {
                        String str = map.getMap()[y + n][x];
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch != 'G' && ch != ' ') {
                                String s = String.valueOf(ch);
                                map.delete(s, x, y + n);
                            }
                            if (ch == 'P'){
                                map.getPlayer().kill();
                            }
                            if (ch == 'Y'){
                                for (YellowEnemy yellow : map.getYellow()){
                                    if (yellow.getXLocation() == x && yellow.getYLocation() == y + n){
                                        yellow.kill();
                                    }
                                }
                            }
                            if (ch == 'R'){
                                for (RedEnemy red : map.getRed()){
                                    if (red.getXLocation() == x && red.getYLocation() == y + n){
                                        red.kill();
                                    }
                                }
                            }
                        }
                        if(n == 1){
                            map.add("d",x,y + n);
                        }else{
                            map.add("D",x,y + n);
                        }
                    }
                } else if (map.getMap()[y + n][x].equals("W")) {
                    downContinue = false;
                }
            }

            if (y - n >= 0 && upContinue){
                if (!map.getMap()[y - n][x].equals("W")) {
                    if (map.getMap()[y - n][x].equals("B")) {
                        upContinue = false;
                        map.delete(x, y - n);
                        if(n == 1){
                            map.add("u",x,y - n);
                        }else{
                            map.add("U",x,y - n);
                        }
                    } else if (map.getMap()[y - n][x].equals("b") || map.getMap()[y - n][x].equals("G")) {
                        if(n == 1){
                            map.add("u",x,y - n);
                        }else{
                            map.add("U",x,y - n);
                        }
                    } else {
                        String str = map.getMap()[y - n][x];
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch != 'G' && ch != ' ') {
                                String s = String.valueOf(ch);
                                map.delete(s, x, y - n);
                            }
                            if (ch == 'P'){
                                map.getPlayer().kill();
                            }
                            if (ch == 'Y'){
                                for (YellowEnemy yellow : map.getYellow()){
                                    if (yellow.getXLocation() == x && yellow.getYLocation() == y - n){
                                        yellow.kill();
                                    }
                                }
                            }
                            if (ch == 'R'){
                                for (RedEnemy red : map.getRed()){
                                    if (red.getXLocation() == x && red.getYLocation() == y - n){
                                        red.kill();
                                    }
                                }
                            }
                        }
                        if(n == 1){
                            map.add("u",x,y - n);
                        }else{
                            map.add("U",x,y - n);
                        }
                    }
                } else if (map.getMap()[y - n][x].equals("W")) {
                    upContinue = false;
                }
            }

            if (x - n >= 0 && leftContinue) {
                if (!map.getMap()[y][x - n].equals("W")) {
                    if (map.getMap()[y][x - n].equals("B")) {
                        leftContinue = false;
                        map.delete(x - n, y);
                        if(n == 1){
                            map.add("l",x - n,y);
                        }else{
                            map.add("L",x - n,y);
                        }
                    } else if (map.getMap()[y][x - n].equals("b") || map.getMap()[y][x - n].equals("G")) {
                        if(n == 1){
                            map.add("l",x - n,y);
                        }else{
                            map.add("L",x - n,y);
                        }
                    } else {
                        String str = map.getMap()[y][x - n];
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch != 'G' && ch != ' ') {
                                String s = String.valueOf(ch);
                                map.delete(s, x - n, y);
                            }
                            if (ch == 'P'){
                                map.getPlayer().kill();
                            }
                            if (ch == 'Y'){
                                for (YellowEnemy yellow : map.getYellow()){
                                    if (yellow.getXLocation() == x - n && yellow.getYLocation() == y){
                                        yellow.kill();
                                    }
                                }
                            }
                            if (ch == 'R'){
                                for (RedEnemy red : map.getRed()){
                                    if (red.getXLocation() == x - n && red.getYLocation() == y){
                                        red.kill();
                                    }
                                }
                            }
                        }
                        if(n == 1){
                            map.add("l",x - n,y);
                        }else{
                            map.add("L",x - n,y);
                        }
                    }

                } else if (map.getMap()[y][x - n].equals("W")) {
                    leftContinue = false;
                }
            }

            if (x + n <= map.getMap()[y].length && rightContinue) {
                if (!map.getMap()[y][x + n].equals("W")) {
                    if (map.getMap()[y][x + n].equals("B")) {
                        rightContinue = false;
                        map.delete(x + n, y);
                        if(n == 1){
                            map.add("r",x + n,y);
                        }else{
                            map.add("x",x + n,y);
                        }
                    } else if (map.getMap()[y][x + n].equals("b") || map.getMap()[y][x + n].equals("G")) {
                        if(n == 1){
                            map.add("r",x + n,y);
                        }else{
                            map.add("x",x + n,y);
                        }
                    } else {
                        String str = map.getMap()[y][x + n];
                        for (int i = 0; i < str.length(); i++) {
                            char ch = str.charAt(i);
                            if (ch != 'G' && ch != ' ') {
                                String s = String.valueOf(ch);
                                map.delete(s, x + n, y);
                            }
                            if (ch == 'P'){
                                map.getPlayer().kill();
                            }
                            if (ch == 'Y'){
                                for (YellowEnemy yellow : map.getYellow()){
                                    if (yellow.getXLocation() == x + n && yellow.getYLocation() == y){
                                        yellow.kill();
                                    }
                                }
                            }
                            if (ch == 'R'){
                                for (RedEnemy red : map.getRed()){
                                    if (red.getXLocation() == x + n && red.getYLocation() == y){
                                        red.kill();
                                    }
                                }
                            }
                        }
                        if(n == 1){
                            map.add("r",x + n,y);
                        }else{
                            map.add("x",x + n,y);
                        }
                    }
                } else if (map.getMap()[y][x + n].equals("W")) {
                    rightContinue = false;
                }
            }
            n += 1;
        }


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
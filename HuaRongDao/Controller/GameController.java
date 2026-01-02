package Java.HuaRongDao.Controller;

import Java.HuaRongDao.Model.Direction;

public class GameController {
    public GameController(Direction direction){
        switch (direction) {
            case UP:
                System.out.println("上被按下了");
                break;
            case DOWN:
                System.out.println("下被按下了");
                break;
            case LEFT:
                System.out.println("左被按下了");
                break;
            case RIGHT:
                System.out.println("右被按下了");
                break;
            default:
                break;
        }
    }
}

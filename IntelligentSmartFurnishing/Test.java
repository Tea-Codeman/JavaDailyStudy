package IntelligentSmartFurnishing;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        JD[] jds = new JD[4];
        // create 4 JD objects
        jds[0] = new Lamp("Lamp", false);
        jds[1] = new Television("Television",true);
        jds[2] = new WashMachine("WashMachine", false);
        jds[3] = new Window("Window", true);
        FurnishingSystem system = FurnishingSystem.getObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用智能家居系统！！");
        System.out.println("=============================================================================");
        system.PrintMachineList(jds);
        while(true){
            System.out.println("=========================================================================");
            System.out.print("请输入你要控制的设备名称：");
            System.out.println("Lamp(1) , Television(2), WashMachine(3), Window(4), PrintAllMachine(5), exit(0)");
            int selectNumber = sc.nextInt();
            switch (selectNumber) {
                case 0:
                    System.out.println("感谢您的使用！！");
                    break;
                case 1:
                    system.control(jds[0]);
                    break;
                case 2:
                    system.control(jds[1]);
                    break;
                case 3:
                    system.control(jds[2]);
                    break;
                case 4:
                    system.control(jds[3]);
                    break;
                case 5:
                    system.PrintMachineList(jds);
                    break;
                default:
                    System.out.println("输入错误,请重试,请输入0-5的整数!!");
                    break;
            }
            if(selectNumber == 0){break;}
       }
       sc.close();
    }
}

package Project1_BankCarddemo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的卡号：");
        long carNumber = sc.nextLong();
        sc.nextLine(); // 读取换行符
        System.out.println("请输入您的姓名：");
        String userName = sc.nextLine();
        System.out.println("请输入您的手机号：");
        long phoneNumber = sc.nextLong();
        sc.nextLine(); // 读取换行符
        System.out.println("请问您要办金卡(gold)还是银卡(silver)");
        String select = sc.nextLine();
        System.out.println("如要办卡，请输入预存入金额：");
        double balance = sc.nextDouble();
        sc.nextLine(); // 读取换行符
        
        
        Card useCard = Card.handlesCard(select, carNumber, userName, phoneNumber, balance);
        if(useCard!= null && useCard.getIssuccessful() == true){
            method(useCard,sc);
        }else if(useCard == null){
            System.out.println("没有该卡类型");
        }else if(useCard.getIssuccessful() == false){
            System.out.println("办卡失败，请稍后再试");
        }
        sc.close();
    }
    public static void method(Card card, Scanner sc){
        
        int select = 0;
        do {
            System.out.println("\n请选择操作：");
            System.out.println("1. 消费 (consumption)");
            System.out.println("2. 存款 (deposit)");
            System.out.println("0. 退出 (exit)");
            System.out.print("请输入选择 (0/1/2): ");
            // 读取用户输入
            while(!sc.hasNextInt()){
                System.out.println("输入有误，请重新输入");
                sc.next();
            }
            select = sc.nextInt();
            
            
            // 清除缓冲区（读取换行符）
            sc.nextLine();
            
            if(select == 1) {
                System.out.print("请输入您要消费的金额(元): ");
                double balance = sc.nextDouble();
                sc.nextLine(); // 清除缓冲区
                card.consumption(balance);
                }
            else if(select == 2){
                System.out.print("请输入您要存入的金额(元): ");
                double balance = sc.nextDouble();
                sc.nextLine(); // 清除缓冲区
                card.deposit(balance);
            }
            else if (select == 0){
                System.out.println("欢迎下次使用");
                break;
            }    
                // 显示当前余额
            System.out.println("您的卡余额为: " + card.getCarBalance());
        }while (select != 0);
       
    }
}
    


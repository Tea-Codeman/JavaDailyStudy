package Project1_BankCarddemo;

public class goldCard extends Card{
    //享受8折优惠，消费满200元提供打印免费洗车票的服务
    
    public goldCard(){}
    public goldCard(long carNumber, String userName,long phoneNumber, double balance){
        super(carNumber,userName,phoneNumber);
        setCardBalance(balance);
        
    }
    @Override
    public void setCardBalance(double balance){
        if(balance < 5000){
            System.out.println("请存入大于5000的数额");
            System.out.println("办理金卡失败");
            setIssuccessful(false);
        }else{
            super.setCardBalance(balance);
            System.out.println("卡号：" + getCardNumber() + " 用户名：" + getUserName() + " 电话号码：" + getPhoneNumber() + " 卡余额：" + getCarBalance());
            System.out.println("办理金卡成功");
            setIssuccessful(true);
            
        }
    }
    //消费方法
    @Override
    public void consumption(double balance){
        service(balance);
        double discountedComsumption = balance * 0.8;
        super.setCardBalance(getCarBalance() - discountedComsumption);
        System.out.println("您当前消耗了"+ discountedComsumption + "(元)");
        
        if(getCarBalance() < 0){
            System.out.println("您的卡余额不足，请充值！");
        }
    }
    //存款
    
    public final void deposit(double balance){
        super.setCardBalance(getCarBalance() + balance);
        System.out.println("您当前存入了"+ balance + "(元)");
    }
     
    //金卡服务方法
    public void service(double balance){
        if(balance >= 200){System.out.println("送您一个免费洗车票的服务！");}
    }
}

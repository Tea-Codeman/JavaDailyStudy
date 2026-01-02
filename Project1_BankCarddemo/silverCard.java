package Java.Project1_BankCarddemo;

public class silverCard  extends Card{
    //享受9折优惠
    
    public silverCard(){}
    public silverCard(long carNumber, String userName,long phoneNumber,double balance){
        super(carNumber,userName,phoneNumber);
        setCardBalance(balance);
        
    }
    @Override
    public void setCardBalance(double balance){
        if(!getIssuccessful()){
            if(balance < 2000){
                System.out.println("请存入大于2000的数额");
                System.out.println("办理银卡失败");
                setIssuccessful(false);
            }else{
                super.setCardBalance(balance);
                System.out.println("卡号：" + getCardNumber() + " 用户名：" + getUserName() + " 电话号码：" + getPhoneNumber() + " 卡余额：" + getCarBalance());
                System.out.println("办理银卡成功");
                setIssuccessful(true);
            }
        }
        
    }
    //消费方法，打9折
    @Override
    public void consumption(double balance){
        double discountedComsumption = balance * 0.9;
        super.setCardBalance(getCarBalance() - discountedComsumption);
        System.out.println("您当前消耗了"+ discountedComsumption + "(元)");
        
        if(super.getCarBalance() < 0){
            System.out.println("您的卡余额不足，请充值！");
        }
    }
    //存款
    @Override
    public void deposit(double balance){
        super.setCardBalance(getCarBalance() + balance);
        System.out.println("您当前存入了"+ balance + "(元)");
    }
     
    
    


}

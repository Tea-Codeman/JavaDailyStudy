package Java.Project1_BankCarddemo;



public abstract class Card {
    private long carNumber = 0;
    private String userName = null;
    private long phoneNumber = 0;
    private double carBalance = 0.00;
    private boolean issuccessful = false;
    public Card (){} 
    public Card(long carNumber, String useName, long phoneNumber){
        this.carNumber = carNumber;
        this.userName = useName;
        this.phoneNumber = phoneNumber;
    }
    public void setCardNumber(long carNumber){
        this.carNumber = carNumber;
    }
        
    public long getCardNumber(){
        return carNumber;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public void setCardBalance(double carBalance){
        this.carBalance = carBalance;
    }
    public double getCarBalance(){
        return carBalance;
    }
    public void setIssuccessful(boolean issuccessful){
        this.issuccessful = issuccessful;
    }
    public boolean getIssuccessful(){
        return issuccessful;
    }
    //消费功能
    public abstract void consumption(double balance);
    //存款功能
    public void deposit(double balance){
        setCardBalance(getCarBalance() + balance);
        System.out.println("您当前存入了"+ balance + "(元)");
    }
    
    //办理功能
    public static Card handlesCard(String str, long carNumber, String useName, long phoneNumber, double balance){
        
        if("gold".equals(str)){
            Card gold = new goldCard(carNumber, useName, phoneNumber, balance);
            return gold;
        }else if("silver".equals(str)){
            Card silver = new silverCard(carNumber, useName, phoneNumber, balance);
            return silver;
        }else{
            System.out.println("没有这种卡");
            return null;
        }
        
    }
}

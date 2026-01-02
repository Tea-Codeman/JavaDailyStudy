package IntelligentSmartFurnishing;

public class FurnishingSystem {
    private static FurnishingSystem system = new FurnishingSystem();
    //私有化构造器
    private FurnishingSystem(){}
    //返回对象（单例）
    public static FurnishingSystem getObject(){
        return system;
    }
    //控制系统
    public void control(JD jd){
        System.out.println("当前控制设备名称：" + jd.getName() + "当前控制设备状态：" + (jd.isStatus()?"开":"关"));
        System.out.println("开始你的操作========================================================================");
        jd.press();
        System.out.println("当前控制设备名称：" + jd.getName() + "操作后的设备状态：" + (jd.isStatus()?"开":"关"));
    }
    //打印系统设备列表
    public void PrintMachineList(JD[] jds){
        for (JD jd : jds) {
            System.out.println("设备名称：" + jd.getName() + "\t设备当前状态：" + (jd.isStatus()?"开":"关"));
        }
    }
} 

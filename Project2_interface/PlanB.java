package Java.Project2_interface;

public class PlanB implements studentSystem{
    @Override
    public void printStudentInfo(Student[] students){
        //打印学生信息(包括男女人数)
        int maleCount = 0;
        int femaleCount = 0;
        System.out.println("全部学生信息如下：");
        System.out.println("姓名\t性别\t成绩");
        for (Student student : students){
            String name = student.getName();
            String gender = student.getGender();
            if("Male".equals(gender)){
                maleCount++;
            }else if("Female".equals(gender)){
                femaleCount++;
            }
            double score = student.getScore();
            System.out.println(name + "\t" + gender + "\t" + score);
        }
        System.out.println("男生人数\t女生人数");
        System.out.println(maleCount + "\t" + femaleCount);

    }
    
    @Override
    public void printAllStudentAverageScore(Student[] students){
        //打印学生平均分(去掉最高/最低分)
        double result = 0;
        double max = students[0].getScore();
        double min = students[0].getScore();
        for (int i = 0;i < students.length - 1;i++){
            double score = students[i].getScore();
            if(score > max){
                max = score;
            }else if(score < min){
                min = score;
            }
            result += score;
        }
        result = (result - max - min) / (students.length - 2);
        System.out.print("全部学生的总平均分如下：");
        System.out.println(result);
    }
    
} 
    
    
   


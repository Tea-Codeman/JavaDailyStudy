package Project2_interface;



public class PlanA implements studentSystem{
    
    //打印学生信息
    @Override
    public void printStudentInfo(Student[] students){
        //打印全部学生信息
        System.out.println("全部学生信息如下：");
        System.out.println("姓名\t性别\t成绩");
        for (Student student : students){
            String name = student.getName();
            String gender = student.getGender();
            double score = student.getScore();
            System.out.println(name + "\t" + gender + "\t" + score);
        }
        

    }
    //打印学生平均分
    @Override
    public void printAllStudentAverageScore(Student[] students){
        //打印全班学生的平均分
        double result = 0;
        for (Student student : students) {
            double score = student.getScore();
            result += score;
        }
        result /= students.length;
        System.out.print("全部学生的总平均分如下：");
        System.out.println(result);
    }
}
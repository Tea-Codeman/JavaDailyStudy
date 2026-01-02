package Java.Project2_interface;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // create ten Student objects
        Student a = new Student("Alice", "Female", 90.5);
        Student b = new Student("Bob", "Male", 85.0);
        Student c = new Student("Charlie", "Male", 95.0);
        Student d = new Student("David", "Male", 80.0);
        Student e = new Student("Emily", "Female", 92.5);
        Student f = new Student("Frank", "Male", 87.5);
        Student g = new Student("Grace", "Female", 97.5);
        Student h = new Student("Henry", "Male", 82.5);
        Student i = new Student("Isabelle", "Female", 99.0);
        Student j = new Student("John", "Male", 89.5);
        Student[] students = {a, b, c, d, e, f, g, h, i, j};
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("请输入您的选择");
            System.out.println("PlanA(1)");
            System.out.println("PlanB(2)");
            System.out.println("退出(0)");
            temp = scanner.nextInt();
            if(temp == 1){
                System.out.println("您选择的是PlanA");
                studentSystem system = new PlanA();
                system.printStudentInfo(students);
                system.printAllStudentAverageScore(students);
            }
            else if(temp == 2){
                System.out.println("您选择的是PlanB");
                studentSystem system = new PlanB();
                system.printStudentInfo(students);
                system.printAllStudentAverageScore(students);
            }
            else {
                System.out.println("感谢您的使用");
            }
        } while (temp != 0);
        scanner.close();


    }
}

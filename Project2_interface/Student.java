package Project2_interface;

public class Student {
    public String name = null;
    public String gender = null;
    public double score = 0.0;
    public Student (){}
    public Student (String name, String gender, double score){
        this.name = name;
        this.gender = gender;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public double getScore() {
        return score;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setScore(double score) {
        this.score = score;
    }
    
    
}

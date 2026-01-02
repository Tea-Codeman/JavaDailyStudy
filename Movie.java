

public class Movie {
    private String name;
    private int year;
    private String director;
    private String genre;
    private double rating;
    private int id;

    public Movie(String name, int year, String director, String genre, double rating, int id) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.id = id;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public String getDirector() {
        return director;
    }
    public String getGenre(){
        return genre;
    }
    public double getRating(){
        return rating;
    }
    public int getId(){
        return id;
    }

    
    
}

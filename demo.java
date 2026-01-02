



public class demo {
    public static void main(String[] args) {
        //传入电影数据
        Movie[] movies = new Movie[6];
        movies[0] = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", "Drama", 9.2,1);
        movies[1] = new Movie("The Godfather", 1972, "Francis Ford Coppola", "Crime, Drama", 9.2,2);
        movies[2] = new Movie("The Dark Knight", 2008, "Christopher Nolan", "Action, Crime, Drama", 9.0,3);
        movies[3] = new Movie("12 Angry Men", 1957, "Tom Hanks", "Drama", 8.9,4);
        movies[4] = new Movie("Schindler's List", 1993, "Franz Kafka", "Drama", 8.8,5);
        movies[5] = new Movie("The Lord of the Rings: The Return of the King", 2003, "J.R.R. Tolkien", "Action, Adventure, Drama", 8.8,6);
        //用户查询电影数据
        OperatorMovies userQueryMovies = new OperatorMovies(movies);
        System.out.println("以下为电影列表:\n");
        userQueryMovies.printName();
        userQueryMovies.queryMovieById();

    }



// The new version of the code adds a parameter to the Movie constructor to specify the number of stars for the movie.
}

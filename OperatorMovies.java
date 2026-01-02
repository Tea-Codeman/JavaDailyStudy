

import java.util.Scanner;

//用户用于查询电影信息的类
public class OperatorMovies{
    public Movie[] movies; //电影数组
    public Movie searchedMovie; //搜索结果
    public  OperatorMovies(Movie[] movies){
        this.movies = movies;
    }
    public void queryMovieById(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查询的电影id：");
        int id = sc.nextInt();
        sc.close();
        for(Movie item : movies){
            if(item.getId() == id){
                searchedMovie = item;
                break;
            }
            
        }
        System.out.println("您想要查询的电影信息如下：");
        System.out.println("名字：" + searchedMovie.getName());
        System.out.println("年份：" + searchedMovie.getYear());
        System.out.println("导演：" + searchedMovie.getDirector());
        System.out.println("类别：" + searchedMovie.getGenre());
        System.out.println("评分：" + searchedMovie.getRating());

    }
    public void printName(){
        for(Movie item : movies){
            System.out.println(item.getName() + '\t' + item.getId());
        }
    }
    
        
}

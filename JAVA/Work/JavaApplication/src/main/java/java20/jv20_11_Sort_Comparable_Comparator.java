package java20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Movie implements Comparable<Movie> {
    
    private double rating;
    private String name;
    private int year;
    
    

    public Movie() {
        super();
    }

    public Movie(String name, double rating, int year) {
        super();
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRationg() {
        return rating;
    }

    public void setRationg(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie [rating=" + rating + ", name=" + name + ", year=" + year
                + "]";
    }

    @Override
    public int compareTo(Movie o) {
        // year를 오름차순으로 정렬
        // + 일 때
        // 0 일 때
        // - 일 때
        return this.year - o.year;
    }
    
    //rating 값으로 오름차순 정렬
    
    public static class RatingCompare implements Comparator<Movie> {
        // 오름차순 정렬 mode = 1;
        // 내림차순 정렬 mode = -1;

        private int mode = 1;
        
        public RatingCompare() {
            mode = 1;
        }
        
        public RatingCompare(boolean desc) {
            if (desc) {
                mode = -1;
            }
        }
        @Override
        public int compare(Movie o1, Movie o2) {
            if (o1.getRationg() < o2.getRationg()) {
                return -mode; // 바꾸지 않는다
            }
            else if (o1.getRationg() > o2.getRationg()) {
                return mode; // 바꾼다
            }
            else {
                return 0;
            }
        }
        
    }
    
    // name을 기준으로 오름차순 정렬
    public static class NameCompare implements Comparator<Movie> {

        private int mode = 1;
        
        public NameCompare() {
            mode = 1;
        }
        
        public NameCompare(boolean desc) {
            if (desc) {
                mode = -1;
            }
        }
        @Override
        public int compare(Movie o1, Movie o2) {
            
            // + 일 때
            // 0 일 때
            // - 일 때
            return o1.getName().compareTo(o2.getName()) * mode;
        }
        
    }
}

public class jv20_11_Sort_Comparable_Comparator {
    
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force", 8.3, 2015));
        list.add(new Movie("Start", 8.7, 1977));
        list.add(new Movie("Empir", 8.8, 1990));
        list.add(new Movie("Retur", 8.4, 2000));
        
        // year를 기준으로 정렬 : Comparable
        Collections.sort(list); // Movie.compareTo()를 사용하여 정렬된다
        
        for (Movie movie : list) {
            System.out.println(movie);
        }
        
        System.out.println();
        
        // rating을 기준으로 정렬 : Comparator
        // 1. Movie.RatingCompare 인스턴스 만들기
        // 2. Collections.sort() 실행
        // 3. 프린트
        
        Movie.RatingCompare rating = new Movie.RatingCompare();
        Collections.sort(list, rating);
        
        for (Movie movie : list) {
            System.out.println(movie);
        }
        
        System.out.println();
        
        // name을 기준으로 정렬 : Comparator
        // 1. Movie.NameCompare 인스턴스 만들기
        // 2. Collections.sort() 실행
        // 3. 프린트
        
        Movie.NameCompare name = new Movie.NameCompare();
        Collections.sort(list, name);
        
        for (Movie movie : list) {
            System.out.println(movie);
        }
        System.out.println();
        
        // 문제. rating을 기준으로 내림차순 정렬 : Comparator
        rating = new Movie.RatingCompare(true);
        Collections.sort(list, rating);
        
        for (Movie movie : list) {
            System.out.println(movie);
        }
        System.out.println();
        
        // 문제. name을 기준으로 내림차순 정렬 : Comparator
        name = new Movie.NameCompare(true);
        Collections.sort(list, name);
        
        for (Movie movie : list) {
            System.out.println(movie);
        }

    }
}

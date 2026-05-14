package IIP_homeworks.part2.homework2_2.Netflix;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        List<Movie> movies = NetflixDataGenerator.generateMovies();
        List<User> users = NetflixDataGenerator.generateUsers(movies);

        NetflixAnalytics analytics = new NetflixAnalytics(users, movies);

        //TASK2.1
        List<String> uniqueMovies = analytics.getAllUniqueMovieNamesSorted();
        System.out.println("Task2.1");
        System.out.println("All unique movies: " + uniqueMovies);
        System.out.println("Count of unique movies: " + uniqueMovies.size());

        //TASK2.2
        List<Movie> highRated = analytics.getSortedMoviesByRating();
        System.out.println("Task2.2");
        System.out.println("Movies with rating >= 8.0:");
        for (Movie movie : highRated){
            System.out.println(movie);
        }
        System.out.println("Count of great movies: " + highRated.size());

        //TASK2.3
        List<User> adultUsers = analytics.getAdultUsers();
        System.out.println("Task2.3");
        System.out.println("Adult users:");
        for (User user : adultUsers){
            System.out.println(user);
        }
        System.out.println("Count of adult users: " + adultUsers.size());

        //TASK2.4
        long totalViews = analytics.getTotalViews();
        System.out.println("Task2.4");
        System.out.println("Count of all views: " + totalViews);

        //TASK3.1
        Map<String, List<Movie>> byGenre = analytics.getMoviesByGenre();
        System.out.println("Task3.1");
        System.out.println("Movies by genre:");
        byGenre.forEach((genre, moviesList) -> {
            System.out.println(genre + ":");
            movies.forEach(movie -> System.out.println("   " + movie.getName()));
        });

        //TASK3.2
        Map<String, Long> genreViewCount = analytics.getCountOfWatches();
        System.out.println("Task3.2");
        System.out.println("Watches by each genre:");
        genreViewCount.forEach((genre, count) ->
                System.out.println("    " + genre + " - " + count + " views")
        );

        //TASK3.3
        Map<User, Long> userMovieCount = analytics.getCountOfWatchedMoviesByEachUser();
        System.out.println("Task3.3");
        System.out.println("Count of watched movies by each user");
        userMovieCount.forEach((user, count) ->
                System.out.println("    " + user.getName() + " - " + count + " movies")
        );

        //Task3.4
        Map<User, Optional<Movie>> longestMovie = analytics.getLongestMovie();
        System.out.println("Task3.4");
        System.out.println("Longest movie watched by each user:");
        for (User user : longestMovie.keySet()) {
            System.out.println("    " + user.getName() + " - " + longestMovie.get(user).get().getName());
        }

        //Task4.1
        String topGenre = analytics.getMostPopularGenreByAgeGroup();
        System.out.println("Task4.1");
        System.out.println("Most popular genre among users between 18-25 years is: " + topGenre);

        //Task4.2
        List<Movie> top3 = analytics.getTop3Movies();
        System.out.println("Task4.2");
        System.out.println("Top 3 most viewed movies:");
        System.out.println("1. " + top3.get(0).getName());
        System.out.println("2. " + top3.get(1).getName());
        System.out.println("3. " + top3.get(2).getName());
    }
}

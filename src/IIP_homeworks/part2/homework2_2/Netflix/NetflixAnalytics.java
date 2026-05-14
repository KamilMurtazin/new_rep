package IIP_homeworks.part2.homework2_2.Netflix;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class NetflixAnalytics {

    private List<User> users;
    private List<Movie> movies;

    public NetflixAnalytics(List<User> users, List<Movie> movies){
        this.users = users;
        this.movies = movies;
    }

    public List<String> getAllUniqueMovieNamesSorted() {
        return users.stream()
                .flatMap(user -> user.getWatchedMovies().stream())
                .map(Movie::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Movie> getSortedMoviesByRating(){
        return movies.stream()
                .filter(movie -> movie.getRating() >= 8.0)
                .sorted(Comparator
                        .comparing(Movie::getRating).reversed()
                        .thenComparing(Movie::getName))
                .collect(Collectors.toList());
    }

    public List<User> getAdultUsers(){
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .filter(user -> user.getWatchedMovies().size() > 0)
                .collect(Collectors.toList());
    }

    public long getTotalViews(){
        return users.stream()
                .flatMap(user -> user.getWatchedMovies().stream())
                .count();
    }

    public Map<String, List<Movie>> getMoviesByGenre(){
        return users.stream()
                .flatMap(user -> user.getWatchedMovies().stream())
                .distinct()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

    public Map<String, Long>  getCountOfWatches(){
        return users.stream()
                .flatMap(user -> user.getWatchedMovies().stream())
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
    }

    public Map<User, Long> getCountOfWatchedMoviesByEachUser(){
        return users.stream()
                .collect(Collectors.toMap(user -> user, user -> (long) user.getWatchedMovies().size()));
    }

    public Map<User, Optional<Movie>> getLongestMovie(){
        return users.stream()
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.getWatchedMovies().stream()
                                .max(Comparator.comparingInt(Movie::getDuration))
                ));
    }

    public String getMostPopularGenreByAgeGroup(){
        return users.stream()
                .filter(user -> user.getAge() >= 18 && user.getAge() <= 25)
                .flatMap(user -> user.getWatchedMovies().stream())
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No genre found");
    }

    public List<Movie> getTop3Movies() {
        return users.stream()
                .flatMap(user -> user.getWatchedMovies().stream())
                .collect(Collectors.groupingBy(movie -> movie, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Movie, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

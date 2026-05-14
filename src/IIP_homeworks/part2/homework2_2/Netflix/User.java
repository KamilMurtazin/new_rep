package IIP_homeworks.part2.homework2_2.Netflix;

import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private int age;
    private String country;
    private List<Movie> watchedMovies;

    public User(int id, String name, int age, String country, List<Movie> watchedMovies){
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.watchedMovies = watchedMovies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWatchedMovies(List<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    @Override
    public String toString(){
        return "ID: " + id + "|Person: " + name + ", " + age + ", " + country + "| Watched Movies: " + watchedMovies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

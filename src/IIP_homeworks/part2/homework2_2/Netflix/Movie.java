package IIP_homeworks.part2.homework2_2.Netflix;

import java.util.Objects;

public class Movie {

    private int id;
    private String name;
    private String genre;
    private int dateOfRelease;
    private double rating;
    private int duration;

    public Movie(int id, String name, String genre, int dateOfRelease, double rating, int duration){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.dateOfRelease = dateOfRelease;
        this.rating = rating;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateOfRelease(int dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString(){
        return "ID: " + id + " | About Movie: " + name + ", " + genre + " (" + dateOfRelease + ") " + rating  + duration + " (minutes)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

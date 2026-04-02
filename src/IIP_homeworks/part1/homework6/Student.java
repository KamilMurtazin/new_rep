package IIP_homeworks.part1.homework6;

public class Student implements Comparable<Student>{
    public String name;
    public double rating;
    public int missedClasses;

    public Student(String name, double rating, int missedClasses){
        this.name = name;
        this.rating = rating;
        this.missedClasses = missedClasses;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getMissedClasses() {
        return missedClasses;
    }

    @Override
    public String toString(){
        return "Name: " + name + "| Rating: " + rating + "| Count Of Missed Classes: " + missedClasses;
    }

    @Override
    public int compareTo(Student other){
        if (this.missedClasses != other.missedClasses){
            return Integer.compare(this.missedClasses, other.missedClasses);
        }
        if (this.rating != other.rating){
            return Double.compare(other.rating, this.rating);
        }

        return this.name.compareTo(other.name);
    }
}

package IIP_homeworks.part2.homework2_1;

@FunctionalInterface
public interface Validator<T> {
    boolean check(T item);
}

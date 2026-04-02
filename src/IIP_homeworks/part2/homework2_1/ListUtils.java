package IIP_homeworks.part2.homework2_1;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T> List<T> filterList(List<T> list, Validator<T> validator) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (validator.check(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

package week10.list.copy;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    private ListUtils() {

    }

    public static <T> List<T> copy(List<T> list) {
        List<T> copyList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            copyList.add(list.get(i));
        return copyList;
    }
}

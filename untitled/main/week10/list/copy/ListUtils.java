package week10.list.copy;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    private int a;
    private int b;
    private ListUtils() {

    }

    public static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        ListUtils listUtils = new ListUtils();
        ListUtils listUtils1= new ListUtils();
        System.out.println(listUtils);
        System.out.println(listUtils1);
        System.out.println(listUtils.toString()==listUtils1.toString());
    }
}
package week10.list.copy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ListUtilsTest {
    @Test
    public void testCopy() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> resultList = ListUtils.copy(list);
        Assertions.assertNotSame(list,resultList);
        Assertions.assertEquals(list.size(), resultList.size());
        Assertions.assertEquals(list.get(0), resultList.get(0));
        Assertions.assertEquals(list.get(1), resultList.get(1));
        Assertions.assertEquals(list.get(2), resultList.get(2));


    }
}
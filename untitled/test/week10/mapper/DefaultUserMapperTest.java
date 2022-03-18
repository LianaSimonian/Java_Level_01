package week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {
    @Test
    public void testMap() {
        UserMapper testSubject = new DefaultUserMapper();
        User user = new User(1L, "student", "Lord");
        Assertions.assertEquals("student", testSubject.map(user).getUsername());
        Assertions.assertEquals("Lord", testSubject.map(user).getFirstName());
    }

}
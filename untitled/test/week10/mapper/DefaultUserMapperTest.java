package week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {
    @Test
    public void testMap() {
        UserMapper testSubject = new DefaultUserMapper();
        User user = new User(1L, "student", "Lord");
        UserModel usermodel =testSubject.map(user);
        Assertions.assertEquals("student", usermodel.getUsername());
        Assertions.assertEquals("Lord", usermodel.getFirstName());
    }

}
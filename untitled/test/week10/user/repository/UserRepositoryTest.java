package week10.user.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

class UserRepositoryTest {
    private UserRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new UserRepository();
    }

    @Test
    public void testSaveWhenUserIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(null);
            }
        });
        Assertions.assertEquals("argument entity  is null", illegalArgumentException.getMessage());
    }

    @Test
    public void testSaveWhenUserDoesNotExist() {
        User user = new User(123L, "username", 18);
        testSubject.save(user);
        Assertions.assertEquals(1, testSubject.count());
        Assertions.assertEquals(user, testSubject.findById(user.getId()));

    }

    @Test
    public void testSaveWhenUserExist() {
        testSubject.save(new User(12L, "username", 18));
        User user = new User(12L, "username1", 19);
        testSubject.save(user);
        Assertions.assertEquals(1, testSubject.count());
        Assertions.assertEquals("username1", testSubject.findById(user.getId()).getUsername());
        Assertions.assertEquals(19, testSubject.findById(user.getId()).getAge());
        Assertions.assertEquals(12L, testSubject.findById(user.getId()).getId());
    }

    @Test
    public void testDeleteWhenEntityNotFound() {
        testSubject.save(new User(12L, "username", 19));
        EntityNotFoundException entityNotFoundException = Assertions.assertThrows(EntityNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.delete(new User(13L, "username", 19));
            }
        });
        Assertions.assertEquals("id=13, username='username', age=19 user not found", entityNotFoundException.getMessage());
    }

    @Test
    public void testDelete() {
        User user = new User(14L, "username2", 21);
        testSubject.save(user);
        Assertions.assertEquals(1, testSubject.count());
        testSubject.delete(user);
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testFindByIdWhenDoesNotFound() {
        Assertions.assertNull(testSubject.findById(12L));
    }

    @Test
    public void testCountWhenRepositoryIsEmpty() {
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testCountWhenRepositoryContains2Entities() {
        Assertions.assertEquals(0, testSubject);
        testSubject.save(new User(12L, "username", 18));
        testSubject.save(new User(13L, "username", 18));
        Assertions.assertEquals(2, testSubject.count());
    }

    @Test
    public void testDeleteAllWhenIsEmpty() {
        Assertions.assertEquals(0, testSubject.count());
        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testDeleteAllWhenContains2Entities() {
        testSubject.save(new User(12L, "username", 18));
        testSubject.save(new User(13L, "username1", 18));
        Assertions.assertEquals(2, testSubject.count());
        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.count());
    }

    @Test
    public void testFindAllWhenEmpty() {
        List<User> users = testSubject.findAll();
        Assertions.assertEquals(0, users.size());

    }

    @Test
    public void testFindAllWhenContains3Entities() {
        User user1 = new User(12L, "username", 18);
        User user2 = new User(13L, "username", 18);
        User user3 = new User(14L, "username", 18);
        testSubject.save(user1);
        testSubject.save(user2);
        testSubject.save(user3);
        List<User> listOfUser = testSubject.findAll();
        Assertions.assertEquals(3, listOfUser.size());
        Assertions.assertEquals(user1, listOfUser.get(0));
        Assertions.assertEquals(user2, listOfUser.get(1));
        Assertions.assertEquals(user3, listOfUser.get(2));
    }
}
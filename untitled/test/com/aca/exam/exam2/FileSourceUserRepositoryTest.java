package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class FileSourceUserRepositoryTest {
    private FileSourceUserRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = FileSourceUserRepository.getInstance();
    }

    @Test
    public void testGetInstance() {
        Assertions.assertNotNull(testSubject);
        FileSourceUserRepository fileSourceUserRepository = FileSourceUserRepository.getInstance();
        Assertions.assertEquals(fileSourceUserRepository, testSubject);
    }

    @Test
    public void testFindByIdWhenIdIsNotFound() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.findById(null);
            }
        });
        Assertions.assertEquals("id can not be null", illegalArgumentException.getMessage());
    }

    @Test
    public void testFindByIdWhenIdIsFound() {
        User user = new User("barracudaassign", "Kaiya", "Dunlap");
        Assertions.assertTrue(user.equals(testSubject.findById("barracudaassign")));
    }

    @Test
    public void testFindAll() {
        File file = new File("D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\\\com\\aca\\exam\\exam2\\User.txt");
        List<User> userList = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String element = scanner.nextLine();
                userList.add(FileSourceUserRepository.createUserObjectFromString(element));
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        Assertions.assertTrue(userList.equals(testSubject.findAll()));
    }
}
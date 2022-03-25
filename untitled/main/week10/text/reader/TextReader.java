package week10.text.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TextReader {
    public static List<String> readLines() throws FileNotFoundException {
        List<String> stringList = new LinkedList<>();
        Scanner scanner = new Scanner(new File("D:\\Users\\user\\IdeaProjects\\Java_Level_01\\untitled\\main\\com\\aca\\homework\\week10\\text\\reader\\doc_numbers.txt"));
        while (scanner.hasNextLine())
            stringList.add(scanner.nextLine());
        scanner.close();
        return stringList;
    }

    public static <T> void print(List<T> stringList) {
        int i = 0;
        for (T item : stringList) {
            System.out.println(" index number:" + i + ", " + "item: " + item);
            i++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        print(readLines());
    }
}

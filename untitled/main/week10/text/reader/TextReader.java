package week10.text.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextReader {
    public static List<String> readLines() throws FileNotFoundException {
        List<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("D:\\Users\\user\\IdeaProjects\\Java_Level_01\\untitled\\main\\com\\aca\\homework\\week10\\text\\reader\\doc_numbers.txt"));
        while (scanner.hasNextLine())
            stringList.add(scanner.nextLine());
        scanner.close();
        return stringList;
    }

    public static void print(List<String> stringList) {
        for (int i = 0; i < stringList.size(); i++)
            System.out.println(" index number:" + i + ", " + "item: " + stringList.get(i));

    }

    public static void main(String[] args) throws FileNotFoundException {
        print(readLines());
    }
}

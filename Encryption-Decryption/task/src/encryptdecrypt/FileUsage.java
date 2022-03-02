package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileUsage {

    public static void writeToFile(File fileName, String str) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(str);
        } catch (IOException e) {
            System.out.printf("Error: An exception occurs %s", e.getMessage());
        }
    }

    public static String readFile(File f) {
        String strInput = "";
        try (Scanner scanner = new Scanner(f)) {
            strInput = scanner.nextLine();
        } catch (NoSuchElementException | FileNotFoundException e) {
            System.out.println("Error: Cannot read file: " + e.getMessage());
        }

        return strInput;
    }
}

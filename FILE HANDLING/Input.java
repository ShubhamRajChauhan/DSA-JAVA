import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        // try(InputStreamReader isr = new InputStreamReader(System.in)) {
        // System.out.print("Enter some letters:");
        // int letters = isr.read();
        // while(isr.ready()) {
        // System.out.println((char) letters);
        // letters = isr.read();
        // }
        // //isr.close(); //no need to write the try-catch automatically close the stream
        // System.out.println();
        // } catch (IOException e) {
        // System.out.println(e.getMessage());
        // }

        try (FileReader fr = new FileReader("note.txt")) {
            int letters = fr.read();
            while (fr.ready()) {
                System.out.println((char) letters);
                letters = fr.read();
            }
            // fr.close(); //no need to write the try-catch automatically close the stream
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // byte to char stream and then reading char stream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("You typed: " + br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(new FileReader("note.txt"))) {
            while(br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

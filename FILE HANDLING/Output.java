import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Output {
    public static void main(String[] args) {
        OutputStream os = System.out;
        // os.write(😃); // range is exceeded

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello World");
            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');
            char[] arr = "hello world".toCharArray();
            osw.write(arr);
            // osw.write(😃);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        try (FileWriter fw = new FileWriter("note.txt", true)) {
            fw.write("this should be appended");  //it append the "this should be appended" in the note.txt
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        try (BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))) {
            bw.write("Hare Krishna"); //this will change the note.txt and rewrite it as Hare Krishna
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

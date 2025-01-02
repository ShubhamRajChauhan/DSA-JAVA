import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Create {
    public static void main(String[] args) {

        // create
        try {
            File fo = new File("new-file.txt");
            fo.createNewFile(); // now a new file is created with the name new-file.txt
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write in the file
        try {
            FileWriter fw = new FileWriter("new-file.txt");
            fw.write("Hello I am Shubham"); // this will add Hello I am Shubham to the new-file.txt
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // reading from a file
        try (BufferedReader br = new BufferedReader(new FileReader("new-file.txt"))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // want to delete 
        try {
            File fo = new File("random.txt");
            fo.createNewFile(); // now a new file is created with the name random.txt
            if(fo.delete()) {
                System.out.println(fo.getName()); //delete then print the name which file is deleted
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

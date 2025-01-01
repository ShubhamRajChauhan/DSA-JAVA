import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static String generate(int size) {
        StringBuffer sb = new StringBuffer(size);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (int) (random.nextFloat() * 26);
            sb.append((char) randomChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // constructor 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        // constructor 2
        StringBuffer sb2 = new StringBuffer("Bikky Singh");

        // constructor 3
        StringBuffer sb3 = new StringBuffer(30); // here pass the capacity of buffer
        System.out.println(sb3.capacity());

        sb.append("WeMakeDevs");
        sb.append(" is nice!");

        // sb.insert(2, " Rahul ");

        sb.replace(1, 5, "Bikky");

        sb.delete(1, 5);

        // sb.reverse();

        String str = sb.toString();
        System.out.println(str);

        int n = 20;
        String name = generate(n);
        System.out.println(name);

        // removing whitespaces
        String sentence = "Hi h   hjh  hjkso  siowi     w ";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        // split
        String arr = "Kunal,Apoorv,Rahul,Snehal";
        String[] names = arr.split(",");
        System.out.println(Arrays.toString(names));

        // rounding off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(7.29));
    }
}

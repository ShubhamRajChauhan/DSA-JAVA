public class Main {
    public static void main(String[] args) {

        //constructor 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        //constructor 2
        StringBuffer sb2 = new StringBuffer("Bikky Singh");

        //constructor 3
        StringBuffer sb3 = new StringBuffer(30); //here pass the capacity of buffer
        System.out.println(sb3.capacity());

        sb.append("WeMakeDevs");
        sb.append(" is nice!");

        //sb.insert(2, " Rahul ");

        sb.replace(1, 5, "Bikky");

        sb.delete(1, 5);

        sb.reverse();

        String str = sb.toString();
        System.out.println(str); 
    }
}

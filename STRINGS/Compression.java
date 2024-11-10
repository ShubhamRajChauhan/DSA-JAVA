
public class Compression {
    public static String compress(String str) {
        //String newStr = "";
        StringBuilder newStr = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            //Integer count = 1;
            int count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            //newStr += str.charAt(i);
            newStr.append(str.charAt(i));
            if(count > 1) {
                //newStr += count.toString();
                newStr.append(count);
            }
        }
        //return newStr;
        return newStr.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }
}

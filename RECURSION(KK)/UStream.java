public class UStream {
    public static void main(String[] args) {
        //1.
        skip("", "baccad");
        //2.
        System.out.println(skip("baccad"));
    }
    
    //pass the ans string in argument
    static void skip(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        
        if(ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        } 
    }

    //(or)
    //create ans variable in the function body
    static String skip(String up) {
        if(up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);
        
        if(ch == 'a') {
             return skip(up.substring(1));
        } else {
            return ch +skip(up.substring(1));
        } 
    }
}

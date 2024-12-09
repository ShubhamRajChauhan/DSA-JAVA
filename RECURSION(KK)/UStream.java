public class UStream {
    public static void main(String[] args) {
        //1.
        skip("", "baccad");
        //2.
        System.out.println(skip("baccad"));
        //3.
        System.out.println(skipApple("bdapplefg"));
        //4.
        System.out.println(skipAppNotApple("bacapplcdah"));
    }
    
    //1.pass the ans string in argument
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
    //2.create ans variable in the function body
    static String skip(String up) {
        if(up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);
        
        if(ch == 'a') {
             return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        } 
    }



    //3.want to skip a entire string
    static String skipApple(String up) {
        if(up.isEmpty()) {
            return "";
        }
        
        if(up.startsWith("apple")) {
             return skipApple(up.substring(5));
        } else {
            return up.charAt(0) + skipApple(up.substring(1));
        } 
    }


    //3.skip app not apple
    static String skipAppNotApple(String up) {
        if(up.isEmpty()) {
            return "";
        }
        
        if(up.startsWith("app") && !up.startsWith("apple")) {
             return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        } 
    }
}

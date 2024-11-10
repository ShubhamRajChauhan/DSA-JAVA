public class Substring {
    public static String substring(String str, int si, int ei) {
        String substr = "";
        for(int i=si; i<ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    
    //OR YOU CAN JUST FIND THE SUBSTRING BY USING THIS FUNCTION str.substring()
    public static void main(String args[]) {
        String str = "HelloWorld";
        System.out.println(str.substring(0, 5));
        //System.out.println(substring(str, 0, 5));
    }
}

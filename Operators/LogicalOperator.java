public class LogicalOperator {
    public static void main(String args[]) {
        System.out.println( (5>2) && (5>0));  //logical AND(&&)
        System.out.println( (3<2) && (5>0));  //logical AND(&&)
        System.out.println( (3<2) || (5<0));  //logical OR(||)
        System.out.println( (3<2) || (5>0));  //logical OR(||)
        System.out.println( !(3<2) );         //logical NOT(!)
    }
}

public class thirtyFive {

    public static int search(int num[], int target) {
        int n= num.length;
        for( int i=0; i<n; i++){
            if(num[i] >= target) {
                return i;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        int num[] = {1,3,5,6};
        int target = 7;
        System.out.println(search(num, target));
    }
}

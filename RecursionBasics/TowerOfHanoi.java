public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char src, char dest, char help) {
        if(n == 1) {
            System.out.println("Move disk"+n+" from "+src+" to "+dest);
            return;
        }

        towerOfHanoi(n-1, src, help, dest);
        System.out.println("Move disk"+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, help, dest, src);
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}

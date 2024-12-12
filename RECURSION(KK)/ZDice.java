import java.util.ArrayList;

public class ZDice {
    public static void main(String[] args) {
        //1.
        dice("", 4);
        //2.
        System.out.println(diceRet("", 4));

    }


    //1.
    static void dice(String p, int target){
        if(target == 0) {
            System.out.println(p);
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }


    //2. return ArrayList
    static ArrayList<String> diceRet(String p, int target){
        if(target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        for(int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i));
        }
        return list;
    }
}

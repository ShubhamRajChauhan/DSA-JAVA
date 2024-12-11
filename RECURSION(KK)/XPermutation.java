import java.util.ArrayList;

public class XPermutation {
    public static void main(String[] args) {
        //1.
        permutations("", "abc");

        //2.
        ArrayList<String> ans = permutationsList("", "abc");
        System.out.println(ans);

        //3.
        System.out.println(permutationsCount("", "abc"));
    }

    //1.
    static void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

    //2.returning ArrayList
    static ArrayList<String> permutationsList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        //local to this call
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    //3.count
    static int permutationsCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}

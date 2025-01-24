public class ATries {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    //insert 0(L)   (L = length of largest word)
    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    //search 0(L)   (L = length of largest word)
    public static boolean search(String key) {
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //startsWith 0(L)
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        //String words[] = {"the", "a", "there", "their", "any", "thee"};
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";
        String prefix3 = "ap";
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        // System.out.println(search("thee")); //true
        // System.out.println(search("thor")); //false
        // System.out.println(search("any")); //true
        // System.out.println(search("an")); //false


        System.out.println(startsWith(prefix1)); //true
        System.out.println(startsWith(prefix2)); //false
        System.out.println(startsWith(prefix3)); //true
    }
}

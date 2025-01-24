//PREFIX PROBLEM

public class CPrefixProblem {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }

            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node(); //with freq 1 , already initialized 
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
    }


    public static String findPrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            prefix.append(word.charAt(i));
            if (curr.children[idx].freq == 1) {
                // Unique prefix found
                break;
            }
            curr = curr.children[idx];
        }

        return prefix.toString(); 
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};

        for (String word : arr) {
            insert(word);
        }

        // Find and print the shortest unique prefix for each word
        System.out.println("Shortest unique prefixes:");
        for (String word : arr) {
            System.out.println(word + " -> " + findPrefix(word));
        }
    }
}



/* 
OUTPUT: Shortest unique prefixes:
        zebra -> z
        dog -> dog
        duck -> du
        dove -> dov
*/
//Disjoint Set Union

import java.util.*;

public class eighteen {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }

    //Find
    public static int find(int x) {
        if(x == par[x]) {
            return x;
        }
        // return find(par[x]);
        return par[x] = find(par[x]);  //path compression optimization in union find
    }

    //Union
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }
    public static void main(String[] args) {
        init();
        System.out.println(find(3)); //3
        union(1, 3);
        System.out.println(find(3)); //1
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3)); //1
        System.out.println(find(4)); //1  
        union(1,5);
    }
}


//TC : union & find => 0(4k) or 0(4) or 0(1)
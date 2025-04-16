//Ninja's Training -> Striver

/* 
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three 
activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day.
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. 
Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
Your task is to calculate the maximum number of merit points that Ninja can earn.
*/


//------------------------Recursion-------------------------------------
/* 
public class SIXNinjaTraining {
    static int f(int day, int last, int[][] points) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }

        return maxi;
    }

    public static int ninjaTraining(int n, int[][] points) {
        return f(n - 1, 3, points);
    }
}
*/



//------------------------Memoization-------------------------------------

public class SIXNinjaTraining {
    static int f(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        if(dp[day][last] != -1) {
            return dp[day][last];
        } else {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    int point = points[day][task] + f(day - 1, task, points, dp);
                    maxi = Math.max(maxi, point);
                }
            }

            maxi = dp[day][last];
            return maxi;
        }   
    }

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return f(n - 1, 3, points, dp);
    }
}

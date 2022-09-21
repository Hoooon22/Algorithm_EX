import java.util.*;

public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        
        // DP
        for (int x = 1; x < triangle.length; x++) {  
            for (int y = 0; y <= x; y++) {
                if (y == 0) { // left
                    dp[x][y] = dp[x-1][y] + triangle[x][y];
                }
                else if (y == triangle[x].length-1) { // right
                    dp[x][y] = dp[x-1][y-1] + triangle[x][y];
                }
                else { // others
                    dp[x][y] = Math.max(dp[x-1][y-1], dp[x-1][y]) + triangle[x][y];
                }
            }
        }
        for (int i = 0; i < triangle[triangle.length-1].length; i++) {
            answer = Math.max(dp[triangle.length-1][i], answer);
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        System.out.println();
    }
}

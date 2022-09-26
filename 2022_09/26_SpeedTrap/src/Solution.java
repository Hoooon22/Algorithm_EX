import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Solution {

    public static int solution(int[][] routes) {
        int answer = 0;
        int[][] camera = new int[routes.length][routes[0].length];
        boolean isOverlap = false;

        // sort
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1]; 
            }
        });

        // init
        camera[0][0] = routes[0][0];
        camera[0][1] = routes[0][1];
        answer++;
        
        for (int i = 1; i < routes.length; i++) {
            for (int j = 0; j < answer; j++) {
                // ! 겹치는 상황이 하나가 아님 !
                if (routes[i][0] <= camera[j][0] && routes[i][1] >= camera[j][1]) {
                    isOverlap = true;
                    break;
                }
                else if (routes[i][1] <= camera[j][0] && routes[i][0] >= camera[j][1]) { // 왼쪽 범위 안에 있다면
                    camera[j][1] = routes[i][1];
                    isOverlap = true;
                    break;
                }
                else if (routes[i][1] >= camera[j][0] && routes[i][0] <= camera[j][1]) { // 오른쪽 범위 안에 있다면
                    camera[j][0] = routes[i][0];
                    isOverlap = true;
                    break;
                }
            }
            if (!isOverlap) { // 겹치는 부분이 없다면
                camera[answer][0] = routes[i][0];
                camera[answer][1] = routes[i][1];
                answer++;
            }
            isOverlap = false;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        int[][] array = {{2, 2},{0, 1},{-10,9}};
        System.out.println(solution(array));
    }
}

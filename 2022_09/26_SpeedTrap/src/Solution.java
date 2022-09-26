public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int solution(int[][] routes) {
        int answer = 0;
        int[][] camera = new int[routes.length][routes[0].length];
        boolean isOverlap = false;

        // init
        camera[0][0] = routes[0][0];
        camera[0][1] = routes[0][1];
        answer++;
        
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j <= answer; j++) {
                // ! 겹치는 상황이 하나가 아님 !
                if (routes[i][1] <= camera[j][0] || routes[i][0] >= camera[j][1]) { //  범위 안에 있다면
                    isOverlap = true;
                    break;
                }
            }
            if (!isOverlap) { // 겹치는 부분이 없다면
                answer++;
                camera[answer][0] = routes[i][0];
                camera[answer][1] = routes[i][1];
            }
            isOverlap = false;
        }

        return answer;
    }
}

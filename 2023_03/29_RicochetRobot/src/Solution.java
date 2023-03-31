/*
 알고리즘 문제 : 프로그래머스 - 리코쳇 로봇
 실습 날짜 : 2023-03-29
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/169199
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 0;
        char[][] arr_board = new char[board.length+2][board[0].length()+2]; // array of board
        int[] start = new int[2]; // start x,y

        // board to array_board
        for (int i = 0; i < arr_board[0].length; i++) { // 1 row
            arr_board[0][i] = 'D';
        }
        for (int i = 1; i < arr_board.length-1; i++) { // 2 ~ last-1 row
            arr_board[i][0] = 'D';
            for (int j = 1; j < arr_board[0].length-1; j++) { // each row
                if (board[i-1].charAt(j-1) == 'R') { // start
                    start[0] = i; // x
                    start[1] = j; // y
                    arr_board[i][j] = '.';
                }
                else {
                    arr_board[i][j] = board[i-1].charAt(j-1);
                }
            }
            arr_board[i][arr_board[0].length-1] = 'D';
        }
        for (int i = 0; i < arr_board[0].length; i++) { // last row
            arr_board[arr_board.length-1][i] = 'D';
        }

        answer = bfs(arr_board, start[0], start[1], 0);

        return answer;
    }

    public static int bfs(char[][] arr_board, int x, int y, int goal) {
        boolean visited[][] = new boolean[arr_board.length][arr_board[0].length];
        LinkedList<int[]> queue = new LinkedList<int[]>();
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        // start point
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        // until queue empty
        while (!queue.isEmpty()) {
            var curr = queue.remove();
            var curr_x = curr[0];
            var curr_y = curr[1];
            goal++;

            // 4방향 벽까지 상하좌우 이동 
            for (int i = 0; i < dx.length; i++) {
                // 현재 좌표 설정
                var nx = curr_x;
                var ny = curr_y;

                System.out.print(nx + " ");
                System.out.println(ny);

                // 다음 방향이 바로 벽이라면 넘어감
                if (arr_board[nx+dx[i]][ny+dy[i]] == 'D') 
                    continue;
                // 아니라면, 벽에 부딪힐때 까지 전진
                for (int j = 1; j < 100; j++) {
                    // 한칸 전진
                    nx += dx[i];
                    ny += dy[i];

                    if (arr_board[nx+dx[i]][ny+dy[i]] == 'D' && arr_board[nx][ny] == 'G') { // 현재 기준, 다음 블럭이 벽이고 지금 블럭이 목표지점이라면
                        // 리턴
                        return goal;                        
                    }
                    else if (arr_board[nx+dx[i]][ny+dy[i]] == 'D' && !visited[nx][ny]) { // 현재 기준, 다음 블럭이 벽이면서 방문했다면
                        // 현재 위치를 큐에 저장
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        break;
                    }
                    else if (arr_board[nx+dx[i]][ny+dy[i]] == 'D' && visited[nx][ny]) { // 벽인데 만났다면,
                        // 스킵
                        break;
                    }
                    // 나머지는 다음으로 전진
                }
            }
        }

        return goal;
    }
}

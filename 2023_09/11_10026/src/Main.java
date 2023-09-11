import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int size;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        char[][] map = new char[size][size];
        boolean[][] visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
            for (int j = 0; j < size; j++) {
                map[i][j] = str.charAt(j);
                visited[i][j] = false;
            }
        }
    }

    // 1. no Color blindness
    public static int bfs_no(int start, char[][] map, boolean[][] visited) {
        int result = 0;
    }
}
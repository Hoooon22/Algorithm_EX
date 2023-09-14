
/*
 * Title : ATM
 * Link : https://www.acmicpc.net/problem/11399
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int size;
        int arr[];
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // sort
        Arrays.sort(arr);

        // sum
        for (int i = 0; i < size; i++) {
            answer += arr[i] * (size - i);
        }

        System.out.println(answer);
    }
}
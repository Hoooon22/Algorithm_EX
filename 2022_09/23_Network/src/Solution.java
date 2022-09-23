import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public boolean stringSimilar(String str1, String str2) {
        int count = 0;
        String[] array_word1;
        String[] array_word2;
        array_word1 = str1.split("");
        array_word2 = str2.split("");

        for (int i = 0; i < str1.length(); i++) {
            if (array_word1[i].equals(array_word2[i])) {
                count++;
            }
        }
        if (count == str1.length() - 1) {
            return true;
        }

        return false;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length+1];
        ArrayList<ArrayList<String>> graph = new ArrayList<ArrayList<String>>();
        Queue<Integer> queue = new LinkedList<>();
        int tmp;

        Arrays.fill(visited, false);
        // n번쨰 인덱스는 begin
        for (int i = 0; i <= words.length; i++) {
            graph.add(new ArrayList<>());
        }
        tmp = words.length;
        visited[tmp] = true;

        // no target
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // is target
        for (int i = 0; i < words.length; i++) {
            if (stringSimilar(begin, words[i]) && !visited[i]) {
                graph.get(tmp).add(words[i]);
                visited[i] = true;
                queue.add(i);
            }
        }
        tmp = queue.poll();
        while (!words[tmp].equals(target) || !queue.isEmpty()) {
            for (int i = 0; i < words.length; i++) {
                if (stringSimilar(words[tmp], words[i]) && !visited[i]) {
                    graph.get(tmp).add(words[i]);
                    visited[i] = true;
                    queue.add(i);
                }
            }
            tmp = queue.poll();
        }

        // Search
        if (!words[tmp].equals(target)) {
            return 0;
        }

        queue.clear();
        int n = tmp;
        queue.add(tmp);
        while (n != words.length) {
            for (int i = 0; i <= words.length; i++) {
                if (graph.get(i).contains(words[n])) {
                    n = i;
                    answer++;
                }
            }
        }

        return answer;
    }
}

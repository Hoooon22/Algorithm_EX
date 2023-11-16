import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> usedWords = new ArrayList<>(); // 사용한 단어
        usedWords.add(words[0]); // 첫 단어 추가
        
        for (int i = 1; i < words.length; i++) {
            // 1. 끝 알파벳과 첫 알파벳이 같지 않을 경우
            // 2. 똑같은 단어를 말했을 경우            
            if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) ||
                usedWords.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                
                break;
            }
            
            usedWords.add(words[i]);
        }
        
        return answer;
    }
}
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int calculation (ArrayList<String>[] arr_ban, int index) {


        return 0;
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ArrayList<String>[] arr_ban = new ArrayList[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            arr_ban[i] = new ArrayList<String>();
        }
        int count = 0;

        for (int i = 0; i < banned_id.length; i++) { // ban
            for (int j = 0; j < user_id.length; j++) { // user
                if (user_id[j].length() == banned_id[i].length()) {
                    count = 0;
                    for (int k = 0; k < user_id[j].length(); k++) {
                        if (user_id[j].charAt(k) == banned_id[i].charAt(k) || banned_id[i].charAt(k) == '*') {
                            count++;
                        }
                    }
                    if (user_id[j].length() == count) { // 밴 의심 대상이라면
                        arr_ban[i].add(user_id[j]);
                    }
                }
            }
        }

        // calculation
        answer = calculation(arr_ban, 0);

        return answer;
    }
}

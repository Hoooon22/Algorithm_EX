/*
 알고리즘 문제 : 프로그래머스 - 여행 경로
 실습 날짜 : 2022-11-02
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/43164
*/
import java.util.*;

public class Solution {
    String[][] tickets = new String[1000][2];

    public static void dfs(List<List<String>> tickets, List<String> route, Boolean[] visit, int x) {
        List<String> remain_ticket = new ArrayList<>();
        for (int k = 0; k < tickets.size(); k++) {
            if (!visit[k]) {
                remain_ticket.add(tickets.get(k).get(0));
            }
        }
        if (remain_ticket.contains(tickets.get(x).get(1))) {
            dfs(tickets, route, visit, x+1);
        }
        else {
            visit[x] = true;
            route.add(tickets.get(x).get(1));
    
            for (int j = 1; j < tickets.size(); j++) {
                if (route.get(route.size()-1).compareTo(tickets.get(j).get(0)) == 0 && !visit[j]) {
                    if (remain_ticket.contains(route.get(route.size()-1))) {
                        dfs(tickets, route, visit, j);
                    }
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        int icn_count = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].compareTo("ICN") == 0) {
                icn_count++;
            }
        }
        
        List<List<String>> tickets_list = new ArrayList<>();
        String[][] ICN_arr = new String[icn_count][2];
        String[][] no_ICN_arr = new String[tickets.length-icn_count][2];
        List<String> route = new ArrayList<String>();
        Boolean[] visit = new Boolean[tickets.length];
        Arrays.fill(visit, false);

        int a=0, b=0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].compareTo("ICN") == 0) {
                ICN_arr[a][0] = tickets[i][0];
                ICN_arr[a][1] = tickets[i][1];
                a++;
            }
            else {
                no_ICN_arr[b][0] = tickets[i][0];
                no_ICN_arr[b][1] = tickets[i][1];
                b++;
            }
        }
        Arrays.sort(ICN_arr, new Comparator<String[]>() {
			
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });
        Arrays.sort(no_ICN_arr, new Comparator<String[]>() {
			
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }			
        });

        for (int i = 0; i < ICN_arr.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add(ICN_arr[i][j]);
            }
            tickets_list.add(list);
        }
        for (int i = 0; i < no_ICN_arr.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add(no_ICN_arr[i][j]);
            }
            tickets_list.add(list);
        }
        route.add("ICN");
        dfs(tickets_list, route, visit, 0);

        answer = route.toArray(new String[tickets.length-1]);

        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

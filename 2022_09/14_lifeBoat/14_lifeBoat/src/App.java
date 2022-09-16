import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Boolean isfull = false;
        Vector<Integer> V_boat = new Vector<Integer>();
        Vector<Integer> V_people = new Vector<Integer>();
        for (int i : people) {
            V_people.add(i);
        }
        V_people.sort(c);

        V_boat.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            for (int j = 0; j < i; j++) {
                if (V_boat.get(j) + i <= limit) {
                    int tmp = V_boat.get(j);
                    V_boat.remove(j);
                    V_boat.add(j, tmp+i);
                    isfull = true;
                    break;
                }
            }
            if (isfull) {
                V_boat.add(i);
            }
        }

        answer = V_boat.size();
        return answer;
    }
}
public class Solution {

    public boolean isGoal(int currentX, int currentY, int itemX, int itemY) {
        if (currentX == itemX && currentY == itemY) {
            return true;
        }
        return false;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] dir_clock = new int[50][50];
        int[][] dir_counterclock = new int[50][50];
        int dir_clock_count = 0;
        int dir_counterclock_count = 0;
        int currentX = characterX;
        int currentY = characterY;

        // 2 way in -> first way = clockwise
        // 1 - down / 2 - up / 3 - right / 4 - left /
        // box's direction setting
        for (int i = 0; i < rectangle.length; i++) {
            // left side - up
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++) {
                if (dir_clock[rectangle[i][0]][j] < 2) {
                    dir_clock[rectangle[i][0]][j] = 2;
                }
            }
            // top side - right
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                if (dir_clock[j][rectangle[i][3]] < 3) {
                    dir_clock[j][rectangle[i][3]] = 3;
                }
            }
            // right side - down
            for (int j = rectangle[i][1]; j < rectangle[i][3]; j++) {
                if (dir_clock[rectangle[i][2]][j] == 4 || dir_clock[rectangle[i][2]][j] == 0) {
                    dir_clock[rectangle[i][2]][j] = 1;
                }
            }
            // bottom side - left
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                if (dir_clock[j][rectangle[i][1]] < 4) {
                    dir_clock[j][rectangle[i][1]] = 4;
                }
            }
        }
        while (!isGoal(currentX, currentY, itemX, itemY)) {
            switch (dir_clock[currentX][currentY]) {
                case 1:
                    currentY--;
                    break;
                case 2:
                    currentY++;
                    break;
                case 3:
                    currentX++;
                    break;
                case 4:
                    currentX--;
                    break;
                default:
                    break;
            }
            dir_clock_count++;
        }

        // 2 way in -> second way = counterclockwise
        //  1 - down / 2 - up / 3 - left / 4 - right /
        // box's direction setting
        for (int i = 0; i < rectangle.length; i++) {
            // left side - down
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++) {
                if (dir_counterclock[rectangle[i][0]][j] == 4 || dir_counterclock[rectangle[i][0]][j] == 0) {
                    dir_counterclock[rectangle[i][0]][j] = 1;
                }
            }
            // top side - left
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                if (dir_counterclock[j][rectangle[i][3]] < 3) {
                    dir_counterclock[j][rectangle[i][3]] = 3;
                }
            }
            // right side - up
            for (int j = rectangle[i][1]; j < rectangle[i][3]; j++) {
                if (dir_counterclock[rectangle[i][2]][j] < 2) {
                    dir_counterclock[rectangle[i][2]][j] = 2;
                }
            }
            // bottom side - right
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                if (dir_counterclock[j][rectangle[i][1]] < 4) {
                    dir_counterclock[j][rectangle[i][1]] = 4;
                }
            }
        }
        while (!isGoal(currentX, currentY, itemX, itemY)) {
            switch (dir_counterclock[currentX][currentY]) {
                case 1:
                    currentY--;
                    break;
                case 2:
                    currentY++;
                    break;
                case 3:
                    currentX--;
                    break;
                case 4:
                    currentX++;
                    break;
                default:
                    break;
            }
            dir_counterclock_count++;
        }

        answer = (dir_clock_count > dir_counterclock_count) ? dir_clock_count : dir_counterclock_count;
        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
 
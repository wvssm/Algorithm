import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int numCommands, answer;
    static int[] gears;  // 각 톱니바퀴를 8비트 정수로 저장
    static int[][] rotationOrder;  // 회전 명령 (1-indexed 톱니바퀴 번호와 회전 방향)

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {
            input();
            answer = 0;
            solve();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void solve() {
        // 각 회전 명령 처리
        for (int i = 0; i < numCommands; i++) {
            processRotation(rotationOrder[i][0], rotationOrder[i][1]);
        }
        calculateScore();
    }

    // 톱니바퀴 회전 전파 (왼쪽, 오른쪽) 및 실제 회전 적용
    static void processRotation(int gearIndex, int direction) {
        int[] directions = new int[4];  // 각 톱니바퀴의 회전 방향 저장 (0이면 회전 없음)
        directions[gearIndex - 1] = direction;  // gearIndex는 1부터 시작

        // 왼쪽으로 전파
        for (int i = gearIndex - 1; i > 0; i--) {
            
            if (((gears[i - 1] >> 2) & 1) != ((gears[i] >> 6) & 1)) {
                directions[i - 1] = -directions[i];
            } else {
                break;
            }
        }
        
        // 오른쪽으로 전파
        for (int i = gearIndex - 1; i < 3; i++) {
            // 현재 톱니의 오른쪽 접촉면 (인덱스 2)와 오른쪽 톱니의 왼쪽 접촉면 (인덱스 6)을 비교
            if (((gears[i] >> 2) & 1) != ((gears[i + 1] >> 6) & 1)) {
                directions[i + 1] = -directions[i];
            } else {
                break;
            }
        }

        // 각 톱니바퀴의 회전 적용
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) {
                gears[i] = rotateClockwise(gears[i]);
            } else if (directions[i] == -1) {
                gears[i] = rotateCounterClockwise(gears[i]);
            }
        }
    }

    // 점수 계산: 맨 위(S극, 즉 gear[0]의 값이 1)이면 각 톱니마다 1, 2, 4, 8 점 추가
    static void calculateScore() {
        for (int i = 0; i < 4; i++) {
            // 톱니바퀴의 top(인덱스 0)은 비트 0에 해당
            if ((gears[i] & 1) == 1) {
                answer += (1 << i);
            }
        }
    }

    // 시계방향 회전: 새[0] = old[7], 새[i] = old[i-1] (1<=i<=7)
    static int rotateClockwise(int x) {
        return (((x << 1) & 0xFF) | ((x >> 7) & 1));
    }

    // 반시계방향 회전: 새[7] = old[0], 새[i] = old[i+1] (0<=i<=6)
    static int rotateCounterClockwise(int x) {
        return ((x >> 1) & 0x7F) | ((x & 1) << 7);
    }

    // 입력 처리: 각 톱니바퀴 상태는 8개의 정수 (0 또는 1)로 입력된다.
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        numCommands = Integer.parseInt(st.nextToken());

        gears = new int[4];
        rotationOrder = new int[numCommands][2];

        // 각 톱니바퀴 상태 읽기
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int gearVal = 0;
            // 입력의 첫 번째 숫자가 톱니바퀴의 top(인덱스 0)라고 가정
            for (int j = 0; j < 8; j++) {
                int bit = Integer.parseInt(st.nextToken());
                gearVal |= (bit << j);
            }
            gears[i] = gearVal;
        }

        // 회전 명령 읽기
        for (int i = 0; i < numCommands; i++) {
            st = new StringTokenizer(br.readLine().trim());
            rotationOrder[i][0] = Integer.parseInt(st.nextToken());  // 톱니 번호 (1~4)
            rotationOrder[i][1] = Integer.parseInt(st.nextToken());  // 회전 방향 (1: 시계, -1: 반시계)
        }
    }
}

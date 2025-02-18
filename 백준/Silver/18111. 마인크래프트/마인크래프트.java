import java.util.*;
import java.io.*;

class Main {
    static int N, M, B, time, block, min, max, min_time, height;
    static int[][] map;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        min_time = Integer.MAX_VALUE;
        height = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i = min; i <= max; i++) {
            block = B;
            time = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = map[j][k] - i;

                    if (diff > 0) { // 블록 제거
                        time += diff * 2;
                        block += diff;
                    } else if (diff < 0) { // 블록 추가
                        time += Math.abs(diff);
                        block -= Math.abs(diff);
                    }
                }
            }

            if (block >= 0 && (min_time > time || (min_time == time && height < i))) {
                min_time = time;
                height = i;
            }
        }

        bw.write(min_time + " " + height);
        bw.flush();
        bw.close();
    }
}

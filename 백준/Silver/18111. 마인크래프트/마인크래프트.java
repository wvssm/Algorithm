import java.util.*;
import java.io.*;

class Main
{
    static int N, M, B, time, block, min, max, min_time, height;
    static int [][] map;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        min_time = Integer.MAX_VALUE;
        height = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(min>map[i][j]) {
                    min = map[i][j];
                }
                if(max<map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        // 가장 낮은 블럭부터 가장 높은 블럭까지 시간 구해보기
        for(int i=min; i<=max; i++) {

            block = B;
            time = 0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    int diff = map[j][k] - i;

                    if(diff< 0) {
                        time += Math.abs(diff);
                        block -= Math.abs(diff);
                    } else if(diff >0) {
                        time += diff * 2;
                        block += diff;
                    }
                }
            }

            if(block >= 0) {
                if(min_time > time || (height < i && min_time == time)) {
                    min_time = time;
                    height = i;
                }
            }
        }


        bw.append(min_time + " " + height);
        bw.flush();
        bw.close();
    }
}

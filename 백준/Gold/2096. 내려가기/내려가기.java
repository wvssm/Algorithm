import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, MAX, MIN;
    static int input[][];
    static int maxDp[][];
    static int minDp[][];

    public static void main(String[] args) throws Exception {
        input();

        maxDp = new int[N+1][3];
        minDp = new int[N+1][3];

        maxDp[0][0] = input[0][0];
        maxDp[0][1] = input[0][1];
        maxDp[0][2] = input[0][2];

        minDp[0][0] = input[0][0];
        minDp[0][1] = input[0][1];
        minDp[0][2] = input[0][2];

        for(int i=1; i<N; i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + input[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + input[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + input[i][2];
        }

        for(int i=1; i<N; i++){
            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + input[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + input[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + input[i][2];
        }

        MAX = Math.max(maxDp[N-1][0], Math.max(maxDp[N-1][1], maxDp[N-1][2]));
        MIN = Math.min(minDp[N-1][0], Math.min(minDp[N-1][1], minDp[N-1][2]));

        System.out.println(MAX + " " + MIN);
    }

    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        input = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<3; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
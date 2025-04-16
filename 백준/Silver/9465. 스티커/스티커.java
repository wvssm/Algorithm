import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N, answer;
    static int input[][];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine().trim());

        for(int test_case=0; test_case<T; test_case++){
            input();

            dp = new int[2][N];

            dp[0][0] = input[0][0];
            dp[1][0] = input[1][0];

            if(N > 1){
                dp[0][1] = dp[1][0] + input[0][1];
                dp[1][1] = dp[0][0] + input[1][1];

                for(int i=2; i<N; i++){
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + input[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + input[1][i];
                }
            }

            answer = Math.max(dp[0][N-1], dp[1][N-1]);
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void input() throws Exception {

        N = Integer.parseInt(br.readLine().trim());

        input = new int[2][N];

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<N; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
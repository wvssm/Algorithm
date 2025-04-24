import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws Exception {
        input();

        dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(arr[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine().trim());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
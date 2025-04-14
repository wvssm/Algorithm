import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int input[][];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        input();

        dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            dp[N][i] = input[N][i];
        }

        System.out.println(find(1,1));
    }

    public static int find(int depth, int index){
        if(depth == N){
            return dp[N][index];
        }

        if(dp[depth][index] == 0){
            dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + input[depth][index];
        }

        return dp[depth][index];
    }

    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        input = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=1; j<=i; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static boolean[] col;
    static boolean[] dplus;
    static boolean[] dminus;
    static int count;
    public static void main(String[] args) throws Exception {
        input();
        count = 0;
        dfs(0);
        System.out.println(count);
    }

    static void dfs(int depth){
        if(depth==N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(col[i] || dplus[depth+i] || dminus[depth-i+N]){
                continue;
            }
            col[i] = true;
            dplus[depth+i] = true;
            dminus[depth-i+N] = true;
            dfs(depth+1);
            col[i] = false;
            dplus[depth+i] = false;
            dminus[depth-i+N] = false;

        }
    }

    static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        col = new boolean[N];
        dplus = new boolean[N*2];
        dminus = new boolean[N*2];
    }
}
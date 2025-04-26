import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] arr;
    static int[][] house;
    static int[][] chicken;
    static int[] nums;
    static int N, M, cindex, hindex, min;

    public static void main(String[] args) throws Exception {
        input();
        min = Integer.MAX_VALUE;

        nums = new int[M];
        dfs(0,0);

        System.out.println(min);
    }

    static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        chicken = new int[13][2];
        house = new int[N*2][2];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    house[hindex][0] = i;
                    house[hindex][1] = j;
                    hindex++;
                } else if(arr[i][j] == 2){
                    chicken[cindex][0] = i;
                    chicken[cindex][1] = j;
                    cindex++;
                }
            }
        }
    }

    static void dfs(int depth, int start){
        if(depth == M){
            int sum = 0;

            for(int i=0; i<hindex; i++){
                int hx = house[i][0];
                int hy = house[i][1];

                int hmin = Integer.MAX_VALUE;

                for(int j=0; j<M; j++){
                    hmin = Math.min(hmin, Math.abs(hx - chicken[nums[j]][0]) + Math.abs(hy - chicken[nums[j]][1]));
                }

                sum += hmin;
           }

            min = Math.min(min, sum);
            return;
        }

        for(int i=start; i<cindex; i++){
            nums[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}
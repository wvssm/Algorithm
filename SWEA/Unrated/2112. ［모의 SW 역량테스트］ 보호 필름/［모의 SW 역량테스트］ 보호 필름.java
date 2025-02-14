import java.util.*;
import java.io.*;


class Solution
{
    static int[][] map;
    static int[] a0, a1;
    static int D, W, K;
    static int ans;
    static List<int[]> medicine = new ArrayList<>();

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T;
        T=Integer.parseInt(st.nextToken());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            a0 = new int[W];
            a1 = new int[W];

            Arrays.fill(a1, 1);

            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = -1;
            for(int i=0; i<=D; i++){
                dfs(0,0,i);
                if(ans!= -1){
                    break;
                }
            }

            bw.append("#"+test_case+" "+ans+"\n");
        }
        bw.flush();
        bw.close();
    }


    // depth = 처리횟수
    static void dfs(int depth, int index, int k) {
        if(depth == k){
            if(check()){
                ans = k;
            }
            return;
        }

        if(index == D){
            return;
        }

        int[] temp = new int[W];
        System.arraycopy(map[index], 0, temp, 0, W);

        System.arraycopy(a0, 0, map[index], 0, W);
        dfs(depth+1, index+1, k);

        System.arraycopy(a1, 0, map[index], 0, W);
        dfs(depth+1, index+1, k);

        System.arraycopy(temp, 0, map[index], 0, W);
        dfs(depth, index+1, k);

    }


    static boolean check() {
        for(int i=0; i<W; i++) {
            int cnt = 1;// 칼럼별 검사
            for(int j=1; j<D; j++) {
                if(map[j-1][i]==map[j][i]) {
                    cnt++;
                }else{
                    cnt=1;
                }
                if(cnt==K){
                    break;
                }
            }
            if(cnt < K){
                return false;
            }
        }
        return true;
    }
}
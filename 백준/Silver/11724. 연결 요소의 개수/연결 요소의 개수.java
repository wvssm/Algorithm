import java.util.*;
import java.io.*;


class Main
{
    static int N, M;
    static int bridge[][];
    static boolean vis[];
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridge = new int[N+1][N+1];
        vis = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            bridge[v1][v2] = 1;
            bridge[v2][v1] = 1;
        }

        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(!vis[i]){
                bfs(i);
                cnt++;
            }
        }

        bw.append(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<=N; i++){
                if(!vis[i] && bridge[cur][i]==1){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }

    }
}
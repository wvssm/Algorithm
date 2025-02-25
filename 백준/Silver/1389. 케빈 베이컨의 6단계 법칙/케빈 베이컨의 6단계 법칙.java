
import java.io.*;
import java.util.*;

// nCr

class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> bridge;
    static boolean[] vis;
    static int answer;
    static int cnt, sum_cnt;
    static int min_cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridge = new ArrayList<>();
        vis = new boolean[N+1];

        for(int i=0; i<N+1; i++) {
            bridge.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bridge.get(start).add(end);
            bridge.get(end).add(start);
        }

        min_cnt = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            vis = new boolean[N+1];
            cnt = 0;
            bfs(i);

            if(min_cnt > cnt) {
                min_cnt = cnt;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        vis[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt += cur[1];
            for(int node : bridge.get(cur[0])){
                if(vis[node]) continue;
                vis[node] = true;
                q.add(new int[]{node, cur[1]+1});
            }
        }

    }
}
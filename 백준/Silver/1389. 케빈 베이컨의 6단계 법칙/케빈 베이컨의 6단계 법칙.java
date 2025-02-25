
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<ArrayList<Integer>> bridge;
    static boolean[] vis;
    static int node_index, bacon, min_bacon;

    public static void main(String[] args) throws IOException {

        input();

        min_bacon = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            vis = new boolean[N+1];
            bacon = 0;
            bfs(i);

            if(min_bacon > bacon) {
                min_bacon = bacon;
                node_index = i;
            }
        }
        System.out.println(node_index);
    }

    static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        vis[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            bacon += cur[1];

            for(int node : bridge.get(cur[0])){
                if(vis[node]) continue;

                vis[node] = true;
                q.add(new int[]{node, cur[1]+1});
            }
        }
    }
    
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

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
    }
}
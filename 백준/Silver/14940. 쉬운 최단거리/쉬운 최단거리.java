import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M, sx, sy;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = { 1, -1, 0 , 0};
    static int[] dy = { 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();

        vis = new boolean[N][M];

        bfs(sx, sy);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!vis[i][j] && map[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }

        print();
    }

    static void bfs(int sx, int sy) {
        Deque<int[]> q = new ArrayDeque<>();
        int depth = 0;

        vis[sx][sy] = true;
        map[sx][sy] = depth;
        q.add(new int[]{sx, sy, depth});

        while(!q.isEmpty()){
            int []cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int ndepth = cur[2] + 1;

                if(nx < 0 || nx >= N || ny < 0 || ny >=M) continue;
                if(vis[nx][ny] || map[nx][ny] == 0) continue;

                vis[nx][ny] = true;
                map[nx][ny] = ndepth;
                q.add(new int[] {nx, ny, ndepth});
            }
        }

    }
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
    }

    static void print(){
        sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}
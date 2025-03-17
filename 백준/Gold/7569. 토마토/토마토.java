import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int M, N, H, max;
    static int[][][] map;
    static int[][][] dist;
    static boolean[][][] vis;
    static Queue<int []> q;
    static int[] dx = { 1, -1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, 1, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(getTomatoDays());
    }

    static void bfs() {
        while(!q.isEmpty()){
            int []cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];

            for(int i=0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if(map[nz][nx][ny] == -1 || dist[nz][nx][ny] != -1) continue;

                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.add(new int[] {nz, nx, ny});
            }
        }

    }

    static int getTomatoDays(){
        max = Integer.MIN_VALUE;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(dist[i][j][k] == -1 && map[i][j][k] != -1){
                        return -1;
                    }

                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }
        return max;
    }
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        dist = new int[H][N][M];
        vis = new boolean[H][N][M];

        q = new ArrayDeque<>();

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int k=0; k<M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.add(new int[]{i, j, k});
                    } else{
                        dist[i][j][k] = -1;
                    }
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
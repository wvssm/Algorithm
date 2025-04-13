import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M, K, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][][] vis;

    public static void main(String[] args) throws Exception {
        input();
        bfs(0,0,0);
        if(N == 1 && M == 1){
            answer = 1;
        }
        else if(answer == 0){
            answer = -1;
        }
        System.out.println(answer);
    }

    public static void bfs(int sx, int sy, int swall){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, swall});
        vis[swall][sx][sy] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int wall = cur[2];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 벽이 아닐 때
                if(map[nx][ny] == 0 && vis[wall][nx][ny] == 0){
                    vis[wall][nx][ny] = vis[wall][x][y]+1;
                    if(nx == N-1 && ny == M-1){
                        answer = vis[wall][nx][ny];
                        return;
                    }
                    q.add(new int[]{nx, ny, wall});
                }

                // 벽일 때
                if(map[nx][ny] == 1 && wall < K && vis[wall+1][nx][ny] == 0){
                    vis[wall+1][nx][ny] = vis[wall][x][y] + 1;
                    if(nx == N-1 && ny == M-1){
                        answer = vis[wall+1][nx][ny];
                        return;
                    }
                    q.add(new int[]{nx, ny, wall+1});
                }
            }
        }
    }
    public static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        vis = new int[K+1][N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine().trim();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
    }
}
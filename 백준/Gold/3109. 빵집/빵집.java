
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int count;
    static int R, C;
    static boolean[][] vis;
    static char[][] map;
    static int dx[] = {-1, 0, 1};
    static int dy[] = {1, 1, 1};

    public static void main(String[] args) throws IOException {

        input();

        for(int i=0; i<R; i++) {
            if(map[i][0] == '.') {
                vis[i][0] = true;
                dfs(i, 0);
            }
        }
        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        // 기저 조건
        if(y == C-1){
            count++;
            return true;
        }
        // 진행 로직
        for(int i=0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= R || ny >=C ) continue;
            if(map[nx][ny] == 'x') continue;
            if(vis[nx][ny]) continue;

            vis[nx][ny] = true;
            if(dfs(nx, ny)) return true;
        }
        return false;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        vis = new boolean[R+1][C+1];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine().trim());
            String input = st.nextToken();
            for(int j=0; j<C; j++){
                map[i][j] = input.charAt(j);
            }
        }
    }
}
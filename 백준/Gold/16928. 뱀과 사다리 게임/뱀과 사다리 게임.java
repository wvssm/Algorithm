import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] d = {1,2,3,4,5,6};
    static int[] map;
    static boolean[] vis;
    static Map<Integer, Integer> fastMove;
    static int snake, ladder, answer;
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    static void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());

        ladder = Integer.parseInt(st.nextToken());
        snake = Integer.parseInt(st.nextToken());

        fastMove = new HashMap<>();

        for(int i=0; i<ladder+snake; i++){
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            fastMove.put(start, end);
        }
    }

    static void solution(){
        map = new int[101];
        vis = new boolean[101];

        bfs(1);

        System.out.println(answer);
    }

    static void bfs(int num){
        vis[num] = true;

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{num, 0});

        while(!q.isEmpty()){
            int[] curArray = q.poll();

            int cur = curArray[0];
            int index = curArray[1];

            if(cur==100){
                answer = index;
                return;
            }

            for(int i=0; i<6; i++){
                int newCur = cur + d[i];

                if(newCur<1 || newCur>100) continue;
                if(vis[newCur]) continue;
                if(fastMove.containsKey(newCur)){
                    vis[newCur] = true;
                    newCur = fastMove.get(newCur);
                }
                vis[newCur] = true;
                q.add(new int[]{newCur, index+1});
            }
        }
    }
}
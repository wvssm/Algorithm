import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, W, H, answer, totalBlock;
    static int[][]map;
    static boolean[][]vis;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    
      
    public static void main(String args[]) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
         
        int T;
        T= Integer.parseInt(br.readLine().trim());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	totalBlock = 0;
            input();
             
            answer = Integer.MAX_VALUE;
            sol();
             
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void sol() {
    	combi(0, totalBlock, map);
    } 
    
    // 실수 2: 조합인줄 알았는데 중복순열이었다.
    // 열을 고르는 순서가 바뀌면, 폭발 결과도 다르다
    // 실수 3: 스태틱 map를 바꿔버리면, 이후에 다른 case를 계산할 때도 영향을 준다. 재귀에 영향을 준다. 그래서 board를 파라미터로 넘겨야한다.
    
    // 순열 고르는 함수(발사할 곳 정하는 함수)
    static void combi(int depth, int remaining, int[][] board) {
    	
    	// 실수 4: 총 개수를 직접 세었는데, bfs에서 터진 것을  빼는 방식으로 비교했다.
    	// 만약 블럭이 이미 다 사라졌을 때
    	if(remaining == 0) {
    		answer = 0;
    		return;
    	}
    	
    	// 만약 정해진 횟수를 다 쳤을 때
    	if(depth == N) {
    		answer = Math.min(answer, remaining);
    		return;
    	}
    	
    	// 열 고름
    	for(int i=0; i<W; i++) {
    		for(int j=0; j<H; j++) {
    			if(board[j][i] != 0) {
    				int[][] newMap = copyBoard(board);
    				int removed = bfs(j, i, newMap);
    				gravity(newMap);
    				combi(depth+1, remaining - removed, newMap);
    				break;
    			}
    		}
    	}
    }
    
    // board 복사 함수
    static int[][] copyBoard(int[][] board) {
        int[][] res = new int[H][W];
        for (int i = 0; i < H; i++) {
            res[i] = board[i].clone();
        }
        return res;
    }
    
    // 터뜨리기 함수
    static int bfs(int x, int y, int[][] board) {
    	int removed = 0;
    	
    	Queue<int[]> q = new ArrayDeque<>();
    	
    	vis = new boolean[H][W];
    	vis[x][y] = true;
    	
    	q.add(new int[] {x, y});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		
    		int cx = cur[0];
    		int cy = cur[1];
    		
    		int gap = board[cx][cy];

    		board[cx][cy] = 0;
    		removed++;
    		
    		for(int i=1; i<gap; i++) { // 실수  1: i시작을 0부터 해버림, 그러면 자기 자신이 또 들어가게 됨
    			for(int j=0; j<4; j++) {
    				int nx = cx + i * dx[j];
    				int ny = cy + i * dy[j];
    				
    				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
    				if(board[nx][ny] == 0 || vis[nx][ny]) continue;
    				
    				vis[nx][ny] = true;
    				
    				q.add(new int[] {nx, ny});
    			}
    		}
    	}
    	
    	return removed;
    }
    
    // 중력 함수
    static void gravity(int [][]board) {
    	for(int c=0; c<W; c++) {
    		int index = H-1;
    		for(int r=H-1; r>=0; r--) {
    			if(board[r][c] == 0) {
    				continue;
    			} else if(board[index][c] != board[r][c]) {
    				board[index][c] = board[r][c];
    				board[r][c] = 0;
    			}
    			
    			index--;
    		}
    	}
    }
    
    // 입력 함수
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
         
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
         
        map = new int[H][W];
         
        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) totalBlock++;
            }
        }
         
    }
}
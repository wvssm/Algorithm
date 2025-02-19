import java.util.*;
import java.io.*;

class Main
 {
	static int N, index;
	static long []map;
	static long []cmap;
	static Map<Long, Integer> m;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 받기
		N = Integer.parseInt(st.nextToken());
		map = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		cmap = new long[N];
		System.arraycopy(map, 0, cmap, 0, N);
		Arrays.sort(cmap);
		
		m = new HashMap<>();
		// 맵에 넣기
		index = 0;
		for(int i=0; i<N; i++) {
			if(!m.containsKey(cmap[i])) {
				m.put(cmap[i], index);
				index++;
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.append(m.get(map[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
}


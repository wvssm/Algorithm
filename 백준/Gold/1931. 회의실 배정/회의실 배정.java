import java.io.*;
import java.util.*;

public class Main {
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		
		// 종료 시간이 빠른 순, 같다면 시작시간이 빠른 순 
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Meeting[] meetings = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings); // 오름차순 정렬
		List<Meeting> result = new ArrayList<>();
		result.add(meetings[0]);
		
		for(int i=1; i<N; i++) {
			if(result.get(result.size()-1).end <= meetings[i].start) { // 배정된 마지막 회의 종료 시간보다
				// 고려하는 회의의 시작시간이 같거나 이후라면 배정 가능
				result.add(meetings[i]);
			}
		}
		
		System.out.println(result.size());
	}
}
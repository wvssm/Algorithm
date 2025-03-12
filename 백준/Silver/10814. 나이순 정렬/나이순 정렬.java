import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String[][] person = new String[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = st.nextToken();
			person[i][1] = st.nextToken();
		}
		
		
		Arrays.sort(person, new MyComparator());
		
		for(int i=0; i<n; i++) {
			bw.append(person[i][0] + " " + person[i][1]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	static class MyComparator implements Comparator<String[]>{

		@Override
		public int compare(String[] o1, String[] o2) {
			return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
		}
		
	}
}
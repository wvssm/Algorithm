
import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static List<String> words;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        
        words = new ArrayList<>();
        
        for(int i = 0; i < R; i++) {
            String str = "";
            for(int j = 0; j < C; j++) {
                if(map[i][j] == '#') {
                    if(!str.isEmpty() && str.length() > 1) {
                        words.add(str);
                    }
                    str = "";
                } else {
                    str += map[i][j];
                }
            }
            // 마지막 단어 처리
            if(!str.isEmpty() && str.length() > 1) {
                words.add(str);
            }
        }
        
        for(int i = 0; i < C; i++) {
            String str = "";
            for(int j = 0; j < R; j++) {
                if(map[j][i] == '#') {
                    if(!str.isEmpty() && str.length() > 1) {
                        words.add(str);
                    }
                    str = "";
                } else {
                    str += map[j][i];
                }
            }

            if(!str.isEmpty() && str.length() > 1) {
                words.add(str);
            }
        }
        
        Collections.sort(words);
        System.out.println(words.get(0));
    }
}

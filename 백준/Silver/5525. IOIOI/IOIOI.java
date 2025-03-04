
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M, patternCount, count;
    static String input;


    public static void main(String[] args) throws Exception {
        input();
        
        int i=1;
        
        patternCount = 0;
        count = 0;
        while(i<M-1){
            if(input.charAt(i-1)=='I' && input.charAt(i)=='O' && input.charAt(i+1)=='I'){
                patternCount++;
                if(patternCount >= N){
                    count++;
                }
                i += 2;
            }
            else {
                patternCount = 0;
                i += 1;
            }
        }
        System.out.println(count);
    }


    static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        input = br.readLine();
    }

}
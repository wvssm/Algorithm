import java.util.*;
import java.io.*;


class Main
{
    static int N;
    static long[] fibo;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        fibo = new long[N+1];

        fibo[0] = 0l;
        fibo[1] = 1l;

        for(int i=2; i<=N; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        bw.append(String.valueOf(fibo[N]));
        bw.flush();
        bw.close();
    }
}
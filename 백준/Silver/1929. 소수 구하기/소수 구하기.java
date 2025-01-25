import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{
    static boolean [] visited = new boolean[1000001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=m; i<=n; i++){
            if(!visited[i] && isPrime(i)){
                for(int j=2; j*i<=n; j++){
                    visited[j*i] = true;
                }
            } else{
                visited[i]= true;
            }
        }

        for(int i=m; i<=n; i++){
            if(!visited[i]){
                bw.append(String.valueOf(i));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2) return true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
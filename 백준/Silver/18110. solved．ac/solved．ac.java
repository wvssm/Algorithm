import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int delete = Math.round((float) n * 0.15f);

        int [] scores = new int[n];

        for(int i=0; i<n; i++){
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);

        int sum = 0;
        for(int i = delete; i<n-delete; i++){
            sum += scores[i];
        }

        sum = Math.round((float) sum/(n-2*delete));

        bw.append(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
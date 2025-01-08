import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        int i = 0;
        int sixDivide = 0;

        while(true){
            sixDivide += i;
            
            if(num <= sixDivide * 6 + 1){ // 기준 수 보다 작거나 같으면
                System.out.println(i+1);
                break;
            }

            i++;
        }

    }
}
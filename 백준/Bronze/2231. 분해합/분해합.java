import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<n; i++){
            if(i + divide(i) == n){
                System.out.println(i);
                br.close();
                return;
            }
        }
        System.out.println(0);
    }

    public static int divide(int number){
        int total = 0;
        while(number != 0 ){
            total += number % 10;
            number = number / 10;
        }
        return total;
    }
}
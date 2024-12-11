import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.StrictMath.pow;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isNotFinish = true;
        int intNumbers[] = new int[3];
        while(isNotFinish){
            String numbers[] = br.readLine().split(" ");
            int max_val = -1;
            int sum_val = 0;

            isNotFinish = false;
            for(int i=0; i<3; i++){
                intNumbers[i] = Integer.parseInt(numbers[i]);
                sum_val += pow(intNumbers[i], 2);

                if(max_val < intNumbers[i]) {
                    max_val = intNumbers[i];
                }

                if(intNumbers[i]!=0){
                    isNotFinish = true;
                }
            }

            if(!isNotFinish){
                return;
            }

            if(sum_val == 2 * pow(max_val,2)){
                System.out.println("right");
            } else{
                System.out.println("wrong");
            }
        }
    }
}
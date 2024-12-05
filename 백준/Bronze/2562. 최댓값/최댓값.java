import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int max_val = 0;
        int index = 0;
        int max_index = 1;

        for(int val:list){
            index++;
            if(val > max_val){
                max_val = val;
                max_index = index;
            }
        }
        System.out.println(max_val);
        System.out.println(max_index);
    }
}
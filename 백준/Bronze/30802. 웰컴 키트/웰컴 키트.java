import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 사이즈 다 받아서 나머지 있으면 + 1 하는 구조
// 펜은 나누기 한 몫 적고, 나머지는 출력

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        int member = Integer.parseInt(br.readLine());
        List<Integer> tshirts = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            tshirts.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 계산
        int total = 0;
        for(int tshirt : tshirts){
            if(tshirt % t != 0){
                total += tshirt/t + 1;
            } else{
                total += tshirt/t;
            }
        }
        sb.append(total + "\n");

        int pen_cnt = member / p;
        int pen_g_cnt = member % p;

        sb.append(pen_cnt + " " + pen_g_cnt);
        System.out.println(sb);
    }
}
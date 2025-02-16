import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int [] arr = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Double> stk = new Stack<>();

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '+'){
                double b = (double) stk.pop();
                double a = (double) stk.pop();
                stk.push(a + b);
            } else if(input.charAt(i) == '-'){
                double b = (double) stk.pop();
                double a = (double) stk.pop();
                stk.push(a - b);
            } else if(input.charAt(i) == '*'){
                double b = (double) stk.pop();
                double a = (double) stk.pop();
                stk.push(a * b);
            } else if(input.charAt(i) == '/'){
                double b = (double) stk.pop();
                double a = (double) stk.pop();
                stk.push(a / b);
            } else{
                stk.push((double)arr[input.charAt(i)-65]);
            }
        }

        double answer = stk.pop();
        answer = Math.round(answer*100)/(double)100;

        System.out.printf("%.2f", answer);
        bw.flush();
        bw.close();
    }
}
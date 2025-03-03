
import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static boolean isEnd = false;
    static int[] nums;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        input();
        np();

        if(isEnd){
            System.out.println(-1);
            return;
        }

        sb = new StringBuilder();
        for(int num : nums){
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void np(){
        // 1. 감소 지점 찾기
        int i = N-1;
        while(i>0 && nums[i-1] > nums[i]){
            i--;
        }

        if(i==0){
            isEnd = true;
            return;
        }

        int j = N-1;
        while(nums[i-1] >= nums[j]){
            j--;
        }

        swap(i-1, j);

        int k = N-1;
        while(i<k){
            swap(i++, k--);
        }

    }

    static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void swap(int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
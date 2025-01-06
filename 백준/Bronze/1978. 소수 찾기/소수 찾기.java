import java.util.Scanner;

class Main
{
    public static boolean isPrime(int n){
        if(n<=1) return false;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int n;
        int cnt = 0;
        n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(isPrime(arr[i])){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
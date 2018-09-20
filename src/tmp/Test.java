package tmp;

import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr=new int[2000];
        for(int i=0;i<3;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);

        int sum=kind(arr);
        System.out.println(sum);
    }

    private static int kind(int[] arr){
        if(arr[0]+arr[1]+1<arr[2]){
            System.out.println(0);
        }
        if(arr[0]+arr[1]==arr[2]-1){
            System.out.println(C(arr[2]-1,arr[0]));
        }
        int[] fac = new  int[2000];
        int sum = 0; int cur = 0;
        int[][]f =new int[3][2000];
        f[cur][0] = 1;
        int[][] c=new int[2000][2000];
        Pre(fac,c);
        int n=3;
        for(int i = 1; i <= n; i ++){
            cur ^= 1;
            for(int t = 0; t <= arr[i]+sum+1; t ++)
                f[cur][t] = 0;
            for(int k = 1; k <= arr[i] && k <= sum+1; k ++)
                for(int j = 0; j <= sum; j ++)
                    for(int l = 0; l <= k && l <= j; l ++){
                        f[cur][j-l+arr[i]-k] +=
                                f[cur^1][j]*c[arr[i]-1][k-1]*(c[j][l]*c[sum+1-j][k-l]);
                        // f[cur][j-l+arr[i]-l] %= mod;
                    }
            sum += arr[i];
        }
        return f[cur][0];
    }

    public static void Pre(int[] fac,int[][] c){
        fac[0]=1;
        for(int i=1;i<=3;i++){
            fac[i]=i*fac[i-1];}
        c[0][0]=1;
        for(int i=1;i<=3;i++){
            for(int j=1;j<i;j++){
                c[i][j]=c[i-1][j]+c[i-1][j-1];
            }
            c[i][0]=c[i][i]=1;
        }
    }

    public static int C(int n, int r)
    {
        return factorialA(n)/(factorialA(n-r)*factorialA(r));
    }
    public static int A(int first , int second)
    {
        int tmp = first;
        int result = first;
        int count = 0;
        while(count < second-1)
        {
            if(second ==1)
            {
                return first;
            }
            else
            {
                count++;
                tmp--;
                System.out.println(result + "*" + tmp);
                result = result * tmp;
            }
        }
        return result;
    }

    /**
     * 实现了数学中阶乘的方法 factorialA(5)即5!
     * @param number
     * @return
     */
    public static int factorialA(int number)
    {
        return A(number,number);
    }
}
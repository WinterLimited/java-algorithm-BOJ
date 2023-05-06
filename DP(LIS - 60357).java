import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1; // 모든 dp[i]는 1로 초기화
            for (int j=1; j<i; j++) {
            	// i - 1번째 dp값들 중에 가장 큰값으로 dp[i] 갱신 
                if (a[j] < a[i] && d[j]+1 > d[i]) { 
                    d[i] = d[j]+1;
                }
            }
        }

        int ans = d[1];
        for (int i=2; i<=n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }

        System.out.println(ans);
        sc.close();
    }
}

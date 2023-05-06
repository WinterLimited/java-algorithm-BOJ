import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열 A의 크기
        int[] a = new int[n]; // 수열 A
        int[] d = new int[n]; // A에서 LIS 길이 저장
        int[] v = new int[n]; // A에서 LIS 수열 저장
        Arrays.fill(v, -1); // 초기값 -1로 설정

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1; // 초기값 1로 설정
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j; // 이전에 나온 값의 인덱스를 저장
                }
            }
        }

        int ans = d[0]; // 최대 길이를 저장하는 변수
        int p = 0; // 최대 길이를 가지는 값의 인덱스 저장 변수
        for (int i = 1; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
                p = i;
            }
        }

        // 저장한 index 값들을 역으로 추적하며 Stack에저장 
        Stack<Integer> s = new Stack<>();
        while (p != -1) {
            s.push(a[p]);
            p = v[p];
        }

        System.out.println(ans); // LIS 길이 출력
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " "); // LIS 수열 출력
        }
        System.out.println(); 
    }
}

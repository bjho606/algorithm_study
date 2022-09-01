package D0831;

import java.util.*;
import java.io.*;
import java.lang.*;

// 완 DP
// 상담 수익 최대화..!
class Q14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2]; // 금액 저장하기
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int day = i + T[i];// i번째 날의 상담기간 구하기!

            if (day <= N + 1)
                dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
            else// 상담일 초과하면 그대로 넣어주기
                dp[i] = dp[i + 1];
        }

        System.out.println(dp[1]);
    }
}
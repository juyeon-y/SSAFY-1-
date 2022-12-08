package 양주연;

import java.io.*;
public class P064_BJ1463_1로만들기
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1]; //dp[n] = n을 연산 3개를 사용해서 1로 만든다고 할 때, 연산 사용 횟수의 최솟값.
		dp[1] = 0;
		for(int i=2; i<=n; i++){
		    dp[i] = dp[i-1]+1; //1을 빼는 연산 사용할 경우
		    if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1); //2로 나누는 연산 사용할 경우
		    if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1); //3으로 나누는 연산 사용할 경우
		}
		bw.write(dp[n]+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
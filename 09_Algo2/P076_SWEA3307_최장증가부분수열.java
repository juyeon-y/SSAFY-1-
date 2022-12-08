package 양주연;

import java.io.*;
public class P076_SWEA3307_최장증가부분수열
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    int N = Integer.parseInt(br.readLine());
		    int[] arr = new int[N];
		    int[] dp = new int[N];
		    String input[] = br.readLine().split(" ");
		    for(int i=0; i<N; i++){
		        arr[i] = Integer.parseInt(input[i]);
		    }
		    int answer=1; //N이 1일 때도 정답 나오기 위해서 answer=1로 초기화
		    dp[0] = 1;
		    for(int i=1; i<N; i++){
		        dp[i] = 1;
		        for(int j=i-1; j>=0; j--){
		            if(arr[i]>arr[j] && dp[j]+1>dp[i]){
		                dp[i] = dp[j]+1;
		            }
		        }
		        answer = Math.max(answer, dp[i]);
		    }
		    bw.write("#"+tc+" "+answer+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
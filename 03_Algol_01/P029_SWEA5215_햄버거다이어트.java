package 양주연;

import java.io.*;

public class P029_SWEA5215_햄버거다이어트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    int N = Integer.parseInt(input[0]); //재료의 수
		    int L = Integer.parseInt(input[1]); //제한 칼로리
		    int[] scores = new int[N]; //재료의 점수들 입력받을 배열
		    int[] cals = new int[N]; //재료의 칼로리들 입력받을 배열
		    int[] dp = new int[L+1]; //dp[idx] => idx 값이 제한 칼로리일때 해당 제한 칼로리 이하의 조합 중 나올 수 있는 가장 높은 점수가 저장됨
		    for(int i=0; i<N; i++){
		        input = br.readLine().split(" ");
		        scores[i] = Integer.parseInt(input[0]); //재료의 점수
		        cals[i] = Integer.parseInt(input[1]); //재료의 칼로리
		    }
		    for(int i=0; i<N; i++){ //재료의 개수만큼 반복
		        for(int j=L; j>=cals[i]; j--){ //재료가 한개씩 있으므로 뒤부터 돌림
		            dp[j] = Math.max(dp[j], dp[j-cals[i]]+scores[i]); 
		        }
		    }
		    bw.write("#"+tc+" "+dp[L]+"\n"); //제한칼로리가 L일 때 나올 수 있는 가장 높은 점수 출력
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}

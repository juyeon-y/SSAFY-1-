package 양주연;

import java.io.*;
public class P065_BJ1149_RGB거리
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n+1][3]; //cost[n][i] = n번 집에 i번색 칠할 경우(0=빨, 1=초, 2=파) n번집까지 규칙에 맞게 칠한 비용의 최솟값
		for(int i=1; i<=n; i++){
		    String[] input = br.readLine().split(" ");
		    cost[i][0] = Integer.parseInt(input[0]);
		    cost[i][1] = Integer.parseInt(input[1]);
		    cost[i][2] = Integer.parseInt(input[2]);
		}
		for(int i=2; i<=n; i++){
		    cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]); //i번집에 빨간색 칠할 경우 최솟값 저장
		    cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]); //i번집에 초록색 칠할 경우 최솟값 저장
		    cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]); //i번집에 파랑색 칠할 경우 최솟값 저장
		}
		bw.write(Math.min(cost[n][0], Math.min(cost[n][1], cost[n][2]))+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
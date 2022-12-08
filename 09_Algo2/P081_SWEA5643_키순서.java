package 양주연;

import java.io.*;
public class P081_SWEA5643_키순서

{
    static final int INF = 99999; //무한
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    int N = Integer.parseInt(br.readLine()); //학생들의 수
		    int M = Integer.parseInt(br.readLine());
		    int[][] dist = new int[N+1][N+1];
		    for(int i=0; i<M; i++){
		        String[] input = br.readLine().split(" ");
		        int a = Integer.parseInt(input[0]);
		        int b = Integer.parseInt(input[1]);
		        dist[a][b] = 1;
		    }
		    for(int i=1; i<=N; i++){
		        for(int j=1; j<=N; j++){
		            if(i==j) continue;
		            if(dist[i][j]==0) dist[i][j] = INF;
		        }
		    }
            //플로이드 와샬
		    for(int k=1; k<=N; k++){
		        for(int i=1; i<=N; i++){
		            if(i==k) continue;
		            for(int j=1; j<=N; j++){
		                if(j==i || j==k) continue;
		                dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
		            }
		        }
		    }
		    int answer=0;
		    for(int i=1; i<=N; i++){
		        int sum=0;
		        for(int j=1; j<=N; j++){
		            if(dist[i][j]!=0 && dist[i][j]!=INF) sum++;
		            if(dist[j][i]!=0 && dist[j][i]!=INF) sum++;
		        }
		        if(sum==N-1) answer++;
		    }
		    bw.write("#"+tc+" "+answer+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

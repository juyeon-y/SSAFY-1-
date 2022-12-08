package 양주연;

import java.io.*;
public class P077_SWEA1263_사람네트워크2

{
    static final int INF = 99999;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    int N = Integer.parseInt(input[0]);
		    int[][] dist = new int[N][N];
		    int idx=1;
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		            dist[i][j] = Integer.parseInt(input[idx++]); //인접행렬 저장
		            if(i!=j && dist[i][j]==0) dist[i][j] = INF; //자기자신으로 가는 경우가 아니고, 인접행렬 값이 0이면 INF 저장.
		        }
		    }
            //플로이드 와샬
		    for(int k=0; k<N; k++){
		        for(int i=0; i<N; i++){
                    if(i==k) continue;
		            for(int j=0; j<N; j++){
                        if(k==j || i==j) continue;
		                dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); 
		            }
		        }
		    }
		    int min = INF;
		    for(int i=0; i<N; i++){
		        int sum=0;
		        for(int j=0; j<N; j++){
		            sum+=dist[i][j];
		        }
		        if(min>sum) min = sum;
		    }
		    bw.write("#"+tc+" "+min+"\n"); //최소인 CC값 출력
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
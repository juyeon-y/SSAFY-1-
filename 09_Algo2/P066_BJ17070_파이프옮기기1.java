package 양주연;

import java.util.*;
import java.io.*;
public class P066_BJ17070_파이프옮기기1
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dx={-1, -1, 0}, dy={0, -1, -1}; //인덱스 : 0->위, 1->왼위, 2->왼
		int[][][] cnt = new int[N+1][N+1][3]; //인덱스 : 0->가로, 1->세로, 2->대각선
		int[][] method = new int[3][3]; 
		for(int i=0; i<3; i++){
		    for(int j=0; j<3; j++){
		        method[i][j] = (i+1)%3;
		    }
		}
		int[][] house = new int[N+1][N+1];
		for(int i=0; i<N; i++){
		    String[] input = br.readLine().split(" ");
		    for(int j=0; j<N; j++){
		        house[i+1][j+1] = Integer.parseInt(input[j]);
		    }
		}
		method[0][0] = -1;
		method[2][1] = -1;
		for(int i=1; i<=N; i++){
		    for(int j=2; j<=N; j++){
		        if(i==1 && j==2){
		            cnt[1][2][0] = 1; //가로 1개 저장.
		            continue;
		        }
		        if(house[i][j]==1) continue; //벽이면 continue
		        for(int k=0; k<3; k++){ //k -> 위, 왼위, 왼
		            int nx = i+dx[k];
		            int ny = j+dy[k];
		            if(nx>=1 && nx<=N && ny>=2 && ny<=N && house[nx][ny]!=1){  //범위 안이고 벽이 아니면
		                for(int l=0; l<3; l++){ //l -> 가로, 세로, 대각선
		                    if(cnt[nx][ny][l]>0 && method[k][l]!=-1){
		                        if(method[k][l]==2){ //대각선으로 놓을 경우
		                            if(house[i-1][j]==1 || house[i][j-1]==1) continue;
		                        }
		                        cnt[i][j][method[k][l]] += cnt[nx][ny][l];
		                    }
		                }
		            }
		        }
		    }
		}
		int res=0;
		for(int i=0; i<3; i++){
		    res+=cnt[N][N][i];
		}
		bw.write(res+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}

package 양주연;

import java.io.*;
import java.util.*;
public class P068_SWEA1249_보급로
{
    static int N;
    static int[][] map, dp;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static class Coor{ //좌표 클래스
        int x, y;
        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(){
        Queue<Coor> q = new ArrayDeque<>();
        dp[0][0]=0;
        q.offer(new Coor(0, 0));
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && dp[tmp.x][tmp.y]+map[nx][ny]<dp[nx][ny]){ //범위 안이고 새 좌표까지의 누적값이 더 최소인 것이 구해진다면,
                    dp[nx][ny] = dp[tmp.x][tmp.y]+map[nx][ny]; //업데이트
                    q.offer(new Coor(nx, ny)); //큐에 삽입
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    N = Integer.parseInt(br.readLine());
		    map = new int[N][N];
		    dp = new int[N][N];
		    for(int i=0; i<N; i++){
		        String input = br.readLine();
		        for(int j=0; j<N; j++){
		            map[i][j] = input.charAt(j)-48;
		            dp[i][j] = Integer.MAX_VALUE;
		        }
		    }
		    bfs();
		    bw.write("#"+tc+" "+dp[N-1][N-1]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
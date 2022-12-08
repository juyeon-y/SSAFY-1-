package 양주연;

import java.util.*;
import java.io.*;
public class P067_BJ1600_말이되고픈원숭이
{
    static int K, W, H;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2}, hdy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static class Coor{
        int x, y, K;
        public Coor(int x, int y, int K){
            this.x = x;
            this.y = y;
            this.K = K;
        }
    }
    public static int bfs(){
        boolean[][][] chk = new boolean[H][W][K+1];
        Queue<Coor> q = new ArrayDeque<>();
        chk[0][0][K] = true;
        q.offer(new Coor(0, 0, K));
        int lev=0;
        boolean flag=false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Coor tmp = q.poll();
                chk[tmp.x][tmp.y][tmp.K]=true;
                if(tmp.x==H-1 && tmp.y==W-1){
                    flag=true;
                    break;
                }
                if(tmp.K>0){
                    for(int j=0; j<8; j++){
                        int nx = tmp.x+hdx[j];
                        int ny = tmp.y+hdy[j];
                        if(nx>=0 && nx<H && ny>=0 && ny<W && !chk[nx][ny][tmp.K-1] && board[nx][ny]!=1){
                            chk[nx][ny][tmp.K-1] = true;
                            q.offer(new Coor(nx, ny, tmp.K-1));
                        }
                    }
                }
                for(int j=0; j<4; j++){
                    int nx = tmp.x+dx[j];
                    int ny = tmp.y+dy[j];
                    if(nx>=0 && nx<H && ny>=0 && ny<W && !chk[nx][ny][tmp.K] && board[nx][ny]!=1){
                        chk[nx][ny][tmp.K] = true;
                        q.offer(new Coor(nx, ny, tmp.K));
                    }
                }
            }
            if(flag) break;
            lev++;
        }
        if(!flag) return -1;
        else return lev;
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);
		board = new int[H][W];
		for(int i=0; i<H; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<W; j++){
		        board[i][j] = Integer.parseInt(input[j]);
		    }
		}
		bw.write(bfs()+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
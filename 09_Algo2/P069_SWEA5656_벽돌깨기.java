package 양주연;

import java.io.*;
import java.util.*;
public class P069_SWEA5656_벽돌깨기
{
    static boolean flag;
    static int N, W, H, brickTotal, brokenBrickCnt, maxBrokenCnt;
    static int[] marbleIdx, dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static int[][] board;
    static class Coor{ //벽돌 좌표 + 벽돌 번호 저장하는 클래스
        int x, y, num;
        Coor(int x, int y, int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    static void perm(int lev){ //중복순열로 구슬 n번 떨어트릴 인덱스 구하는 함수
        if(flag) return;
        if(lev==N){
            brokenBrickCnt = 0;
            breakBricks(copy(board));
            maxBrokenCnt = Math.max(maxBrokenCnt, brokenBrickCnt);
            if(maxBrokenCnt == brickTotal) flag=true; //모든 블록이 부서저서 더이상 부술게 없는 경우
        }else{
            for(int i=0; i<W; i++){
                marbleIdx[lev] = i;
                perm(lev+1);
            }
        }
    }
    static void breakBricks(int[][] copy){ //벽돌 깨는 함수
        for(int m : marbleIdx){
            Queue<Coor> q = new ArrayDeque<>();
            for(int i=0; i<H; i++){
                if(copy[i][m]>=1){
                    q.offer(new Coor(i, m, copy[i][m]));
                    copy[i][m] = 0;
                    brokenBrickCnt++;
                    break;
                }
            }
            while(!q.isEmpty()){
                Coor tmp = q.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x;
                    int ny = tmp.y;
                    int curNum = tmp.num;
                    for(int j=0; j<curNum-1; j++){
                        nx+=dx[i];
                        ny+=dy[i];
                        if(nx>=0 && nx<H && ny>=0 && ny<W && copy[nx][ny]>0){
                            q.offer(new Coor(nx, ny, copy[nx][ny]));
                            copy[nx][ny]=0;
                            brokenBrickCnt++;
                        }
                    }
                }
            }
            dropBricks(copy);
        }
    }
    static void dropBricks(int[][] copy){ //빈 공간이 있을 경우 벽돌 밑으로 떨어지는 것 처리하는 함수
        for(int i=H-1; i>=0; i--){
            for(int j=0; j<W; j++){
                if(copy[i][j]==0){
                    for(int k=i-1; k>=0; k--){
                        if(copy[k][j]>0){
                            copy[i][j] = copy[k][j];
                            copy[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    static int[][] copy(int[][] arr){ //배열 깊은복사 함수
        int[][] copy = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    N = Integer.parseInt(input[0]);
		    W = Integer.parseInt(input[1]);
		    H = Integer.parseInt(input[2]);
		    maxBrokenCnt = Integer.MIN_VALUE;
		    board = new int[H][W];
		    brickTotal = 0;
		    flag=false;
		    for(int i=0; i<H; i++){
		        input = br.readLine().split(" ");
		        for(int j=0; j<W; j++){
		            board[i][j] = Integer.parseInt(input[j]);
		            if(board[i][j]>0) brickTotal++;
		        }
		    }
    		marbleIdx = new int[N];
		    perm(0);
		    bw.write("#"+tc+" "+(brickTotal-maxBrokenCnt)+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
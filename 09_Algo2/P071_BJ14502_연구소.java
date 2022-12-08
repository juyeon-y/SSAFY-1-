package 양주연;

import java.io.*;
import java.util.*;
public class P071_BJ14502_연구소
{
    static int N, M, safeAreaCnt, max=Integer.MIN_VALUE;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static int[][] lab;
    static List<Coor> emptySpace, virus;
    static int[] selIdx;
    static class Coor{
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void comb(int lev, int start){ //빈칸 중 3곳 고르는 조합 함수
        if(lev==3){
            safeAreaCnt = emptySpace.size() - 3;
            buildWall();
            max = Math.max(safeAreaCnt, max);
        }else{
            for(int i=0; i<emptySpace.size(); i++){
                selIdx[lev]=i;
                comb(lev+1, i+1);
            }
        }
    }
    static void buildWall(){ //벽 세우는 함수
        int[][] copy = copy(lab);
        for(int i : selIdx){
            Coor tmp = emptySpace.get(i);
            copy[tmp.x][tmp.y] = 1;
        }
        spreadVirus(copy);
    }
    static void spreadVirus(int[][] copy){ //바이러스 퍼트려서 안전영역 세는 함수
        Queue<Coor> q = new ArrayDeque<>();
        for(Coor c : virus){
            q.offer(new Coor(c.x, c.y));
        }
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && copy[nx][ny]==0){
                    copy[nx][ny]=2;
                    safeAreaCnt--;
                    q.offer(new Coor(nx, ny));
                }
            }
        }
    }
    static int[][] copy(int[][] arr){ //배열 깊은복사 함수
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		lab = new int[N][M];
		emptySpace = new ArrayList<>();
		virus = new ArrayList<>();
		selIdx = new int[3];
		for(int i=0; i<N; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<M; j++){
		        lab[i][j] = Integer.parseInt(input[j]);
		        if(lab[i][j]==0){
		            emptySpace.add(new Coor(i, j));
		        }else if(lab[i][j]==2){
		            virus.add(new Coor(i, j));
		        }
		    }
		}
		comb(0, 0);
		bw.write(max+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
package 양주연;

import java.io.*;
import java.util.*;

public class P054_BJ13055_탈출 {

	static int R, C, hedX, hedY, answer;
    static boolean flag = false;
    static Queue<Coor> waterQ;
    static boolean[][] waterChk;
    static char[][] map;
    static int[] dx={-1, 1, 0, 0}, dy={0, 0, 1, -1};
    static class Coor{
        int x, y;
        public Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void bfs(){
        Queue<Coor> q = new ArrayDeque<>();
        boolean[][] chk = new boolean[R][C];
        q.offer(new Coor(hedX, hedY));
        chk[hedX][hedY]=true;
        int lev=0;
        while(!q.isEmpty()){
            int size = q.size();
            lev++;
            waterExpand();
            for(int eCnt=0; eCnt<size; eCnt++){
                Coor tmp = q.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x+dx[i];
                    int ny = tmp.y+dy[i];
                    if(nx>=0 && nx<R && ny>=0 && ny<C && !chk[nx][ny] && map[nx][ny]!='*' && map[nx][ny]!='X'){
                        chk[nx][ny]=true;
                        q.offer(new Coor(nx, ny));
                        if(map[nx][ny]=='D'){
                            flag=true;
                            answer=lev;
                            return;
                        }
                    }
                }
            }
        }
    }
    static void waterExpand(){
        int size = waterQ.size();
        for(int eCnt=0; eCnt<size; eCnt++){
            Coor tmp = waterQ.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C && !waterChk[nx][ny] && map[nx][ny]!='D' && map[nx][ny]!='X'){
                    waterChk[nx][ny]=true;
                    waterQ.offer(new Coor(nx, ny));
                    map[nx][ny]='*';
                }
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        waterQ = new ArrayDeque<>();
        waterChk = new boolean[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    hedX=i;
                    hedY=j;
                }
                else if(map[i][j] == '*'){
                    waterQ.add(new Coor(i,j));
                    waterChk[i][j]=true;
                }
            }
        }
        bfs();
        if(flag) bw.write(answer+"\n");
        else bw.write("KAKTUS");
        br.close();
        bw.flush();
        bw.close();
	}
}

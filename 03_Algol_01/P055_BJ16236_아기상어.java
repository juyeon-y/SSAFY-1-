package 양주연;

import java.io.*;
import java.util.*;

public class P055_BJ16236_아기상어 {

	static int[][] map;
    static int lev=0;
    static int N, answer=0;
    static int[] dx={-1, 0, 0, 1}, dy={0, -1, 1, 0};
    static Shark s;
    static class Shark{
        int x, y, size, eatCnt;
        public Shark(int x, int y, int size, int eatCnt){
            this.x=x;
            this.y=y;
            this.size=size;
            this.eatCnt=eatCnt;
        }
    }
    static class Coor implements Comparable<Coor>{
        int x, y;
        public Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Coor o){
            if(this.x==o.x) return this.y-o.y;
            return this.x-o.x;
        }
    }
    static boolean bfs(){
        Queue<Coor> q = new ArrayDeque<>();
        boolean[][] chk = new boolean[N][N];
        ArrayList<Coor> fishList = new ArrayList<>();
        q.offer(new Coor(s.x, s.y));
        chk[s.x][s.y]=true;
        lev = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int eCnt=0; eCnt<size; eCnt++){
                Coor tmp = q.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x+dx[i];
                    int ny = tmp.y+dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && !chk[nx][ny] && map[nx][ny]<=s.size){
                        chk[nx][ny]=true;
                        q.offer(new Coor(nx, ny));
                        if(map[nx][ny]>=1 && map[nx][ny]<s.size){ //먹을 수 있다
                            fishList.add(new Coor(nx, ny));
                        }
                    }
                }
            }
            lev++;
            if(!fishList.isEmpty()){
                Collections.sort(fishList);
                int fishX = fishList.get(0).x;
                int fishY = fishList.get(0).y;
                answer+=lev;
                map[fishX][fishY]=0;
                s.eatCnt++;
                if(s.eatCnt==s.size){
                    s.size++;
                    s.eatCnt=0;
                }
                s.x=fishX;
                s.y=fishY;
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==9){
                    s = new Shark(i, j, 2, 0);
                    map[i][j]=0;
                }
            }
        }
        while(true){
            if(!bfs()) break;
        }
        bw.write(answer+"\n");
        br.close();
        bw.flush();
        bw.close();
	}
}

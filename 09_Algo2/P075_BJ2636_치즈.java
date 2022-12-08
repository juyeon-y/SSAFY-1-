package 양주연;

import java.io.*;
import java.util.*;
public class P075_BJ2636_치즈
{
    static int row, col, cheeseTotal;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1}; //방향배열
    static int[][] board;
    static class State{ //상태 클래스 
        int time, cheeseCnt; //걸린 시간, 남아있는 치즈조각이 놓여 있는 칸의 개수
        State(int time, int cheeseCnt){
            this.time=time;
            this.cheeseCnt=cheeseCnt;
        }
    }
    static class Coor{ //좌표 클래스
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void bfs(){
        Queue<Coor> q = new ArrayDeque<>();
        boolean[][] chk = new boolean[row][col];
        q.offer(new Coor(0, 0));
        chk[0][0] = true;
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int j=0; j<4; j++){
                int nx = tmp.x+dx[j];
                int ny = tmp.y+dy[j];
                if(nx>=0 && nx<row && ny>=0 && ny<col && !chk[nx][ny]){
                    chk[nx][ny] = true;
                    if(board[nx][ny]==0){ //치즈 없는 칸이면
                        q.offer(new Coor(nx, ny)); //큐에 삽입
                    }else{ //치즈 있는 칸이면
                        board[nx][ny]=0; //치즈 녹이고
                        cheeseTotal--; //cheeseTotal-1
                    }
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		board = new int[row][col];
		cheeseTotal=0;
		for(int i=0; i<row; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<col; j++){
		        board[i][j] = Integer.parseInt(input[j]);
		        if(board[i][j]==1) cheeseTotal++;
		    }
		}
		List<State> answer= new ArrayList<>();
		int time=0;
		answer.add(new State(time, cheeseTotal)); //초기 상태 저장(0시간)
		while(cheeseTotal>0){
		    time++; //한시간 증가
		    bfs(); //테두리 치즈 녹임
		    answer.add(new State(time, cheeseTotal)); //한시간 후의 상태 저장
		}
		if(answer.size()==1){ //처음부터 모두 녹아있을 경우
		    bw.write("0\n");
		    bw.write("0\n");
		}else if(answer.size()>=2){
		    bw.write(answer.get(answer.size()-1).time+"\n");
		    bw.write(answer.get(answer.size()-2).cheeseCnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
package 양주연;

import java.io.*;
public class P072_BJ2239_스도쿠
{
    static int[][] board, answer;
    static boolean flag=false;
    
    static boolean chkBoard(int x, int y, int num){ //행, 열, 3×3 크기의 보드에 num이 이미 존재하는지 확인하고, 없어서 해당 좌표에 num 적을 수 있으면 true, 있어서 못 적으면 false 리턴
        for(int i=0; i<9; i++){
            if(board[i][y]==num) return false;
        }
        for(int j=0; j<9; j++){
            if(board[x][j]==num) return false;
        }
        int startX = (x/3)*3;
        int startY = (y/3)*3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int nx = startX+i;
                int ny = startY+j;
                if(board[nx][ny]==num) return false;
            }
        }
        return true;
    }
    
    static void dfs(int x, int y){
        if(flag) return; 
        if(y==9){ //마지막 열의 다음 열일 경우 
            dfs(x+1, 0); //다음 행으로
            return;
        }
        if(x==9){ //마지막 행의 다음 행일 경우 스도쿠 완성되었으므로 저장하고 종료
            flag=true;
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    answer[i][j] = board[i][j];
                }
            }
            return;
        }
        if(board[x][y]==0){ //아직 숫자가 채워지지 않은 칸일 경우 
            for(int i=1; i<=9; i++){ //1~9
                if(chkBoard(x, y, i)){ //x, y 좌표에 i 적는 게 가능할 경우
                    board[x][y] = i; //적고
                    dfs(x, y+1); //다음 열로
                }
            }
            board[x][y] = 0; //이전으로 돌아가므로 다시 아직 숫자가 채워지지 않은 칸으로 만들어줌.
            return;
        }
        else dfs(x, y+1); //숫자 채워진 칸일 경우 다음 열로
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		board = new int[9][9];
		answer = new int[9][9];
		for(int i=0; i<9; i++){
		    String line = br.readLine();
		    for(int j=0; j<9; j++){
		        board[i][j] = line.charAt(j)-48;
		    }
		}
		dfs(0, 0);
		for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(answer[i][j]+"");
                }
                bw.write("\n");
            }
		br.close();
		bw.flush();
		bw.close();
	}
}
package 양주연;

import java.io.*;

public class P042_BJ3109_빵집 {

	static char[][] map;
    static int R,C, answer=0;
    static boolean[][] chk;
    static int[] dx={-1,0,1};
    static boolean dfs(int x, int y){
        chk[x][y]=true;
        if(y==C-1){
            answer++;
            return true;
        }
        for(int i=0; i<3; i++){
            int nx = x+dx[i];
            int ny = y+1;
            if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!='x' && !chk[nx][ny]){
                if(dfs(nx, ny)){
                    return true;
                }
            }
        }
        return false;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        chk = new boolean[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<R; i++){
            dfs(i,0);
        }
        bw.write(answer+"\n");
        br.close();
        bw.flush();
        bw.close();
	}

}

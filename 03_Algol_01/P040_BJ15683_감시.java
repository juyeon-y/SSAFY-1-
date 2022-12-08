package 양주연;

import java.io.*;

public class P040_BJ15683_감시 {
	
	static int[] dx={-1,0,1,0}, dy={0,1,0,-1};
    static int[][] office;
    static int N, M;
    static int minCnt;
    static int getBlindSpot(int[] direct){
        int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++){
            System.arraycopy(office[i], 0, tmp[i], 0, office[i].length);
        }
        int idx=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(office[i][j]>=1 && office[i][j]<=5){
                    int curX = i, curY = j;
                    int curDir = direct[idx++];
                    switch(office[i][j]){
                        case 1:
                            update(curX, curY, curDir, tmp);
                            break;
                        case 2:
                            update(curX, curY, curDir, tmp);
                            update(curX, curY, (curDir+2)%4, tmp);
                            break;
                        case 3:
                            update(curX, curY, curDir, tmp);
                            update(curX, curY, (curDir+1)%4, tmp);
                            break;
                        case 4:
                            update(curX, curY, curDir, tmp);
                            update(curX, curY, (curDir+1)%4, tmp);
                            update(curX, curY, (curDir+3)%4, tmp);
                            break;
                        case 5:
                            update(curX, curY, curDir, tmp);
                            update(curX, curY, (curDir+1)%4, tmp);
                            update(curX, curY, (curDir+2)%4, tmp);
                            update(curX, curY, (curDir+3)%4, tmp);
                            break;
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmp[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    static void update(int curX, int curY, int curDir, int[][] tmp){
        while(true){
            curX+=dx[curDir];
            curY+=dy[curDir];
            if(curX<0 || curX>=N || curY<0 || curY>=M || tmp[curX][curY]==6) break;
            if(tmp[curX][curY]>=1 && tmp[curX][curY]<=5) continue;
            tmp[curX][curY]=-1;
        }
    }
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]);
	    M = Integer.parseInt(input[1]);
	    office = new int[N][M];
	    int k = 0; //cctv 수
	    int blankCnt = 0;
	    for(int i=0; i<N; i++){
	        input = br.readLine().split(" ");
	        for(int j=0; j<M; j++){
	            office[i][j] = Integer.parseInt(input[j]);
	            if(office[i][j]>=1 && office[i][j]<=5) k++;
	            if(office[i][j]==0) blankCnt++;
	        }
	    }
	    minCnt = blankCnt;
	    int end = (int)Math.pow(4, k);
	    for(int i=0; i<end; i++){
	        int[] direct = new int[k];
	        int tmp = i;
	        for(int j=k-1; j>=0; j--){
	            direct[j] = tmp%4;
	            tmp/=4;
	        }
	        int curCnt = getBlindSpot(direct);
	        if(curCnt<minCnt) minCnt = curCnt;
	    }
	    bw.write(minCnt+"\n");
	    br.close();
	    bw.flush();
	    bw.close();
	}
}

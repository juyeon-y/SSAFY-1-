package 양주연;
import java.io.*;

public class P025_BJ16926_배열돌리기1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int R = Integer.parseInt(input[2]);
	    int[][] arr= new int[N][M];
	    int[] dx = {0,1,0,-1}, dy={1,0,-1,0};
	    for(int i=0; i<N; i++){
	        input = br.readLine().split(" ");
	        for(int j=0; j<M; j++){
	            arr[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    int min = N > M ? M : N;
	    int grpNo = min/2;
	    for(int i=0; i<R; i++){
	        for(int j=0; j<grpNo; j++){
	            int x=j;
	            int y=j;
	            int temp=arr[x][y];
	            int idx=0;
	            while(idx<4){
	                int nx=x+dx[idx];
					int ny=y+dy[idx];
					if(nx<j || nx>=N-j || ny<j || ny>=M-j){
					    idx++;
					}
					else{
					    arr[x][y]=arr[nx][ny];
					    x=nx;
					    y=ny;
					}
	            }
	            arr[j+1][j]=temp;
	        }
	    }
	    for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
	    br.close();
	    bw.flush();
	    bw.close();
	}
}

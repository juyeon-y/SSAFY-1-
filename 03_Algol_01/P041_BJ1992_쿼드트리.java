package 양주연;

import java.io.*;

public class P041_BJ1992_쿼드트리 {

	static int[][] img;
    static StringBuilder sb;
    static void div(int startX, int startY, int len){
        int sum=0;
        for(int i=startX; i<startX+len; i++){
            for(int j=startY; j<startY+len; j++){
                sum+=img[i][j];
            }
        }
        if(sum==0){
            sb.append("0");
        }else if(sum==len*len){
            sb.append("1");
        }
        else{
            sb.append("(");
            div(startX, startY, len/2);
            div(startX, startY+len/2, len/2);
            div(startX+len/2, startY, len/2);
            div(startX+len/2, startY+len/2, len/2);
            sb.append(")");
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		img = new int[N][N];
		sb = new StringBuilder();
		for(int i=0; i<N; i++){
		    String tmp = br.readLine();
		    for(int j=0; j<N; j++){
		        img[i][j] = tmp.charAt(j)-48;
		    }
		}
		div(0, 0, N);
		bw.write(sb+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}

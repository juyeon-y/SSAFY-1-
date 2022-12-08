package 양주연;

import java.io.*;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer=0;
        while(true){
            if(N%5==0){
                answer+=N/5;
                break;
            }
            else if(N>0){
                N-=3;
                answer++;
            }
            else{
                answer=-1;
                break;
            }
        }
        bw.write(answer+"\n");
        br.close();
        bw.flush();
        bw.close();
	}

}

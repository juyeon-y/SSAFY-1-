package 양주연;

import java.io.*;

public class P036_BJ1074_Z {

	static int count=0;
    static void search(int len, int r, int c){
        if(len==1) return; //len==1일 경우 종료
        if(r<len/2 && c<len/2){ //1사분면
            search(len/2, r, c); 
            //1사분면일땐 count에 더해주지 않음.
        }
        else if(r<len/2 && c>=len/2){ //2사분면
            count+=(len*len/4)*1; //1사분면만큼 더해줌.
            search(len/2, r, c-len/2); //len/2해주고 2사분면에서 1사분면으로 r,c 좌표 옮겨줘야함.
        }
        else if(r>=len/2 && c<len/2){ //3사분면
            count+=(len*len/4)*2; //1사분면, 2사분면만큼 더해줌.
            search(len/2, r-len/2, c); //len/2해주고 3사분면에서 1사분면으로 r,c 좌표 옮겨줘야함.
        }
        else{ //4사분면
            count+=(len*len/4)*3; //1사분면, 2사분면, 3사분면만큼 더해줌.
            search(len/2, r-len/2, c-len/2); //len/2해주고 4사분면에서 1사분면으로 r,c 좌표 옮겨줘야함.
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int len = (int) Math.pow(2, N);
        search(len, r, c);
        bw.write(count+"\n");
        br.close();
        bw.flush();
        bw.close();
	}

}

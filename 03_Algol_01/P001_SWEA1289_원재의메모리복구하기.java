package 양주연;

import java.io.*;

public class P001_SWEA1289_원재의메모리복구하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int T = Integer.parseInt(br.readLine());
	    for(int tc=1; tc<=T; tc++){
	        String oriVal=br.readLine();
	        int cnt=0;
	        char prev='0';
	        for(char c : oriVal.toCharArray()){
	            if(c!=prev){
	                prev=c;
	                cnt++;
	            }
	        }
	        bw.write("#"+tc+" "+cnt+"\n");
	    }
	    br.close();
	    bw.flush();
	    bw.close();
	}

}

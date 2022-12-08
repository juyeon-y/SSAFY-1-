package 양주연;

import java.io.*;
import java.util.*;

public class P003_BJ1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int switchNum = Integer.parseInt(br.readLine());
		char[] switches = new char[switchNum+1];
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<=switchNum; i++){
		    switches[i] = st.nextToken().charAt(0);
		}
		int studentNum = Integer.parseInt(br.readLine());
		for(int i=0; i<studentNum; i++){
		    st = new StringTokenizer(br.readLine());
		    char gender = st.nextToken().charAt(0);
		    int num = Integer.parseInt(st.nextToken());
		    if(gender=='1'){
		        for(int j=num; j<switchNum+1; j+=num){
		            if(switches[j]=='0') switches[j]='1';
		            else switches[j]='0';
		        }
		    }
		    else{
		        int min = Math.min(switchNum-num, num-1), j=0;
		        for(j=1; j<=min; j++){
		            if(switches[num-j]!=switches[num+j]) break; 
		        }
		        j--;
		        for(int k=num-j; k<=num+j; k++){
		            if(switches[k]=='0') switches[k]='1';
		            else switches[k]='0';
		        }
		    }
		}
		for(int i=1; i<=switchNum; i++){
		    bw.write(switches[i]+" ");
		    if(i%20==0) bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

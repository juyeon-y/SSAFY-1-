package 양주연;

import java.io.*;

public class P031_BJ3040_백설공주와일곱난쟁이 {

	static int[] hat, selected, answer;
    static boolean found=false;
    static void combi(int lev, int start, int total){
        if(lev==7){
            if(total==100){
                int idx=0;
                for(int x: selected){
                    answer[idx++]=x;
                    found = true;
                }
            }
        }
        else{
            if(found) return;
            for(int i = start; i<9; i++){
                selected[lev] = hat[i];
                combi(lev+1, i+1, total+hat[i]);
                
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		hat = new int[9];
		selected = new int[7];
		answer = new int[7];
		for(int i=0; i<9; i++){
		   hat[i] = Integer.parseInt(br.readLine());
		}
		combi(0,0,0);
		for(int x: answer){
		    bw.write(x+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

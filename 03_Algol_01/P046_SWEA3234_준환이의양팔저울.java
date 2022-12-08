package 양주연;

import java.io.*;

public class P046_SWEA3234_준환이의양팔저울 {

	static int cnt;
    static void dfs(int lev, boolean[] isSelected, int leftTotal, int rightTotal, int[] weights, int N){
        if(lev==N){
            cnt++;
        }
        else{
            for(int i=0; i<N; i++){
                if(!isSelected[i]){
                    isSelected[i]=true;
                    dfs(lev+1, isSelected, leftTotal+weights[i], rightTotal, weights, N);
                    if(leftTotal>=rightTotal+weights[i]) dfs(lev+1, isSelected, leftTotal, rightTotal+weights[i], weights, N);
                    isSelected[i]=false;
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    cnt=0;
		    int N = Integer.parseInt(br.readLine());
		    String[] input = br.readLine().split(" ");
		    int[] weights = new int[N];
		    for(int i=0; i<N; i++){
		        weights[i] = Integer.parseInt(input[i]);
		    }
		    dfs(0, new boolean[N], 0, 0, weights, N);
		    bw.write("#"+tc+" "+cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

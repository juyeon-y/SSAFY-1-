package 양주연;

import java.io.*;

public class P027_BJ1010_다리놓기 {

	static int[][] memo = new int[30][30];
    static int combi(int n, int r){
        if(r==0 || n==r) return 1;
        if(memo[n][r]!=0) return memo[n][r];
        return memo[n][r] = combi(n-1, r-1)+combi(n-1, r);
    }
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            bw.write(combi(m, n)+"\n");
            
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

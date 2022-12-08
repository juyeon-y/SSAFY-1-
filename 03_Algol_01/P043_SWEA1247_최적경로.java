package 양주연;

import java.io.*;
import java.util.*;

public class P043_SWEA1247_최적경로 {

	static int companyX, companyY, homeX, homeY, minDist, N;
    static ArrayList<Coor> customer;
    static boolean[] isSelected;
    static class Coor{
        int x, y;
        public Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void dfs(int lev, int curX, int curY, int dist){
        if(lev==N){
        	int tmp = dist + Math.abs(curX-homeX)+Math.abs(curY-homeY); //마지막 고객과 집과의 거리까지 계산해 더해줌
            if(tmp<minDist) minDist = tmp; //최단 경로 이동거리 업데이트
            
        }
        else{
            for(int i=0; i<N; i++){
                if(isSelected[i]) continue;
                isSelected[i]=true;
                int tmp = Math.abs(curX-customer.get(i).x)+Math.abs(curY-customer.get(i).y);
                dfs(lev+1, customer.get(i).x, customer.get(i).y, dist+tmp); 
                isSelected[i]=false;
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            minDist=Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            customer = new ArrayList<>();
            String[] input = br.readLine().split(" ");
            companyX = Integer.parseInt(input[0]);
            companyY = Integer.parseInt(input[1]);
            homeX = Integer.parseInt(input[2]);
            homeY = Integer.parseInt(input[3]);
            for(int i=4; i<(N+2)*2; i+=2){
                customer.add(new Coor(Integer.parseInt(input[i]), Integer.parseInt(input[i+1])));
            }
            int curX = companyX;
            int curY = companyY;
            dfs(0, curX, curY, 0);
            bw.write("#"+tc+" "+minDist+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

	}

}

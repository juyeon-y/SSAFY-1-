package 양주연;

import java.io.*;
import java.util.*;

public class P032_BJ15686치킨배달 {

	static ArrayList<Point> houses, cHouses;
    static int[] cHouseIdx;
    static int M, minChick=Integer.MAX_VALUE;
    static class Point{ //좌표값 클래스
        int x, y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void combi(int lev, int start){ //조합
        if(lev==M){ 
            int cityChick=0;
            for(Point p : houses){
                int min = Integer.MAX_VALUE;
                for(int i : cHouseIdx){
                    int tmp = Math.abs(p.x - cHouses.get(i).x) + Math.abs(p.y - cHouses.get(i).y);
                    min = Math.min(tmp, min);
                }
                cityChick+=min;
            }
            if(cityChick<minChick) minChick=cityChick;
        }
        else{
            for(int i=start; i<cHouses.size(); i++){
                cHouseIdx[lev]=i;
                combi(lev+1, i+1);
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		cHouseIdx = new int[M];
		houses = new ArrayList<>();
		cHouses = new ArrayList<>();
		for(int i=0; i<N; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<N; j++){
		        int tmp = Integer.parseInt(input[j]);
		        if(tmp==1) houses.add(new Point(i+1, j+1));
		        else if(tmp==2) cHouses.add(new Point(i+1, j+1));
		    }
		}
		
		combi(0, 0);
		bw.write(minChick+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

}

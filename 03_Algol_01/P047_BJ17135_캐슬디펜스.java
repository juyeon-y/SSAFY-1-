package 양주연;

import java.io.*;
import java.util.*;

public class P047_BJ17135_캐슬디펜스 {

	static int N, M, D, max=0;
    static ArrayList<Coor> enemyList;
    static class Coor implements Comparable<Coor>{
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Coor o){
        	if(this.y==o.y) return o.x-this.x; //행으로 내림차순
            return this.y-o.y; //열로 오름차순           
        }
    }
    static void comb(int lev, int start, ArrayList<Coor> archerList){
        if(lev==3){
            int killCnt=0, leftEnemy=enemyList.size();
            boolean[] enemyStatus = new boolean[leftEnemy];
            int idx=0;
            while(leftEnemy>0){
            	for(int i=0; i<enemyList.size(); i++) {
            		if(enemyList.get(i).x+idx==N){ //적이 성 도착 했으면 상태 변경
                        leftEnemy--;
                        enemyStatus[i]=true;
                        break;
                    }
            	}
                //한 라운드 시작(궁수들 모두 쏨)
                ArrayList<Integer> killIdx = new ArrayList<>();
                System.out.println();
                for(Coor archer : archerList){ 
                	System.out.println("dddddds: "+archer.x+" "+archer.y);
                    for(int i=0; i<enemyList.size(); i++){
                        if(!enemyStatus[i]){ //해당 적이 남아있다면 (false - 남o, true -남x)
                            //System.out.println("dd=: "+enemyList.get(i).x+" "+enemyList.get(i).y);
                            int dist = Math.abs(archer.x-(enemyList.get(i).x+idx))+Math.abs(archer.y-enemyList.get(i).y);
                            if(dist<=D){ //아직 성 도착 안했고 제한거리 안이면 죽이기 가능
                                killIdx.add(i);
                                break;
                            }
                        }
                    }
                }
                for(int x : killIdx){
                    if(!enemyStatus[x]){
                        killCnt++;
                        enemyStatus[x]=true;
                        leftEnemy--;
                    }
                }
                idx++;
            }
            if(killCnt>max) max = killCnt;
        }
        else{
            for(int i=start; i<M; i++){
                archerList.add(new Coor(N, i));
                comb(lev+1, i+1, archerList);
                archerList.remove(archerList.size()-1);
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);
		enemyList = new ArrayList<>();
		for(int i=0; i<N; i++){
		    input = br.readLine().split(" ");
		    for(int j=0; j<M; j++){
		        int tmp = Integer.parseInt(input[j]);
		        if(tmp==1){
		            enemyList.add(new Coor(i,j));
		        }
		    }
		}
		Collections.sort(enemyList);
		comb(0, 0, new ArrayList<Coor>());
		bw.write(max+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

}

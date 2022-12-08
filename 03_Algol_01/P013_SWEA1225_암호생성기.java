package 양주연;

import java.io.*;
import java.util.*;

public class P013_SWEA1225_암호생성기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
	    Queue<Integer> q = new LinkedList<>(); //큐는 인터페이스라서 LinkedList 객체로 큐 생성
	    for(int tc=1; tc<=10; tc++){ //테스트케이스만큼 반복
	        int tcNum = Integer.parseInt(br.readLine()); //테스트케이스 번호 입력받음
	        String[] input = br.readLine().split(" "); //8개의 데이터 문자열 배열에 입력받음
	        for(int i=0; i<8; i++){
	            q.offer(Integer.parseInt(input[i])); //큐에 8개의 데이터 int로 변환하여 집어넣음
	        }
	        int minus=1; //감소시킬 수를 minus 변수에 저장
	        while(true){ //break 만날떄까지 반복
	            if(minus==6) minus=1; //minus 값이 6이면 1로 변경
	            int tmp = q.poll(); //큐에서 하나꺼내와서 tmp에 저장
	            tmp = Math.max(0, tmp-(minus++)); //tmp를 minus만큼 감소시키고 minus 값에 1을 더해줌. 만약 tmp가 0보다 작아지는 경우 tmp에 0을 저장함.
	            q.offer(tmp); //큐에 tmp 집어넣음.
	            if(tmp==0) break; //만약 집어넣은 tmp가 0일 경우 break로 빠져나옴.
	        }
	        bw.write("#"+tc+" "); //테스트케이스 번호 출력 
	        while(!q.isEmpty()){ //큐가 비어있지 않는 한 반복
	            bw.write(q.poll()+" "); //큐에서 원소 꺼내와서 출력
	        }
	        bw.write("\n"); //다음 줄로
	    }
	    br.close(); //BufferedReader 닫기
	    bw.flush(); //BufferedWriter 버퍼 비우기
	    bw.close(); //BufferedWriter 닫기
	}

}

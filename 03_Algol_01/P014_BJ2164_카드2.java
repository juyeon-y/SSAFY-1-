package 양주연;

import java.io.*;
import java.util.*;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
	    Queue<Integer> queue = new LinkedList<>(); //큐는 인터페이스라서 LinkedList 객체로 큐 생성
	    int n = Integer.parseInt(br.readLine()); //카드 수 입력받음
	    for(int i=1; i<=n; i++) queue.offer(i); //1부터 n까지를 큐에 집어넣음
	    while(queue.size()>1){ //큐 크기가 1보다 클 동안 반복. 큐에 하나만 남으면 빠져나옴
	        queue.poll(); //큐에서 하나 꺼냄
	        queue.offer(queue.poll()); //큐에서 하나 꺼내고 바로 큐에 다시 집어넣음
	    }
	    bw.write(queue.poll()+"\n"); //큐에 마지막에 남은 원소를 출력. (제일 마지막에 남게 되는 카드 번호 출력)
	    br.close(); //BufferedReader 닫기
	    bw.flush(); //BufferedWriter 버퍼 비우기
	    bw.close(); //BufferedWriter 닫기
	}

}

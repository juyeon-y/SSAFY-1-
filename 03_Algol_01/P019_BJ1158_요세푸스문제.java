package 양주연;

import java.io.*;
import java.util.*;

public class P019_BJ1158_요세푸스문제 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //n 입력받음
		int k = Integer.parseInt(input[1]); //k 입력받음
		Queue<Integer> q = new LinkedList<>(); //큐 생성
		for(int i=1; i<=n; i++){
		    q.offer(i); //1부터 n까지 큐에 집어넣음.
		}
		bw.write("<");
		while(!q.isEmpty()){ //큐가 비어있지 않은한 반복
		    for(int i=0; i<k-1; i++){ //k-1번 반복
		        q.offer(q.poll()); //큐에서 숫자를 꺼내서 다시 집어넣음
		    }
		    bw.write(String.valueOf(q.poll())); //큐에서 꺼낸 k번째 숫자를 출력
		    if(!q.isEmpty()) bw.write(", "); //큐가 비어있지 않은한 , 출력
		}
		bw.write(">");
		br.close();
		bw.flush();
		bw.close();
	}

}

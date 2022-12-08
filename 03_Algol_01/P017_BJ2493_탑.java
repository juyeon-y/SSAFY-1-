package 양주연;

import java.io.*;
import java.util.*;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		int n = Integer.parseInt(br.readLine()); //탑의 수 n에 입력 받음
		Stack<int[]> stack = new Stack<>(); //{탑의 높이, 탑의 번호} 저장할 스택 생성
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++){ //탑의 개수만큼 반복
		    int tower = Integer.parseInt(input[i]); //탑의 높이 입력 받음
		    while(!stack.isEmpty() && stack.peek()[0]<tower) stack.pop(); //스택이 비어있지 않고, 입력받은 탑의 높이보다 스택의 맨위에 저장된 탑의 높이가 작은(<) 한 계속 pop. (첫번째로 만난 나보다 탑의 높이가 큰 탑에서 레이저 신호를 수신함. 스택에는 탑의 높이가 스택 바닥부터 위까지 내림차순(>)으로 저장되어있어야 함. N개의 높이가 서로 다른 탑이므로 같은(=) 경우는 없음.)
		    if(stack.isEmpty()) bw.write("0 "); //스택이 비어있다면 신호를 수신할 탑이 존재하지 않는 것이므로 0 출력
		    else bw.write(stack.peek()[1]+" "); //아니면 스택의 맨 위에 저장된 탑의 번호 출력
		    stack.push(new int[]{tower, i+1}); //스택에 입력받은 탑의 높이와 탑의 번호 배열로 저장
		}
		br.close(); //BufferedReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}

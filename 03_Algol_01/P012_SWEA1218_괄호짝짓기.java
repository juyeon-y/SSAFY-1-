package 양주연;

import java.io.*;
import java.util.*;

public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
	    for(int tc=1; tc<=10; tc++){ //테스트케이스만큼 반복
	        int answer=1; //answer를 1로 초기화. answer가 변경되지 않는한 유효하다고 출력됨.
	        int len = Integer.parseInt(br.readLine()); //길이 입력 받음
	        String str = br.readLine(); //문지열 입력 받음
	        Stack<Character> stack = new Stack<>(); //스택 생성
	        for(char c : str.toCharArray()){ //문자열에 문자가 있는 한 반복
	            if(c=='('||c=='['||c=='{'||c=='<') stack.push(c); //문자가 (, [, {, < 일 경우 스택에 푸쉬받음
	            else{ //아닐경우
	            	 if(stack.isEmpty()) { //스택이 비어있을 경우 answer 유효하지 않다고 수정후 break
	            		 answer=0;
	            		 break;
	            	 }
	                char tmp = stack.pop(); //스택에서 하나꺼냄
	                if((c==')'&&tmp!='(')||(c==']'&&tmp!='[')||(c=='}'&&tmp!='{')||(c=='>'&&tmp!='<')){ //하나 꺼낸 게 짝이 맞지 않을 경우
	                    answer=0; //유효하지 않다고 answer 수정
	                    break; //break로 빠져나옴
	                }
	            }
	        }
	        if(!stack.isEmpty()) answer=0; //스택에 문자가 남아있을 경우에도 짝이 맞지 않은 것이므로 answer 유효하지 않다고 수정
	        bw.write("#"+tc+" "+answer+"\n"); //answer 출력
	    }
	    br.close(); //BufferedReader 닫기
	    bw.flush(); //BufferedWriter 버퍼 비우기
	    bw.close(); //BufferedWriter 닫기
	}

}

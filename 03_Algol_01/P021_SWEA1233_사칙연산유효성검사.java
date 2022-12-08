package 양주연;

import java.io.*;

public class P021_SWEA1233_사칙연산유효성검사 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		String[] input;
		for(int tc=1; tc<=10; tc++){ //테스트케이스 수만큼 반복
		    n = Integer.parseInt(br.readLine()); //노드의 개수 입력받음
		    boolean flag=true; //식의 유효성 검사할 때 사용할 변수 flag true로 초기화.(계산이 가능하다면 true, 불가능하다면 false)
		    for(int i=0; i<n; i++){ //노드 개수만큼 반복
		        input = br.readLine().split(" "); //한줄(노드 한개)씩 입력받음
		        if((!Character.isDigit(input[1].charAt(0)) && input.length!=4) || (Character.isDigit(input[1].charAt(0)) && input.length!=2)){
		            flag=false; //한 노드라도 연산자가 저장된 노드이지만 왼쪽 오른쪽 자식노드 없을 경우 or 숫자 저장된 노드이지만 자식노드가 없는 리프노드가 아닐 경우 계산 불가능하므로 false 저장.
		        } //계산이 가능하려면 노드들이 모두 둘 중 하나여야 함. 1. 연산자 노드일 경우 왼쪽 오른쪽 자식노드 있어야 함 2. 숫자 노드일 경우 자식노드 없는 리프 노드여야 함.
		    }
		    if(flag) bw.write("#"+tc+" 1\n"); //계산 가능하면 1 출력
		    else bw.write("#"+tc+" 0\n"); //계산 불가능하면 0 출력
		}
	    br.close();
	    bw.flush();
	    bw.close();
	}

}

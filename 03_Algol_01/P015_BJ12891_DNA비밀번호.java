package 양주연;

import java.io.*;
import java.util.*;

public class P015_BJ12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter 생성
		String[] input = br.readLine().split(" ");
		int s = Integer.parseInt(input[0]); //DNA 문자열 길이 입력 받음
		int p = Integer.parseInt(input[1]); //부분 문자열 길이 입력 받음
		String dna = br.readLine(); //DNA 문자열 입력 받음
		char[] alp = {'A', 'C', 'G', 'T'}; //{‘A’, ‘C’, ‘G’, ‘T’} char 배열에 저장
		int[] least = new int[4]; // {‘A’, ‘C’, ‘G’, ‘T’}의 최소 개수 저장할 배열 생성
		input = br.readLine().split(" ");
		for(int i=0; i<4; i++){
		    least[i] = Integer.parseInt(input[i]); //{‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 입력 받음
		}
		HashMap<Character, Integer> map = new HashMap<>(); // 현재 부분문자열에서 {‘A’, ‘C’, ‘G’, ‘T’}가 몇번 등장했는지 저장할 해시맵 생성
		for(int i=0; i<p; i++){
		    map.put(dna.charAt(i), map.getOrDefault(dna.charAt(i), 0)+1); //첫번째 부분문자열의 {‘A’, ‘C’, ‘G’, ‘T’} 등장횟수 저장
		}
		int cnt=0; //만들 수 있는 비밀번호 수 저장할 cnt 변수 초기화
		boolean flag; //최소 개수 만족하면 flag가 true 아니면 false
		for(int i=p; i<=s; i++){ //p에서 s-1까지 반복하면 되나 최소 개수 먼저 확인하고 새로 추가하기 때문에 마지막에 추가한것이 최소 개수 만족하는지 확인하기 위하여 s까지 돌림.
		    flag=true; //true로 초기화
		    for(int j=0; j<4; j++){ //{‘A’, ‘C’, ‘G’, ‘T’} 이므로 4번 반복
		        if(least[j]>map.getOrDefault(alp[j], 0)){ //현재 {‘A’, ‘C’, ‘G’, ‘T’} 등장 횟수가 최소 개수 만족하지 않으면 
		            flag=false; //flag에 false 저장
		            break; //break로 빠져나옴
		        }
		    }
		    if(flag) cnt++; //{‘A’, ‘C’, ‘G’, ‘T’} 등장 횟수가 최소 개수 만족하면 cnt++
		    if(i==s) break; //i가 s라서 문자열 배열 범위 벗어나면 오류날 수 있으므로 break
		    //슬라이딩 윈도우
		    map.put(dna.charAt(i), map.getOrDefault(dna.charAt(i), 0)+1); //다음 한 문자를 현재 {‘A’, ‘C’, ‘G’, ‘T’} 등장횟수에 추가
		    map.put(dna.charAt(i-p), map.get(dna.charAt(i-p))-1); //이전 한 문자를 현재 {‘A’, ‘C’, ‘G’, ‘T’} 등장횟수에서 제거
		}
		bw.write(cnt+"\n"); //만들 수 있는 비밀번호 수 출력
		br.close(); //BufferedReader 닫기
		bw.flush(); //BufferedWriter 버퍼 비우기
		bw.close(); //BufferedWriter 닫기
	}

}

package 양주연;

import java.util.*;

public class P016_BJ2023_신기한소수 {

	static int n; //n을 static 변수로 선언
    static StringBuilder sb; //StringBuilder를 static 변수로 선언
    public static void dfs(int lev, int num){ // 깊이 우선 탐색 메서드.  lev : 트리의 레벨, num : 현재까지 만들어진 소수
        if(lev==n){ //트리 레벨이 n이 되면 신기한 소수 완성
            sb.append(num+"\n"); //StringBuilder에 append
        }
        else{ //레벨이 n이 아니면
            for(int i=1; i<=9; i++){ //0이 들어가면 2의 배수가 되어 소수가 되는 것이 불가능하므로  1부터 9까지만 사용 
                if(lev==0 && i==1) continue; //1은 소수가 아니므로 첫번째 자리수로 1이 들어가게 될 상황이면 continue
                int tmp = num*10+i; //해당 번째 자리수 추가 (lev 0이면 첫번째, lev 1이면 두번째, ...)
                boolean flag = true; //flag가 true이면 소수 false이면 소수 아님. true로 초기화
                for(int j=2; j*j<=tmp; j++){ //2부터 제곱근까지 반복
                    if(tmp%j==0){ //만약 나뉘면
                        flag=false; //소수 아님
                        break; //break로 빠져나옴
                    }
                }
                if(flag) dfs(lev+1, tmp); //소수이면 다음 레벨, 현재까지 만들어진 소수 집어넣고 재귀 호출
            }
        }
    }
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in); //스캐너 생성
	    n = sc.nextInt(); //n 입력 받음
	    sb = new StringBuilder(); //StringBuilder 생성
	    dfs(0, 0); //lev=0, num=0으로 초기화하고 메서드 호출
	    System.out.print(sb); //StringBuilder 출력. toString() 메서드 자동 호출됨
	}

}

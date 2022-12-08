package 양주연;

import java.io.*;

public class P022_SWEA6808_규영이와인영이의카드게임 {

	static int[] gCard=new int[9], iCard=new int[9]; //규영이와 인영이의 카드에 적힌 수 저장할 배열 생성
    static int winCnt=0, loseCnt=0; //규영이가 이기는 경우와 지는 경우의 수 저장할 변수 winCnt, loseCnt
    static boolean[] iChk = new boolean[9]; //인영이가 이미 낸 카드 true로 저장해서 다시 내는 일이 없도록 하는데 사용할 iChk 배열
    static void dfs(int lev, int gTotal, int iTotal){ //dfs 함수. lev:트리 레벨, gTotal: 규영의 총점, iTotal: 인영의 총점
        if(lev==9){ //lev==9이면 아홉 라운드가 모두 끝난 것이므로 승패 카운트
            if(gTotal>iTotal) winCnt++; //규영이가 이겼으면 winCnt++
            else if(gTotal<iTotal) loseCnt++; //규영이가 졌으면 loseCnt++
        }
        else{
            for(int i=0; i<9; i++){ //9번 반복
                if(iChk[i]==true) continue; //이미 낸 카드이면 내지 않음
                iChk[i]=true; //해당 카드(iCard[i]) 낸다는 의미에서 iChk 배열값에 true 저장
                int sum = gCard[lev]+iCard[i]; //두 카드에 적힌 수의 합 sum에 저장
                if(gCard[lev]>iCard[i]) dfs(lev+1, gTotal+sum, iTotal); //규영이가 더 높은 수가 적힌 카드를 냈다면 규영의 총점에 sum더해주고 다음 레벨로 넘어감
                else dfs(lev+1, gTotal, iTotal+sum); //인영이가 더 높은 수가 적힌 카드를 냈다면 인영의 총점에 sum더해주고 다음 레벨로 넘어감
                iChk[i]=false; //현 라운드에서 해당 카드를 낸다고 했을 경우의 탐색이 끝났으므로 false 저장해주고 다음 반복으로 넘어가서 다른 카드 내는 경우 탐색함
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수 입력 받음
		String[] input;
		for(int tc=1; tc<=T; tc++){ //테스트케이스 수만큼 반복
		    winCnt=0; //winCnt, loseCnt 0으로 초기화
		    loseCnt=0;
		    input = br.readLine().split(" ");
		    boolean[] chk = new boolean[19]; //1~18까지 적힌 카드 중 규영이나 인영이 가져간 것은 true로 가져가지 않은 것은 false로 저장할 chk 배열 생성
		    for(int i=0; i<9; i++){ 
		        gCard[i] = Integer.parseInt(input[i]); //규영의 카드 배열에 입력 받음
		        chk[gCard[i]]=true; //규영이 가져간 카드는 true로 저장
		    }
		    int idx=0;
		    for(int j=1; j<=18; j++){
		        if(chk[j]==false) iCard[idx++]=j; //규영이 가져가지 않은 카드 인영의 카드 배열에 입력 받음
		    }
		    dfs(0, 0, 0); //dfs 함수 호출
		    bw.write("#"+tc+" "+winCnt+" "+loseCnt+"\n"); //규영이가 이기는 경우와 지는 경우의 수 출력
		}
	    br.close();
	    bw.flush();
	    bw.close();
	}

}

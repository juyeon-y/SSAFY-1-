package 양주연;

import java.io.*;
public class P082_SWEA4014_활주로건설
{
    static int N, X, map[][], map2[][];
    
    private static int process(){ //활주로 건설 가능한 경우의 수 리턴해주는 함수
        int count = 0;
        for(int i=0; i<N; i++){
            if(makeRoad(map[i])) count++; //수평 활주로 건설 체크
            if(makeRoad(map2[i])) count++; //수직 활주로 건설 체크
        }
        return count;
    }
    
    private static boolean makeRoad(int[] road){ //해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴하는 함수. (int[] road가 한 행.)
        int beforeHeight = road[0]; //이전 높이. 첫번째 칸은 이전 높이가 없으니까 자신과 똑같은 높이를 갖는 애가 이전에 있었던 것처럼 road[0]으로 초기화.
        int size = 0; //연속 길이
        int j = 0;
        while(j<N){
            if(beforeHeight == road[j]) { //동일 높이
                size++;
                j++;
            }else if(beforeHeight+1 == road[j]) { //이전 높이보다 1 높음 : 오르막 경사로 설치 체크
                if(size<X) return false; //X 길이 미만이면 활주로 건설 불가
                beforeHeight++;
                size=1;
                j++;
            }else if(beforeHeight-1 == road[j]) { //이전 높이보다 1 작음
                int count = 0;
                for(int k=j; k<N; k++){ //현재 위치부터 끝까지 들여다보며 체크
                    if(road[k] != beforeHeight-1) return false;
                    if(++count == X) break; //road[k] == beforeHeight-1를 만족하는 길이가 최소 길이 만족했으면 반복문 빠져나옴.
                }
                if(count < X) return false; //연속길이가 X보다 작으면 활주로 건설 불가능
                beforeHeight--;
                j += X; //다음 탐색 위치로 이동
                size = 0;
            }else { //높이가 2이상 차이
                return false;
            }
        }
        return true; //리턴되지 않고 끝까지 다 돌면 활주로 건설 가능하므로 true 리턴.
    }
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    N = Integer.parseInt(input[0]); //지도의 한 변의 길이 N
		    X = Integer.parseInt(input[1]); //경사로 밑변 길이 X
		    map = new int[N][N];
		    map2 = new int[N][N]; //열을 수평(행)으로 만들어놓은 다음, 행체크하는 함수(makeRoad) 사용하여 체크할 것이기 때문에 map의 행, 열 뒤집어 저장할 map2 필요.
		    for(int i=0; i<N; i++){
		        input = br.readLine().split(" ");
		        for(int j=0; j<N; j++){
		            map2[j][i] = map[i][j] = Integer.parseInt(input[j]);
		        }
		    }
		    System.out.println("#"+tc+" "+process());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
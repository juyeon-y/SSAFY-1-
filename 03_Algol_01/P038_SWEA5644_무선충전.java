package 양주연;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P038_SWEA5644_무선충전 {
	
	
	static int M, A;
	
	static int[] userA_move;
	static int[] userB_move;
	
	static int res;
	
	static int[] dx = {0, -1, 0, 1, 0};
	static int[] dy = {0, 0, 1, 0, -1};
	
	
	
	static ArrayList<BC> bcLst;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int cNum = 1; cNum <= T; cNum++) {
			res = 0;
			
			bcLst = new ArrayList<>();
			
			String[] ma = br.readLine().split(" ");
			M = Integer.parseInt(ma[0]);
			A = Integer.parseInt(ma[1]);
			
			userA_move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			userB_move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for (int i = 0; i < A; i++) {
				int[] crCP = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				bcLst.add(new BC(crCP[0], crCP[1], crCP[2], crCP[3])); // BC 정보를 저장 
			}
			
			int aX = 0;
			int aY = 0;
			
			int bX = 9;
			int bY = 9;
			
			// 첫번째 충전로직
			charge(aX, aY, bX, bY);
			
			for (int i = 0; i < M; i++) {
				
				// 이동로직
				aX = aX + dx[userA_move[i]];
				aY = aY + dy[userA_move[i]];
				bX = bX + dx[userB_move[i]];
				bY = bY + dy[userB_move[i]];
				
				// 충전로직
				charge(aX, aY, bX, bY);
			}
			
			bw.write("#"+cNum+" "+res+"\n");
		}
		
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	static void charge(int ax, int ay, int bx, int by) {
		// 가능한 BC 인덱스 모음 
		ArrayList<Integer> chargeA = new ArrayList<>();
		ArrayList<Integer> chargeB = new ArrayList<>();
		
		for (int i = 0; i < bcLst.size(); i++) {
			int dist = Math.abs(ax - bcLst.get(i).row) + Math.abs(ay - bcLst.get(i).col);
			
			if (dist <= bcLst.get(i).C) {
				chargeA.add(i);
			}
			
			int dist2 = Math.abs(bx - bcLst.get(i).row) + Math.abs(by - bcLst.get(i).col);
			if (dist2 <= bcLst.get(i).C) {
				chargeB.add(i);
			}
		}
		
		int curMax = 0;
		if(chargeA.isEmpty() && chargeB.isEmpty()) curMax=0;
		else if(chargeA.isEmpty()) {
			for (int j = 0; j < chargeB.size(); j++) {
				int b_BC = chargeB.get(j);
				curMax = Math.max(curMax, bcLst.get(b_BC).P);
			}
		}
		else if(chargeB.isEmpty()) {
			for (int i = 0; i < chargeA.size(); i++) {
				int a_BC = chargeA.get(i);
				curMax = Math.max(curMax, bcLst.get(a_BC).P);
			}
		}
		for (int i = 0; i < chargeA.size(); i++) {
			for (int j = 0; j < chargeB.size(); j++) {
				int a_BC = chargeA.get(i);
				int b_BC = chargeB.get(j);
				
				if (a_BC == b_BC) {
					curMax = Math.max(curMax, bcLst.get(a_BC).P);
				}else {
					curMax = Math.max(curMax, bcLst.get(a_BC).P + bcLst.get(b_BC).P);
				}
			}
		}
		res += curMax;
	}
	
	
	static class BC{
		int col; int row; int C; int P;

		public BC(int col, int row, int c, int p) {
			this.col = col -1; // 사용자가 0, 0부터 시작하게 하려고..
			this.row = row -1;
			this.C = c;
			this.P = p;
		}
		
	}
	

}

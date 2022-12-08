package 양주연;

import java.io.*;
import java.util.*;

public class P039_BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String exp = br.readLine();
		ArrayList<Integer> valList = new ArrayList<>();
		ArrayList<Character> opList = new ArrayList<>();
		int tmp=0;
		for(char c : exp.toCharArray()){
		    if(Character.isDigit(c)){
		        tmp=tmp*10+(c-48);
		    }
		    else{
		        valList.add(tmp);
		        tmp=0;
		        opList.add(c);
		    }
		}
		valList.add(tmp);
		int sum = valList.get(0);
		boolean flag=false;
		for(int i=0; i<opList.size(); i++){
		    if(opList.get(i)=='-'){
		        if(!flag) flag = true;
		        sum-=valList.get(i+1);
		        
		    }
		    else{
		        if(flag) sum-=valList.get(i+1);
		        else sum+=valList.get(i+1);
		    }
		}
		bw.write(sum+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

}

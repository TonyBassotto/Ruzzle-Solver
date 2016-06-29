package model;

import java.util.HashMap;
import java.util.Map;

public class chek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,boolean[][]>ex=new HashMap<String,boolean[][]>();
		boolean[][]x=new boolean[2][2];
		x[0][0]=false;
		x[0][1]=true;
		x[1][0]=false;
		x[1][1]=false;
		String s="tony";
		ex.put(s,x);
		System.out.println(s);
		for(int i=0;i<4;i++){
			System.out.println(ex.get(s)[i/2][i%2]);
		}
	}

}

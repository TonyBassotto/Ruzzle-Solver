package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import dao.daodb;

public class mainx {
	List<String>paroleesistenti;
	Map<String,boolean[][]>parolesoluzione=new HashMap<String,boolean[][]>();
	Map<String,boolean[][]>parolesoluzioneX=new HashMap<String,boolean[][]>();

	List<String>paroleperController;

	boolean trye[][]=new boolean[4][4];
	Random r = new Random();
	daodb db=new daodb();
	
	public void aggiungielenco(){
		if(paroleesistenti==null){
		paroleesistenti=new ArrayList<String>(db.dizionario());
		}
	}
	public List<String>lista(){
		return paroleesistenti;
	}
	public List<String>listacontroller(){
		return paroleperController;
	}
	
	public Map<String,boolean[][]>mappa(){
		return parolesoluzione;
	}
	public Map<String,boolean[][]>mappaX(){
		return parolesoluzioneX;
	}
	
	
	int x[][]=new int[4][4];
	String[][] ruzzle=new String[4][4];
	public void starte(){
		for(int i=0;i<16;i++){
			x[i/4][i%4]=2;
		}
		for(int i=0;i<16;i++){
			trye[i/4][i%4]=false;
		}
		for(int i=0;i<16;i++){
			String consonanti="QWRTYPSDFGHJKLZXCVBNM";
			String vocali="AEIOU";
			int casul=r.nextInt(3);
			String c;
				if(casul>0){
					c = (consonanti.charAt(r.nextInt(consonanti.length())))+"";
				}
				else{
					c = (vocali.charAt(r.nextInt(vocali.length())))+"";
				}
			
			ruzzle[i/4][i%4]=c;
		}
	}
	
	//--------------------------------------------------------
	//--------------------------------------------------------
	public void er(int level,String[][] esit,boolean trye[][],String result,int temp,Map<String,boolean[][]>mappa){
		//if()
		
		//if(level==16){
		//	return;
		//}
		result+=esit[temp/4][temp%4];
		trye[temp/4][temp%4]=true;
		//System.out.println(result);
		boolean continux=false;
		for(String s:this.lista()){
			if(s.startsWith(result.toLowerCase())){
				//System.out.println(s);
				continux=true;
				break;
			}	
		}
		if(continux==false){
			trye[temp/4][temp%4]=false;
			return;
		}
		if(paroleesistenti.contains(result.toLowerCase()) && !mappa().containsKey(result) && result.length()>2){
			System.out.println("Parola esistente : "+result);
			boolean[][] poser=new boolean[4][4];
			poser=trye;
			mappa().put(result,poser);
			for(int i=0;i<16;i++){
				if(i%4==0 && i!=0){
					System.out.println("");
				}
				System.out.print(mappa().get(result)[i/4][i%4]+"\t");
			}
			System.out.println("");
			boolean [][]xmpaer=new boolean[4][4];
			for(int i=0;i<16;i++){
				xmpaer[i/4][i%4]=poser[i/4][i%4];
			}
			parolesoluzioneX.put(result, xmpaer);
		}
		
		
		for(int i=0;i<16;i++){
			int check_x=Math.abs(temp/4-(i/4));
			int check_y=Math.abs(temp%4-(i%4));
			boolean b = (check_x==1 && check_y==0) || (check_x==0 && check_y==1) || (check_x==1 && check_y==1);

			if(trye[i/4][i%4]==false && b==true){

				er(level,esit,trye,result ,i,mappa());
				
			}
		}
		trye[temp/4][temp%4]=false;
		result.substring(0,result.length()-1);

	}
	public int[][] get(){
		return x;
	}
	public boolean[][] getx(){
		return trye;
	}
	public String[][] getruzzle(){
		return ruzzle;
	}
	public void EXE(){
		//paroleesistenti=new ArrayList<String>();
		parolesoluzione=new HashMap<String,boolean[][]>();
		parolesoluzioneX=new HashMap<String,boolean[][]>();
		if(paroleperController!=null)
			paroleperController=null;
		boolean trye[][]=new boolean[4][4];
		ruzzle=new String[4][4];

		starte();
		aggiungielenco();
		for(int level=0;level<1;level++){
			System.out.println("\nParto in casella "+level/4+"_"+level%4+"\n\n");
			er(0, ruzzle, trye, "", level,mappa());
		}
		paroleperController=new LinkedList<String>(mappaX().keySet());
		Collections.sort(paroleperController,new inversComparator<String>());
		System.out.println("NJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJJJJNJNJNNJNJJJNJNJNJNJNJNJNJNJN");
		int xx=1;
		for(String s:paroleperController){
			System.out.println(xx+"  "+s);
			xx++;
			for(int i=0;i<16;i++){
				if(i%4==0 && i!=0){
					System.out.println("");
				}
				boolean rex=mappaX().get(s)[i/4][i%4];
				System.out.print(rex+"\t");
				
			}
			System.out.println("");
		}
	}
	
	//--------------------------------------------------------
	//--------------------------------------------------------
	public static void main (String[] args){
	
		
		
	}
}

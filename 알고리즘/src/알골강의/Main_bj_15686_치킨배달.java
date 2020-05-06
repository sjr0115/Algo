package 알골강의;

import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달{
	public static int N,M,min=987654321;
	public static List<int[]> home,chicken,choice;
	 	 
	public static void comb(int start,int cnt){
	    if(cnt==M){
	    	int sum=0;
		    for(int i=0; i<choice.size(); i++){
		    	int dist=987654321;
		        for(int j=0; j<home.size(); j++){
		            dist=Math.min(dist,Math.abs(choice.get(i)[0]-home.get(j)[0])+
		            		           Math.abs(choice.get(i)[1]-home.get(j)[1]));
		        }
		        sum+=dist;
		    }
		    min=Math.min(min,sum);
	        return;
	    }
	    for(int i=start; i<chicken.size(); i++){
	        choice.add(chicken.get(i));
	        comb(i+1,cnt+1);
	        choice.remove(choice.size()-1);
	    }
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_15686.txt"));
		Scanner sc=new Scanner(System.in);
		home=new ArrayList<int[]>();
		chicken=new ArrayList<int[]>();
		choice=new ArrayList<int[]>();
	    N=sc.nextInt();//도시크기,2<=N<=50
	    M=sc.nextInt();//치킨집선택최대값,1<=M<=13
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            int a=sc.nextInt();//0:빈집,1:집,2:치킨집
	            if(a==1) home.add(new int[]{i,j});
	            else if(a==2) chicken.add(new int[]{i,j});
	        }
	    }
	    comb(0,0);
	    System.out.println(min);
	    sc.close();
	}
}
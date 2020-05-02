package 알골강의;

import java.io.*;
import java.util.*;

public class Solution_d9_1949_등산로조성 {   
	static int[] di={-1,1,0,0};//상하좌우
	static int[] dj={0,0,-1,1};
	static int N,K,max;
    static int[][] map;
    static boolean[][] visit;
 
    public static void dfs(int i,int j,int cnt,boolean used){ 
    	max=Math.max(max,cnt);//가장 긴 등산로 갱신 
        visit[i][j]=true; 
        for(int d=0; d<4; d++){ 
            int ni=i+di[d];
            int nj=j+dj[d]; 
            if(0<=ni&&ni<N && 0<=nj&&nj<N && !visit[ni][nj]){
                if(map[ni][nj]<map[i][j]){//범위 안에 내르막길
                    dfs(ni,nj,cnt+1,used);
                }else{
                    if(!used){//깎지 안았다면
                        for(int k=1; k<=K; k++){//최대공사 가능깊이  1<=K<=5만큼 깍는 작업
                            if(map[ni][nj]-k<map[i][j]){
                                map[ni][nj]-=k;
                                dfs(ni,nj,cnt+1,true);
                                map[ni][nj]+=k;
                            }
                        }
                    }
                }
            }
        }
        visit[i][j]=false;
    } 
    public static void main(String[] args) throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine()); 
        
        for(int tc=1; tc<=T; tc++){ 
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());//지도크기 3<=N<=8
            K=Integer.parseInt(st.nextToken());//최대공사 가능깊이  1<=K<=5
            map=new int[N][N];
            visit=new boolean[N][N]; 
            int high=0;
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine()," ");
                for(int j=0; j<N; j++){
                    map[i][j]=Integer.parseInt(st.nextToken());//1<=지형의높이<=20
                    high=Math.max(high,map[i][j]);//가장높은 봉우리는 최대 5개
                }
            } 
            max=-1;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==high) dfs(i,j,1,false);
                }
            } 
            sb.append("#"+tc+" "+max+"\n");
        }
        System.out.print(sb); 
        br.close();
    } 
}
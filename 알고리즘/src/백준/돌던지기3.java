package 백준;

import java.io.*;
import java.util.StringTokenizer;
 
public class 돌던지기3 {
    
    static int T;
    static int N;
    static int H[] = new int[100000];
    static int R, C;
    static char map[][] = new char[30000][31];
    static Quick quick[] = new Quick[30];
 
    // 빠른 접근을 위한 class 배열
    static class Quick {
        int col[]; // col[r] 하면 r번째행은 몇번째 열에 있는가 반환
        int r; // 장애물의 위치
 
        public Quick() {
            super();
            this.col = new int[30000];
            this.r = 1;
        }
 
        public void insert() {
            map[r - 1][col[r - 1]] = 'O';
        }
 
        public void trim() {
            while(true) {
                // 장애물 바로위를 가리킨다.
                int cur = col[r-1];
                
                // 만약 그지점이 빈공간이 아니라면 insert한 직후
                // 위로 거슬러 올라가면서 빠른접근하도록 갱신한다.
                if(r >1 && map[r-1][cur] != '.'){
                    r--;
                }
                // 타겟 위치가 맨밑이라는건 갱신할때까지 갓다는것
                else if(r == R)
                    break;
                // X도 갱신할만큼 갱신한것.
                else if(map[r][cur] == 'X')
                    break;
                else if(map[r][cur] == '.')
                    col[r++] = cur;
                else {
                    // 좌
                    if(cur>0 && map[r][cur-1] == '.' && map[r-1][cur-1]=='.') 
                        col[r++] = cur-1;
                    // 우
                    else if( cur+1<C && map[r][cur+1]=='.' && map[r-1][cur+1]=='.')
                        col[r++] = cur+1;
                    // 둘다아니면 갱신끝
                    else 
                        break;
                    
                }
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();
 
        for (int j = 0; j < C; j++) {
            // 배열을 만들고 j의 위치에서 타겟위치 r의 위치를 갱신해준다.
            quick[j] = new Quick();
            quick[j].col[0] = j;
            quick[j].trim();
        }
 
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(br.readLine()) - 1;
        }
        
        for( int i=0;i<N;i++) {
            quick[H[i]].insert();
            for(int j=0;j<C;j++)
                quick[j].trim();
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
 
    }
 
}
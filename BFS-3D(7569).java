import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h;
    static int[][][] grid;
    static int[][][] day;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        grid = new int[h][n][m];
        day = new int[h][n][m];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
            	for(int k = 0; k < m; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                    if(grid[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k});
                    }
            	}
            }
        }        
        bfs(queue);
        int totalDay = -1;
        for(int k = 0; k < h; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(grid[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    totalDay = Math.max(totalDay, day[k][i][j]);
                }
            }  
        } 
        System.out.println(totalDay);
        br.close();
    }
    
    public static void bfs(Queue<int[]> queue) {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];
            int curZ = curr[2];
            
            
            for(int i = 0; i < 6; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextZ = curZ + dz[i];
                int nextDay = day[curX][curY][curZ] + 1;
                
                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= n || nextZ < 0 || nextZ >= m) {
                    continue;
                }
                
                if(grid[nextX][nextY][nextZ] == 0) {
                    queue.offer(new int[] {nextX, nextY, nextZ});
                    grid[nextX][nextY][nextZ] = 1;
                    day[nextX][nextY][nextZ] = nextDay;
                }
            }
        }
    }
}

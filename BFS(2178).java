import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];
        distance[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < m; j++) {
        		grid[i][j] = line.charAt(j) - '0';
        	}
        }
        
        bfs(0, 0);
        
        System.out.println(distance[n - 1][m - 1]);
        
        br.close();
    }
    
    public static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<>();
    	queue.offer(new int[] {x, y});
    	visited[x][y] = true;
    	
    	while(!queue.isEmpty()) {
    		int[] curr = queue.poll();
    		int curX = curr[0];
    		int curY = curr[1];
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = curX + dx[i];
    			int nextY = curY + dy[i];
    			int nextDis = distance[curX][curY] + 1;
    			
    			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
    				continue;
    			}
    			
    			if(!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
    				queue.offer(new int[] {nextX, nextY});
    				visited[nextX][nextY] = true;
    				distance[nextX][nextY] = nextDis;
    			}
    		}
    	}
    	
    }
}

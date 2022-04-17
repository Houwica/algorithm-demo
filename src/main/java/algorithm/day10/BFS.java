package algorithm.day10;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n =  grid[0].length;
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if (grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        if (queue.isEmpty()){
            return -1;
        }


        if (queue.size() == m*n || cnt == 0){
            return 0;
        }

        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];
                for (int[] move : moves) {
                    int r2 = r + move[0];
                    int c2 = c + move[1];
                    if (inArea(r2, c2, grid) && grid[r2][c2] == 1){
                        queue.add(new int[]{r2, c2});
                        grid[r2][c2] = 2;
                        cnt--;
                    }
                }
                size--;
            }
            res++;
        }

        return cnt == 0 ? res : -1;

    }


    private static boolean inArea(int r, int c, int[][] grid){

        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;

    }

    public static void main(String[] args) {
        int[][] grid = {{0,2}};


        Integer a = 0, b= 0, c= 0;



        System.out.println(orangesRotting(grid));
    }
}

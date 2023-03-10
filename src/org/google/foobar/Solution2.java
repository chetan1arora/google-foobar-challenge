package org.google.foobar;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public static int solution(int src, int dest) {
        int srcRow = src / 8; // row index of source square
        int srcCol = src % 8; // column index of source square
        int destRow = dest / 8; // row index of destination square
        int destCol = dest % 8; // column index of destination square

        // Possible moves a knight can make
        int[][] moves = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];

        // Add source square to the queue and mark as visited
        queue.offer(new int[]{srcRow, srcCol, 0});
        visited[srcRow][srcCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if (row == destRow && col == destCol) {
                // Destination square reached, return the distance
                return dist;
            }

            for (int[] move : moves) {
                int nextRow = row + move[0];
                int nextCol = col + move[1];

                // Check if the next move is valid and not visited yet
                if (nextRow >= 0 && nextRow < 8 &&
                        nextCol >= 0 && nextCol < 8 &&
                        !visited[nextRow][nextCol]) {

                    queue.offer(new int[]{nextRow, nextCol, dist + 1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        // Destination square not reachable
        return -1;
    }

    public static void main(String[] args){
        System.out.println(Solution2.solution(19,36));
        System.out.println(Solution2.solution(0,1));
    }
}
package com.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BestPath {

    public static int findBestPath(String S, String[] strGrid) {
        char[][] grid = convertGrid(strGrid);

        char[] chars = S.toCharArray();
        int distance = 0;
        try {
            int[] fromLocation = findLocation(grid, chars[0]);
            for (int i = 0; i < chars.length - 1; i++) {
                int[] result = findClosestChar(grid, fromLocation, chars[i + 1]);
                distance += result[2];
                fromLocation = new int[] { result[0], result[1] };
                // System.out.println(chars[i + 1] + ", " + Arrays.toString(result));
            }
        } catch (Exception e) {
            return -1;
        }
        return distance;
    }

    public static char[][] convertGrid(String[] strGrid) {
        int rows = strGrid.length, cols = strGrid[0].length();
        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = strGrid[r].charAt(c);
            }
        }
        return grid;
    }

    public static int[] findLocation(char[][] grid, char targetChar) throws Exception {
        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == targetChar) {
                    return new int[] { r, c };
                }
            }
        }
        throw new Exception("NotFound");
    }

    /**
     * @param grid
     * @param fromLocation
     * @param targetChar
     * @return [row, col, distance]
     */
    public static int[] findClosestChar(char[][] grid, int[] fromLocation, char targetChar) throws Exception {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // Right, Down, Left, Up
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int fr = fromLocation[0], fc = fromLocation[1];

        queue.offer(new int[] { fr, fc, 0 });
        visited.add(fr + "," + fc);

        int a = 1;
        // BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            System.out.println(a++ + " " + Arrays.toString(current));
            int r = current[0], c = current[1], distance = current[2];

            // If 'B' is found, return the distance
            if (grid[r][c] == targetChar) {
                return new int[] { r, c, distance };
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited.contains(nr + "," + nc)) {
                    queue.offer(new int[] { nr, nc, distance + 1 });
                    visited.add(nr + "," + nc);
                }
            }
        }

        throw new Exception("NotFound");
    }

    public static void main(String[] args) {
        String[] grid = {
                "K....", "S...L", "....R", "LX...", "XM..S"
        };

        System.out.println(findBestPath("KLLRML", grid));
    }
}

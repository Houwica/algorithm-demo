package algorithm.day4;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static int[][] Intersection(int[][] firstList, int[][] secondList) {
        int[][] res = new int[0][0];

        if (firstList.length == 0 || secondList.length == 0) {
            return res;
        }


        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            if (!(firstList[i][0] > secondList[j][1] || firstList[i][1] < secondList[j][0])) {
                // 存在交集才行
                int lo = Math.max(firstList[i][0], secondList[j][0]);
                int hi = Math.min(firstList[i][1], secondList[j][1]);

                list.add(new int[]{lo, hi});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);

    }

    public static int maxArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }


        int left = 0, right = height.length - 1, res = 0;
        while (right > left) {
            if (height[left] < height[right]) {
                left++;

                res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int[][] s = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};

        int[][] t = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] res = Intersection(s, t);

//        System.out.println(Intersection(s, t));
        printArray(res);


    }

    public static void printArray(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.println(input[i][j]);
            }
        }

    }

}

package array;

/**
 * 1 -> 2 -> 3 ⬇️ 4 ⬇️ 5 <- 6 <- 7 ⬆️ 8 ->9
 */

public class generateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //startX & startY position
        int x = 0;
        int y = 0;
        //循环次数为n的一半
        int loop = n / 2;
        //循环次数位奇数，处理中间的值
        int mid = n / 2;

        //画笔
        int count = 1;
        //每一圈循环，需要控制每一条边遍历长度
        int offset = 1;

        int i = 0;
        int j = 0;

        //开始
        while (loop > 0) {
            i = x;
            j = y;
            //转圈 l->r
            for (; j < y + n -offset; j++) {
                res[x][j] = count++;
            }
            //u->d
            for (; i < x + n -offset; i++) {
                res[i][j] = count++;
            }
            //r -> l
            for (; j > y; j--) {
                res[i][j] = count++;
            }


            //d -> u
            for (; i > x; i--) {
                res[i][j] = count++;
            }
            //第二圈开始。起始位置+1 比如[0][0] [1][1]
            x++;
            y++;
            //控制每一圈里面每一条遍历的长度
            offset += 2;
            loop --;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;

    }
}

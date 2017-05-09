package cn.iqhighest.test.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * Created by Steven on 2017-05-09.
 */
public class HanoiTower {
    int i = 1;

    private void move(int n, int from, int to) {
        System.out.println(MessageFormat.format("第{0}步：将第‘{1}’号盘子{2}--->{3}", i++, n, from, to));
    }

    private void hanoi(int n, int from, int dependOn, int to) {
        if (n == 1) {
            move(n, from, to);
        } else {
            hanoi(n - 1, from, to, dependOn);
            move(n, from, to);
            hanoi(n - 1, dependOn, from, to);
        }
    }

    public static void main(String[] args) {
        HanoiTower tower = new HanoiTower();
        System.out.println("请输入盘子数量：");
        int n = 1;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(reader.readLine());
            System.out.println("输入的盘子数量："+ n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tower.hanoi(n, 1, 2, 3);
    }
}

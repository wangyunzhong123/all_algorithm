package wyz;

/**
 * Created by tianxi on 4/18/17.
 */

/*
* 动态规划的基本思想是将待求解问题分解成若干个子问题，先求解子问题，并将这些子问题的解保存起来，如果以后在求解较大子问题的时候需要用到这些子问题的解，就可以直接取出这些已经计算过的解而免去重复运算。保存子问题的解可以使用填表方式，例如保存在数组中。
用一个实际例子来体现动态规划的算法思想——硬币找零问题。
硬币找零问题描述：现存在一堆面值为 V1、V2、V3 … 个单位的硬币，问最少需要多少个硬币才能找出总值为 T 个单位的零钱？假设这一堆面值分别为 1、2、5、21、25 元，需要找出总值 T 为 63 元的零钱。
很明显，只要拿出 3 个 21 元的硬币就凑够了 63 元了。
基于上述动态规划的思想，我们可以从 1 元开始计算出最少需要几个硬币，然后再求 2 元、3元…每一次求得的结果都保存在一个数组中，以后需要用到时则直接取出即可。那么我们什么时候需要这些子问题的解呢？如何体现出由子问题的解得到较大问题的解呢？
其实，在我们从 1 元开始依次找零时，可以尝试一下当前要找零的面值（这里指 1 元）是否能够被分解成另一个已求解的面值的找零需要的硬币个数再加上这一堆硬币中的某个面值之和，如果这样分解之后最终的硬币数是最少的，那么问题就得到答案了。
单是上面的文字描述太抽象，先假定以下变量：
values[] : 保存每一种硬币的币值的数组
valueKinds :币值不同的硬币种类数量，即values[]数组的大小
money : 需要找零的面值
coinsUsed[] : 保存面值为 i 的纸币找零所需的最小硬币数
算法描述：
当求解总面值为 i 的找零最少硬币数 coinsUsed[ i ] 时，将其分解成求解 coinsUsed[ i – cents]和一个面值为 cents 元的硬币，
由于 i – cents < i ， 其解 coinsUsed[ i – cents] 已经存在，如果面值为 cents 的硬币满足题意，
那么最终解 coinsUsed[ i ] 则等于 coinsUsed[ i – cents] 再加上 1（即面值为 cents）的这一个硬币。
* */

public class Money_DP {

    /**
     * 硬币找零：动态规划算法
     *
     * @param values
     *            :保存每一种硬币的币值的数组
     * @param valueKinds
     *            :币值不同的硬币种类数量，即coinValue[]数组的大小
     * @param money
     *            :需要找零的面值
     * @param coinsUsed
     *            :保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        // 对每一分钱都找零，即保存子问题的解以备用，即填表
        for (int cents = 1; cents <= money; cents++) {

            // 当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;

            // 遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                // 若当前面值的硬币小于当前的cents则分解问题并查表
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            // 保存最小硬币数
            coinsUsed[cents] = minCoins;

            System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
                    + coinsUsed[cents]);
        }
    }

    public static void main(String[] args) {

        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
        // 需要找零的面值
        int money = 63;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];

        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }

}

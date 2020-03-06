package classicAlgorithm;

import java.util.Arrays;

//public class RadixSort {
//    public int[] sort(int[] sourceArray){
//             // 对 arr 进行拷贝，不改变参数内容
//        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//        int maxDigit = getMaxDigit(arr);
//        return radixSort(arr, maxDigit);
//    }
//
////          /**
////     * 获取最高位数
////     */
//    private int getMaxDigit(int[] arr) {
//        int maxValue = getMaxValue(arr);
//        return getNumLenght(maxValue);
//    }
//
//    private int getMaxValue(int[] arr) {
//        int maxValue = arr[0];
//        for (int value : arr) {
//            if (maxValue < value) {
//                maxValue = value;
//            }
//        }
//        return maxValue;
//    }
//
//    protected int getNumLenght(long num) {
//        if (num == 0) {
//            return 1;
//        }
//        int lenght = 0;
//        for (long temp = num; temp != 0; temp /= 10) {
//            lenght++;
//        }
//        return lenght;
//    }
//
//    private int[] radixSort(int[] arr, int maxDigit) {
//        int mod = 10;
//        int dev = 1;
//        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
//            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
//            int[][] counter = new int[mod * 2][0];
//            for (int j = 0; j < arr.length; j++) {
//                int bucket = ((arr[j] % mod) / dev) + mod;
//                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
//            }
//
//            int pos = 0;
//            for (int[] bucket : counter) {
//                for (int value : bucket) {
//                    arr[pos++] = value;
//                }
//            }
//        }
//
//        return arr;
//    }
//    private int[] arrayAppend(int[] arr, int value) {
//        arr = Arrays.copyOf(arr, arr.length + 1);
//        arr[arr.length - 1] = value;
//        return arr;
//    }
//
//    public static void main(String[] args) {
//        int[] array = {321, 1, 10, 60, 577, 743, 127};
//        int[] result = new RadixSort().sort(array);
//        System.out.println(Arrays.toString(result));
//    }
//}
/**
 * 基数排序：Java
 *
 * @author skywang
 * @date 2014/03/15
 */

public class RadixSort {

    /*
     * 获取数组a中最大值
     *
     * 参数说明：
     *     a -- 数组
     *     n -- 数组长度
     */
    private static int getMax(int[] a) {
        int max;

        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];

        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private static void countSort(int[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++)
            buckets[ (a[i]/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中，Crazy
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++)
            a[i] = output[i];

        output = null;
        buckets = null;
    }

    /*
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
    public static void radixSort(int[] a) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort(a, exp);
    }

    public static void main(String[] args) {
        int i;
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        radixSort(a);    // 基数排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}

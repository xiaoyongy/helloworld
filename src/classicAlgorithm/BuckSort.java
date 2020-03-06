package classicAlgorithm;

import java.util.Arrays;


public class BuckSort {
//    private static final InsertSort insertSort = new InsertSort();
    public int[] sort(int[] sourceArray){
             // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return bucketSort(arr, 5);
    }
//    bucketSize为桶的大小
    private int[] bucketSort(int[] arr, int bucketSize){
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
//bucketCount为桶的个数
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = InsertSort.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

      /*自动扩容，并保存数据

      @param arr
      @param value*/
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args){
        int[] array = {7,12,56,23,19,33,35,42,42,2,8,22,39,26,17};
        int[] result = new BuckSort().sort(array);
        System.out.println(Arrays.toString(result));
    }
}

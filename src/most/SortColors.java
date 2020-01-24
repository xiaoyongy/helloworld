package most;

public class SortColors {
    //非原地进行排序
    public int[] NotArrangeArray(int[] array){
        int len = array.length;
        int[] result = new int[len];
        int count=0,countZero=0;
        int countTwo = len-1;
        for (int value : array) {
            if(count<=countTwo){
                result[count++]=1;
            }
            if (value == 0) {
                result[countZero++] = 0;
            } else if (value == 2) {
                result[countTwo--] = 2;
            }
        }
        /*for(;countZero<=countTwo;){
            result[countZero++] = 1;
        }*/
        return result;
    }
    //原地对只有三个数的数组进行排序
    public static void ArrangeArray(int[] array){
        int len = array.length;
        int countZero = 0;
        int countTwo = len-1;
        for(int i=0;i<=countTwo;){
            int temp;
            if(array[i]==0){
                temp = array[countZero];
                array[countZero++]=0;
                array[i++]=temp;
            }else if (array[i]==2){
                temp = array[countTwo];
                array[countTwo--]=2;
                array[i]=temp;
            }else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] str = {2,0,2,1,1,0,1,2,0};
        SortColors.ArrangeArray(str);
        for(int value:str){
            System.out.println(value);
        }
    }
}

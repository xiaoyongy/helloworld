package most;

public class NumberAppearOnce {
    /*public int[] DoubleNumbers(int[] array){
        int[] doublenNumer = new int[2];
        int doubleSum = array[0];
        for (int i=1;i<array.length;i++){
            doubleSum ^= array[i];
        }
        String binary = Integer.toBinaryString(doubleSum);
        int binaryLength = binary.length();
        int count = 0;
        while (binaryLength-->0){
            if (binary.charAt(binaryLength)==1) break;
            count++;
        }
        for (int i=0;i<array.length;i++){
            if (((array[i]>>count)&1)==1){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=0;i<array.length;i++){
            String temp = Integer.toBinaryString(array[i]);
            int index = temp.length()-count;
            if (index<0){
                list2.add(array[i]);
                continue;
            }
            if (temp.charAt(index)==1){
                list1.add(array[i]);
            }else {
                list2.add(array[i]);
            }
        }
        int result1 = list1.get(0);
        int result2 = list2.get(0);
        for (int i=1;i<list1.size();i++){
            result1 ^= list1.get(i);
        }
        for (int i=1;i<list2.size();i++){
            result2 ^= list2.get(i);
        }
        doublenNumer[0] = result1;
        doublenNumer[1] = result2;
        return doublenNumer;
    }*/
    public void DoubleNumbers(int[] array, int num1[], int num2[]){
        if(array==null || array.length<2)
            return;
        int resultExclusiveOR=0;
        for(int i=0;i<array.length;i++)
            resultExclusiveOR^=array[i];

        int indexOf1=0;
        while(((resultExclusiveOR&1)==0) && (indexOf1<=4*8)){
            resultExclusiveOR=resultExclusiveOR>>1;  //只有n>>1不完整，要n=n>>1
            indexOf1++;
        }

        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if(((array[i]>>indexOf1)&1)==1)
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,2,1,3,5};
        int[] num1={0},num2={0};
        new NumberAppearOnce().DoubleNumbers(array, num1, num2);
        System.out.println(num1[0]+","+num2[0]);
    }
}

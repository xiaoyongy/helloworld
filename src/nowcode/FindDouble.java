package nowcode;

public class FindDouble {
    public boolean Find(int target, int [][] array) {
        int row = array.length, col = array[0].length;
        for(int i=row-1,j = 0;i>=0&&j<col;){
            if(array[i][j]>target){
                i--;
            }else if(array[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean flash = new FindDouble().Find(5, array);
        System.out.println(flash);
    }
}

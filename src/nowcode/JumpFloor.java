package nowcode;

public class JumpFloor {
    public int jumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        //return JumpFloor(target-1)+JumpFloor(target-2);
        int floor = 0, one = 1, two = 2;
        for(int i=3;i<=target;i++){
            floor = one+two;
            one = two;
            two = floor;
        }
        return floor;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloor(4));
    }
}

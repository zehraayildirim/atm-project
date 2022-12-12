import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion {

    /*
    int arr[] = {3, 5, 1, 2, 7, 9, 2, 3, 5, 7};
    By using array create a method which returns the following list
                [3, 5+1, 2+7+9, 2+3+5+7] ==> [3, 6, 18, 17]
    */

    public static void main(String[] args) {
        int arr[] = {3, 5, 1, 2, 7, 9, 2, 3, 5, 7};
        addArrEl(arr);
    }

    public static void addArrEl(int arr[]){
        List<Integer> list = new ArrayList<Integer>();
        int n = 0;
        while(n<arr.length) {
            int startingIdx = n * (n + 1) / 2;
            int endingIdx = (n + 1) * (n + 2) / 2;

            int sum = 0;

            if(endingIdx> arr.length){
                break;
            }
            while(startingIdx<endingIdx){
                sum = sum + arr[startingIdx];
                startingIdx++;
            }
            list.add(sum);
            n++;
        }
        System.out.println(list);
    }
}

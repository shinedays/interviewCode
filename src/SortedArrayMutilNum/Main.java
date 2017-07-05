package SortedArrayMutilNum;

/**
 * Created by bupt on 4/26/17.
 */
public class Main {

    /*
    public int solution(int[] array, int aim) {
        int high = array.length - 1;
        int low = 0;
    }
    */

    public int binarySearch(int[] array, int low, int high, int aim) {
        int middle = (low + high) >> 1;
        int res = 0;
        if (array[middle] == aim)
            res = middle;
        else if (array[middle] > aim)
            binarySearch(array, low, middle - 1, aim);
        else {
            binarySearch(array, middle + 1, high, aim);
        }
        return res;
    }

    public int binarySearch2(int[] array, int low, int high, int aim){
        if(low > high || aim > array[high] || aim < array[low])
            return -1;
        while(low < high){
            int middle = (low + high) >> 1;
            if(aim > array[middle]){
                low = middle + 1;
            } else if(aim < array[middle]) {
                high = middle - 1;
            } else
                return middle;

        }
        return -1;
    }



    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        Main m = new Main();
        int high = array.length - 1;
        System.out.println(m.binarySearch(array,0,high,5));
        System.out.println(m.binarySearch2(array,0,high,5));
    }
}

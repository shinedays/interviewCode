package Sort;

/**
 * Created by bupt on 6/27/17.
 */
public class HeapSort {
    public static void adjustMInHeap(int[] array, int parent, int len){
        int temp;
        int child;
        for(temp = array[parent]; 2* parent + 1 <= len; parent = child){
            child = 2 * parent + 1;
            if(child <  len && array[child] < array[child + 1]){
                child ++;
            }
            if(array[child] > temp)
                array[parent] = array[child];
            else
                break;
        }
        array[parent] = temp;
    }

    public static void heapSort(int[] array){
        int len = array.length;
        for(int i = len / 2;i >= 0; i--){
            adjustMInHeap(array,i,len - 1);
        }
        for(int i = len -1;i >= 0; i--){
            int temp  = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustMInHeap(array,0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {6,5,4,9,8,7,6,0,1,3,2};
        heapSort(array);
        for(int num : array)
            System.out.println(num);
    }
}

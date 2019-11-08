import java.util.Arrays;

public class BinaryHeap {
    private int[] array;
    private int size;
    public BinaryHeap () {
        array = new int[10];
        size = 0;
    }
    public int left (int index){
        return (index * 2) + 1;
    }
    public int right(int index){
        return (index * 2) + 2;
    }
    public int parent (int index){
            return (index - 1)/2;
    }
    public void swap(int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    public int[] doubleSize(int[] arr){
        return Arrays.copyOf (arr, arr.length * 2);
    }
    public int remove()  {
        if(size==0){
           return 0;
        }
        if(size == 1){
            size--;
            return array[0];
        }
        int root = array[0];
        array[0] = array[size-1];
        size--;
        sorter(0);
        return root;
    }

    public void add(int element) {
        if(size == array.length - 1 || size > array.length-1){ array=doubleSize(array);}
        int index = size;
        size++;
        //System.out.println("my Size: " + size + " vs capacity: " + array.length);

        array[index] = element;
//        System.out.println("index-1/2: " + parent(index));
//        System.out.println("index " + index);
//        System.out.println(" Parent index " + array[parent(index)]);
//        System.out.println("Array[index] " + array[index]);
//        System.out.println();

        while(index != 0 && array[parent(index)] > array[index]){
//            System.out.println("Swap x: " + array[index] + " vs Swap y: " + array[parent(index)] );
            swap(index, parent(index));
         //   System.out.println("Swap x: " + array[index] + " vs Swap y: " + array[parent(index)] );
            index = parent(index);
        }
    }

    public void sorter(int root){
        int left = left(root);
        int right = right(root);
        int parent = root;

        if(left < size && array[left] < array[root]){
            parent = left;
        }
        if(right < size && array[right] < array[parent]){
            parent = right;
        }
        if(parent != root){
            swap(root, parent);
            sorter(parent);
        }
    }


    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }


}

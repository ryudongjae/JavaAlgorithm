package algorithm.selectionSort;

public class Selection_sort2 {

    public void sort(int []a){
        int size = a.length;
        int temp;
        int min;

        for(int i=0; i<size -1; i++){
            min =i;
            for (int j = i+1; j<size; j++){
                if(a[min]>a[j]){
                    min = j;
                }

            }
            temp  = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        Selection_sort2 s = new Selection_sort2();
        int a[] = {4,7,2,3,1,6,5};
        s.sort(a);

        for (int i = 0; i<a.length; i++){
            System.out.print(" " +a[i]);
        }
    }
}

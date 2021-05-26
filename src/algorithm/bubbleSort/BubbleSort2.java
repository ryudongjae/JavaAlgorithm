package algorithm.bubbleSort;

public class BubbleSort2 {

    public void sort(int [] data){
        int temp = 0;
        for (int i =data.length -1; i>=0; i--){
            for (int j = 0; j<i; j++){
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
            BubbleSort2 b = new BubbleSort2();
            int []data = {3,5,4,6,8,7};

            b.sort(data);

            for(int i = 0; i<data.length; i++){
                System.out.println(data[i] + " ");
            }

    }
}

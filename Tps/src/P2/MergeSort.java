package P2;

public class MergeSort {
    private int[] numbers;
    private int[] aux;

    public void Sort (int[] values) {
        this.numbers = values;
        this.aux = new int[values.length];
        this.mergeSort(0, values.length - 1);
    }

    private void mergeSort (int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;

            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }





    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = numbers[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (aux[ i ] <= aux[ j ]) {
                numbers[ k ] = aux[ i ];
                i++;
            } else {
                numbers[ k ] = aux[ j ];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[ k ] = aux[ i ];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[ k ] = aux[ j ];
            k++;
            j++;
        }
    }

}

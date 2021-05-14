package P2;

public class QuickSort {

    public void sort (int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        quickSort(numbers, low, high);
    }

    private void quickSort (int[] numbers, int low, int high) {
        if (low < high) {
            int partition = partition(numbers, low, high);
            quickSort(numbers, low, partition - 1);
            quickSort(numbers, partition + 1, high);
        }
    }

    private int partition (int[] numbers, int low, int high) {
        int pivot = numbers[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, i + 1, high);
        return i + 1;
    }

    private void swap (int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

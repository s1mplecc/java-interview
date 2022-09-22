package sort;

public class QuickSort {
    public int[] quickSort(int[] seq, int low, int high) {
        if (high <= low)
            return seq;

        int pivot = seq[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && seq[j] >= pivot)
                j--;
            swap(seq, i, j);
            while (i < j && seq[i] <= pivot)
                i++;
            swap(seq, i, j);
        }

        quickSort(seq, low, i - 1);
        quickSort(seq, i + 1, high);
        return seq;
    }

    private void swap(int[] seq, int i, int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}


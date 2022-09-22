package sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    public void should_sort_by_quick_sort() {
        QuickSort sort = new QuickSort();
        int[] seq = {2, 21, 4, 7, 32, 8, 5};
        int[] result = sort.quickSort(seq, 0, seq.length - 1);

        assertThat(result).containsExactly(2, 4, 5, 7, 8, 21, 32);
    }
}
package sortAlgorithmns;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] numbers = {10, 30, 2, 7, 100, 28, 11, 1 , 56, 4, 2, 12};
        int[] numbersDuplicate = Arrays.copyOf(numbers, numbers.length);

        int[] bubbleNumbers = Sorts.bubbleSort(numbers);
        int[] selectionNumbers = Sorts.selectionSort(numbers);
        int[] insertSortNumbers = Sorts.insertionSort(numbers);
        int[] quickSortNumbers = Sorts.quickSort(numbers, 0,
                                numbers.length -1);
        int[] mergeSortNumbers = Sorts.mergeSort(numbers, 0,
                numbers.length -1);

        System.out.println("Numbers before sorting: "
                +Arrays.toString(numbersDuplicate));

        System.out.println();

        System.out.println("Bubble-Sorted: "+Arrays.toString(bubbleNumbers));
        System.out.println("Selection-Sorted: "+
                        Arrays.toString(selectionNumbers));
        System.out.println("Insertion-Sorted: "+
                        Arrays.toString(insertSortNumbers));
        System.out.println("Quick-Sorted: "+
                Arrays.toString(quickSortNumbers));
        System.out.println("Merge-Sorted: "+
                Arrays.toString(mergeSortNumbers));
    }
}

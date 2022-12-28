package sortAlgorithmns;


/**This class represents a class that contains sorting algorithms. Most of
 * the parameters are in a linear data structure - arrays. This is because
 * elements of arrays can be converted into list view, using Arrays.asList()
 * or non-linear data structures by simply using a for loop to process
 * element of an array into the non-linear data structure.
 */
public class Sorts {

    /**This method takes an integer array as a parameter and sorts it in
     * ascending order. This method sorts an integer array by comparing a
     * specific element in the array with the element ahead of it. It
     * performs this operation n-1 number of times, where n is the length of
     * the array. This iteration cannot run n number of times because we are
     * comparing two elements at the same time. Running n number of times
     * would throw an IndexOutOfBoundsException nth iteration would need to
     * access one more element, which would not exist.It also uses a
     * boolean flag to indicate when a swap occurs in the array. If a swap no
     * longer occurs before n - 1 number of iterations, this means that array
     * is sorted, and loop can terminate early. This provides optimization.
     *
     * @param arr (array to be sorted)
     * @return sorted version, in ascending order, of the parameter, "arr"
     */
    public static int[] bubbleSort(int[] arr){
        boolean swap;

        // checking for valid parameters
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("Invalid array parameter");

        int[] sortedArr;

        /* outer loop to make sure that the number of iteration that must happen
         * for array to be sorted is the length. So where length is n, the
         * outer loop runs n - 1 times */
        for(int outer = arr.length - 1; outer > 0; outer--){
            swap = false;// keeps track of whether a swap occurs or not

            // inner loop that actually does the swapping of element
            for(int inner = 0; inner < outer; inner++){
                // if an element is greater than the element in front of it
                if(arr[inner] > arr[inner+1]){
                    swap(arr, inner, inner+1 );// swaps the elements
                    swap = true;
                }
            }

            /* if no swapping occurred,this means array is sorted. There
             is no need to let the loop continue*/
            if(!swap)
                break;
        }

        sortedArr = arr;

        return sortedArr;
    }
    //TODO optimize
    /** This method sorts an array in ascending order. It performs this
     * operation by finding the smallest element in every iteration and
     * swapping it with the element at the first position. It does this
     * through an inner for loop.Then it finds the next smallest element, and
     * swaps it with the element at the second position. It performs this
     * operation n - 1 number of times, where n is the length of the array,
     * until the array is sorted
     *
     * @param array (array to sort)
     * @return sorted version, in ascending order, of the parameter, "arr"
     */
    public static int[] selectionSort(int[] array){
        // checking for valid parameters
        if(array == null || array.length == 0)
            throw new IllegalArgumentException("Invalid array parameter");

        int[] sortedArr;
        int minIndex;// stores the index where the smallest element is

        // outer for loop for swapping.
        for(int outer = 0; outer < array.length - 1; outer++){
            minIndex = outer;// minIndex starts at the first element in array

            // inner for loop to always find the smallest element in an array
            for(int inner = outer + 1; inner < array.length; inner++){
                /* checks if current smallest element is greater than current
                 element in this iteration*/
                if(array[minIndex] > array[inner]){
                    minIndex = inner;// changes smallest element's index to
                                    // inner if true
                }
            }
            swap(array, outer, minIndex);// current iteration with smallest
        }
        sortedArr = array;

        return sortedArr;
    }

    /**This method sorts by comparing two elements. It divides the array
     * into sorted and unsorted. Then it takes the first element of the
     * unsorted part of the array and adds it to the correct position in the
     * sorted part of the array. For each iteration, it takes the first
     * element of the unsorted part of the array, k, and backtracks until it
     * finds an element less than k. It does this n number of times, where n
     * is the length of array. What actually happens is the value to sort is
     * stored in a placeholder and checked versus the other values. If those
     * values are smaller, they are simply shifted, i.e. replace the previous
     * (or next) position in the list/array. The placeholder's value is then
     * put in the position from which the element was shifted. This is more like
     * an extreme swap.
     *
     * @param array (array to sort)
     * @return sorted version, in ascending order, of the parameter, "arr"
     */
    public static int[] insertionSort(int[] array){
        // checking for valid parameters
        if(array == null || array.length == 0)
            throw new IllegalArgumentException("Invalid array parameter");

        int[] sortedArr;
        /*j represents index of the elements in 'unsorted part of
          array, while key represents the element to backtrack to*/
        int j, key;

        /* for loop to update index. Note that loop starts from second index.
        * The first element is regarded as the sorted part of the array*/
        for(int i = 1; i < array.length;i++){
            // sets key to first element of 'unsorted' part of array
            key = array[i];
            j = i;

            /* while loop to compare first element of unsorted, key, to sorted
            * part of array. In the first iteration, this means comparing
            * array[1] to array[0] and so on.*/
            while(j > 0 && key < array[j-1]){
                /* changes the element where key is to the element ahead of it.
                 if the element ahead of key is less than key*/
                array[j] = array[j-1];
                j--;// j backtracks to position of key. i.e.
            }
            array[j] = key;// update element at position j with key
        }
        sortedArr = array;

        return sortedArr;
    }

    /**
     *
     * @param array
     * @param indexLow
     * @param indexHigh
     * @return
     */
    public static int[] quickSort(int[] array, int indexLow, int indexHigh){
        // checking for valid parameters. Indexes cannot be invalid too
        if(array == null || array.length == 0
                || indexLow < 0 || indexLow > array.length || indexHigh < 0
                || indexHigh > array.length)
        {
            throw new IllegalArgumentException("Invalid array parameter");
        }

        int[] sortedArr;
        int pivotIndex;// keeps track of index for pivot element

        /* checks if index of 'left side of array' is less than index of
         'right side of array' before partitioning and sorting*/
        if (indexLow < indexHigh){
            /* pivot index of every recursive iteration is updated after
             partitioning the list*/
            pivotIndex = partitionList(array, indexLow, indexHigh);
            /* recursively sort 'left side' of array from beginning of array to
            index before the pivot element*/
            quickSort(array, indexLow, pivotIndex - 1);
            /* recursively sort 'right side' of array from element after
            pivot to end of array*/
            quickSort(array, pivotIndex + 1, indexHigh);
        }
        sortedArr = array;

        return sortedArr;
    }

    private static int partitionList(int[] array, int low, int high) {
        /*pivot element with the last element in the array. left represent
        index where left part of the array to sort starts from. right
        represent where right part of the array to sort ends*/
      int left = low, right = high - 1, pivotElement = array[high];

      /* loop runs while the index of left part of array is less than or
         equal to the right part of array*/
      while (left <= right){
          //---UPDATING INDEXES
          /* index of left part of array increases as long as each element on
           the left of the pivot element is less*/
          while(left <= right && array[left] <= pivotElement)
              left++;

          /* index of right part of array decreases as long as each element on
           the right of the pivot element is greater*/
          while(left <= right && array[right] >= pivotElement)
              right--;

            // optimization. Still sorts without this if statement.
          if (left < right)
              swap(array, left,right);
      }

      swap(array, left, high);// position of pivot element changes to the
                                // sorted part of the array

      return left;// returns last index of the left side of array which is
                    // sorted
    }

    /**
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int[] mergeSort(int[] array, int low, int high){
        // check for valid parameters
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("Invalid array parameter");
        }

        int mid;// variable to keep track of middle of array
        int[] sortedArr = null;// points to sorted version of array

        // if there is only one element, then it is sorted
        if(array.length == 1){
            sortedArr = array;
        }

        else {
            // find the middle index to spilt array into two
            mid = (low + high) / 2;

            /* checks to see that low is not high, because then, that would
            mean array cannot be spilt anymore, which means initial array is
            already at its subatomic level. i.e. initial array has been spilt
             to one array containing each element of initial array */
            if (low != high) {
                // recursively mergeSort left part of array
                mergeSort(array, low, mid);
                /* recursively mergeSort right part of array, starting from
                * element after the middle element*/
                mergeSort(array, mid + 1, high);
                // merge all the arrays that were spilt
                sortedArr = merge(array, low, high, mid);
            }
        }

        return sortedArr;
    }

    /**
     *
     * @param array
     * @param low
     * @param high
     * @param mid
     * @return
     */
    private static int[] merge(int[] array, int low, int high, int mid){
        // new array to represent merged arrays spilt from mergeSort
        int[] mergedArray = new int[array.length];

        /* j represents iterator/index used to add to the mergedArray
        *  left represents a reference to index in the left array
        *  right represent a reference to first index in the right array.
        *  Upperbound of left array is mid
        *  Upperbound of right array is high
        */
        int j = 0, left = low, right = mid + 1;

        // while left is a valid index and right is a valid index
        while(left <= mid || right <= high){

            /* compares element in left array to element in right array.
            * if element in left array is less than right array, it is added
            * to mergedArray first. Also checks if first element in the right
            * is greater than its upperbound, then left should be added*/
            if(left <= mid && array[left] <= array[right] || right > high)
                mergedArray[j++] = array[left++];// adds element in left array
            else
                mergedArray[j++] = array[right++];// else adds the right
        }

        return  mergedArray;
    }

    /**This method swaps two element in an array. It does this by accessing
     * the index of the elements to be removed and swapping them
     *
     * @param arr (array to swap element from)
     * @param index (first element to swap)
     * @param index1 (second element to swap)
     */
    public static void swap(int[] arr, int index, int index1){

        //checking for valid parameters
        if(arr == null || arr.length==0 || index < 0 || index1 < 0)
            throw new IllegalArgumentException("Invalid value detected");

        int temp = arr[index];// stores the element at position index, in arr
        arr[index] = arr[index1];// swaps element at index with index1
        arr[index1] = temp;// swaps element at index1 with temp
    }
}

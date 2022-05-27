package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1, 9, 6, 3, 7, 2, 0};

        sort(a, 0, a.length - 1);

        for (int j : a) {
            System.out.println(j);
        }
    }

    static void sort(int[] a, int pivot, int end) {
        if (pivot >= end) {
            return;
        }

        int left = pivot + 1;
        int right = end;
        while (left <= right) {
            while (left <= end && a[left] <= a[pivot]) {
                left += 1;
            }

            while(right > pivot && a[right] >= a[pivot]){
                right -= 1;
            }

            if (left > right) {
                swap(a, pivot, right);
            } else {
                swap(a, left, right);
            }
        }


        sort(a, pivot, right - 1);
        sort(a, right + 1, end);
    }

    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }


}

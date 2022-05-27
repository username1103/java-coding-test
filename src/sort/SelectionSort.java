package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {1, 9, 3, 6, 8, 2, 0};

        sort(a);

        for (int j : a) {
            System.out.println(j);
        }
    }

    static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
}

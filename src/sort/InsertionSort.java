package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1, 9, 6, 3, 7, 2, 0};

        sort(a);

        for (int j : a) {
            System.out.println(j);
        }
    }

    static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j] < a[j - 1]){
                    swap(a, j, j - 1);
                } else break;
            }
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
}

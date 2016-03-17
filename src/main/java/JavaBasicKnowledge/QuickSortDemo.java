package JavaBasicKnowledge;

/**
 * 快排的示例
 * Created by kevin on 2016/3/10.
 */
public class QuickSortDemo {
    public void QuickSort(int[] nums) {

    }

    public static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray, int left, int center, int right) {

    }

    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center+1, right);
            merge(a, tmpArray, left, center+1, right);
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {
        AnyType[] tmp = (AnyType[]) new Comparable[a.length];

        mergeSort(a, tmp, 0, a.length - 1);
    }
}

package site.sanniu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author sanniu
 * @Description 归并排序
 * @Date $ $
 **/
public class MergeSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arr) {
        List<Integer> left = new ArrayList<>();
        left.add(1);
        left.add(3);
        left.add(5);
        left.add(7);
        left.add(9);
        List<Integer> right = new ArrayList<>();
        right.add(2);
        right.add(4);
        right.add(6);
        right.add(8);
        right.add(10);
        return merge(left, right);
    }

    /**
     * 归并排序
     * @param left 有序集合
     * @param right 有序集合
     * @return
     */
    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> newArr = new ArrayList<>();

        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) < right.get(0)) {
                newArr.add(left.remove(0));
            } else {
                newArr.add(right.remove(0));
            }
        }

        while (left.size() > 0) {
            newArr.add(left.remove(0));
        }

        while (right.size() > 0) {
            newArr.add(right.remove(0));
        }

        return newArr;
    }
}

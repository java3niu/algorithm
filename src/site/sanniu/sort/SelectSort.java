package site.sanniu.sort;

import java.util.List;

/**
 * @Author sanniu
 * @Description 选择排序
 * @Date $ $
 **/
public class SelectSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int minIndex = 0;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            // 交换
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
        return arr;
    }
}

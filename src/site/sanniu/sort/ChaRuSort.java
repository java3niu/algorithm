package site.sanniu.sort;

import java.util.List;

/**
 * @Author sanniu
 * @Description 插入排序
 * @Date $ $
 **/
public class ChaRuSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arr) {

        for (int i = 1; i < arr.size(); i++) {
            int preIndex = i - 1;
            int currentValue = arr.get(i);

            while (preIndex >= 0 && arr.get(preIndex) > currentValue) {
                arr.set(preIndex + 1, arr.get(preIndex));
                preIndex--;
            }
            arr.set(preIndex + 1, currentValue);
        }

        return arr;
    }
}

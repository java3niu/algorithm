package site.sanniu.sort;

import java.util.List;

/**
 * @Author sanniu
 * @Description 冒泡排序
 * @Date $ $
 **/
public class MaoPaoSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }
}

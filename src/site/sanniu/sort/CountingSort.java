package site.sanniu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author sanniu
 * @Description 计数排序
 * @Date $ $
 **/
public class CountingSort implements ISort<Integer>{

    @Override
    public List<Integer> sort(List<Integer> arr) {

        int n = arr.size();
        // 找出最大值和最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 计算计数数组的长度，并初始化为0
        int range = max - min + 1;
        int[] count = new int[range];

        // 统计每个元素的出现次数
        for (int num : arr) {
            count[num - min]++;
        }

        // 对计数数组进行累加操作
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // 创建临时数组，用于存储排序结果
        int[] result = new int[n];
        List<Integer> result1 = new ArrayList<>(n);

        // 逆向遍历原数组，根据计数数组将元素放置到正确位置
        for (int i = n - 1; i >= 0; i--) {
            int num = arr.get(i);
            int index = count[num - min] - 1;
            result[index] = num;
            count[num - min]--;
        }

        return result1;
    }
}

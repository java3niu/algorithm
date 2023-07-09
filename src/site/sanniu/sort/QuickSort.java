package site.sanniu.sort;

import java.util.List;

/**
 * @Author sanniu
 * @Description 快速排序
 * @Date $ $
 **/
public class QuickSort implements ISort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arr) {

        quickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    public void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            // 分区 获得分区点
            int partitionIndex = partition(arr, low, high);

            // 对分区后的左右子序列递归排序
            quickSort(arr, 0, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }


    /**
     * 分区
     *
     * @param list  待排的集合
     * @param left  待排序的最左边索引
     * @param right 待排序的最右边索引
     * @return 集合被分割的 索引值
     */
    public int partition(List<Integer> list, int left, int right) {
        // 基准志索引
        int standardValue = list.get(left), startIndex = left + 1, endIndex = right;
        while (startIndex <= endIndex) {

            // 从左侧找到第一个大于基准元素的位置
            while (startIndex <= endIndex && list.get(startIndex) <= standardValue) {
                startIndex++;
            }

            // 从右侧找到第一个小于基准元素的位置
            while (startIndex <= endIndex && list.get(endIndex) > standardValue) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                int temp = list.get(startIndex);
                list.set(startIndex, list.get(endIndex));
                list.set(endIndex, temp);
            }
        }

        // 将基准的数据 放到 正确的位置
        int temp = list.get(left);
        list.set(left, list.get(endIndex));
        list.set(endIndex, temp);

        return endIndex;
    }
}

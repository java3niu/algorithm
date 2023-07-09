package site.sanniu.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class SortTest {

    public static List<Integer> param = Arrays.asList(9,1,2,4,20,6,20,1,9);

    public static void main(String[] args) {
        //ISort<Integer> sort = new QuickSort();
        CountingSort sort = new CountingSort();
        List<Integer> sortResult = sort.sort(param);
        System.out.println("排序结果为:" + sortResult);
    }

}

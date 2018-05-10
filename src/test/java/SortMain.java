/**
 * Author:   shitian
 * Date:     2018/5/9 15:49
 * Description:
 */

import com.sort.inner.NumberSort;
import com.sort.inner.impl.HeapSort;
import com.sort.inner.impl.MergeSort;

import java.util.Arrays;

/**
 * 〈〉
 *
 * @author shitian
 * @create 2018/5/9
 * @since 1.0.0
 */
public class SortMain {


    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 4, 4, 6, 8, 9, 0, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(nums));

        System.out.println("排序后");
        NumberSort sort = new MergeSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

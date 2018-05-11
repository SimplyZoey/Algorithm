/**
 * Author:   shitian
 * Date:     2018/5/11 12:36
 * Description:
 */

import com.search.graph.GraphSearch;
import com.search.graph.impl.BreadthFirstSearch;

/**
 * 〈〉
 *
 * @author shitian
 * @create 2018/5/11
 * @since 1.0.0
 */
public class SearchMain {
    public static void main(String[] args){
        GraphSearch search = new BreadthFirstSearch();
        search.search();
    }
}

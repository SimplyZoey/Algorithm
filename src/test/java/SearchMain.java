/**
 * Author:   shitian
 * Date:     2018/5/11 12:36
 * Description:
 */

import com.search.graph.GraphSearch;
import com.search.graph.impl.BreadthFirstSearch;
import com.search.graph.impl.DijkstraSearch;
import com.search.number.NumberSearch;
import com.search.number.impl.DictionarySearch;

/**
 * 〈〉
 *
 * @author shitian
 * @create 2018/5/11
 * @since 1.0.0
 */
public class SearchMain {
    public static void main(String[] args){
        //GraphSearch();
        numberSearch();
    }

    private static void GraphSearch(){
        GraphSearch search = new DijkstraSearch();
        search.search();
    }

    private static void numberSearch(){
        NumberSearch search = new DictionarySearch();
        search.findNumber();
    }
}

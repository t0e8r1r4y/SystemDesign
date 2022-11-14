package study.book.systemdesign.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.book.systemdesign.consistenthash.sample.MyServiceNode;

/**
 * https://github.com/Jaskey/ConsistentHash
 */
public class ConsistentHashTest {

    MyServiceNode node1 = new MyServiceNode("IDC1","127.0.0.1",8080);
    MyServiceNode node2 = new MyServiceNode("IDC1","127.0.0.1",8081);
    MyServiceNode node3 = new MyServiceNode("IDC1","127.0.0.1",8082);
    MyServiceNode node4 = new MyServiceNode("IDC1","127.0.0.1",8084);
    MyServiceNode node5 = new MyServiceNode("IDC1","127.0.0.1",8085);

    private static List<String> data = new ArrayList<>();
    private static final int DATA_COUNT = 100000;

    @BeforeAll
    static void prepareData(){
        for(int i=0; i < DATA_COUNT; i++){
            data.add("data_"+i);
        }
    }

    @Test
    @DisplayName("노드가 하나인 경우")
    void 기본_구현_노드가_하나(){
        ConsistentHashRouter<Node> router = new ConsistentHashRouter<>(Lists.list(node1), 1);
        Map<Node, Long> countMap = getCountMap(router);
        Assertions.assertThat(countMap.get(node1)).isEqualTo(DATA_COUNT);
        Assertions.assertThat(router.calculateHashSpaceOfNode(node1)).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    @DisplayName("노드가 두개인 경우")
    void 기본_구현_노드가_두개(){
        ConsistentHashRouter<Node> router = new ConsistentHashRouter<>(Lists.list(node1,node2), 1);
        System.out.println(getCountMap(router));
        System.out.println(getHashSpaceMap(router));
        Assertions.assertThat(router.calculateHashSpaceOfNode(node1) + router.calculateHashSpaceOfNode(node2)).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    @DisplayName("노드가 다섯개인 경우")
    void 기본_구현_노드가_다섯개(){
        ConsistentHashRouter<Node> router = new ConsistentHashRouter<>(Lists.list(node1,node2,node3,node4,node5), 1);
        System.out.println(getCountMap(router));
        System.out.println(getHashSpaceMap(router));
        Assertions.assertThat(router.calculateHashSpaceOfNode(node1)
                + router.calculateHashSpaceOfNode(node2)
                + router.calculateHashSpaceOfNode(node3)
                + router.calculateHashSpaceOfNode(node4)
                + router.calculateHashSpaceOfNode(node5)
        ).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    @DisplayName("노드 제거시 데이터 재배치")
    void 기본_구현_데이터_재배치(){
        ConsistentHashRouter<Node> router = new ConsistentHashRouter<>(Lists.list(node1,node2), 1);
        Map<Node, Long> countMap = getCountMap(router);
        Assertions.assertThat(countMap.get(node1)).isLessThanOrEqualTo(DATA_COUNT);

        router.removeNode(node2);
        countMap = getCountMap(router);
        Assertions.assertThat(countMap.get(node1)).isEqualTo(DATA_COUNT);
    }

    @Test
    @DisplayName("가상노드_추가시_데이터_분포_균일화_확인")
    void 가상노드_추가시_데이터_분포_균일화_확인(){
        ConsistentHashRouter<Node> router = new ConsistentHashRouter<>(Lists.list(node1,node2), 1000000);
        System.out.println(getCountMap(router));
        System.out.println(getHashSpaceMap(router));
    }



    private Map<Node, Long> getCountMap(ConsistentHashRouter<Node> router) {
        Map<Node, Long> allocatedDataCount = new HashMap<>();

        for(String d : data){
            Node node = router.routeNode(d);
            allocatedDataCount.putIfAbsent(node, 0L);
            allocatedDataCount.computeIfPresent(node,(k,v) -> v+1);
        }
        return allocatedDataCount;
    }

    private Map<Node, Long> getHashSpaceMap(ConsistentHashRouter<Node> router) {
        Map<Node, Long> map = new HashMap<>();
        map.put(node1, router.calculateHashSpaceOfNode(node1));
        map.put(node2, router.calculateHashSpaceOfNode(node2));
        map.put(node3, router.calculateHashSpaceOfNode(node3));
        map.put(node4, router.calculateHashSpaceOfNode(node4));
        map.put(node5, router.calculateHashSpaceOfNode(node5));

        return map;
    }
}

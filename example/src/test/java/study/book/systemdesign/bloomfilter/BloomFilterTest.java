package study.book.systemdesign.bloomfilter;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/guava-bloom-filter
 * https://meetup.toast.com/posts/192
 * https://gngsn.tistory.com/201
 * False Positive 가 있을 수 있다. (데이터가 없는데 있다고 결론이 나는 경우가 있음)
 */
class BloomFilterTest {

    @Test
    @DisplayName("기본")
    void test1(){
        BloomFilter<String> bf =BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8),1000);
        bf.put("owihfowaifwfwffwwfwf");
        Assertions.assertThat(bf.mightContain("owihfowaifwfwffwwfwf")).isTrue();
        Assertions.assertThat(bf.mightContain("fofofofofofof")).isFalse();
    }

    @Test
    @DisplayName("False Positive 만들기")
    void test2(){
        BloomFilter<String> bf =BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8),1,0.3);
        bf.put("owihfowaifwfwffwwfwf");
        Assertions.assertThat(bf.mightContain("fofofofofofof")).isTrue();
    }
}

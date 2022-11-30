package study.book.systemdesign.redis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    @DisplayName("Strings 자료구조")
    void strings(){
        String key = "key";
        String value = "dwdwdwd";
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
        Assertions.assertThat(valueOperations.get(key)).isEqualTo(value);
    }
}

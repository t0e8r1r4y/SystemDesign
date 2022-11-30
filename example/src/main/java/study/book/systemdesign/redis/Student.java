package study.book.systemdesign.redis;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    private String id;
    private String name;
    private Gender gender;
    private int grade;
}

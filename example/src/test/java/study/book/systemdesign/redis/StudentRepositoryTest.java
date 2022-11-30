package study.book.systemdesign.redis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.book.systemdesign.redis.Student.Gender;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("데이터 추가 및 제거 ")
    void test1(){
        Student student = new Student(
                "1", "Amber", Student.Gender.MALE, 1);
        studentRepository.save(student);
        Student founded = studentRepository.findById("1").get();
        Assertions.assertThat(founded.getGender()).isEqualTo(Gender.MALE);

        studentRepository.delete(founded);
        Assertions.assertThat(studentRepository.count()).isZero();

    }
}

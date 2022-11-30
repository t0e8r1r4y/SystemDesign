package study.book.systemdesign.kafka.produce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CountMessageProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    private long count = 0;

    @Scheduled(fixedDelay = 100)
    public void counting(){
        log.info(String.valueOf(count));
        kafkaTemplate.send(KafkaConfig.MY_TOPIC,String.valueOf(count++));
    }
}

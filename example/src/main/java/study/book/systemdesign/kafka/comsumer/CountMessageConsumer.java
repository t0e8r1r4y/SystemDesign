package study.book.systemdesign.kafka.comsumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CountMessageConsumer {

    @KafkaListener(topics = KafkaConsumerConfig.MY_TOPIC, groupId = KafkaConsumerConfig.MY_TOPIC_CONSUMER_GROUP)
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {

        log.info("consumer 1 received value: {}", consumerRecord.value().toString());
    }

    @KafkaListener(topics = KafkaConsumerConfig.MY_TOPIC, groupId = KafkaConsumerConfig.MY_TOPIC_CONSUMER_GROUP)
    public void consumer2(ConsumerRecord<?, ?> consumerRecord) {

        log.info("consumer 2 received value: {}", consumerRecord.value().toString());
    }
}

package sash.dev.kafaktopicdrainui;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

public class DynamicConsumerService {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicConsumerService.class);

    private final ConsumerFactory consumerFactory;

    public DynamicConsumerService(ConsumerFactory consumerFactory) {

        this.consumerFactory = consumerFactory;
    }

    public void consumeTopic(String topicName) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9292");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, topicName + "group_dynamic");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        DefaultKafkaConsumerFactory consumerFactory = new DefaultKafkaConsumerFactory(null, new JsonDeserializer(String.class), new JsonDeserializer(String.class));
        KafkaConsumer consumer = (KafkaConsumer) consumerFactory.createConsumer();
    }
}

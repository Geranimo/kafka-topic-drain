package sash.dev.kafaktopicdrainui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class KafkaTopicController {

    @GetMapping("/topic/{topicName}")
    public List<String> getMessagesInTopic() {
        return Arrays.asList("method1", "method2");
    }

}

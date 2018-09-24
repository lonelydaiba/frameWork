package daily.framework.example.rocketmq;

import daily.framework.TestSupport;
import daily.framework.util.rocketmq.RocketMqProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class RocketMqProducerTest extends TestSupport {

    @Autowired
    private RocketMqProducer rocketMqProducer;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.tag}")
    private String notifyTag;

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            String str = "I send message to RocketMQ " + i;
            rocketMqProducer.sendMsg(topic,notifyTag,str.getBytes());
        }
    }

}



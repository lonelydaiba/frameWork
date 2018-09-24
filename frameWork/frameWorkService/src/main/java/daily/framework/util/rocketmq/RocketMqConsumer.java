package daily.framework.util.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RocketMqConsumer implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(RocketMqProducer.class);

    @Value("${rocketmq.consumer.group}")
    private String consumerGroup;

    @Value("${rocketmq.namesrvAddr}")
    private String namesAddr;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.tag}")
    private String notifyTag;

    private DefaultMQPushConsumer msgConsumer;

    public void init() {
        this.msgConsumer = new DefaultMQPushConsumer(this.consumerGroup);
        this.msgConsumer.setNamesrvAddr(this.namesAddr);
        try {
            this.msgConsumer.subscribe(this.topic, this.notifyTag);
            this.msgConsumer.setConsumeFromWhere(ConsumeFromWhere
                    .CONSUME_FROM_FIRST_OFFSET);

            this.msgConsumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> list,
                        ConsumeConcurrentlyContext Context) {
                    MessageExt msg = (MessageExt)list.get(0);
                    String msgStr = new String(msg.getBody());
                    LOGGER.info("msg content - " + msgStr);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            this.msgConsumer.start();
            LOGGER.info("MsgConsumer init - success.");
        }
        catch (MQClientException e) {
            LOGGER.error("MsgConsumer init - failed.");
        }
    }

    public void destroy() {
        if (this.msgConsumer != null)
            this.msgConsumer.shutdown();
    }

    public void afterPropertiesSet() throws Exception {
        init();
    }
}

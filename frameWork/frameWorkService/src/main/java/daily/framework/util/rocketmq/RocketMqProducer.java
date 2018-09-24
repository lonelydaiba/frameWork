package daily.framework.util.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import daily.framework.util.RunTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description 生产者
 * @author daili
 * @version 1.0.0
 */
@Component("rocketMqProducer")
public class RocketMqProducer implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(RocketMqProducer.class);

    @Value("${rocketmq.producer.group}")
    private String group = null;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr = null;

    public DefaultMQProducer rocketMqProducer = null;

    public volatile boolean initiated = false;

    public void init() {
        this.rocketMqProducer = new DefaultMQProducer(this.group);
        this.rocketMqProducer.setNamesrvAddr(this.namesrvAddr);
        this.rocketMqProducer.setInstanceName(RunTimeUtil.getRocketMqUniqeInstanceName());
        try {
            this.rocketMqProducer.start();
            this.initiated = true;
        }
        catch (MQClientException localMQClientException) {
        }
    }


    @Override
    public void destroy() throws Exception {
        this.rocketMqProducer.shutdown();
    }

    public SendResult sendMsg(String topic, String tagName, byte[] msgBody) {
        Message msg = new Message(topic, tagName, msgBody);
        SendResult result = null;
        try {
            while (!this.initiated) {
                Thread.sleep(1000L);
            }
            result = this.rocketMqProducer.send(msg);
            LOGGER.info(result.toString() + ",msgId:"+result.getMsgId());
        }
        catch (Exception e) {
            LOGGER.error("msgBody:" + new String(msgBody), e);
        }
        return result;
    }

    public void sendMsgOrderly(final String vehicleNum, String topic, String tagName, byte[] msgBody) {
        String key = "key" + System.currentTimeMillis();
        Message msg = new Message(topic, tagName, key, msgBody);
        try {
            while (!this.initiated) {
                Thread.sleep(1000L);
            }
            SendResult result = this.rocketMqProducer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer)Math.abs(vehicleNum.hashCode());
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, vehicleNum);
            LOGGER.info(new String(msgBody, "utf-8")+",延迟消息msgId:"+result.getMsgId());
        }
        catch (Exception e) {
            LOGGER.error("msgBody:" + new String(msgBody), e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}

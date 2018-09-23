package daily.framework.example.zookeeper;

import daily.framework.TestSupport;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ZookeeperDemo extends TestSupport {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperDemo.class);



    @Test
    public  void test() throws IOException,InterruptedException,KeeperException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181",3000,new TestWatcher());
        String node = "/orderId2";
        Stat state = zk.exists(node,false);
        if (state == null) {
            String createResult = zk.create(node ,"test".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            logger.info("-----createState is {}",createResult);
        }
        byte[] b = zk.getData(node,false,state);
        logger.info("-------------b is {}",String.valueOf(new String(b)));
        zk.close();
    }


     class  TestWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            logger.info("-----------------");
            logger.info("path is {}",watchedEvent.getPath());
            logger.info("type is {} ",watchedEvent.getType());
             logger.info("state is {}",watchedEvent.getState());
             logger.info("-----------------");
        }
    }
}

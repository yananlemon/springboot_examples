package site.ilemon.springbootzookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Configuration
public class AppConfig {

    @Value("${zookeeper.connection.address}")
    private String host;

    @Value("${zookeeper.timeout}")
    private int timeout;
    final CountDownLatch connectedSignal = new CountDownLatch(1);
    @Bean
    public ZooKeeper zooKeeper() throws IOException, InterruptedException {
        ZooKeeper zoo = new ZooKeeper(host, timeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
            }
        });
        connectedSignal.await();
        return zoo;
    }
}

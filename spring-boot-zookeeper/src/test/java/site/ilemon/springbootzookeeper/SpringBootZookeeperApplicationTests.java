package site.ilemon.springbootzookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.ilemon.springbootzookeeper.service.IZooKeeperService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootZookeeperApplicationTests {

    @Autowired
    private IZooKeeperService zooKeeperService;

    @Test
    public void testCreate() {
        try {
            String path = "/newNode5";
            String value = "newNode5";
            zooKeeperService.create(path,value);
            String val = zooKeeperService.getZNodeData(path,false);
            Assert.assertEquals(value,val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {
        try {
            String path = "/newNode5";
            String value = "hh";
            zooKeeperService.update(path,value);
            String val = zooKeeperService.getZNodeData(path,false);
            Assert.assertEquals(value,val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetChildren() {
        try {
            List<String> list = zooKeeperService.list("/",null);
            for(String node : list)
                System.out.println(node);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetChildrenAndWatch(){
        try {
            zooKeeperService.watch("/");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册三台服务器到zk集群
     */
    @Test
    public void registServer(){
        // 创建三个临时节点
        String[] hostNames = {"hadoop001","hadoop002","hadoop003"};
        try{

            for(int i = 0; i < hostNames.length; i++){
                StringBuffer path = new StringBuffer("/servers/server").append(i);
                zooKeeperService.createWithEphemeralAndSeq(path.toString(),hostNames[i]);
                System.out.println(hostNames[i]+"is online");
            }
            Thread.sleep(Long.MAX_VALUE);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 注册客户端并监听
     */
    @Test
    public void registClientAndWatch(){
        try {
            zooKeeperService.watch("/servers");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

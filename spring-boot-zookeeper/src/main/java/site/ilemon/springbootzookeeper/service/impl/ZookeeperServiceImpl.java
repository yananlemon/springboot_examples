package site.ilemon.springbootzookeeper.service.impl;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.ilemon.springbootzookeeper.service.IZooKeeperService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZookeeperServiceImpl implements IZooKeeperService {

    @Autowired
    private ZooKeeper zooKeeper;


    /**
     * 创建节点：节点持久化不带序号
     * @param path
     * @param data
     * @throws Exception
     */
    @Override
    public void create(String path, String data) throws Exception {
        zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 创建临时节点：带序号
     * @param path
     * @param data
     * @throws Exception
     */
    @Override
    public void createWithEphemeralAndSeq(String path, String data) throws Exception {
        zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
    }

    @Override
    public String getZNodeData(String path, boolean watchFlag) throws Exception{
        byte[] bytes = zooKeeper.getData(path, null, null);
        return new String(bytes);
    }

    @Override
    public void update(String path, String data) throws Exception {
        Stat stat = this.checkExists(path);
        if(stat != null)
            zooKeeper.setData(path,data.getBytes(),stat.getVersion());
    }

    @Override
    public List<String> list(String path,Watcher watcher) throws KeeperException, InterruptedException {
        return zooKeeper.getChildren(path,watcher);
    }

    @Override
    public Stat checkExists(String path) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(path,true);
        return stat;
    }

    @Override
    public void watch(String path) throws Exception {
        try {
            List<String> nodeList = zooKeeper.getChildren(path, new Watcher() {

                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.NodeChildrenChanged) {
                        try {
                            watch(event.getPath());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            List<String> dataList = new ArrayList<>();
            for (String node : nodeList) {
                String value = this.getZNodeData(path+"/"+ node, false);
                dataList.add(new String(value));
            }
            System.out.println("node data: "+dataList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

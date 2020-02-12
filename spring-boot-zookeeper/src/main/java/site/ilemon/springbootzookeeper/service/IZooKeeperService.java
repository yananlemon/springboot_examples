package site.ilemon.springbootzookeeper.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * zookeeper 服务接口
 */
public interface IZooKeeperService {

    public void create(String path, String data)
            throws Exception;
    public void createWithEphemeralAndSeq(String path, String data) throws Exception;
    public String getZNodeData(String path, boolean watchFlag) throws Exception;
    public void update(String path, String data)
            throws Exception;

    public List<String> list(String path, Watcher watcher) throws KeeperException, InterruptedException;

    public Stat checkExists(String path) throws KeeperException, InterruptedException;

    public void watch(String path) throws Exception;
}

package site.ilemon;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * Kafka生产者
 *
 */
public class KafkaProducerDemo {
    public static void main( String[] args ) {
        Properties props = new Properties();
        // 一个host/port对列表，用于建立Kafka集群的初始化连接。
        //客户端将使用所有服务器而不受这里指定的服务器列表的影响
        //这个列表仅影响初始化hosts，该hosts被用来发现完整的服务器列表。
        //这个列表应该是这样的形式：host1:port1,host2:port2
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.60.128:9092,192.168.60.129:9092,192.168.60.130:9092");
        props.setProperty(ProducerConfig.ACKS_CONFIG,"all");
        props.setProperty(ProducerConfig.RETRIES_CONFIG,"3");
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG,"site.ilemon.MyPartitioner");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++){
            //producer.send(new ProducerRecord<String,String>("my_topic","value"+i));

            producer.send(new ProducerRecord<String, String>("my_topic", "hello" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if(exception == null){
                        System.out.printf("partition:%d,offset:%d\n",metadata.partition(),metadata.offset());
                    }else{
                        exception.printStackTrace();
                    }
                }
            });
        }
        producer.close();

    }
}

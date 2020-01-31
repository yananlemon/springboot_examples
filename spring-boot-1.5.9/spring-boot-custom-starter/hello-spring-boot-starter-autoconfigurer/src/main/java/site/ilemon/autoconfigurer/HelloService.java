package site.ilemon.autoconfigurer;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    private HelloProperties helloProperties;

    public HelloService(HelloProperties helloProperties){
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name ){
        return helloProperties.getPrefix()+" " + name + " " + helloProperties.getSuffix();
    }
}

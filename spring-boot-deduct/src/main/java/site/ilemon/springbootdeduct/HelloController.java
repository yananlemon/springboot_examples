package site.ilemon.springbootdeduct;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String STRING_KEY_STOCK = "stock_";

    private static final String LOCK_KEY_PRODUCT = "product_lock_";

    @Autowired
    private Redisson redisson;

    @GetMapping("/product/{id}")
    public String deductProduct(@PathVariable("id") String productId) throws InterruptedException {
        RLock lock = null;
        try{
            lock = redisson.getLock(LOCK_KEY_PRODUCT+productId);
            lock.tryLock(5,TimeUnit.SECONDS);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(STRING_KEY_STOCK+productId));
            if(stock > 0 ){
                int remainStock = stock - 1;
                stringRedisTemplate.opsForValue().set(STRING_KEY_STOCK+productId,String.valueOf(remainStock));
                System.out.printf("扣减成功，剩余库存%d\n",remainStock);
            }else{
                System.out.println("扣减失败，库存不足。");
            }
        }finally {
            // 释放锁
            lock.unlock();
        }
        return "end";
    }
}

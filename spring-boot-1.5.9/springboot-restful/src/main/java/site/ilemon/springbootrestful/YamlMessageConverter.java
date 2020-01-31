package site.ilemon.springbootrestful;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.yaml.snakeyaml.Yaml;
import site.ilemon.springbootrestful.model.Customer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class YamlMessageConverter extends AbstractHttpMessageConverter<Customer> {


    public YamlMessageConverter(){
        // 支持application/yaml
        super(new MediaType("application","yaml" , Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    /**
     * 将请求的参数转换为yaml格式的数据
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Customer readInternal(Class<? extends Customer> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        Yaml yaml = new Yaml();
        Customer t = yaml.loadAs(httpInputMessage.getBody(), aClass);
        return t;
    }

    /**
     * 将响应的数据转换为yaml格式
     * @param o
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Customer o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Yaml yaml = new Yaml();
        OutputStreamWriter writer = new OutputStreamWriter(httpOutputMessage.getBody());
        yaml.dump(o, writer);
        System.out.println(yaml.dump(o));
        writer.close();
    }
}

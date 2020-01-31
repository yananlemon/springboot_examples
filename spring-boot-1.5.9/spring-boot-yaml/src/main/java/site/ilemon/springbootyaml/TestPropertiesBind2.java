package site.ilemon.springbootyaml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class TestPropertiesBind2 {

    /**
     * @Value注解类似配置文件中配置bean属性的方式
     * <bean id="aBean">
     *  <property name="firstName" value="bill"></property>
     *  <property name="lastName" value="${属性文件中的key}"></property>
     * </bean>
     */
    @Value("bill")
    private String firstName;

    @Value("${testPro2.lastName}")
    private String lastName;

    @Value("#{10*1.9}")
    private Integer age;

    public TestPropertiesBind2() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "TestPropertiesBind{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

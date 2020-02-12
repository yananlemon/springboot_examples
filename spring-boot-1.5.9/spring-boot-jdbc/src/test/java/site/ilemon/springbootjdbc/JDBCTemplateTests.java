package site.ilemon.springbootjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCTemplateTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void selectCourseTest() {
        List<Map<String, Object>> courses = jdbcTemplate.queryForList("select * from course");

        for (Map<String, Object> row : courses) {
            System.out.printf("%d,%s\n", row.get("id"), row.get("name").toString());
        }
    }

}

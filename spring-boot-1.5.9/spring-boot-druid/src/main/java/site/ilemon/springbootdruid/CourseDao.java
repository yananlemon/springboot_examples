package site.ilemon.springbootdruid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listCourse() {
        List<Map<String, Object>> courses = jdbcTemplate.queryForList("select * from course");
        return courses;
    }
}

package site.ilemon.springbootdruid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @GetMapping()
    public List<Map<String, Object>> listCourse() {
        return courseDao.listCourse();
    }
}

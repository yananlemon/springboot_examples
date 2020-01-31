package site.ilemon.springbootmybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.ilemon.springbootmybatis.dao.CourseMapper;
import site.ilemon.springbootmybatis.entity.Course;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private CourseMapper mapper;

    @Test
    public void testList() {
        List<Course> courses = mapper.list();
        for(Course course :courses)
            System.out.println(course);
    }

    @Test
    public void testGetCourseById() {
        Course course = mapper.getCourseById(1);
        System.out.println(course);
    }

    @Test
    public void testInsert() {
        Course course = new Course("Java Programming");
        int effectedRow = mapper.insert(course);
        System.out.println(effectedRow);
    }

    @Test
    public void testUpdate() {
        Course course = new Course(5,"Java Programming1111");
        int effectedRow = mapper.update(course);
        System.out.println(effectedRow);
    }

    @Test
    public void testDelete() {
        int effectedRow = mapper.delete(5);
        System.out.println(effectedRow);
    }

}

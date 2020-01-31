package site.ilemon.springbootmybatis.dao;

import org.apache.ibatis.annotations.Param;
import site.ilemon.springbootmybatis.entity.Course;

import java.util.List;

public interface CourseMapper {

    public List<Course> list();

    public int insert(Course course);

    public Course getCourseById(@Param("id") int id);

    public int delete(@Param("id") int id);

    public int update(Course course);

}

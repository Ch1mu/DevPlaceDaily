package Dia19.EjerciciosManana19.services;

import Dia19.EjerciciosManana19.models.Course;
import Dia19.EjerciciosManana19.models.User;
import Dia19.EjerciciosManana19.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    CourseRepo cC;

    public Course saveCourse(Course c)
    {
        return  cC.save(c);
    }
    public ArrayList<Course> getCourses()
    {
        return (ArrayList<Course>) cC.findAll();
    }
    public Course editCourse(Course course, long id)
    {
        course.setId(id);
        return  cC.save(course);
    }
    public  Course getCourseById(long id)
    {
        return  cC.getCourseById(id);
    }
}

package Dia19.EjerciciosManana19.repositories;

import Dia19.EjerciciosManana19.models.Course;
import Dia19.EjerciciosManana19.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    public Course getCourseById(long id);

}

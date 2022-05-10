package com.example.EjerciciosManana18.controller.api;

import com.example.EjerciciosManana18.controller.service.StudentService;
import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {
    @Autowired
    private StudentService ss;
    
    @Autowired
    private SubjectService subs;
    

    @GetMapping(value = "/{pagNum}/{pagSize}",  produces = { "application/json", "application/xml" })
    public Page<Student> getAll( @PathVariable int pagNum, @PathVariable int pagSize) {

        return  ss.getAll(pagNum, pagSize);

    }
    @GetMapping(value = "/asc/{pagNum}/{pagSize}",  produces = { "application/json", "application/xml" })
    public Page<Student> asc( @PathVariable int pagNum, @PathVariable int pagSize) {

        return ss.ascendant(pagNum, pagSize);

    }
    @GetMapping(value = "/desc/{pagNum}/{pagSize}",  produces = { "application/json", "application/xml" })
    public Page<Student> desc( @PathVariable int pagNum, @PathVariable int pagSize) {

        return ss.desc(pagNum, pagSize);

    }



    @PostMapping("/createStudent")
    public ResponseEntity insertStudent(@RequestBody Student sub) {
        ss.insertStudent(sub);
        return ResponseEntity.ok().body("Success.");

    }



    @PutMapping("/update/{dni}")
    public ResponseEntity updateSubject(@RequestBody Student sub) {
        ss.updateStudent(sub);
        return ResponseEntity.ok().body("Success.");
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity deleteUser(@PathVariable("dni") long dni ){
        ss.deleteStudent(dni);
        return ResponseEntity.ok().body("Success.");
    }



    @GetMapping(value = "/byName",  produces = { "application/json", "application/xml" })
    public List<Student> byName(@RequestParam("name")String name)
    {
       return ss.byName(name);

    }



    @GetMapping(value = "/byLastname",  produces = { "application/json", "application/xml" })
    public List<Student> byLastName(@RequestParam("lastname")String name)
    {
        return ss.byLastName(name);
    }
}

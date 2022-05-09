package com.example.EjerciciosManana18.controller.api;

import com.example.EjerciciosManana18.controller.service.SubjectService;
import com.example.EjerciciosManana18.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectApiController {
    @Autowired
    private SubjectService ss;

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<Subject> getAll() {
      return ss.getAll();

    }



    @PostMapping("/createSubject")
    public ResponseEntity insertSubject(@RequestBody Subject sub) {
        ss.insertSubject(sub);
        return ResponseEntity.ok().body("Success.");
    }


    @PutMapping("/update/{code}")
    public ResponseEntity updateSubject(@RequestBody Subject sub, @PathVariable("code") long code) {
        ss.updateSubject(sub);
        return ResponseEntity.ok().body("Success.");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity deleteUser(@PathVariable("code") long code ){
        ss.deleteSubject(code);
        return ResponseEntity.ok().body("Success.");
    }
}




package com.bootcamp.Templates.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		name="registration"
)
public class Register {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.REMOVE })

	private Subjects subject;
	
	@ManyToOne(cascade = {CascadeType.REMOVE })

	private Students student;
	
	public Register(Subjects su, Students stu) {
		this.subject = su;
		this.student = stu;
	}
}

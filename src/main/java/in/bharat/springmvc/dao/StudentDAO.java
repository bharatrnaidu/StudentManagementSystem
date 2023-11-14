package in.bharat.springmvc.dao;

import java.util.List;

import in.bharat.springmvc.entity.Student;

public interface StudentDAO {
	 public List < Student > getStudents();

	 public void saveStudent(Student theStudent);

	 public Student getStudent(int theId);

	 public void deleteStudent(int theId);
}

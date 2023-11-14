package in.bharat.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.bharat.springmvc.entity.Student;
import in.bharat.springmvc.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	 @Autowired
	    private StudentService studentService;

	    @GetMapping("/list")
	    public String listStudents(Model theModel) {
	        List < Student > theStudents = studentService.getStudents();
	        theModel.addAttribute("students", theStudents);
	        return "student-list";
	    }

	    @GetMapping("/showForm")
	    public String showFormForAdd(Model theModel) {
	    	Student theStudent = new Student();
	        theModel.addAttribute("student", theStudent);
	        return "student-form";
	    }

	    @PostMapping("/saveCustomer")
	    public String saveStudent(@ModelAttribute("student") Student theStudent) {
	    	studentService.saveStudent(theStudent);
	        return "redirect:/student/list";
	    }

	    @GetMapping("/updateForm")
	    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
	        Student theStudent = studentService.getStudent(theId);
	        theModel.addAttribute("student", theStudent);
	        return "student-form";
	    }

	    @GetMapping("/delete")
	    public String deleteStudent(@RequestParam("studentId") int theId) {
	    	studentService.deleteStudent(theId);
	        return "redirect:/student/list";
	    }
}

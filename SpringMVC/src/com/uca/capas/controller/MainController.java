package com.uca.capas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {

	//Controlador por defecto
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("message", "Bienvenidos a MVC");
		return mav;

	}
	
	/*Controlador que recibe la informacion de la pagina central
	 *El valor de value debe ser igual a su contraparte del jsp*/
	@RequestMapping(value = "/formData", method = RequestMethod.POST)
	public ModelAndView formData(@RequestParam(value = "name") String name, @RequestParam(value = "lname") String lName,
			@RequestParam(value = "bdate") Date bDate, @RequestParam(value = "career") String career,
			@RequestParam(value="experience") String experience) {
		ModelAndView mav = new ModelAndView();
		Student student = new Student();
		student.setName(name);
		student.setLastName(lName);
		student.setbDate(new SimpleDateFormat("MM/dd/yyyy").format(bDate).toString());
		student.setCareer(career);
		student.setExperience(experience);
		mav.setViewName("form");
		mav.addObject("student",student);
		return mav;

	}
	
	/*Ejemplo de uso de @ResponseBody
	 * Este retorna contenido en formato JSON
	 * Para mapear una serie de objetos se usa la libreria jackson(Revisar presentacion 7)*/
	@RequestMapping(value="/rBody", produces = "application/json")
	@ResponseBody
	public ArrayList<Student> studentsList(){
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Hector","Matus","11/0/1996","Ing informatica","Estudiante"));
		students.add(new Student("Luis","Castro","11/0/1996","Ing informatica","Estudiante"));
		students.add(new Student("Juan","Lozano","11/0/1996","Ing informatica","Catedratico"));
		return students;
		
	}
	
	//Ejemplo basico de @ResponseBody
	@RequestMapping("/f")
	@ResponseBody
	public Student studentF() {
		Student student = new Student("Hector","Matus","11/0/1996","Ing informatica","Estudiante");
		return student;
		
	}

}

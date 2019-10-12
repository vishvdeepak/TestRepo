package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"isWorking\" : true }";
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		Iterable<Employee> result = employeeRepository.findAll();
		List<Employee> employeesList = new ArrayList<Employee>();
		result.forEach(employeesList::add);
		return employeesList;
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp;
	}

	@PutMapping("/employee/{id}")
	public Optional<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id) {
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		if (optionalEmp.isPresent()) {
			Employee emp = optionalEmp.get();
			emp.setEmp_first(newEmployee.getEmp_first());
			emp.setEmp_last(newEmployee.getEmp_last());
			emp.setEmp_dept(newEmployee.getEmp_dept());
			employeeRepository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/employee/{id}", produces = "application/json; charset=utf-8")
	public String deleteEmployee(@PathVariable Integer id) {
		Boolean result = employeeRepository.existsById(id);
		employeeRepository.deleteById(id);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		int id = new Random().nextInt();
		Employee emp = new Employee(id, newEmployee.getEmp_first(), newEmployee.getEmp_last(), newEmployee.getEmp_dept());
		employeeRepository.save(emp);
		return emp;
	}
}
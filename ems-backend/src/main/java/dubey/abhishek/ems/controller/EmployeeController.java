 package dubey.abhishek.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dubey.abhishek.ems.dto.EmployeeDto;
import dubey.abhishek.ems.service.EmployeeService;
import lombok.AllArgsConstructor;


/*
 *  Once we annotate a class with @RestController annotation
 *  then this class becomes a spring MVC REST controller
 *  and this class is capable to handle HTTP request
 *  
 *  @RequestMapping is used to define the base url for the
 *  REST APIs.
 */

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	//	ResponseEntity<> is a generic class we have to pass the type i.e EmployeeDto
	//	Build add employee REST API
	//  @RequestBody annotation will extract the JSON from the HTTP request
	//	and it will convert this JSON into employeeDto java object
	
	
	//  Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	
	//	Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	
	
	//	Build Get All Employee REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEMployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//	Build Update Employee REST API
	@PutMapping({"/{id}"})
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
													  @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	
	//	Build Delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok(employeeDto);
	}

}

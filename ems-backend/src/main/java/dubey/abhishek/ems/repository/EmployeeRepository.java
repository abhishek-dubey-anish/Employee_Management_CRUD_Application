package dubey.abhishek.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dubey.abhishek.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

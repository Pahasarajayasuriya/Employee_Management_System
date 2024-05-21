package com.ems.Employee.Management.System.mapper;

import com.ems.Employee.Management.System.dto.EmployeeDto;
import com.ems.Employee.Management.System.entity.Employee;
//map employee entity to employeedto
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
              employee.getId(),
              employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static Employee  mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirst_name(),
                employeeDto.getLast_name(),
                employeeDto.getEmail()
        );
    }
}

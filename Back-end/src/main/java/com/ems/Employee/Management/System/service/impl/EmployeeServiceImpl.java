package com.ems.Employee.Management.System.service.impl;

import com.ems.Employee.Management.System.dto.EmployeeDto;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.exception.ResourceNotFoundExecption;
import com.ems.Employee.Management.System.mapper.EmployeeMapper;
import com.ems.Employee.Management.System.repository.EmployeeRepository;
import com.ems.Employee.Management.System.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundExecption("Employee is not exists with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundExecption("Employee is not exists with give id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirst_name());
        employee.setLastName(updatedEmployee.getLast_name());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundExecption("Employee is not exists with give id: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }
}

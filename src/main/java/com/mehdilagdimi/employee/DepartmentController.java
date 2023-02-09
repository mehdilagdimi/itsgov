package com.mehdilagdimi.employee;

import com.mehdilagdimi.itsgovhealthcareservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/healthcare/department")
public class DepartmentController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public void addDepartment(@RequestBody DepartmentDto employeeDto) {
        try{
            Department department = departmentRepository.save(convertToEntity(employeeDto));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public DepartmentDto getDepartmentById(@PathVariable("id") Long id) {
        return convertToDto(departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));
    }

    private Department convertToEntity(DepartmentDto employeeDto) throws ParseException {
        Department employee = modelMapper.map(employeeDto, Department.class);
        return employee;
    }

    private DepartmentDto convertToDto(Department employee) {
        DepartmentDto employeeDto = modelMapper.map(employee, DepartmentDto.class);
        return employeeDto;
    }
}

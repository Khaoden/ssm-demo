package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeService employeeService;

    @Test
    void testService() {
        System.out.println(employeeService.getEmployeeById(1));
    }

    @Test
    void testmapper() {
        Employee emp = new Employee();
        emp.setName("小红");
        emp.setAge(18);
        emp.setEmail("123@qq.com");
        emp.setGender("女");
        emp.setBirth(new Date(2012, 10, 23));
        employeeMapper.addEmployee(emp);
    }

}

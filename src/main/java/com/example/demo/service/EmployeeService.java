package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.vo.req.EmployeeAddReq;
import com.example.demo.vo.req.EmployeeUpdateReq;
import com.example.demo.vo.resp.EmployeeResp;

import java.util.List;

public interface EmployeeService {
    EmployeeResp getEmployeeById(Integer id);

    void addEmployee(EmployeeAddReq employee);

    void updateEmployee(EmployeeUpdateReq employee);

    void deleteEmployeeById(Integer id);

    List<EmployeeResp> getAll();
}

package com.example.demo.service.Impl;

import com.example.demo.Exception.BizException;
import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import com.example.demo.vo.resp.EmployeeResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.vo.req.EmployeeAddReq;
import com.example.demo.vo.req.EmployeeUpdateReq;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.Exception.BizExceptionEnume.EMPLOYEE_ID_EMPTY;
import static com.example.demo.Exception.BizExceptionEnume.EMPLOYEE_NOT_EXIST;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public EmployeeResp getEmployeeById(Integer id) {
        if (id == null) {
            throw new BizException(EMPLOYEE_ID_EMPTY);
        }
        Employee employee = employeeMapper.getEmployeeById(id);
        if (employee == null) {
            throw new BizException(EMPLOYEE_NOT_EXIST);
        }
        EmployeeResp res = new EmployeeResp();
        BeanUtils.copyProperties(employee, res);
        return res;
    }

    @Transactional
    public void addEmployee(EmployeeAddReq req) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(req, employee);
        employeeMapper.addEmp(employee);
    }

    @Transactional
    public void updateEmployee(EmployeeUpdateReq req) {
        if (req.getId() == null) {
            throw new BizException(EMPLOYEE_ID_EMPTY);
        }
        
        Employee existingEmployee = employeeMapper.getEmployeeById(req.getId());
        if (existingEmployee == null) {
            throw new BizException(EMPLOYEE_NOT_EXIST);
        }
        
        Employee employee = new Employee();
        BeanUtils.copyProperties(req, employee);
        employeeMapper.updateEmployee(employee);
    }

    public void deleteEmployeeById(Integer id) {
        Employee employee = employeeMapper.getEmployeeById(id);
        if (employee == null) {
            throw new BizException(EMPLOYEE_NOT_EXIST);
        }
        employeeMapper.deleteEmployeeById(id);
    }

    @Transactional
    public List<EmployeeResp> getAll() {
        List<Employee> employeeList = employeeMapper.getAll();
        return employeeList.stream().map(employee -> {
            EmployeeResp employeeResp = new EmployeeResp();
            BeanUtils.copyProperties(employee, employeeResp);
            return employeeResp;
        }).toList();
    }
}

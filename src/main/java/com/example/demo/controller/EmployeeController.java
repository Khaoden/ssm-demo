package com.example.demo.controller;

import com.example.demo.common.R;
import com.example.demo.service.EmployeeService;
import com.example.demo.vo.req.EmployeeAddReq;
import com.example.demo.vo.req.EmployeeUpdateReq;
import com.example.demo.vo.resp.EmployeeResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@CrossOrigin
@RequestMapping("api/emp")
@RestController
@Validated
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "获取所有员工信息")
    @Parameter(name = "num", description = "页码")
    @GetMapping("/employee/page/{num}")
    public R<PageInfo<EmployeeResp>> getAllEmployee(@Valid @PathVariable(value = "num") int num) {
        PageHelper.startPage(num, 5);
        List<EmployeeResp> list = employeeService.getAll();
        return R.success(new PageInfo<>(list));
    }

    @Operation(summary = "根据id获取员工信息")
    @Parameter(name = "id", description = "员工id")
    @GetMapping("/employee/{id}")
    public R<EmployeeResp> getEmployeeById(@Valid @PathVariable("id") Integer id) {
        EmployeeResp employeeResp = employeeService.getEmployeeById(id);
        return R.success(employeeResp);
    }

    @Operation(summary = "添加员工信息")
    @Parameter(name = "employee", description = "员工信息")
    @PostMapping("/employee/add")
    public R<String> addEmployee(@Valid @RequestBody EmployeeAddReq employeeAddReq) {
        employeeService.addEmployee(employeeAddReq);
        return R.success();
    }

    @Operation(summary = "修改员工信息")
    @Parameter(name = "employee", description = "员工信息")
    @PutMapping("/employee/update")
    public R<String> updateEmployee(@Valid @RequestBody EmployeeUpdateReq employeeUpdateReq) {
        employeeService.updateEmployee(employeeUpdateReq);
        return R.success();
    }

    @Operation(summary = "删除员工信息")
    @Parameter(name = "id", description = "员工id")
    @DeleteMapping("/employee/delete/{id}")
    public R<String> deleteEmployeeById(@Valid @PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return R.success();
    }
}

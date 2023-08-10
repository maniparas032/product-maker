package com.electcomm.productmaker.controller;

import com.electcomm.productmaker.model.Department;
import com.electcomm.productmaker.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department)
    {
        Department savedDepartment = departmentService.addDepartment(department);
        return  new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED);
    }

}

package com.electcomm.productmaker.serviceImpl;

import com.electcomm.productmaker.dao.DepartmentDao;
import com.electcomm.productmaker.model.Department;
import com.electcomm.productmaker.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Department addDepartment(Department department) {
        Department savedDepartment =  departmentDao.save(department);
        return savedDepartment;
    }
}

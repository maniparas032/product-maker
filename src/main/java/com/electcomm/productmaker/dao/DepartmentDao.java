package com.electcomm.productmaker.dao;

import com.electcomm.productmaker.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}

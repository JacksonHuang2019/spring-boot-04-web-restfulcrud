package com.ccic.springboot.controller;

import com.ccic.springboot.dao.DepartmentDao;
import com.ccic.springboot.dao.EmployeeDao;
import com.ccic.springboot.entities.Department;
import com.ccic.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Author :hzs
 * @Date :Created in 16:53 2019/11/21
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面，查出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        // redirect 重定向到一个地址
        // forward 转发到一个地址
        return "redirect:/emps";
    }

    // 去修改页面
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/add";
    }
}

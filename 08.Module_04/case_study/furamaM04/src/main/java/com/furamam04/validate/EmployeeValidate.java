package com.furamam04.validate;

import com.furamam04.entity.Employee;
import com.furamam04.entity.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// test thôi ko làm vào việc gì
public class EmployeeValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Employee))
            return;
        Employee employee = (Employee) target;
        // validate so dien thoai
        if (employee.getSalary() % 1 != 0)
            errors.rejectValue("salary", "integer", "Vui lòng nhập số nguyên dương");
        // validate tuoi khong duoc de trong
//        if (employee.getAge()==null)
//            errors.rejectValue("age", "age", "không được để trống");
    }
}

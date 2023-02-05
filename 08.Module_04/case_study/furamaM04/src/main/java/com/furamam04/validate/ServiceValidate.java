package com.furamam04.validate;

import com.furamam04.entity.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServiceValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Service.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Service))
            return;
        Service service = (Service) target;
        // validate so dien thoai
        if (service.getServiceMaxPeople() == null)
            errors.rejectValue("serviceMaxPeople", "integer", "Vui lòng nhập số nguyên dương");
        // validate tuoi khong duoc de trong
//        if (service.getAge()==null)
//            errors.rejectValue("age", "age", "không được để trống");
    }
}

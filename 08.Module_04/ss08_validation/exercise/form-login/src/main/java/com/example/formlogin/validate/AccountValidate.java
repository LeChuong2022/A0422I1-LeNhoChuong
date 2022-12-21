package com.example.formlogin.validate;

import com.example.formlogin.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AccountValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Account))
            return;
        Account account = (Account) target;
        // validate so dien thoai
        if (account.getPhoneNumber().length()!=10)
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"},"Số điện thoại không đúng định dạng");
        else if (!account.getPhoneNumber().startsWith("0"))
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        // validate tuoi khong duoc de trong
//        if (account.getAge()==null)
//            errors.rejectValue("age", "age", "không được để trống");

    }
}

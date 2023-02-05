package com.furamam04.validate;

import com.furamam04.entity.Contract;
import com.furamam04.entity.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Contract))
            return;
        Contract contract = (Contract) target;
        // validate so dien thoai
        if (contract.getContractStartDate().after(contract.getContractEndDate()))
            errors.rejectValue("contractStartDate", "day", "Vui lòng nhập ngày kết thúc sau ngày bắt đầu");

        if (contract.getContractStartDate()==null)
            errors.rejectValue("contractStartDate", "", "không được để trống");
        if (contract.getContractEndDate() == null)
            errors.rejectValue("contractEndDate", "", "không được để trống");
    }
}

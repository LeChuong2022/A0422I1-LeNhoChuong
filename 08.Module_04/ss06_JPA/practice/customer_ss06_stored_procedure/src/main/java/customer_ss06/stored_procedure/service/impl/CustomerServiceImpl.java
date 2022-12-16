package customer_ss06.stored_procedure.service.impl;

import customer_ss06.stored_procedure.bean.Customer;
import customer_ss06.stored_procedure.repository.ICustomerRepository;
import customer_ss06.stored_procedure.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public boolean insertCustomerWithStoredProcedure(Customer customer) {
        return customerRepository.insertCustomerWithStoredProcedure(customer);
    }
}

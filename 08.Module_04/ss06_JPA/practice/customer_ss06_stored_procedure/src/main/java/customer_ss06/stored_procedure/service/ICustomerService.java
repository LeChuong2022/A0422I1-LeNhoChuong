package customer_ss06.stored_procedure.service;

import customer_ss06.stored_procedure.bean.Customer;

public interface ICustomerService {
    boolean insertCustomerWithStoredProcedure(Customer customer);

}

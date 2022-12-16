package customer_ss06.stored_procedure.repository;

import customer_ss06.stored_procedure.bean.Customer;

public interface ICustomerRepository {
    boolean insertCustomerWithStoredProcedure(Customer customer);
}

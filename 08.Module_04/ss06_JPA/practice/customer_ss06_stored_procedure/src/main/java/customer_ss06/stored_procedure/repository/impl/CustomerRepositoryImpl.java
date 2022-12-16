package customer_ss06.stored_procedure.repository.impl;

import customer_ss06.stored_procedure.bean.Customer;
import customer_ss06.stored_procedure.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean insertCustomerWithStoredProcedure(Customer customer) {
        String sql = "call insert_customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}

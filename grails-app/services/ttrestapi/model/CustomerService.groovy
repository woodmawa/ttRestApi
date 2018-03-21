package ttrestapi.model

import grails.gorm.services.Service

@Service(Customer)
interface CustomerService {

    Customer get(Serializable id)

    Customer get(Serializable id, Map args )

    List<Customer> list(Map args)

    Long count()

    void delete(Serializable id)

    Customer save(Customer customer)

}
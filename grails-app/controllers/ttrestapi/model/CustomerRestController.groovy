package ttrestapi.model

import grails.validation.ValidationException
import grails.web.servlet.mvc.GrailsParameterMap
import groovy.transform.CompileStatic

import static org.springframework.http.HttpStatus.*

@CompileStatic
class CustomerRestController {

    static responseFormats = ['json']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    CustomerService customerService

    def index(Integer max) {
        println "CustomerRest.customerRest.index method invoked"
        params.max = Math.min(max ?: 10, 100)
        params.put("fetch", [sites:"join"])   //force join fetch on sites
        println "param map to customerService contains $params"

        Collection result = customerService.list(params)
        println "service returned collection  $result"

 //       respond customerService.list(params), [ttrestapi.model:[customerCount: customerService.count()], view:"fred"]
        respond result, [model:[customerCount: customerService.count()]]
    }

    def show(Long id) {
        println "CustomerRest.customerRest.show method invoked"
        //respond customerService.get(id), view:"fred"
        respond customerService.get(id)
    }

    /*
    def create() {
        respond new Customer(params)
    }

    def save(Customer customer) {
        if (customer == null) {
            notFound()
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException e) {
            respond customer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*' { respond customer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerService.get(id)
    }

    def update(Customer customer) {
        if (customer == null) {
            notFound()
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException e) {
            respond customer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*'{ respond customer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), id])
                redirect action:"customerRest.index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])
                redirect action: "customerRest.index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    */
}

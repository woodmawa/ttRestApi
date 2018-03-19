package model

import grails.validation.ValidationException
import groovy.transform.CompileStatic

import static org.springframework.http.HttpStatus.*

@CompileStatic
class CustomerRestController {

    static responseFormats = ['json']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    CustomerService customerService

    def index(Integer max) {
        println "CustomerRest.index method invoked"
        params.max = Math.min(max ?: 10, 100)
        respond customerService.list(params), [model:[customerCount: customerService.count()], view:"fred"]
    }

    def show(Long id) {
        println "CustomerRest.show method invoked"
        respond customerService.get(id), view:"fred"
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
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    */
}

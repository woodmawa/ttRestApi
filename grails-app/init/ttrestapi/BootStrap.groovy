package ttrestapi

import model.Customer
import model.Site

class BootStrap {

    def init = { servletContext ->
        new Book (name:"book1").save(failOnError: true)
        new Book (name:"book2").save(failOnError: true)
        new JsonApiBook (name:"json api book#1").save(failOnError: true)
        new JsonApiBook (name:"json api book#2").save(failOnError: true)

        def hsbc = new Customer (name: "HSBC").save(failOnError: true)
        def asda = new Customer (name: "ASDA").save(failOnError: true)
        hsbc.addToSites (new Site(name:"Canary Wharf"))
    }

    def destroy = {
    }
}

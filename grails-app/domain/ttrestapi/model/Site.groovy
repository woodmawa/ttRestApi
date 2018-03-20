package ttrestapi.model

class Site {

    static constraints = {
    }

    static belongsTo  = [customer:Customer]

    String name
    Customer customer
}

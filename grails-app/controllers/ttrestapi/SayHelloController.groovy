package ttrestapi

class SayHelloController {

    def index() { render "Hello William!"}

    def work () {
        println "sayHelloController: controller 'work' action called with ${params.restAction}"
        render "{doing work '$params.restAction'}"
    }

}

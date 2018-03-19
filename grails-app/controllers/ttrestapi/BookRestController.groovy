package ttrestapi

import grails.rest.RestfulController

class BookRestController extends RestfulController {

    BookRestController () {
        super (Book)
    }

    static responseFormats = ['json', 'html']
    //dummied up a response object to render to json
    def index() {
        respond ([name:"book1"])/*Book.list()*/ }

    //override methods as required to customise
    //http://docs.grails.org/3.0.7/api/grails/rest/RestfulController.html
    @Override
    protected Book queryForResource (Serializable id) {
        //etc
    }
}

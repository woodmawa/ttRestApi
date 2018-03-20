package ttrestapi

class BookController  {

    static responseFormats = ['json', 'html']
    //customerRest.show list of pre saved Books from bootstrap
    def index() { respond (Book.list()) }
    def index2() {
        //dummy a response using no domain class
        respond ([name:"book1"]) }
}

package ttrestapi

import grails.rest.*

//expose as rest resoure at stated uri
@Resource (uri='/api/jsonApiBook', formats=['json','xml'])
class JsonApiBook {

    static constraints = {
    }

    String name
}

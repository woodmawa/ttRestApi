package ttrestapi

import ttrestapi.model.Customer

class UrlMappings {

    static mappings = {

        "/api/customers"(resources:"customerRest")

        //or try to declare with explicit mappings
        "/api/sites" (controller: "siteRest", action: "index")
        "/api/sites/$id" (controller: "siteRest", action: "show", view: "customerRest.show")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

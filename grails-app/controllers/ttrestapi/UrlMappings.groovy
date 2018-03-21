package ttrestapi

import ttrestapi.model.Customer

class UrlMappings {

    static mappings = {

        post "/sayHello/$restAction" {
            controller =  "sayHello"
            action = "work"
        }

        get "/sayHello" (controller:"sayHello")


        "/api/customers"(resources:"customerRest")
        /** not strictly restful - but can trigger controller action
         * and params.task will be the 'work' that needs to be executed,
         * can be invoked like localhost:8080/api/customers/do/activate?backup=anytime
         * and get params map like [backup = anytime, controller = customerRest, task = activate, action = action]
         **/
        "/api/customers/do/$task?" {
            controller = "customerRest"
            action = "action"
        }


        /*
        //or try to declare with explicit mappings
        "/api/sites" (controller: "siteRest", action: "index")
        "/api/sites/$id" (controller: "siteRest", action: "show" )
        post "/api/sfred" {
            controller = "siteRest"
            action = "work"
        }//(controller: "siteRest", action: "work")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

package model

class Customer {

    static constraints = {
        sites nullable: true
    }

    static hasMany = [sites:Site]

    String name
    Collection sites

}

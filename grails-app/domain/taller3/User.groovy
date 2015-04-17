package taller3

class User {
    String name
    String lastname
    int age
    String username
    String password
    static constraints = {
        name( blank : false, minSize : 3, maxSize : 50 )
        lastname( blank : false, minSize : 3, maxSize : 50 )
        age( min: 13 )
        username( blank : false, unique: true )
        password( blank : false, minSize: 8, matches: "[a-zA-Z0-9]*([a-z][a-zA-Z0-9]*[A-Z][a-zA-Z0-9]*[0-9]|[a-z][a-zA-Z0-9]*[0-9][a-zA-Z0-9]*[A-Z]|[A-Z][a-zA-Z0-9]*[a-z][a-zA-Z0-9]*[0-9]|[A-Z][a-zA-Z0-9]*[0-9][a-zA-Z0-9]*[a-z]|[0-9][a-zA-Z0-9]*[a-z][a-zA-Z0-9]*[A-Z]|[0-9][a-zA-Z0-9]*[A-Z][a-zA-Z0-9]*[a-z])[a-zA-Z0-9]*" )
    }

    static mapping ={
        tablePerHierarchy true
    }
    String toString(){
        username
    }
}

package forum

class User {

    String name
    String lastname
    int age
    String username
    String password

    static constraints = {

        name blank: false, size: 3..50
        lastname blank: false, size: 3..50
        age min: 13 
        username blank: false, unique: true
        password blank: false, matches: "(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{8,}"

    }
    
    //Así lo maneja Grails por defecto...
    static mapping = {

        tablePerHierarchy true

    }

}

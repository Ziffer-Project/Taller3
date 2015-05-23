package forum

class Admin extends User {

    int level
    double rating

    static hasMany = [ forums: Forum ]

    static constraints = {

        level range: 1..5
        rating min: 0 as Double, max: 100 as Double
        forums nullable: true

    }

    static mapping = {

        sort level: 'desc'

    }
}
    

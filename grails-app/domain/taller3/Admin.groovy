package taller3

class Admin extends User {
    int level
    double rating

    static constraints = {
        level( range: 1..5 )
        rating( validator: {rating -> if(rating.isNaN()) return false else if( rating <= 100.0 && rating >= 0.0) return true else return false} )
    }

    static hasMany = [fora: Forum]

}
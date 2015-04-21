package taller3

class Regular {
    int postViews = 0
    int strikesNumber
    int starsNumber

    static constraints = {
        strikesNumber( range: 0..3 )
        starsNumber( range: 0..5 )
    }

    static hasMany=[posts: Post]

}

package forum

class Regular extends User{

    int postViews
    int strikesNumber
    int starsNumber

    static hasMany = [ posts: Post ]
    static constraints = {

        strikesNumber range: 0..3
        starsNumber range: 0..5
        postViews min: 0
        posts nullable: true

    }

}

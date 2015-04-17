package taller3

class Forum {
    String name
    Date dateCreated
    String category
    static constraints = {
        name( blank: false, unique: true, size: 3..20 )
        dateCreated( blank: false, nullable: false, validator: {date-> date.after(GregorianCalendar.getInstance().getTime())} )
        category( blank: false, size: 3..15 )
    }

    List<Post> posts
    //static hasMany=[posts:Post]

    def beforeInsert={
        dateCreated=new Date()
    }
}

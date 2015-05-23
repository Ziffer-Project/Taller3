package forum

class Post {

    String topic
    Date dateCreated
    Date lastUpdated
    boolean itsAllowed
    ArrayList<String> comments

    static hasMany = [ files: File ]

    static belongsTo = [ forum: Forum, regular: Regular ]

    static constraints = {

        topic blank: false, size: 3..50
        dateCreated validator: {return (it >= new Date())}
        lastUpdated validator: {return (it >= new Date())}
        files nullable: true

    }

    static mapping = {

        regular column: 'owner_id'        
        forum column: 'fatherForum_id'

    }


    //Estos métodos también son redudantes pero se añaden por requisito del taller
    def beforeInsert() {

        dateCreated = new Date()

    }

    def beforeUpdate() {

        lastUpdate = new Date()

    }

}

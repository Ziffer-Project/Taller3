package taller3

class Post {
    String topic
    Date dateCreated
    Date lastupdate
    boolean itsAllowed

    static constraints = {
        topic( blank: false, size: 3..50)
        dateCreated( blank: false, nullable: false, validator: {date-> date.after(GregorianCalendar.getInstance().getTime())} )
        lastupdate( blank: false, nullable: false, validator: {date-> date.after(GregorianCalendar.getInstance().getTime())} )
        itsAllowed()
    }

    static hasMany = [files: File]
    static belongsTo = [forum: Forum, regular: Regular]

    static mapping = {
        table 'Regular'
        id column: 'owner_id'
        table 'Forum'
        id column: 'fatherForum_id'
    }

    def beforeInsert() {
        this.dateCreated = new Date()
    }

    def beforeUpdate() {
        this.lastUpdate = new Date()
    }

    void comment() {}
    void rate() {}
    void share() {}
}

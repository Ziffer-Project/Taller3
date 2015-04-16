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

    void comment(){}
    void rate(){}
    void share(){}
}

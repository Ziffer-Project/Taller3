package forum

class Forum {

    String name
    Date dateCreated
    String category

    static hasMany = [ post: Post ]

    static constraints = {

        name blank: false, unique: true, size: 3..20
        dateCreated validator: {return (it >= new Date())}
        category blank: false, size: 3..15
        post nullable: true

    }

    //No hay ningún requisito para eliminar foros si se elimina el admin

    def beforeInsert() {

        dateCreated = new Date()

    }

}

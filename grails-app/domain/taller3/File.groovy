package taller3

class File {
    String fileType
    Byte[] content
    double size
    static constraints = {
        fileType( blank: false, matches: "[^/]+(/[^/]+)+" )
        content( )
        size( validator: { size-> if(size.isNaN() || size > (1024*1024*10))return false else return true })
    }

    static belongsTo = [post: Post]

    static mapping = {
        table 'Post'
        id column: 'post_belongs_id'
    }
}

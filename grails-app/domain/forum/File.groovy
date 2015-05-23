package forum

class File {

    String fileType
    byte[] content
    double size

    static belongsTo = [ post: Post ]

    static constraints = {

        fileType blank: false, matches: "\\w+\\/[\\w+-\\.\\+]+"
        content maxSize: 1024*1024*10
        size max: 1024*1024*10 as Double

    }

    static mapping = {

        post column: 'post_belongs_id'

    }

    void download() {}

    void share() {}
}

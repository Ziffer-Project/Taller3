package taller3

class File {
    String fileType
    Byte[] content
    double size
    static constraints = {
        fileType( blank: false, matches: "[^/]+(/[^/]+)+" )
        content( )
        size( validator: { size-> if(size.isNaN() || size > 10000000)return false else return true })
    }

    void download(){

    }

    void share(){

    }
}

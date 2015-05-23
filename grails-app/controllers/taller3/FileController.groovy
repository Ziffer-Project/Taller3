package taller3



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        render File.list()
    }

    def show(File fileInstance) {
        respond fileInstance
    }

    def create() {
        respond new File(params)
    }

    @Transactional
    def save(File fileInstance) {
        if (fileInstance == null) {
            notFound()
            return
        }

        if (fileInstance.hasErrors()) {
            println fileInstance.errors
            return
        }

        fileInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'file.label', default: 'File'), fileInstance.id])
                redirect fileInstance
            }
            '*' { respond fileInstance, [status: CREATED] }
        }
    }

    def upload() {
        def file = request.getFile('file')

        if (file.isEmpty()) {
            flash.message = "No puedes subir un archivo vacio"
        } else if (!file.getContentType().equals("text/plain") && !file.getContentType().equals("image/png")) {
            flash.message = "El archivo debe ser un texto plano (.txt) o una imagen (.png)."
        } else {
            def fileToUpload = new File()
            fileToUpload.fileType = file.getContentType()
            fileToUpload.size = file.getSize()
            fileToUpload.content = file.getBytes()
            this.save(fileToUpload)
        }
    }

    def edit(File fileInstance) {
        respond fileInstance
    }

    @Transactional
    def update(File fileInstance) {
        if (fileInstance == null) {
            notFound()
            return
        }

        if (fileInstance.hasErrors()) {
            respond fileInstance.errors, view:'edit'
            return
        }

        fileInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'File.label', default: 'File'), fileInstance.id])
                redirect fileInstance
            }
            '*'{ respond fileInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(File fileInstance) {

        if (fileInstance == null) {
            notFound()
            return
        }

        fileInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'File.label', default: 'File'), fileInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def share() { render "Esta funcionalidad no ha sido implementada" }

    def download() {

        def file = File.get(params.actualFile)

        if (file == null) {
            flash.message = "Archivo no encontrado."
        } else {
            response.setContentType(file.getContentType())
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${file.name}\"")
            def outputStream = response.getOutputStream()
            outputStream << file.getBytes()
            outputStream.flush()
            outputStream.close()
        }

    }

    protected void notFound() {
        println 'File instance with id = $params.id not found'
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'file.label', default: 'File'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def beforeInterceptor = {
        println "Se va a ejecutar la accion: $actionName"
    }

    def afterInterceptor = {
        println "Se ha ejecutado la accion: $actionName"
    }

}

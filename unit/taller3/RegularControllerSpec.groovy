package taller3



import grails.test.mixin.*
import spock.lang.*

@TestFor(RegularController)
@Mock(Regular)
class RegularControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.regularInstanceList
            model.regularInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.regularInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def regular = new Regular()
            regular.validate()
            controller.save(regular)

        then:"The create view is rendered again with the correct model"
            model.regularInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            regular = new Regular(params)

            controller.save(regular)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/regular/show/1'
            controller.flash.message != null
            Regular.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def regular = new Regular(params)
            controller.show(regular)

        then:"A model is populated containing the domain instance"
            model.regularInstance == regular
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def regular = new Regular(params)
            controller.edit(regular)

        then:"A model is populated containing the domain instance"
            model.regularInstance == regular
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/regular/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def regular = new Regular()
            regular.validate()
            controller.update(regular)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.regularInstance == regular

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            regular = new Regular(params).save(flush: true)
            controller.update(regular)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/regular/show/$regular.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/regular/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def regular = new Regular(params).save(flush: true)

        then:"It exists"
            Regular.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(regular)

        then:"The instance is deleted"
            Regular.count() == 0
            response.redirectedUrl == '/regular/index'
            flash.message != null
    }
}

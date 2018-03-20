package ttrestapi.model

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class SiteControllerSpec extends Specification implements ControllerUnitTest<SiteController>, DomainUnitTest<Site> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the customerRest.index action returns the correct ttrestapi.model"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The customerRest.index action is executed"
        controller.index()

        then:"The ttrestapi.model is correct"
        !model.siteList
        model.siteCount == 0
    }

    void "Test the create action returns the correct ttrestapi.model"() {
        when:"The create action is executed"
        controller.create()

        then:"The ttrestapi.model is correctly created"
        model.site!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/site/customerRest.index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * save(_ as Site)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def site = new Site(params)
        site.id = 1

        controller.save(site)

        then:"A redirect is issued to the customerRest.show action"
        response.redirectedUrl == '/site/customerRest.show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * save(_ as Site) >> { Site site ->
                throw new ValidationException("Invalid instance", site.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def site = new Site()
        controller.save(site)

        then:"The create view is rendered again with the correct ttrestapi.model"
        model.site != null
        view == 'create'
    }

    void "Test the customerRest.show action with a null id"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * get(null) >> null
        }

        when:"The customerRest.show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the customerRest.show action with a valid id"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * get(2) >> new Site()
        }

        when:"A domain instance is passed to the customerRest.show action"
        controller.show(2)

        then:"A ttrestapi.model is populated containing the domain instance"
        model.site instanceof Site
    }

    void "Test the edit action with a null id"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * get(null) >> null
        }

        when:"The customerRest.show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * get(2) >> new Site()
        }

        when:"A domain instance is passed to the customerRest.show action"
        controller.edit(2)

        then:"A ttrestapi.model is populated containing the domain instance"
        model.site instanceof Site
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/site/customerRest.index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * save(_ as Site)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def site = new Site(params)
        site.id = 1

        controller.update(site)

        then:"A redirect is issued to the customerRest.show action"
        response.redirectedUrl == '/site/customerRest.show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * save(_ as Site) >> { Site site ->
                throw new ValidationException("Invalid instance", site.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new Site())

        then:"The edit view is rendered again with the correct ttrestapi.model"
        model.site != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/site/customerRest.index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.siteService = Mock(SiteService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to customerRest.index"
        response.redirectedUrl == '/site/customerRest.index'
        flash.message != null
    }
}







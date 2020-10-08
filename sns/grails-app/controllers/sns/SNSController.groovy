package sns

import grails.core.GrailsApplication

class SNSController {

    GrailsApplication grailsApplication
    def SNSService
    def index() {
        // Application.ymlの（pushMessage）を
        String push = grailsApplication.config.getProperty('push')
        SNSService.test()
        render 'aiueo'
    }
}

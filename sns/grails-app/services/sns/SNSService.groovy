package sns

import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional

@Transactional
class SNSService {
    GrailsApplication grailsApplication
    def serviceMethod() {

    }
    def test() {
        String push = grailsApplication.config.getProperty('push')
        println(push)
    }
}

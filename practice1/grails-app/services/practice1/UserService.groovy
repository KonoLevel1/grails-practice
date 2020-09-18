package practice1

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def serviceMethod() {

    }

    def saveUser(User user){
        user.save(flush: true, failOnError: true)
    }
}

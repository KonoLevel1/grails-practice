package practice1

import grails.gorm.transactions.Transactional

@Transactional
class MoneyService {

    def serviceMethod() {

    }

    def saveMoney(Money money){
        money.save(flush: true, failOnError: true)
    }
}

package practice1

import grails.gorm.transactions.Transactional

// AWS SNS
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model.PublishRequest
import software.amazon.awssdk.services.sns.model.SnsException

@Transactional
class MoneyService {

    def serviceMethod() {

    }

    def saveMoney(Money money){
        sendPush()
        money.save(flush: true, failOnError: true)
    }
    def void sendPush(){
        println("IN : sendPush")
        SnsClient snsClient = SnsClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()
        try {
            PublishRequest request = PublishRequest.builder()
                    .message('{"default": "新しい収支が登録されました" ,"email": "新しい収支が登録されました","APNS": {"aps":{"alert":"新しい収支が登録されました"}}}')
                    .topicArn(---)
                    .messageStructure("json")
                    .build()
            snsClient.publish(request)
        } catch (SnsException e) {
            log.error String.format("プッシュ通知送信エラー: エラー内容： %s", e)
        }
    }
}

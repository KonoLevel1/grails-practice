package sns

import grails.gorm.transactions.Transactional

// AWS SNS
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model.PublishRequest
import software.amazon.awssdk.services.sns.model.SnsException
import software.amazon.awssdk.services.sns.model.SubscribeRequest

@Transactional
class SnsService {

    /**
     * トピックに登録された通知先に対してメッセージ通知を飛ばす
     * @param message
     * @param topicArn
     * @return infoMessage
     */
    String sendMessage(String message, String topicArn) {
        String infoMessage = ""

        SnsClient snsClient = SnsClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()

        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topicArn)
                    .build()
            snsClient.publish(request)
            infoMessage = "通知の送信に成功しました。"
        } catch (SnsException e) {
            infoMessage = "通知を送信できませんでした：" + e
        }
        return infoMessage
    }

    /**
     * EmailアドレスをAWS-SNSのトピックに登録する
     * @param email
     * @param topicArn
     * @return infoMessage
     */
    String registerEmail(String email, String topicArn) {
        String infoMessage = ""

        SnsClient snsClient = SnsClient.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()

        try {
            SubscribeRequest request = SubscribeRequest.builder()
                    .topicArn(topicArn)
                    .endpoint(email)
                    .protocol("email")
                    .build()
            snsClient.subscribe(request)
            infoMessage = email + "を登録しました。メール受信者に、メール内容を確認し、通知の許可をもらってください。"
        } catch (SnsException e) {
            infoMessage = "メールアドレスを登録できませんでした：" + e
        }
        return infoMessage
    }

    /**
     * 入力されたメールアドレスと再入力されたメールアドレスが正しいかを判定する
     * @param email
     * @param reEmail
     * @return boolean
     */
    Boolean checkEmail(String email, String reEmail) {
        if (email.equals(reEmail)){
            return false
        }else{
            return true
        }
    }

}

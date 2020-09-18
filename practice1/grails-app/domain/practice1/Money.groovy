package practice1

import java.time.LocalDateTime

class Money {

    /**
     * ユーザーID
     */
    Integer userId

    /**
     * メモ
     */
    String memo

    /**
     * 金額
     */
    Integer money

    /**
     * 作成日時
     */
    LocalDateTime createTime = LocalDateTime.now()

    /**
     * 削除フラグ
     */
    Integer deleteFlag = 0

    static constraints = {
    }

    static belongsTo = [user: User]

    // データベースにドメインクラスをマップする方法を設定する
    static mapping = {
        userId column: 'user_id'
        memo column: 'memo'
        money column: 'money'
        createTime column: 'create_time'
        deleteFlag column: 'delete_flag'
    }
}

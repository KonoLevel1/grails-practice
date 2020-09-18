package practice1

import java.time.LocalDateTime

class User {

    /**
     * ユーザー名
     */
    String userName

    /**
     * ユーザーパスワード
     */
    String password

    /**
     * 作成日時
     */
    LocalDateTime createTime = LocalDateTime.now()

    /**
     * 最終更新日時
     */
    LocalDateTime updateTime = LocalDateTime.now()

    /**
     * 削除フラグ
     */
    Integer deleteFlag = 0

    // 制約を設定する
    static constraints = {
    }

    // リレーショナル
    static hasMany = [
            money: Money
    ]

    // データベースにドメインクラスをマップする方法を設定する
    static mapping = {
        userName column: 'user_name'
        password column: 'password'
        createTime column: 'create_time'
        updateTime column: 'update_time'
        deleteFlag column: 'delete_flag'
    }
}

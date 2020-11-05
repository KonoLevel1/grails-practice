## ドメインの基本的な構成
```
package hoge

import java.time.LocalDateTime

class OfferDetail {

    // プロパティの定義

    /**
    * ID
    */
    Integer id

    /**
     * 年齢
     */
    Integer age

    /**
     * 氏名
     */
    String name

    /**
    * 一言
    */
    String message
    /**
     * 作成日時
     */
    LocalDateTime createTime = LocalDateTime.now()

    // リレーションの設定

    static belongsTo = [offer : Offer]
    Offer offer

    // 制約の設定

    static constraints = {

        // id に 一意性制約を設定
        id unique: true

        // age に 下限0、上限150を設定
        age min: 0, max: 150

        // name に 1~20文字数制限と空白禁止を設定
        name size: 1..20, blank: false

        // message に 0~200文字数制限とnull許容を設定
        message size: 0..200, nullable: true
    }

    // マッピングの設定
    /**
    * GORMがドメインクラスをデータベースにマッピングする方法を構成する。
    */

    static mapping = {

        // テーブルを設定
        table 'hoge_table'
        version false
        id column: 'user_id'
        age column: 'age'

        // プロパティの name と DBの name を紐付ける
        name column: 'name'
    }
}
```

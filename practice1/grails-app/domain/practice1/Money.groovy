package practice1

import java.sql.SQLException
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
     * 収入金額
     */
    Integer incomeAmount

    /**
     * 支出金額
     */
    Integer spendingAmount

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

    //static belongsTo = [user: User]

    // データベースにドメインクラスをマップする方法を設定する
    static mapping = {
        userId column: 'user_id'
        memo column: 'memo'
        incomeAmount column: 'income_amount'
        spendingAmount column: 'spending_amount'
        createTime column: 'create_time'
        deleteFlag column: 'delete_flag'

        sort createTime: 'desc'

        // バージョンのカラムは生成しない
        version false
    }

    /**
     * 残高算出
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return
     * @throws SQLException
     */
    static List<ArrayList> totalFee(Integer userId) throws SQLException {
       return Money.executeQuery(
               "select sum(m.amount) from Money m where m.userId = :userId AND m.deleteFlag = 0",[userId: userId])
    }
}

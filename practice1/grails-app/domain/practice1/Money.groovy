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
        incomeAmount nullable : true, max : 999999999, min : 1
        spendingAmount nullable : true, max : 999999999, min : 1
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
     * 収入総計計算
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return
     * @throws SQLException
     */
    static Integer totalIncome(Integer userId) throws SQLException {
       def total = Money.executeQuery(
               "select sum(m.incomeAmount) from Money m where m.userId = :userId AND m.deleteFlag = 0",[userId: userId])
        if (total[0] == null){
            return 0
        }
        return total[0]
    }

    /**
     * 支出総計計算
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return
     * @throws SQLException
     */
    static Integer totalSpending(Integer userId) throws SQLException {
        def total =  Money.executeQuery(
                "select sum(m.spendingAmount) from Money m where m.userId = :userId AND m.deleteFlag = 0",[userId: userId])
        if (total[0] == null){
            return 0
        }
        return total[0]
    }

    /**
     * 支出総計計算
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return Integer
     */
    static Integer totalFee(Integer userId){
        def totalIncome = totalIncome(userId)
        def totalSpending = totalSpending(userId)
        println("金額確認" + totalSpending + " " + totalIncome)
        return totalIncome - totalSpending
    }

    /**
     * 全収支論理削除
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return
     * @throws SQLException
     */
    static void allDelete(Integer userId) throws SQLException {
        Money.executeQuery("update Money set deleteFlag = 0 where userId = :userId AND deleteFlag = 0",[userId: userId])
    }

    /**
     * 該当ユーザー全情報取得
     * 条件　ユーザーIDが同じで論理削除されていない収支
     * @param userId
     * @return
     * @throws SQLException
     */
    static List<ArrayList> testAll(Integer userId) throws SQLException {
        return Money.executeQuery(
                "select format(incomeAmount, '#,###') from Money m where m.userId = :userId AND m.deleteFlag = 0",[userId: userId])
    }


}

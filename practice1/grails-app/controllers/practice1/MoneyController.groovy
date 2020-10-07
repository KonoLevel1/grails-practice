package practice1

class MoneyController {

    def MoneyService
    def index() {}

    /**
     * 収入登録
     * @param amount : 金額
     * @return
     */
    def plus(){
        User user = User.findByUserName(params.userName)
        Money money = new Money(userId: user.id, incomeAmount: params.amount, memo: params.memo)
        if((params.amount).isEmpty()){
            flash.message = "金額を入力してください"
        }else{
            if (money.validate()){
                MoneyService.saveMoney(money)
            }else{
                flash.message = "入力内容が不適切です。"
            }
        }
        redirect(action:"mainInfo",params:[id: user.id, userName: params.userName])
    }

    def minus(){
        User user = User.findByUserName(params.userName)
        Money money = new Money(userId: user.id, spendingAmount: params.amount, memo: params.memo)
        if((params.amount).isEmpty()){
            flash.message = "金額を入力してください"
        }else{
            if (money.validate()){
                MoneyService.saveMoney(money)
            }else{
                flash.message = "入力内容が不適切です。"
            }
        }
        redirect(action:"mainInfo",params:[id: user.id, userName: params.userName])
    }

    def mainInfo(Integer id, String userName){
        def moneys = Money.findAll{userId == id && deleteFlag == 0}
        //def moneys = Money.testAll(id)
        def totalFee = String.format("%,d",Money.totalFee(id))
        render(view: "/user/info.gsp", model:[Moneys: moneys,userName: userName, totalFee: totalFee])
    }

    def delete(Integer id, Integer userId){
        User user = User.findById(userId)
        Money money = Money.findById(id)
        money.setDeleteFlag(1)
        if (money.validate()){
            MoneyService.saveMoney(money)
            redirect(action:"mainInfo",params:[id:user.id,userName:user.userName])
        }else{
            println("入力項目がおかしいです")
            flash.message = "入力項目がおかしいです"
            def moneys = Money.findAllByUserId(user.id)
            render(view: "/user/info.gsp", model:[Moneys: moneys,userName: userName])
        }
    }

    def update(Integer id, Integer userId){
        User user = User.findById(userId)
        Money money = Money.findById(id)
        def incomeMemo = ""
        def spendingMemo = ""
        def incomeOldAmount = ""
        def spendingOldAmount = ""
        if (money.getIncomeAmount() == null){
            println("A--")
            spendingMemo = money.getMemo()
            spendingOldAmount = money.getSpendingAmount()
        }else if (money.getSpendingAmount() == null){
            println("B--")
            incomeMemo = money.getMemo()
            incomeOldAmount = money.getIncomeAmount()
        }
        render(view: "/user/update.gsp", model:[Moneys: money,userName: user.userName,
                                                spendingMemo:spendingMemo,incomeMemo:incomeMemo,
                                                spendingOldAmount: spendingOldAmount,incomeOldAmount: incomeOldAmount,
                                                id: id])
    }

    def updatePlus(){
        println("updatePlus" + params.amount + " " + params.id)
        User user = User.findByUserName(params.userName)
        Money money = Money.findById(params.id)
        money.setIncomeAmount(Integer.parseInt(params.amount))
        money.setSpendingAmount(null)
        println(params.memo)
        money.setMemo(params.memo)
        if((params.amount).isEmpty()) {
            flash.message = "金額を入力してください"
        }else {
            if (money.validate()) {
                MoneyService.saveMoney(money)
            } else {
                println("入力項目がおかしいです")
                flash.message = "入力項目がおかしいです"
            }
        }
        redirect(action:"mainInfo",params:[id: user.id, userName: params.userName])
    }

    def updateMinus(){
        User user = User.findByUserName(params.userName)
        Money money = Money.findById(params.id)
        money.setSpendingAmount(Integer.parseInt(params.amount))
        money.setIncomeAmount(null)
        money.setMemo(params.memo)
        println(params.memo)
        if((params.amount).isEmpty()) {
            flash.message = "金額を入力してください"
        }else{
            if (money.validate()) {
                MoneyService.saveMoney(money)
            } else {
                println("入力項目がおかしいです")
                flash.message = "入力項目がおかしいです"
            }
        }
        redirect(action:"mainInfo",params:[id: user.id, userName: params.userName])
    }


    def allDelete(Integer id, String userName){
        Money.allDelete(id)
        render(view: "/user/info.gsp", model:[userName: userName])
    }
}

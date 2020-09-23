package practice1

class MoneyController {

    def MoneyService
    def index() { }

    def plus(String memo, Integer amount, String userName){
        User user = User.findByUserName(userName)
        Money money = new Money(userId: user.id, amount:amount, memo:memo)
        if (money.validate()){
            MoneyService.saveMoney(money)
            redirect(action:"mainInfo",params:[id:user.id,userName:userName])
        }else{
            println("入力項目がおかしいです")
            flash.message = "入力項目がおかしいです"
            def moneys = Money.findAllByUserId(user.id)
            render(view: "/user/info.gsp", model:[Moneys: moneys,userName: userName])
        }
    }

    def minus(String memo, Integer amount, String userName){
        User user = User.findByUserName(userName)
        amount = amount * -1
        Money money = new Money(userId: user.id, amount:amount, memo:memo)
        if (money.validate()){
            MoneyService.saveMoney(money)
            redirect(action:"mainInfo",params:[id:user.id,userName:userName])
        }else{
            println("入力項目がおかしいです")
            flash.message = "入力項目がおかしいです"
            def moneys = Money.findAllByUserId(user.id)
            render(view: "/user/info.gsp", model:[Moneys: moneys,userName: userName])
        }
    }

    def mainInfo(Integer id, String userName){
       // def moneys = Money.findAllByUserId(id).Money.findAllByDeleteFlag(0)
        def moneys = Money.findAll{userId == id && deleteFlag == 0}
        render(view: "/user/info.gsp", model:[Moneys: moneys,userName: userName])
    }

    def mainView(){

    }

    def delete(Integer id, String deleteFlag, Integer userId){
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
}

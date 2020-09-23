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
            render(view:'/user/info.gsp', model:[Moneys: Money.findAll(),userName:userName])
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
            render(view:'/user/info.gsp', model:[Moneys: Money.findAll(),userName:userName])
        }
    }

    def mainInfo(Integer id, String userName){
        println("ID：" + id)
        println("UserName" + userName)
      //  render(view: "/user/info", model:[Moneys: Money.findAllById(1),userName: userName])
       // render(Money.findAll())
        render(view: "/user/info.gsp", model:[Moneys: Money.findAll(),userName: userName])
    }

    def mainView(){

    }
}

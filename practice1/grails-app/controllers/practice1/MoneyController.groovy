package practice1

class MoneyController {

    def MoneyService
    def index() { }
    def plus(String memo, Integer amount, String userName){
        User user = User.findByUserName(userName)
        Money money = new Money(userId: user.id, amount:amount, memo:memo)
        MoneyService.saveMoney(money)
        render(view: "/user/info", model:[Moneys: Money.findAllById(user.id),userName: userName])
    }

    def minus(String memo, Integer amount, String userName){
        User user = User.findByUserName(userName)
        amount = amount * -1
        Money money = new Money(userId: user.id, amount:amount, memo:memo)
        MoneyService.saveMoney(money)
        render(view: "/user/info", model:[Moneys: Money.findAllById(user.id),userName: userName])
    }
}

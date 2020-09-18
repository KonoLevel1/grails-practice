package practice1

import groovy.util.logging.Slf4j

@Slf4j
class UserController {
    def UserService
    def index() { }

    def create() {
        println("create")
        render(view: "/user/create")
    }

    def check() {
        println("check")
        render(view: "/user/check")
    }

    def registration(String userName, String password, String rePassword) {
        log.info("registration")
        User user = new User(userName: userName, password: password)
        if (user.validate()){
            if (user.getPassword().equals(rePassword)) {
                render(view: "/user/check", model:[userName: userName, password: password])
            }else{
                println("パスワードが一致しませんでした。")
                render(view:'/user/create')
            }
        }else{
            println("入力項目がおかしいです")
            render(view:'/user/create', model:[errorUser: user])
        }
    }

    def mainRegistration(String userName, String password) {
        User user = new User(userName: userName, password: password)
        if (user.validate()){
            UserService.saveUser(user)
            render(view: "/user/info", model:[userName: userName])
        }else{
            println("入力項目がおかしいです")
            render(view:'/user/create', model:[errorUser: user])
        }
    }
}

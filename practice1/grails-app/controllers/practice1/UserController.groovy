package practice1

import groovy.util.logging.Slf4j

@Slf4j
class UserController {
    def UserService
    def index() { }

    def create() {
        println("create")
        render(view: "/user/create.gsp")
    }

    def check() {
        println("check")
        render(view: "/user/check.gsp")
    }

    def registration(String userName, String password, String rePassword) {
        log.info("registration")
        User user = new User(userName: userName, password: password)
        if (user.validate()){
            if (user.getPassword().equals(rePassword)) {
                render(view: "/user/check.gsp", model:[userName: userName, password: password])
            }else{
                println("パスワードが一致しませんでした。")
                flash.message = "パスワードが一致しませんでした。"
                render(view: "/user/create.gsp")
            }
        }else{
            println("入力項目がおかしいです")
            flash.message = "入力項目がおかしいです"
            render(view: "/user/create.gsp")
        }
    }

    def mainRegistration(String userName, String password) {
        User user = new User(userName: userName, password: password)
        if (user.validate()){
            UserService.saveUser(user)
            User user2 = User.findByUserName(userName)
            render(view: "/user/info.gsp", model:[userName: userName])
        }else{
            println("入力項目がおかしいです")
            flash.message = message("エラー")
            render(view:'/user/create.gsp', model:[errorUser: user])
        }
    }

    def login(){
        println("Login")
        render(view: "/user/login.gsp")
    }

    def logincheck(String userName, String password){
        def user1 = User.findByUserName(userName)
        if (user1.getPassword().equals(password)){
      //      render(view: "/user/info.gsp", model:[userName: userName])
            redirect(controller:"money",action:"mainInfo",params:[id:user1.getId(),userName:userName])
        }else{
            println("ログイン拒否")
            flash.message = "ログイン情報が間違っています。"
            render(view: "/user/login.gsp")
        }
    }

}

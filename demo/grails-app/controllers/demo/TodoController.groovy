package demo
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
class TodoController {

    def index() {
        respond Todo.list()
        respond new Todo()
    }
    def save(Todo todo) {
        todo.save()
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: ['メモ',todo.memo])
                redirect(controller: "todo", action: "index")
            }
        }
    }

    def delete(Long id){
        def todo = Todo.get(id)
        todo.delete(flush:true)
        request.withFormat{
            form multipartForm{
                flash.message = message(code:'default.deleted.message',args:['メモ',todo.memo])
                redirect(controller:"todo",action:"index")
            }
        }
    }

    def edit(Long id){
        respond Todo.list()
        respond Todo.get(id),view: "index"
    }
}

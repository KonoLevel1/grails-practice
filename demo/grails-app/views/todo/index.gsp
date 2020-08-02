<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
<ul>
<g:each in="${todoList}">
    <li>${it.memo}
        <g:link action="delete" id="${it.id}">削除</g:link>
        <g:link action="edit" id="${it.id}">編集</g:link>
    </li>
</g:each>
<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<g:form resource="${this.todo}" action="save" method="POST">
    <fieldset class="form">
        <g:hiddenField name="id" value="${this.todo.id}"/>
        <f:field bean="todo" property="memo" label="メモ"/>
    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="create" class="save" value="保存" />
    </fieldset>
</g:form>
</ul>
</body>
</html>

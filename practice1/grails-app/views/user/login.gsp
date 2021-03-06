<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Practice1 | ユーザー作成</title>
</head>
<body>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ユーザー設定<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">ユーザーを作成する</a></li>
            <li class="dropdown-item"><a href="#">ユーザーを切り替える</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">収支登録<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">作成中</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">設定<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">作成中</a></li>
        </ul>
    </li>
</content>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>ログインページ</h1>
    </section>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="center">
    <g:renderErrors bean="${errorUser}" as="list" field="user"/>
                <form action="/user/logincheck">
                    <h3>ハンドルネームを入力してください</h3>
                    <input name="userName" placeholder="Name">
                    <h3>パスワードを入力してください</h3>
                    <input name="password" type="password" placeholder="Password" oncopy="return false"
                        onpaste="return false" oncontextmenu="return false"/>
                    <h3>ログイン</h3>
                    <button type="submit" class="btn btn-success">ログイン</button>
                </form>
    </div>
</div>

</body>
</html>
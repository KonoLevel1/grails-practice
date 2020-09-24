<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Practice1 | 確認画面</title>
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
        <h1>登録確認画面</h1>
    </section>
    <div class="center">
                <h2>お名前：　${userName}</h2>
                <h2>パスワード： ${password}</h2>
                <div class="side">
                    <button onclick="location.href='../user/create/'" type="submit" class="btn btn-warning">やり直す</button>
                 </div>
                 <div class="side">
                    <form controller="user" action="mainRegistration" method="POST">
                        <input type="hidden" name="userName" value=${userName}>
                        <input type="hidden" name="password" value=${password}>
                        <button type="submit" class="btn btn-success">登録</button>
                    </form>
                </div>

     </div>
</div>

</body>
</html>
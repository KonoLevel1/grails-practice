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
        <h1>${userName}さんのページです。</h1>
    </section>
    <div class="center">
    <g:renderErrors bean="${errorUser}" as="list" field="user"/>
                <form controller="user" action="../registration">
                    <input name="userName" placeholder="お給料">
                    <input name="userName" placeholder="12345">
                    <button type="submit" class="btn btn-dark">収入登録</button>
                </form>
                   <form controller="user" action="../registration">
                       <input name="userName" placeholder="食費">
                       <input name="userName" placeholder="12345">
                       <button type="submit" class="btn btn-danger">支出登録</button>
                   </form>
    </div>
</div>

</body>
</html>
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
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
    <div class="center">
    <g:renderErrors bean="${errorUser}" as="list" field="user"/>
                <form action="/money/plus">
                    <input name="memo" placeholder="お給料">
                    <input name="amount" placeholder="12345">
                    <input type="hidden" name="userName" value=${userName}>
                    <button type="submit" class="btn btn-dark">収入登録</button>
                </form>
                <form action="/money/minus">
                       <input name="memo" placeholder="食費">
                       <input name="amount" placeholder="12345">
                       <input type="hidden" name="userName" value=${userName}>
                       <button type="submit" class="btn btn-danger">支出登録</button>
                 </form>
                 <p>${moneys}</p>
                 <table>
                    <tr>
                        <th>内容</th>
                        <th>金額</th>
                        <th>日時</th>
                    </tr>
                        <g:each in="${Moneys}">
                    <tr>
                        <td>${it.memo}</td>
                        <td>${it.amount}</td>
                        <td>${it.createTime}</td>
                    </tr>
                 </g:each>
                 </table>
    </div>
</div>

</body>
</html>
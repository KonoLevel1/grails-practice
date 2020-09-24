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
            <li class="dropdown-item"><a href="#">ログインする</a></li>
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
            <li class="dropdown-item"><a href="#">全削除</a></li>
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
                <form action="/money/updatePlus" method="POST">
                    <input name="memo" placeholder=${incomeMemo}>
                    <input name="amount" placeholder=${incomeOldAmount}>
                    <input type="hidden" name="userName" value=${userName}>
                    <input type="hidden" name="id" value=${id}>
                    <button type="submit" class="btn btn-dark">収入登録</button>
                </form>
                <form action="/money/updateMinus" method="POST">
                       <input name="memo" placeholder=${spendingMemo}>
                       <input name="amount" placeholder=${spendingOldAmount}>
                       <input type="hidden" name="userName" value=${userName}>
                       <input type="hidden" name="id" value=${id}>
                       <button type="submit" class="btn btn-danger">支出登録</button>
                 </form>

                 <h2>残高　${totalFee} 円</h2>

                 <table>
                    <tr>
                        <th>内容</th>
                        <th>収入</th>
                        <th>支出</th>
                        <th>日時</th>
                        <th>修正取り消し</th>
                    </tr>
                        <g:each in="${Moneys}">
                    <tr>
                        <td>${it.memo}</td>
                        <td class="right">${it.incomeAmount}</td>
                        <td class="right">${it.spendingAmount}</td>
                        <td>${it.createTime}</td>
                        <td><form action="/money/info"><input type="hidden" name="userId" value=${it.userId}><input type="hidden" name="id" value=${it.id}><input type="hidden" name="deleteFlag" value="1"><button type="submit" class btn btn-danger">修正取り消し</button></form></td>

                    </tr>
                 </g:each>
                 </table>
    </div>
</div>
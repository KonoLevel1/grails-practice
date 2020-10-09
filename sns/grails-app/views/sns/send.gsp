<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Grails SNS Application</title>
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">操作<span class="caret"></span></a>
            <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="/sns/send/">通知を送信</a></li>
            <li class="dropdown-item"><a href="/sns/register/">通知先を作成</a></li>
            <li class="dropdown-item"><a href="/sns/help/">ヘルプ</a></li>
            </ul>
        </li>
    </content>
    <div class="center back-green">
        <form action="/sns/notificationSend" method="POST">
            <h3>通知メッセージを入力してください</h3>
            <input name="message" placeholder="Enter the message">
            <h3>問題なければ送信</h3>
            <button type="submit" class="btn btn-success">送信</button>
        </form>
    </div>
    <div class="center back-blue">
        <form action="/sns/defaultNotificationSend" method="POST">
            <h3><strong>${message}</strong>で通知送信</h3>
            <button type="submit" class="btn btn-primary">送信</button>
        </form>
    </div>
</body>
</html>
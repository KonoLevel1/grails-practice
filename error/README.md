# ERRORまとめ


### 注意事項
秘密情報を載せないように十分注意すること

```
Configuring Spring Security Core ...
... finished configuring Spring Security Core

2020-08-27 15:13:04.133 ERROR --- [           main] org.apache.catalina.util.LifecycleBase   : Failed to start component [Connector[HTTP/1.1-8080]]
```
# パスが設定できていない
発生条件
* grailsコマンドを使用すると発生する
* windows環境で確認（Macでも発生すると思う）
* SDKMANを利用して導入後
```
grails help
```
エラー内容
```
Please set the JAVA_HOME variable in your environment to match the
location of your Java installation.
```
翻訳結果
```
お使いの環境でJAVA_HOME変数を設定して、
Javaインストールの場所。
```

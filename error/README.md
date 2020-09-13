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
* grailsをインストール済み
* javaをインストール済
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
解決策
* JavaとGrailsのパスを設定してやる
    * .sdkman > candidates > ... の中にJavaとGrailsのbinがあるので取得
```
C:\Users\****\.sdkman\candidates\grails\4.0.4\bin
```
    
```
C:\Users\****\.sdkman\candidates\java\11.0.8-amzn\bin
```
* bash_profileにパスを追加する
```
vim ~/.bash_profile
```
* "vim"コマンドとは
    * vim（ビム）と呼ばれるテキストエディタを起動するコマンド
```
export PATH=$PATH:C:\Users\****\.sdkman\candidates\grails\4.0.4\bin
export PATH=$PATH:C:\Users\****\.sdkman\candidates\java\11.0.8-amzn\bin
```
* 入力内容を保存
    * ESCキー > wq（保存） > Enterキー
* 入力内容を間違えて破棄したい場合は
    * ESCキー > q!（破棄） > Enterキー
* 変更内容を反映する
```
source ~/.bash_profile
```

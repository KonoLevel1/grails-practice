# grails-practice


### ドキュメント
Grails4.04
<br>
https://docs.grails.org/4.0.4/guide/single.html#conventionOverConfiguration
<br>
Grails超入門チュートリアル
<br>
https://www.slideshare.net/ikufumisato1/grails-106265680

### 構成

* **helloworld**<br>
公式チュートリアル「HelloWorld」の表示<br>
http://localhost:8080/helloworld/hello/index アクセスで文字列表示
* **demo**<br>
ToDoメモの作成<br>
http://localhost:8081/todo/index アクセスで文字列登録、一覧表示

### 備考
**Grailsコマンド入力時の警告**
```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v7.Java7$1 (file:/Users/***/.sdkman/candidates/grails/4.0.4/lib/org.codehaus.groovy/groovy/jars/groovy-2.5.6.jar) to constructor java.lang.invoke.MethodHandles$Lookup(java.lang.Class,int)
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.vmplugin.v7.Java7$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```
Goovyがリフレクションにより、<br>本来アクセスできないはずのシグネチャにアクセスしている為、警告が発生している。<br>実害はないので現状無視する

**デバッグ**<br>
Intellijで、Run > Edit Configurations > Remote > 任意の名前をつけてOK
```
grails run-app --debug-jvm
```
**Port番号を変更して実行**<br>
```
grails> run-app --port=8090
```

### データベースコンソール
H2 database console は JDBCドライバを持つ任意のデータベースをWebブラウザから確認できる便利な機能<br>
http://localhost:8080/h2-console (バージョン4.0.4時点)

### Grailsコマンド一覧
```
assemble                                本番デプロイメント用のJARかWARアーカイブを作成
bug-report                              現在のプロジェクトの課題レポーチに添付できるzipファイルを作成
clean                                   Grailsアプリケーションのコンパイル済みソースをクリーンアップ
compile                                 Grailsアプリケーションをコンパイル
console                                 Grailsインタラクティブコンソールを実行
create-command                          アプリケーションコマンドを作成
create-controller                       コントローラーを作成
create-domain-class                     ドメインクラスを作成　
create-functional-test                  Geb機能テストを作成（？）
create-integration-test                 統合テストを作成
create-interceptor                      インターセプターを作成
create-scaffold-controller              スカフォールドコントローラーを作成
create-script                           Grailsスクリプトを作成
create-service                          サービスを作成
create-taglib                           タグライブラリを作成
create-unit-test                        ユニットテストを作成
dependency-report                       Grailsアプリケーションの依存関係を出力
generate-all                            CRUD操作と関連するビューを実行するコントローラーを生成
generate-async-controller               CRUD操作を実行する非同期コントローラーを作成
generate-controller                     CRUD操作を実行するコントローラーを作成
generate-views                          指定されたドメインクラスのGSPビューを生成
gradle                                  Gradleタスクの実行を許可
help                                    コマンドのヘルプ情報を出力
install-templates                       プロパティをレンダリングするためにf:allを仕様するスカフォールドテンプレートをインストール
list-plugins                            プラグインリポジトリから利用可能なプラグインを一覧表示
open                                    プロジェクト内のファイルを開く
plugin-info                             指定されたプラグインに関する情報を出力
run-app                                 Grailsアプリケーションを実行
run-command                             Grailsコマンドを実行
run-script                              GrailsコンテキストでGroovyスクリプトを実行
schema-export                           データベーススキーマのDDLファイルを作成
shell                                   Grails対話型シェルを実行
stats                                   プロジェクトに関する統計を出力
stop-app                                実行中のGrailsアプリケーションを停止
test-app                                アプリケーションのテストを実行
url-mappings-report                     プロジェクトのURLマッピングレポートを出力

```
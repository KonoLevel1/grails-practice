# grails-practice


### ドキュメント
https://docs.grails.org/4.0.4/guide/single.html#conventionOverConfiguration

### 構成

* **helloworld**<br>
公式チュートリアル「HelloWorld」の表示<br>
http://localhost:8080/helloworld/hello/index アクセスで文字列表示

### 備考
**Grailsコマンド入力時の警告**
```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v7.Java7$1 (file:/Users/***/.sdkman/candidates/grails/4.0.4/lib/org.codehaus.groovy/groovy/jars/groovy-2.5.6.jar) to constructor java.lang.invoke.MethodHandles$Lookup(java.lang.Class,int)
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.vmplugin.v7.Java7$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```
Goovyがリフレクションにより、本来アクセスできないはずのシグネチャにアクセスしている為、警告が発生している。<br>実害はないので現状無視する

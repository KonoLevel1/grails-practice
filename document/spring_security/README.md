## SpringSecurityとは
認証機能などの導入ができる
## SpringSecurityの導入方法
1. [こちら](http://plugins.grails.org/plugin/grails/spring-security-core)のページよりcompileするものを確認
2. build.gradleに 1 で確認したものを追加
```
dependencies {
    // 省略
    compile 'org.grails.plugins:spring-security-core:4.0.3'
}
```

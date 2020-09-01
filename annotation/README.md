# grails-practice


### アノテーション
* **@Slf4j**
    * ログ
* **@Transactional**
    * 例外が発生した際に自動でロールバックする
    ```
    @Transactional
    ```

    * レコードを操作すると例外が投げられる
    ```
    @Transactional(readOnly = true)
    ```

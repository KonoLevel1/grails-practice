# study

Grailsに関する理解を深めるためのまとめ
## render（レンダリング）
* 単純なテキスト応答から様々な形式の応答をレンダリングして、ビューとテンプレートを表示する。
    ```
    // 単純に文字のみ返す
    render "いろはにほへと"

    // ステータスコードを返す
    render(status: 503 text "データを更新できませんでした。${b.id}")
    ```

## redirect（リダイレクト）
* あるアクションから次のアクションにリダイレクトする。
    ```
    // showアクションにリダイレクト
    redirect(action:"show")

    // Bookコントローラーのshowアクションにリダイレクト
    redirect(controller:"book", action:"show")
    ```

## respond（レスポンド）
* 要求されたコンテンツタイプに最適なタイプを返却しようとする。
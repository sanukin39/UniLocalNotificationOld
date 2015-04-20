# UniLocalNotification

## 説明
UniLocalNotificationはUnity上でローカル通知の登録、削除を容易に行うことができるプラグインです。
iOS, Androidの両プラットフォームに対応してます。

## 使い方
#### namespace の追加
```
using LocalNotification;
```
#### 通知の登録
```
// 30秒後に通知を行う
LocalNotificationManager.SetNotification ("message", 30, "title");
```
// 対応プラットフォームがiOSのみであれば、タイトルを入れる必要は有りません
```
LocalNotificationManager.SetNotification ("message", 30);
```

#### 通知の削除
```
LocalNotificationManager.CancelAllNotification();
```
アプリケーションの起動時、復帰時に呼ぶと良いです

## インストール
[LocalNotification.unitypackage](https://github.com/sanukin39/UniLocalNotification/blob/master/dist/UniLocalNotification.unitypackage)　からそれぞれのプロジェクトにインストールしてください

## Contribution
[Donuts Co.,Ltd.](https://github.com/d-o-n-u-t-s)

## License

[MIT](https://github.com/sanukin39/UniLocalNotification/blob/master/LICENSE)

## Author
[sanukin39](https://github.com/sanukin39)

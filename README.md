# UniLocalNotification

## Description
UniLocalNotification is plugin for Unity that register/cancel localnotification easily. It works iOS and Android platform.

## Usage
#### Add namespace
```
using LocalNotification;
```
#### Register notification
```
// Launch localnotificaion 30 secounds after
LocalNotificationManager.SetNotification ("message", 30, "title");
```
If only use iOS device, you need not define title as below.
```
LocalNotificationManager.SetNotification ("message", 30);
```

#### Cancel All Notification
```
LocalNotificationManager.CancelAllNotification();
```
You might want to call the method when applicaion resume;

## Install
Use [LocalNotification.unitypackage](https://github.com/sanukin39/UniLocalNotification/blob/master/dist/UniLocalNotification.unitypackage)

## Contribution
[Donuts Co.,Ltd.](https://github.com/d-o-n-u-t-s)

## License

[MIT](https://github.com/sanukin39/UniLocalNotification/blob/master/LICENSE)

## Author
[sanukin39](https://github.com/sanukin39)

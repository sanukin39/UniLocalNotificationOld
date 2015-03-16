package jp.ne.donuts.localnotifications;

/**
 * Created by sanuki.wataru on 2015/02/24.
 */
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import java.util.Calendar;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.Service;
import android.util.Log;

public class LocalNotifications {
    public static void setLocalNotification(final Context context,final String title, final String message,final int requestCode,final int interval){
        // Intentの作成
        Intent intent = new Intent(context, NotificationReceiver.class);
        // Intentに通知情報を登録
        intent.putExtra("MESSAGE", message);
        intent.putExtra("TITLE", title);
        // sender を作成
        PendingIntent sender = PendingIntent.getBroadcast(context,  requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 通知時間を設定
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, interval);

        // AlarmManagerを使って通知を登録
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    public static void cancelNotifications(final Context context, final int requestCode) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, NotificationReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(sender);
    }
}

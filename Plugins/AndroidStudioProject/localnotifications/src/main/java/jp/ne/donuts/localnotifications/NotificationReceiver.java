package jp.ne.donuts.localnotifications;

/**
 * Created by sanukin39 on 2015/02/24.
*/
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.app.PendingIntent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // 通知内容を受け取る
        String message = intent.getStringExtra("MESSAGE");
        String title = intent.getStringExtra("TITLE");

        // タップしたらアプリを起動できるようにIntentを設定する
        final PackageManager pm=context.getPackageManager();
        Intent intentCustom = pm.getLaunchIntentForPackage(context.getPackageName());

        int id =(int)(Math.random()*10000.0f)+1;
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intentCustom,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // LargeIcon の Bitmap を生成
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = pm.getApplicationInfo(context.getPackageName(),PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return;
        }
        final int appIconResId=applicationInfo.icon;
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), appIconResId);

        // NotificationBuilderを作成
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(contentIntent);
        // ステータスバーに表示されるテキスト
        builder.setTicker("");
        // Notificationを開いたときに表示されるタイトル
        builder.setContentTitle(title);
        // Notificationを開いたときに表示されるサブタイトル
        builder.setContentText(message);
        // Notificationを開いたときに表示されるアイコン
        builder.setLargeIcon(largeIcon);
        // ステータスバーに表示されるアイコン
        builder.setSmallIcon(context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName()));

        // 通知するタイミング
        builder.setWhen(System.currentTimeMillis());
        // 通知時の音・バイブ・ライト
        builder.setDefaults(Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS);
        // タップするとキャンセル(消える)
        builder.setAutoCancel(true);

        // NotificationManagerを取得
        NotificationManager manager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);

        // Notificationを作成して通知
        manager.notify(id, builder.build());
    }
}
using UnityEngine;
using System.Collections;
using LocalNotification;

public class ExampleScript : MonoBehaviour {

    void OnGUI(){

        var SetButtonRect = new Rect (10, 10, Screen.width - 20, Screen.height / 10);
        var CancelButtonRect = new Rect (10, 20 + Screen.height / 10, Screen.width - 20, Screen.height / 10);

        if (GUI.Button (SetButtonRect, "SetNotification")) {
            RegisterNotifications ();
        }

        if (GUI.Button (CancelButtonRect, "CancelNotirication")) {
            LocalNotificationManager.CancelAllNotification();
        }
    }

    void RegisterNotifications(){
        LocalNotificationManager.SetNotification ("hogehoge is called", 10, "hogehoge");
        LocalNotificationManager.SetNotification ("hogehoge is called", 5, "hogehoge");
    }
}

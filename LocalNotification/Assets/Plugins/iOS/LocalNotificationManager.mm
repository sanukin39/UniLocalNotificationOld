//
//  LocalNotificationManager.m
//
//  Created by sanukin39 on 2015/01/16.
//  Copyright (c) 2015年 sanukin39. All rights reserved.
//
#define SYSTEM_VERSION_GREATER_THAN_OR_EQUAL_TO(v)  ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] != NSOrderedAscending)

extern "C"
{
    void setNotification(const char* body, int delay){
        
        UILocalNotification *l = [[UILocalNotification alloc] init];
        l.fireDate = [NSDate dateWithTimeIntervalSinceNow:delay];
        l.alertBody =  [ [ NSString alloc ] initWithUTF8String:body ];
        l.timeZone = [NSTimeZone localTimeZone];
        l.soundName = UILocalNotificationDefaultSoundName;
        l.alertAction = @"OPEN";
        [[UIApplication sharedApplication] scheduleLocalNotification:l];

        // This is a badge auto increment func. it works well at ios7 but does not at ios8
        // NSArray *pendingNotifications = [[UIApplication sharedApplication] scheduledLocalNotifications];

        // if (pendingNotifications.count != 0)
        // {
        //     [[UIApplication sharedApplication] cancelAllLocalNotifications];
        //     NSUInteger badgeNbr = 1;

        //     for (UILocalNotification *notification in pendingNotifications)
        //     {
        //         NSLog(@"Resister Notification");
        //         notification.applicationIconBadgeNumber = badgeNbr++;
        //         [[UIApplication sharedApplication] scheduleLocalNotification:notification];
        //     }
        // }
    }
    
    void cancelAllNotification(){
        [[UIApplication sharedApplication] cancelAllLocalNotifications];
        [UIApplication sharedApplication].applicationIconBadgeNumber = 0;
    }
}

#import "UnityAppController.h"

@interface MyAppController : UnityAppController
@end

@implementation MyAppController

- (BOOL)application:(UIApplication*)application didFinishLaunchingWithOptions:(NSDictionary*)launchOptions{

	[super application:application didFinishLaunchingWithOptions:launchOptions];
    
    if ([application respondsToSelector:@selector(registerUserNotificationSettings:)]) {
        UIUserNotificationSettings *settings = [UIUserNotificationSettings settingsForTypes:UIUserNotificationTypeAlert|UIUserNotificationTypeSound|UIUserNotificationTypeBadge categories:nil];
        [application registerUserNotificationSettings:settings];
    }
    
    return YES;
}

@end

IMPL_APP_CONTROLLER_SUBCLASS(MyAppController)

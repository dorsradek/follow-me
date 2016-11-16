package pl.rdors.follow_me3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.PowerManager;

/**
 * Created by rdors on 2016-11-16.
 */
public class LocationTracker extends BroadcastReceiver {

    private PowerManager.WakeLock wakeLock;

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pow = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = pow.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wakeLock.acquire();

        Location currentLocation = LocationProvider.getInstance().getCurrentLocation();

        // Send new location to backend. // this will be different for you
//        UserService.registerLocation(context, new Handlers.OnRegisterLocationRequestCompleteHandler() {
//            @Override
//            public void onSuccess() {
//                Log.d("success", "UserService.RegisterLocation() succeeded");
//
//                wakeLock.release();
//            }
//
//            @Override
//            public void onFailure(int statusCode, String errorMessage) {
//                Log.d("error", "UserService.RegisterLocation() failed");
//                Log.d("error", errorMessage);
//
//                wakeLock.release();
//            }
//        }, currentLocation);
    }
}
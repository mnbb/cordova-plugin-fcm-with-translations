package com.gae.scaffolder.plugin;

import org.json.JSONArray;
import android.support.v4.app.NotificationCompat;

public class ByLangNotification {
    private String selectedLanguage;

    public void setLanguage(String lang) {
        this.selectedLanguage = lang;
    }

    public void fireNotification(JSONArray data) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        JSONArray translatedData = data[this.selectedLanguage];
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(translatedData.title)
            .setContentText(translatedData.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true);
        notificationManager.notify(0, mBuilder.build());
    }
}
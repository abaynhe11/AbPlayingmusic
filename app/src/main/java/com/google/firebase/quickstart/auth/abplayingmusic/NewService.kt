package com.google.firebase.quickstart.auth.abplayingmusic
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class NewService : Service() {

    // declaring object of MediaPlayer
    private lateinit var player:MediaPlayer

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)


        player.setLooping(true)

        // starting the process
        player.start()

        // returns the status
        // of the program
        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()

        // stopping the process
        player.stop()
        player.setLooping(false)


    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}

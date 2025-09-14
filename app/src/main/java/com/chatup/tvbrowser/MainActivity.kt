package com.chatup.tvbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoRuntimeSettings
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {
    private lateinit var geckoView: GeckoView
    private lateinit var session: GeckoSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        geckoView = GeckoView(this)
        setContentView(geckoView)

        // Configuración del runtime con autoplay
        val runtime = GeckoRuntime.create(
            this,
            GeckoRuntimeSettings.Builder()
                .javaScriptEnabled(true)
                .autoplayDefault(GeckoRuntimeSettings.AUTOPLAY_ALLOWED)
                .build()
        )


        session = GeckoSession()
        session.open(runtime)
        geckoView.setSession(session)

        session.loadUri("https://atencioncolas.chatup.pe/screen")
    }
}

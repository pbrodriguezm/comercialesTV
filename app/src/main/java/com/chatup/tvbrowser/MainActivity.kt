package com.chatup.tvbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {
    private lateinit var geckoView: GeckoView
    private lateinit var session: GeckoSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        geckoView = GeckoView(this)
        setContentView(geckoView)

        val runtime = GeckoRuntime.create(this)
        session = GeckoSession()
        session.open(runtime)
        geckoView.setSession(session)

        // Configuración autoplay
        val settings = session.settings
        settings.usePrivateMode = true
        settings.mediaAutoplay = GeckoSession.Settings.AUTOPLAY_ALLOWED

        // Cargar URL fija
        session.loadUri("https://atencioncolas.chatup.pe/screen")
    }
}

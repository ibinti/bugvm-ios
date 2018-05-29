package com.bugvm.ladybug

import com.bugvm.apple.foundation.NSAutoreleasePool
import com.bugvm.apple.uikit.UIApplication
import com.bugvm.apple.uikit.UIApplicationDelegateAdapter
import com.bugvm.apple.uikit.UIApplicationLaunchOptions
import com.bugvm.apple.uikit.UIScreen
import com.bugvm.apple.uikit.UIWindow

class LadyBug : UIApplicationDelegateAdapter() {

    override fun didFinishLaunching(application: UIApplication, launchOptions: UIApplicationLaunchOptions?): Boolean {

        // Create a new window at screen size.
        val window = UIWindow(UIScreen.getMainScreen().bounds)
        // Set the view controller as the root controller for the window.
        window.rootViewController = WebViewController()
        // Make the window visible.
        window.makeKeyAndVisible()

        return true
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val pool = NSAutoreleasePool()
            UIApplication.main<UIApplication, LadyBug>(args, null, LadyBug::class.java)
            pool.close()
        }
    }
}

/**
 * Created by BugVM on 2017-04-07.
 */

package com.bugvm.ios

class Goblin : com.bugvm.apple.uikit.UIApplicationDelegateAdapter() {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val pool = com.bugvm.apple.foundation.NSAutoreleasePool()
            com.bugvm.apple.uikit.UIApplication.main<com.bugvm.apple.uikit.UIApplication, Goblin>(args, null, Goblin::class.java)
            pool.close()
        }
    }

    override fun didFinishLaunching(application: com.bugvm.apple.uikit.UIApplication, launchOptions: com.bugvm.apple.uikit.UIApplicationLaunchOptions?): Boolean {
        // Set up the view controller.
        val rootViewController = GoblinViewController()

        // Create a new window at screen size.
        val window = com.bugvm.apple.uikit.UIWindow(com.bugvm.apple.uikit.UIScreen.getMainScreen().bounds)
        // Set the view controller as the root controller for the window.
        window.setRootViewController(rootViewController)
        // Make the window visible.
        window.makeKeyAndVisible()

        return true
    }
}

class GoblinViewController : com.bugvm.apple.uikit.UIViewController() {
    private var clickCount: Int = 0

    init {
        // Setup background.
        view.backgroundColor = com.bugvm.apple.uikit.UIColor.green()

        // Setup label.
        val label = com.bugvm.apple.uikit.UILabel(com.bugvm.apple.coregraphics.CGRect(20.0, 250.0, 280.0, 44.0))
        label.font = com.bugvm.apple.uikit.UIFont.getSystemFont(24.0)
        label.textAlignment = com.bugvm.apple.uikit.NSTextAlignment.Center
        view.addSubview(label)

        // Setup button.
        val button = com.bugvm.apple.uikit.UIButton(com.bugvm.apple.uikit.UIButtonType.RoundedRect)
        button.frame = com.bugvm.apple.coregraphics.CGRect(60.0, 150.0, 180.0, 40.0)
        button.setTitle("Catch me!", com.bugvm.apple.uikit.UIControlState.Normal)
        button.titleLabel.font = com.bugvm.apple.uikit.UIFont.getBoldSystemFont(22.0)
        button.addOnTouchUpInsideListener { control: com.bugvm.apple.uikit.UIControl, event: com.bugvm.apple.uikit.UIEvent ->

            label.text = "Number of try: " + ++clickCount

        }
        view.addSubview(button)
    }
}
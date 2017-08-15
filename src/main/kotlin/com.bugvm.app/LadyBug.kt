package com.bugvm.app

import com.bugvm.apple.uikit.UIApplicationDelegateAdapter
import com.bugvm.apple.uikit.UIApplication
import com.bugvm.apple.uikit.UIApplicationLaunchOptions
import com.bugvm.apple.uikit.UIWindow
import com.bugvm.apple.uikit.UIScreen
import com.bugvm.apple.uikit.UIViewController
import com.bugvm.apple.uikit.UIColor
import com.bugvm.apple.uikit.UILabel
import com.bugvm.apple.coregraphics.CGRect
import com.bugvm.apple.uikit.NSTextAlignment
import com.bugvm.apple.uikit.UIButton
import com.bugvm.apple.uikit.UIButtonType
import com.bugvm.apple.uikit.UIControlState
import com.bugvm.apple.uikit.UIFont
import com.bugvm.apple.uikit.UIControl
import com.bugvm.apple.uikit.UIEvent

class BugVM : UIApplicationDelegateAdapter() {

    override fun didFinishLaunching(application: UIApplication, launchOptions: UIApplicationLaunchOptions?): Boolean {
        val window = UIWindow(UIScreen.getMainScreen().bounds)
        window.rootViewController = BugVMViewController()
        window.makeKeyAndVisible()
        return true
    }
}

class BugVMViewController : UIViewController() {
    private var clickCount: Int = 0

    init {
        view.backgroundColor = UIColor.green()

        val label = UILabel(CGRect(20.0, 250.0, 280.0, 44.0))
        label.font = UIFont.getSystemFont(24.0)
        label.textAlignment = NSTextAlignment.Center
        view.addSubview(label)

        val button = UIButton(UIButtonType.RoundedRect)
        button.frame = CGRect(60.0, 150.0, 180.0, 40.0)
        button.setTitle("Catch me!", UIControlState.Normal)
        button.titleLabel.font = UIFont.getBoldSystemFont(22.0)
        button.addOnTouchUpInsideListener { control: UIControl, event: UIEvent ->

            label.text = "Number of try: ${++clickCount}"

        }
        view.addSubview(button)
    }
}
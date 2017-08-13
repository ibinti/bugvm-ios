/**
 * Created by BugVM on 2017-04-07.
 */

package sample

class Goblin : com.bugvm.apple.uikit.UIApplicationDelegateAdapter() {

    override fun didFinishLaunching(application: com.bugvm.apple.uikit.UIApplication, launchOptions: com.bugvm.apple.uikit.UIApplicationLaunchOptions?): Boolean {
        val window = com.bugvm.apple.uikit.UIWindow(com.bugvm.apple.uikit.UIScreen.getMainScreen().bounds)
        window.rootViewController = GoblinViewController()
        window.makeKeyAndVisible()
        return true
    }
}

class GoblinViewController : com.bugvm.apple.uikit.UIViewController() {
    private var clickCount: Int = 0

    init {
        view.backgroundColor = com.bugvm.apple.uikit.UIColor.green()

        val label = com.bugvm.apple.uikit.UILabel(com.bugvm.apple.coregraphics.CGRect(20.0, 250.0, 280.0, 44.0))
        label.font = com.bugvm.apple.uikit.UIFont.getSystemFont(24.0)
        label.textAlignment = com.bugvm.apple.uikit.NSTextAlignment.Center
        view.addSubview(label)

        val button = com.bugvm.apple.uikit.UIButton(com.bugvm.apple.uikit.UIButtonType.RoundedRect)
        button.frame = com.bugvm.apple.coregraphics.CGRect(60.0, 150.0, 180.0, 40.0)
        button.setTitle("Catch me!", com.bugvm.apple.uikit.UIControlState.Normal)
        button.titleLabel.font = com.bugvm.apple.uikit.UIFont.getBoldSystemFont(22.0)
        button.addOnTouchUpInsideListener { control: com.bugvm.apple.uikit.UIControl, event: com.bugvm.apple.uikit.UIEvent ->

            label.text = "Number of try: ${++clickCount}"

        }
        view.addSubview(button)
    }
}
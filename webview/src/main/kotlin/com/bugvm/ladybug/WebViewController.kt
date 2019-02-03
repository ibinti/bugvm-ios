package com.bugvm.ladybug

import com.bugvm.apple.coregraphics.CGRect
import com.bugvm.apple.foundation.NSError
import com.bugvm.apple.foundation.NSURL
import com.bugvm.apple.foundation.NSURLRequest
import com.bugvm.apple.uikit.UIButton
import com.bugvm.apple.uikit.UIButtonType
import com.bugvm.apple.uikit.UIColor
import com.bugvm.apple.uikit.UIControl
import com.bugvm.apple.uikit.UIControlState
import com.bugvm.apple.uikit.UIEvent
import com.bugvm.apple.uikit.UIFont
import com.bugvm.apple.uikit.UIScreen
import com.bugvm.apple.uikit.UIView
import com.bugvm.apple.uikit.UIViewController
import com.bugvm.apple.uikit.UIWebView
import com.bugvm.apple.uikit.UIWebViewDelegateAdapter
import com.bugvm.apple.uikit.UIWebViewNavigationType

class WebViewController : UIViewController() {

    internal var btnBugVM: UIButton
    internal var btnGithub: UIButton
    internal var webView: UIWebView? = null

    init {
        // Get the view of this view controller.
        val view = getView()

        val b = UIScreen.getMainScreen().getBounds()

        // Setup background.
        view.setBackgroundColor(UIColor.black())

        btnBugVM = UIButton(UIButtonType.Custom)
        btnBugVM.setBackgroundColor(UIColor.lightGray())
        btnBugVM.setFrame(CGRect(0.0, 0.0, b.getWidth(), 50.0))
        btnBugVM.setTitle("We are the BugVM", UIControlState.Normal)
        btnBugVM.getTitleLabel().setFont(UIFont.getBoldSystemFont(20.0))
        btnBugVM.addOnTouchDownListener({ control: UIControl, event: UIEvent ->
            btnBugVM.setBackgroundColor(UIColor.clear())

            webView?.loadRequest(NSURLRequest(NSURL("https://ibinti.com/bugvm")))

        })
        btnBugVM.addOnTouchUpInsideListener({ control: UIControl, event: UIEvent ->

            btnBugVM.setBackgroundColor(UIColor.lightGray())

        })
        btnBugVM.addOnTouchUpOutsideListener({ control: UIControl, event: UIEvent -> btnBugVM.setBackgroundColor(UIColor.lightGray()) })
        view.addSubview(btnBugVM)

        webView = UIWebView()

        webView?.setFrame(CGRect(0.0, 50.0, b.getWidth(), b.getHeight() - 100.0))

        webView?.setDelegate(webView?.addStrongRef(object : UIWebViewDelegateAdapter() {
            override fun shouldStartLoad(uiWebView: UIWebView, nsurlRequest: NSURLRequest, uiWebViewNavigationType: UIWebViewNavigationType): Boolean {

                return true
            }

            override fun didStartLoad(uiWebView: UIWebView) {

            }

            override fun didFinishLoad(uiWebView: UIWebView) {

                webView?.setHidden(false)

            }

            override fun didFailLoad(uiWebView: UIWebView, nsError: NSError) {

            }
        }))
        val URL = NSURL("https://ibinti.com/bugvm")
        webView?.loadRequest(NSURLRequest(URL))
        webView?.setHidden(true)

        view.addSubview(webView)

        btnGithub = UIButton(UIButtonType.Custom)
        btnGithub.setBackgroundColor(UIColor.lightGray())
        btnGithub.setFrame(CGRect(0.0, b.getHeight() - 50.0, b.getWidth(), 50.0))
        btnGithub.setTitle("GitHub", UIControlState.Normal)
        btnGithub.getTitleLabel().setFont(UIFont.getBoldSystemFont(20.0))
        btnGithub.addOnTouchDownListener({ control: UIControl, event: UIEvent ->
            btnGithub.setBackgroundColor(UIColor.clear())

            webView?.loadRequest(NSURLRequest(NSURL("https://github.com/ibinti/bugvm")))

        })
        btnGithub.addOnTouchUpInsideListener({ control: UIControl, event: UIEvent ->

            btnGithub.setBackgroundColor(UIColor.lightGray())


        })
        btnGithub.addOnTouchUpOutsideListener({ control: UIControl, event: UIEvent ->

            btnGithub.setBackgroundColor(UIColor.lightGray())

        })
        view.addSubview(btnGithub)
    }
}
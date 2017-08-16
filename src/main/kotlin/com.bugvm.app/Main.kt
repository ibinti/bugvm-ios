package com.bugvm.app

import com.bugvm.apple.foundation.NSAutoreleasePool
import com.bugvm.apple.uikit.UIApplication

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val pool = NSAutoreleasePool()
        UIApplication.main<UIApplication, BugVM>(args, null, BugVM::class.java)
        pool.close()
    }
}
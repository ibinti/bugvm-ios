import com.bugvm.apple.foundation.NSAutoreleasePool
import com.bugvm.apple.uikit.UIApplication

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val pool = NSAutoreleasePool()
        UIApplication.main<UIApplication, LadyBug>(args, null, LadyBug::class.java)
        pool.close()
    }
}
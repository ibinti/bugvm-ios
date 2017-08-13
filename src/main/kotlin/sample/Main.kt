package sample

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val pool = com.bugvm.apple.foundation.NSAutoreleasePool()
        com.bugvm.apple.uikit.UIApplication.main<com.bugvm.apple.uikit.UIApplication, Goblin>(args, null, Goblin::class.java)
        pool.close()
    }
}
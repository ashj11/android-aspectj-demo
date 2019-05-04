# android-aspectj-demo
Android project to demonstrate the issue of using `com.archinamon.aspectj` with Android connected tests.

# Description
On running the main app, activity ui is displayed which contains a single button and a text field. On Clicking the button, count will be displayed in the text view below. In logcat, we will log the time taken by the `incrementAndGetCount` function in `MainActivity.java`. 
`2019-05-04 22:26:45.957 10214-10214/com.ashj.aspectjdemo V/TraceAspect: TimeTaken= 0ms`

# Issue
Though the aspect is woven correctly and executed while running the app, when running connectedTests, this results in Class not found exception.

# Steps to reproduce
1. Run `MainActivityTest`.
Shows the below error
```
java.lang.ClassNotFoundException: com.ashj.aspectjdemo.MainActivityTest
at java.lang.Class.classForName(Native Method)
at java.lang.Class.forName(Class.java:453)
at androidx.test.internal.runner.TestLoader.doCreateRunner(TestLoader.java:72)
at androidx.test.internal.runner.TestLoader.getRunnersFor(TestLoader.java:104)
at androidx.test.internal.runner.TestRequestBuilder.build(TestRequestBuilder.java:793)
at androidx.test.runner.AndroidJUnitRunner.buildRequest(AndroidJUnitRunner.java:547)
at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:390)
at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2075)
Caused by: java.lang.ClassNotFoundException: Didn't find class "com.ashj.aspectjdemo.MainActivityTest" on path: DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/com.ashj.aspectjdemo.test-wwzgCTSCs-xIiXgmJUHk0w==/base.apk", zip file "/data/app/com.ashj.aspectjdemo-CMfzKuP0HI8ORsx86_fZyw==/base.apk"],nativeLibraryDirectories=[/data/app/com.ashj.aspectjdemo.test-wwzgCTSCs-xIiXgmJUHk0w==/lib/x86, /data/app/com.ashj.aspectjdemo-CMfzKuP0HI8ORsx86_fZyw==/lib/x86, /system/lib, /vendor/lib]]
at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:125)
at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
... 8 more
```

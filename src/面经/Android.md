#### okHttp

#### Gson

#### Butterknife

#### Retrofit

#### activity生命周期
转自 https://blog.csdn.net/xiajun2356033/article/details/78741121

四个状态：running->paused->stopped->killed

- running：一个是new  String 创建的一个新的对象，一个是常量“abc”对象的内容创建出的一个新的String对象，
- paused：依旧在用户可见状态，但是界面焦点已经失去，此Activity无法与用户进行交互
- stopped：用户看不到当前界面,也无法与用户进行交互 完全被覆盖.
- killed：当前界面被销毁，等待这系统被回收

！[activity](https://img-blog.csdn.net/20140810102151522?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZWNsb3RoeQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

Starting ——–>Running 所执行的生命周期顺序 onCreate()->onstart()->onResume()

当前称为活动状态（Running），此activity所处于任务栈的top中，可以与用户进行交互

Running ——>Paused 所执行Activity生命周期中的onPause（）

当前称为暂停状态（Paused），该Activity已失去了焦点但仍然是可见的状态(包括部分可见)。

Paused ——>Running所执行的生命周期为:OnResume()

当前重新回到活动状态(Running),此情况用户操作home键，然后重新回到当前activity界面发生。

Paused ——>Stoped所执行的生命周期为:onStop()

该Activity被另一个Activity完全覆盖的状态,该Activity变得不可见，所以系统经常会由于内存不足而将该Activity强行结束。

Stopped——>killed所执行的生命周期为:onDestroy()

该Activity被系统销毁。当一个Activity处于暂停状态或停止状态时就随处可能进入死亡状态，因为系统可能因内存不足而强行结束该Activity。

![activityLife](http://hi.csdn.net/attachment/201109/1/0_1314838777He6C.gif)

各个方法执行的动作：

onCreate():

当我们点击activity的时候，系统会调用activity的oncreate()方法，在这个方法中我们会初始化当前布局setContentLayout（）方法。

onStart():

onCreate()方法完成后，此时activity进入onStart()方法,当前activity是用户可见状态，但没有焦点，与用户不能交互，一般可在当前方法做一些动画的初始化操作。

onResume():

onStart()方法完成之后，此时activity进入onResume()方法中，当前activity状态属于运行状态 (Running)，可与用户进行交互。

onPause()

当另外一个activity覆盖当前的acitivty时，此时当前activity会进入到onPouse()方法中，当前activity是可见的，但不能与用户交互状态。

onStop()

onPause()方法完成之后，此时activity进入onStop()方法，此时activity对用户是不可见的，在系统内存紧张的情况下，有可能会被系统进行回收。所以一般在当前方法可做资源回收。

onDestroy()

onStop()方法完成之后，此时activity进入到onDestory()方法中，结束当前activity。

onRestart()

onRestart()方法在用户按下home()之后，再次进入到当前activity的时候调用。调用顺序onPause()->onStop()->onRestart()->onStart()->onResume().

activity的进程优先级。前台进程>可见进程>service进程>后台进程>空进程

- 前台进程： 
    1. 当前进程activity正在与用户进行交互。
    2. 当前进程service正在与activity进行交互或者当前service调用了startForeground()属于前台进程或者当前service正在执行生命周期（onCreate(),onStart(),onDestory()）
    3. 进程持有一个BroadcastReceiver,这个BroadcastReceiver正在执行onReceive()方法

- 可见进程：
    1. 进程持有一个activity，这个activity不再前台，处于onPause()状态下，当前覆盖的activity是以dialog形式存在的。
    2. 进程有一个service，这个service和一个可见的Activity进行绑定。

- service进程：
    1. 当前开启startService()启动一个service服务就可以认为进程是一个服务进程。

- 后台进程：
    1. activity的onStop()被调用，但是onDestroy()没有调用的状态。该进程属于后台进程。

- 空进程：
    1. 该进程没有任何运行的数据了，且保留在内存空间，并没有被系统killed,属于空进程。该进程很容易被杀死。


#### onSaveInstanceState(Bundle outState) 和 onRestoreInstanceState(Bundle outState)
- onSaveInstanceState函数在Activity生命周期中执行。
  outState 参数作用 :
  数据保存 : Activity 声明周期结束的时候, 需要保存 Activity 状态的时候, 会将要保存的数据使用键值对的形式 保存在 Bundle 对象中;
  
  调用时机 :
  Activity 被销毁的时候调用, 也可能没有销毁就调用了;
  按下Home键 : Activity 进入了后台, 此时会调用该方法;
  按下电源键 : 屏幕关闭, Activity 进入后台;
  启动其它 Activity : Activity 被压入了任务栈的栈底;
  横竖屏切换 : 会销毁当前 Activity 并重新创建；
  
  onSaveInstanceState方法调用注意事项 :
  用户主动销毁不会调用 : 当用户点击回退键 或者 调用了 finish() 方法, 不会调用该方法;
  调用时机不固定 : 该方法一定是在 onStop() 方法之前调用, 但是不确定是在 onPause() 方法之前 还是 之后调用;
  布局中组件状态存储 : 每个组件都 实现了 onSaveInstance() 方法, 在调用函数的时候, 会自动保存组件的状态, 注意, 只有有 id 的组件才会保存;
  关于默认的 super.onSaveInstanceState(outState) : 该默认的方法是实现 组件状态保存的;
  
- 方法回调时机 : 在 Activity 被系统销毁之后 恢复 Activity 时被调用, 只有销毁了之后重建的时候才调用, 如果内存充足, 系统没有销毁这个 Activity, 就不需要调用;
  – Bundle 对象传递 : 该方法保存的 Bundle 对象在 Activity 恢复的时候也会通过参数传递到 onCreate() 方法中;


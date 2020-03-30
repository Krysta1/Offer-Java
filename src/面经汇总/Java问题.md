#### Java基本数据类型 和 包装类型
byte/8 char/16 short/16 int/32 float/32 long/64 double/64 boolean/~

boolean只会有两个值：true false  可以使用1bit来存储，但是具体大小没有明确规定。JVM在编译时会将boolean类型的数据转换为int，1表示true，0表示false。JVM支持boolean数组，但是是通过读写byte数组实现的

包装类型：基本类型都有对应的包装类型，基本类型与其对应的包装类型之前的赋值使用自动装箱与拆箱完成。比如Integer x = 2装箱调用了Integer.valueOf(2)  int y = x 拆箱调用了  X.intValue()

#### new Integer(123) 和 Integer.valueOf(123) 的区别
和String a = "abc" 和 String a = new String("abc")类似，new会在堆中新建一个对象，Integer会在缓存池中查找如果用直接使用。

    Integer x = new Integer(123);
    Integer y = new Integer(123);
    System.out.println(x == y);    // false
    Integer z = Integer.valueOf(123);
    Integer k = Integer.valueOf(123);
    System.out.println(z == k);   // true
ValueOf的实现：Java8中Integer缓存池的大小默认为-128~127

    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
- boolean values true and false 
- all byte values 
- short values between -128 and 127 
- int values between -128 and 127
- char in the range \u0000 to \u007F

在 jdk 1.8 所有的数值类缓冲池中，Integer 的缓冲池 IntegerCache 很特殊，这个缓冲池的下界是 - 128，上界默认是 127，但是这个上界是可调的，在启动 jvm 的时候，通过 -XX:AutoBoxCacheMax=<size> 来指定这个缓冲池的大小，该选项在 JVM 初始化的时候会设定一个名为 java.lang.IntegerCache.high 系统属性，然后 IntegerCache 初始化的时候就会读取该系统属性来决定上界。

#### String
String 被声明为 final，因此它不可被继承。(Integer 等包装类也不能被继承）value 数组被声明为 final，这意味着 value 数组初始化之后就不能再引用其它数组。并且 String 内部没有改变 value 数组的方法，因此可以保证 String 不可变。

不可变会带来一些好处：可以缓存 hash 值，因为 String 的 hash 值经常被使用，例如 String 用做 HashMap 的 key。不可变的特性可以使得 hash 值也不可变，因此只需要进行一次计算。

String Pool 的需要：如果一个 String 对象已经被创建过了，那么就会从 String Pool 中取得引用。只有 String 是不可变的，才可能使用 String Pool。

安全性：String 经常作为参数，String 不可变性可以保证参数不可变。例如在作为网络连接参数的情况下如果 String 是可变的，那么在网络连接过程中，String 被改变，改变 String 的那一方以为现在连接的是其它主机，而实际情况却不一定是。

线程安全：String 不可变性天生具备线程安全，可以在多个线程中安全地使用。

#### String String Buffer String Builder对比
1.可变性
   - String 不可变
   - StringBuffer 和 StringBuilder 可变
    
2.线程安全
 - String 不可变，因此是线程安全的
- StringBuilder 不是线程安全的
- StringBuffer 是线程安全的，内部使用 synchronized 进行同步

#### String Pool
字符串常量池（String Pool）保存着所有字符串字面量（literal strings），这些字面量在编译时期就确定。不仅如此，还可以使用 String 的 intern() 方法在运行过程将字符串添加到 String Pool 中。

当一个字符串调用 intern() 方法时，如果 String Pool 中已经存在一个字符串和该字符串值相等（使用 equals() 方法进行确定），那么就会返回 String Pool 中字符串的引用；否则，就会在 String Pool 中添加一个新的字符串，并返回这个新字符串的引用。

下面示例中，s1 和 s2 采用 new String() 的方式新建了两个不同字符串，而 s3 和 s4 是通过 s1.intern() 方法取得同一个字符串引用。intern() 首先把 s1 引用的字符串放到 String Pool 中，然后返回这个字符串引用。因此 s3 和 s4 引用的是同一个字符串。
    
    String s1 = new String("aaa");
    String s2 = new String("aaa");
    System.out.println(s1 == s2);           // false
    String s3 = s1.intern();
    String s4 = s1.intern();
    System.out.println(s3 == s4);           // true
如果是采用 "bbb" 这种字面量的形式创建字符串，会自动地将字符串放入 String Pool 中。

    String s5 = "bbb";
    String s6 = "bbb";
    System.out.println(s5 == s6);  // true
    
#### new String("abc")
使用这种方式一共会创建两个字符串对象（前提是 String Pool 中还没有 "abc" 字符串对象）。

- "abc" 属于字符串字面量，因此编译时期会在 String Pool 中创建一个字符串对象，指向这个 "abc" 字符串字面量；
- 而使用 new 的方式会在堆中创建一个字符串对象。

以下是 String 构造函数的源码，可以看到，在将一个字符串对象作为另一个字符串对象的构造函数参数时，并不会完全复制 value 数组内容，而是都会指向同一个 value 数组。

    public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
    }
    
#### 参数传递
Java 的参数是以值传递的形式传入方法中，而不是引用传递。存储的是对象的地址。在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中。

在方法中将指针引用了其它对象，那么此时方法里和方法外的两个指针指向了不同的对象，在一个指针改变其所指向对象的内容对另一个指针所指向的对象没有影响。

    public class PassByValueExample {
        public static void main(String[] args) {
            Dog dog = new Dog("A");
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            func(dog);
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            System.out.println(dog.getName());          // A
        }
    
        private static void func(Dog dog) {
            System.out.println(dog.getObjectAddress()); // Dog@4554617c
            dog = new Dog("B");
            System.out.println(dog.getObjectAddress()); // Dog@74a14482
            System.out.println(dog.getName());          // B
        }
    }
    
#### double与float
Java 不能隐式执行向下转型，因为这会使得精度降低。
对于// float f = 1.1;是不允许的，因为1.1字面量属于double类型，这是向下转化
1.1f才是float字面量，正确的做法是float f = 1.1f;

#### 隐式类型转化问题

    short s1 = 1;不可以，因为1的字面量是int，比short的精度高，不能进行隐式类型转换
    但是 s1 += 1; s1++;可以，因为相当于执行了 s1 = (short) (s1 + 1);
    将 s1 + 1 的计算结果进行了向下转型：

#### 

#### 为什么需要垃圾回收
如果不进行垃圾回收，内存迟早都会被消耗空，因为我们在不断的分配内存空间而不进行回收。除非内存无限大，我们可以任性的分配而不回收，但是事实并非如此。所以，垃圾回收是必须的。
https://www.cnblogs.com/xiaoxi/p/6486852.html
https://www.cnblogs.com/andy-zcx/p/5522836.html

#### 为什么JVM不使用引用计数法
无法处理两个对象相互引用的情况，比如Obj1.instance = Obj2  Obj2.instance = Obj1
Obj1 = null   Obj2 = null 但是两个对象都不会被回收，因为count计数还是1

#### JVM的内存空间
https://www.cnblogs.com/ityouknow/p/5610232.html

#### 线程和进程的区别
https://blog.csdn.net/ThinkWon/article/details/102021274
与进程不同的是同类的多个线程共享进程的堆和方法区资源，但每个线程有自己的程序计数器、虚拟机栈和本地方法栈，所以系统在产生一个线程，或是在各个线程之间作切换工作时，负担要比进程小得多，也正因为如此，线程也被称为轻量级进程。

根本区别：进程是操作系统资源分配的基本单位，而线程是处理器任务调度和执行的基本单位

进程：

1 进程是资源竞争的基本单位，比如竞争CPU的调度，以及申请内存（物理地址空间）

2 进程之间相互独立安全性高，如果两个进程之间需要进行（事件通知，数据传输，资源共享，进程控制）那么就需要通过进程间通信（管道，消息队列，共享内存，信号量等）的方式来达成。

3 进程有自己的内存，通过分页将虚拟地址空间映射到物理地址空间来存储数据

线程：

1 线程是程序运行的最小单位，线程是进程的一个分流（一个进程至少有一个线程）

2 一个进程内部的多个线程之间共享进程的数据，如果多个线程同时访问临界资源就会存在线程冲突（通过互斥锁来放置线程访问共享资源冲突的问题，有的时候互斥锁会带“死锁”和“饥饿现象”的问题），当然大多数线程内部的数据是单独享有的存储在线程栈上面。

3 线程共享进程的虚拟地址空间（共享段、数据段）、用户ID和组ID、文件描述符表、当前工作目录、但是线程也私有自己的一部分数据例如一组寄存器（用于线程切换时保存独立硬件上下）、用户栈（保存私有数据）、线程优先级等

#### String a = "abc" 和 String a = new String("abc")有什么区别
简单来说就是，前者在常量池中，后者在堆中

String a = "abc";
首先会在栈中创建一个对String类对象的引用变量a，然后去查找字符串常量池中是否有"abc"。如果有，会把a指向这个对象的地址。如果字符串常量池中没有"abc"，则在栈中创建三个char型的值'a','b','c'，然后在堆中创建一个String对象object，它的值是刚才在栈中创建的三个char型值组成的数组{'a','b','c'}，接着这个String对象object会被存放进字符串常量池中，最后将a指向这个对象的的地址。

String b = new String("abc");


可以分为两步，String object = "abc"; 和 String b = new String(object);
第一步参照上面，第二步由于"abc"已经被创建并保存在字符串常量池中，因此jvm只会在堆中创建一个String对象，它的值共享栈中已有的三个char型值。

第一种方式JVM会根据String pool中的具体情况来决定是否创建新的对象。
第二种方式一概在堆中创建新的对象，而不管字符串常量池中是否已有这个的字符串。

#### ArrayList 和 LinkedList 的区别
ArrayList基于动态数组实现的非线程安全的集合；LinkedList基于链表实现的非线程安全的集合。

对于随机index访问的get和set方法，一般ArrayList的速度要优于LinkedList。因为ArrayList直接通过数组下标直接找到元素；LinkedList要移动指针遍历每个元素直到找到为止。

新增和删除元素，一般LinkedList的速度要优于ArrayList。因为ArrayList在新增和删除元素时，可能扩容和复制数组；LinkedList实例化对象需要时间外，只需要修改指针即可。

LinkedList集合不支持 高效的随机随机访问（RandomAccess）

ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间
————————————————
版权声明：本文为CSDN博主「ConstXiong」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/meism5/article/details/89845468

#### String类如何被加载的【类加载机制】；双亲委派模型【常规题】
https://blog.csdn.net/xstardust/article/details/98495630
https://www.cnblogs.com/aspirant/p/7200523.html
https://blog.csdn.net/ren365880/article/details/83786535
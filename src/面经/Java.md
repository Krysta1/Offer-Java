#### 类和类之间的关系
继承、实现、依赖、关联、聚合、组合。

继承：一个类或者接口继承另一个类或者接口的功能，并且可以增加自己的新功能的能力。通过extends关键字标识，UML图用一条带空心三角箭头的实线表示。

实现：一个类实现接口的功能，是类和接口之间最常见的关系。通过implements关键字标识，UML中带空心三角箭头的虚线表示。

依赖：一个类A用到了另一个类B，这种关系是偶然性的，临时性的，非常弱的，但是类B的变化会影响到A。代码层面就是类B作为参数被类A中的某个方法使用。UML中，类A指向类B的带箭头虚线。

关联：关系比依赖更强一点，一般是长期性的，双方平等的关系。可以是单向，双向的。代码层面，被关联类B以类的属性形式出现在关联类A中。也可能是关联类A引用了一个类型为被关联类B的全局变量。
UML中，由关联类A指向被关联类B的带箭头实现表示，可以在两端标注关联双方的角色和多重性标记。

聚合：是关联关系的一种特例，它体现的是整体与部分的关系，即has-a的关系。整体与部分之间是可分离的，它们可以具有各自的生命周期，部分可以属于多个整体对象，也可以为多个整体对象共享。
表现在代码层面，和关联关系是一致的，UML中，聚合关系以空心菱形加实线箭头表示。

组合：组合也是关联关系的一种特例，它体现的是一种contains-a的关系，这种关系比聚合更强，也称为强聚合。
同样体现整体与部分间的关系，但此时整体与部分是不可分的，整体的生命周期结束也就意味着部分的生命周期结束。表现在代码层面，和关联关系是一致的，
UML中，组合关系以实心菱形加实线箭头表示。

总的来说，后几种关系所表现的强弱程度依次为：组合 > 聚合 > 关联 > 依赖。

#### 数组和链表的区别。
数组：内存中，数组是一块连续的区域。数组需要预留空间，在使用前要先申请占内存的大小，可能会浪费内存空间。 插入数据和删除数据效率低，随机读取效率很高。不利于扩展，数组定义的空间不够时要重新定义数组。

链表：内存中可以存在任何地方，不要求连续。每一个数据都保存了下一个数据的内存地址，通过这个地址找到下一个数据。增加数据和删除数据很容易。查找数据时效率低，因为不具有随机访问性。不指定大小，扩展方便。

#### Java集合框架知识
转载https://blog.csdn.net/ThinkWon/article/details/98844796

集合和数组的区别：数组是固定长度的；集合可变长度的。数组可以存储基本数据类型，也可以存储引用数据类型；集合只能存储引用数据类型。数组存储的元素必须是同一个数据类型；集合存储的对象可以是不同数据类型。

集合容器在不断向上抽取过程中，出现了集合体系。在使用一个体系的原则：参阅顶层内容。建立底层对象。

Iterator接口，用于遍历集合元素的接口。hasNext() 如果仍有元素可以迭代，则返回true。next() 返回迭代的下一个元素。remove() 从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("abc0");
        list1.add("abc1");
        list1.add("abc2");
    
        // while循环方式遍历
        Iterator it1 = list1.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    
        // for循环方式遍历
        for (Iterator it2 = list1.iterator(); it2.hasNext(); ) {
            System.out.println(it2.next());
        }
    
    }

ListIterator是一个功能更加强大的迭代器 只能用于各种List类型的访问 可以调用listIterator(n)方法创建一个一开始就指向列表索引为n的元素处的ListIterator
1. 允许我们向前、向后两个方向遍历 List；
2. 在遍历时修改 List 的元素；
3. 遍历时获取迭代器当前游标所在位置。

- add(E e) 将指定的元素插入到列表 （可选操作）。
- hasPrevious() 如果此列表迭代器在相反方向还有更多的元素时，返回 true
- nextIndex() 返回调用 next()后返回的元素索引。
- previous() 返回列表中的上一个元素和光标的位置向前移动。
- previousIndex() 返回调用previous() 后返回的元素索引 。
- remove() 删除列表中调用next()或previous()的返回最后一个元素。
- set(E e) 用指定元素替换列表中调用next()或previous()的返回最后一个元素。

单列集合的继承关系
！[Collection](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tL0pvdXJXb24vaW1hZ2UvbWFzdGVyL0phdmElRTklOUIlODYlRTUlOTAlODglRTYlQTElODYlRTYlOUUlQjYvY29sbGVjdGlvbi5wbmc)

Collection集合主要有List和Set两大接口
- List：有序(元素存入集合的顺序和取出的顺序一致)，元素都有索引。元素可以重复。
- Set：无序(存入和取出顺序有可能不一致)，不可以存储重复元素。必须保证元素唯一性。

List集合，主要实现：ArrayList， LinkedList， Vector。

常见方法：
- 增：add(index, element) addAll(index, Collection)
- 删：remove(index) removeAll(Collection) clear()
- 改：set(index, element)
- 获取：get(index) subList(from, to) listIterator() indexOf(obj) size()
- 判断：isEmpty() contains(Collection)

ArrayList、LinkedList、Vector 的区别:

|   | ArrayList | LinkedList | Vector |
| ------ | ------ | ------ | ------ |
| 底层实现 | 数组 | 双向链表 | 数组 |
|同步性及效率|不同步，非线程安全，效率高，支持随机访问|不同步，非线程安全，效率高|同步，线程安全，效率低|
|特点|查询快，增删慢|查询慢，增删快|查询快，增删慢|
|默认容量|10|/|10|
|扩容机制|1.5 倍|/|2 倍|

遍历时操作元素：在ArrayList中，modCount是指集合的修改次数，当进行add或者delete时，modCount会+1；expectedModCount是指集合的迭代器的版本号，初始值是modCount，但是当集合进行add或者delete操作时，modCount会+1，而expectedModCount不会改变，所以方法二中会抛出异常。但是it.remove操作时，会同步expectedModCount的值，把modCount的值赋予expectedModCount。所以不会抛出异常。

Set集合：主要实现类：HashSet， TreeSet。

常见方法：基本同于List集合。多了
- equals(Object c)
- hashCode()

HashSet、TreeSet、LinkedHashSet的区别

|   | HashSet | TreeSet | LinkedHashSet |
| ------ | ------ | ------ | ------ |
| 底层实现 | HashMap | 红黑树 | LinkedHashMap |
| 重复性 | 不允许重复 | 不允许重复 | 不允许重复 |
|有无序|无序|有序，支持两种排序方式，自然排序和定制排序，其中自然排序为默认的排序方式。|有序，以元素插入的顺序来维护集合的链接表|
|时间复杂度|add()，remove()，contains()方法的时间复杂度是O(1)|add()，remove()，contains()方法的时间复杂度是O(logn)|LinkedHashSet在迭代访问Set中的全部元素时，性能比HashSet好，但是插入时性能稍微逊色于HashSet，时间复杂度是 O(1)。|
|同步性|不同步，线程不安全|不同步，线程不安全|不同步，线程不安全|
|null值|允许null值|不支持null值，因为TreeSet应用 compareTo() 方法于各个元素来比较他们，当比较null值时会抛出 NullPointerException异常。|允许null值|
|比较|equals()|compareTo()|equals()|

HashSet如何检查重复

HashSet会先计算对象的hashcode值来判断对象加入的位置，同时也会与其他加入的对象的hashcode值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。
但是如果发现有相同hashcode值的对象，这时会调用equals()方法来检查hashcode相等的对象是否真的相同。如果两者相同，HashSet就不会让加入操作成功。

Map接口：常用实现类：HashMap、TreeMap、HashTable、LinkedHashMap、ConcurrentHashMap
Map 是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。

常见方法：
- 增：put(Object key, Object value) putAll(Map t)
- 删：remove(Object key) clear()
- 获取：get(Object key) entrySet() keySet() Values() size()
- 判断：isEmpty() containsKey() containsValue()
- 额外：同Set equals(Object c) hashCode()

HashMap、HashTable、TreeMap的区别:

|   | HashMap | HashTable | TreeMap |
| ------ | ------ | ------ | ------ |
| 底层实现 | 哈希表（数组+链表） | 哈希表（数组+链表） | 红黑树 |
|同步性|线程不同步|同步|线程不同步|
|null值|允许 key 和 Vale 是 null，但是只允许一个 key 为 null，且这个元素存放在哈希表 0 角标位置|不允许key、value 是 null|value允许为null。当未实现 Comparator 接口时，key 不可以为null当实现 Comparator 接口时，若未对 null 情况进行判断，则可能抛 NullPointerException 异常。如果针对null情况实现了，可以存入，但是却不能正常使用get()访问，只能通过遍历去访问。                                                                                   |
|hash|使用hash(Object key)扰动函数对 key 的 hashCode 进行扰动后作为 hash 值|直接使用 key 的 hashCode() 返回值作为 hash 值| |
|容量|容量为 2^4 且容量一定是 2^n|默认容量是11，不一定是 2^n| |
|扩容|两倍，且哈希桶的下标使用 &运算代替了取模|2倍+1，取哈希桶下标是直接用模运算||

集合工具类Collections：这个类不需要创建对象，内部提供的都是静态方法：

    Collections.sort(list);//list集合进行元素的自然顺序排序。
    Collections.sort(list,new ComparatorByLen());//按指定的比较器方法排序。
    class ComparatorByLen implements Comparator<String>{
      public int compare(String s1,String s2){
         int temp = s1.length()-s2.length();
         return temp==0?s1.compareTo(s2):temp;
      }
    }
    Collections.max(list);//返回list中字典顺序最大的元素。
    int index = Collections.binarySearch(list,"zz");//二分查找，返回角标。
    Collections.reverseOrder();//逆向反转排序。
    Collections.shuffle(list);//随机对list中的元素进行位置的置换。
    
    //将非同步集合转成同步集合的方法：Collections中的  XXX synchronizedXXX(XXX);  
    //原理：定义一个类，将集合所有的方法加同一把锁后返回。
    List synchronizedList(list);
    Map synchronizedMap(map);

数组工具类Arrays：用于操作数组对象的工具类，里面都是静态方法。

数组 -> 集合：asList方法，将数组转换成list集合。

    String[] arr ={"abc","kk","qq"};
    List<String> list =Arrays.asList(arr);//将arr数组转成list集合。
    // 如果数组中存储的引用数据类型，直接作为集合的元素可以直接用集合方法操作。
    // 数组中存储的是基本数据类型，asList会将数组实体作为集合元素存在。
    
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        List<int[]> intList = Arrays.asList(arr1);
        // intList size: 1
        System.out.println(String.format("intList size: %s", intList.size()));
    
        Integer[] arr2 = { 1, 2, 3, 4, 5 };
        List<Integer> integerList = Arrays.asList(arr2);
        // integerList size: 5
        System.out.println(String.format("integerList size：%s", integerList.size()));
    }

asList方法接受的参数是一个泛型的变长参数，基本数据类型是无法泛型化的，也就是说基本类型是无法作为asList方法的参数的， 
要想作为泛型参数就必须使用其所对应的包装类型。但是这个这个实例中为什么没有出错呢？因为该实例是将int 类型的数组当做其参数，
而在Java中数组是一个对象，它是可以泛型化的。所以该例子是不会产生错误的。既然例子是将整个int 类型的数组当做泛型参数，那么经过asList转换就只有一个int 的列表了.

asList转换得到的ArrayList不是java.util.ArrayList，此处ArrayList是Arrays的内部类,并没有add方法,add方法是父类AbstractList的,但是没有具体实现,而是直接抛出UnsupportedOperationException异常.

    // 错误操作
    public static void main(String[] args) {
        String[] arr = {"abc", "kk", "qq"};
        List<String> list = Arrays.asList(arr);
        // 添加一个元素,抛出异常UnsupportedOperationException
        list.add("bb");
    }
    // 正确操作
    public static void main(String[] args) {
        String[] arr = {"abc", "kk", "qq"};
    	// 使用new ArrayList包裹一层
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.add("bb");
    }

集合 -> 数组：用的是Collection接口中的toArray()方法;

如果给toArray传递的指定类型的数据长度小于了集合的size，那么toArray方法，会自定再创建一个该类型的数据，长度为集合的size。

如果传递的指定的类型的数组的长度大于了集合的size，那么toArray方法，就不会创建新数组，直接使用该数组即可，并将集合中的元素存储到数组中，其他为存储元素的位置默认值null。

所以，在传递指定类型数组时，最好的方式就是指定的长度和size相等的数组

#### hashCode()与equals()的相关规定：
- 如果两个对象相等，则hashcode一定也是相同的
- 两个对象相等，equals方法返回true
- 两个对象有相同的hashcode值，它们也不一定是相等的
- 综上，equals方法被覆盖过，则hashCode方法也必须被覆盖
  hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）。

#### 抽象类和接口区别
https://blog.csdn.net/qq_44543508/article/details/102609910 这个总结的超级好

接口是对动作的抽象，抽象类是对根源的抽象。

总结：
1. 抽象类和接口都不能直接实例化。
2. 抽象类要被子类继承，接口要被类实现。
3. 接口只能做方法申明，抽象类中可以做方法申明，也可以做方法实现
4. 接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量
5. 抽象类里的抽象方法必须全部被子类所实现，如果子类不能全部实现父类抽象方法，那么该子类只能是抽象类。同样，一个实现接口的时候，如不能全部实现接口方法，那么该类也只能为抽象类。
6. 抽象方法只能申明，不能实现，接口是设计的结果，抽象类是重构的结果
7. 抽象类里可以没有抽象方法
8. 如果一个类里有抽象方法，那么这个类只能是抽象类
9. 抽象方法要被实现，所以不能是静态的，也不能是私有的。
10. 接口可继承接口，并可多继承接口，但类只能单根继承。

- 抽象类 和 接口 都是用来抽象具体对象的. 但是接口的抽象级别最高；
- 抽象类可以有具体的方法 和属性,  接口只能有抽象方法和不可变常量
- 抽象类主要用来抽象类别,接口主要用来抽象功能.
- 抽象类中，且不包含任何实现，派生类必须覆盖它们。接口中所有方法都必须是未实现的
- 不能创建构造方法；接口中的静态方法，只能接口进行调用；接口中定义的变量默认是public static final 型，且必须给其初值，所以实现类中不能重新定义，也不能改变其值。接口方法，访问权限必须是公共的 public 接口内只能有公共方法，不能存在成员变量 接口内只能含有未被实现的方法，也叫抽象方法，但是不用abstract关键字。
- 什么是抽象方法？我们在类里面定义的没有方法体的方法就是抽象方法，abstract function fun1(); 只要一个类里面有一个方法是抽象方法，那么这个类就要定义为抽象类，
抽象类也要使用“abstract”关键字来修饰；在抽象类里面可以有不是抽象的方法和成员属性，但只要有一个方法是抽象的方法，抽象类修饰符必须为public或者protected，不能是private，

- 接口只有定义，不能有方法的实现，java 1.8中可以定义default方法体，而抽象类可以有定义与实现，方法可在抽象类中实现。
- 接口强调特定功能的实现，而抽象类强调所属关系。
- 接口成员变量默认为public static final，必须赋初值，不能被修改；其所有的成员方法都是public、abstract的。
- 抽象类中成员变量默认default，可在子类中被重新定义，也可被重新赋值；
- 抽象方法被abstract修饰，不能被private、static、synchronized和native等修饰，必须以分号结尾，不带花括号。

- 关于static关键字。虽然外部抽象类不能用Static修饰，但内部的抽象类却可以使用static声明是的，当使用static声明的内部抽象类相当于一个外部抽象类，继承的时候使用“外部类.内部类”的形式表示类名称。这种骚操作属实是稳中带皮。

- 接口中的方法定义默认为public abstract类型，接口中的成员变量类型默认为public static final。

#### 进程和线程的区别
https://blog.csdn.net/ThinkWon/article/details/102021274
根本区别：进程是操作系统资源分配的基本单位，而线程是处理器任务调度和执行的基本单位

资源开销：每个进程都有独立的代码和数据空间（程序上下文），程序之间的切换会有较大的开销；同类的多个线程共享进程的堆和方法区资源，线程可以看做轻量级的进程，同一类线程共享代码和数据空间，每个线程都有自己独立的运行栈和程序计数器（PC），线程之间切换的开销小。

内存分配：同一进程的线程共享本进程的地址空间和资源，而进程之间的地址空间和资源是相互独立的

影响关系：一个进程崩溃后，在保护模式下不会对其他进程产生影响，但是一个线程崩溃整个进程都死掉。所以多进程要比多线程健壮。

执行过程：每个独立的进程有程序运行的入口、顺序执行序列和程序出口。但是线程不能独立执行，必须依存在应用程序中，由应用程序提供多个线程执行控制，两者均可并发执行

堆和方法区是所有线程共享的资源，其中堆是进程中最大的一块内存，主要用于存放新创建的对象 (所有对象都在这里分配内存)，方法区主要用于存放已被加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。

多线程并不能提高运行速度，但可以提高运行效率，让CPU的使用率更高。但是如果多线程有安全问题或出现频繁的上下文切换时，运算速度可能反而更低。

#### Java中面向对象的特征，多态的具体一些体现
面向对象编程有四个特征：抽象，封装，继承，多态

- 抽象：忽略一个主题中与当前目标无关的那些方面，以便更充分地注意与当前目标有关的方面。抽象包括两个方面，一是过程抽象,二是数据抽象。
- 继承：派生类可以从它的基类那里继承方法和实例变量，并且类可以修改或增加新的方法使之更适合特殊的需要。
- 封装：封装是把过程和数据包围起来，对数据的访问只能通过已定义的界面。
- 多态：许不同类的对象对同一消息作出响应。多态性包括参数化多态性和包含多态性。多态性语言具有灵活、抽象、行为共享、代码共享的优势，很好的解决了应用程序函数同名问题。

多态的四种体现形式

- 接口和接口的继承
- 类和类的继承
- 重载
- 重写

#### 重载和重写的区别
转自 https://blog.csdn.net/wintershii/article/details/80558739

- 重载（Overload）：在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同甚至是参数顺序不同）则视为重载。同时，重载对返回类型没有要求，可以相同也可以不同，不能通过返回类型是否相同来判断重载。
    1. 重载Overload是一个类中多态性的一种表现
    2. 重载要求同名方法的参数列表不同(参数类型，参数个数甚至是参数顺序)
    3. 重载的时候，返回值类型可以相同也可以不相同。无法以返回型别作为重载函数的区分标准
    
- 重写（Override）：其实就是在子类中把父类本身有的方法重新写一遍。在方法名，参数列表，返回类型(除过子类中方法的返回值是父类中方法返回值的子类时)都相同的情况下， 对方法体进行修改或重写，这就是重写。但要注意子类函数的访问修饰权限不能少于父类的。
    1. 发生在父类与子类之间
    2. 方法名，参数列表，返回类型（除过子类中方法的返回类型是父类中返回类型的子类）必须相同
    3. 访问修饰符的限制一定要大于被重写方法的访问修饰符（public>protected>default>private)
    4. 重写方法一定不能抛出新的检查异常或者比被重写方法申明更加宽泛的检查型异常

总结：方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，而后者实现的是运行时的多态性。重载发生在一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为重载；重写发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的参数列表，有兼容的返回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里氏代换原则）。重载对返回类型没有特殊的要求，不能根据返回类型进行区分。

#### Java中创建线程的四种方法及区别
转自 https://blog.csdn.net/m0_37840000/article/details/79756932

- 继承Thread类创建线程
- 实现Runnable接口创建线程
- 使用Callable和Future创建线程
- 使用线程池（例如Executor框架）

- 继承Thread类创建线程
    1. 定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
    2. 创建Thread子类的实例，也就是创建了线程对象
    3. 启动线程，即调用线程的start()方法
- 实现Runnable接口创建线程
    1. 定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
    2. 创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
    3. 调用线程对象的start()方法来启动线程
- 使用Callable和Future创建线程
    1. 创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例。
    2. 使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
    3. 使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
    4. 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
    
    
    public class Main {
    　　public static void main(String[] args){
    　　　MyThread3 th=new MyThread3();
    　　　//使用Lambda表达式创建Callable对象
    　　   //使用FutureTask类来包装Callable对象
    　　　FutureTask<Integer> future=new FutureTask<Integer>(
    　　　　(Callable<Integer>)()->{
    　　　　　　return 5;
    　　　　}
    　　  );
    　　　new Thread(task,"有返回值的线程").start();//实质上还是以Callable对象来创建并启动线程
    　　  try{
    　　　　System.out.println("子线程的返回值："+future.get());//get()方法会阻塞，直到子线程执行结束才返回
     　　 }catch(Exception e){
    　　　　ex.printStackTrace();
    　　　}
    　　}
    }
    
- 使用线程池（Executor框架）
    1. 提交一个Callable对象给ExecutorService（如最常用的线程池ThreadPoolExecutor）
    2. 得到一个Future对象，调用Future对象的get方法等待执行结果就好了。
    
Executor框架包括：线程池，Executor，Executors，ExecutorService，CompletionService，Future，Callable等。
Executor接口中之定义了一个方法execute（Runnable command），该方法接收一个Runable实例，它用来执行一个任务，任务即一个实现了Runnable接口的类。

ExecutorService接口继承自Executor接口，它提供了更丰富的实现多线程的方法，比如，ExecutorService提供了关闭自己的方法，以及可为跟踪一个或多个异步任务执行状况而生成 Future 的方法。

ExecutorService的生命周期包括三种状态：运行、关闭、终止。创建后便进入运行状态，当调用了shutdown（）方法时，便进入关闭状态，此时意味着ExecutorService不再接受新的任务，但它还在执行已经提交了的任务，当素有已经提交了的任务执行完后，便到达终止状态。

Executors提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。   

    public static ExecutorService newFixedThreadPool(int nThreads)
    // 创建固定数目线程的线程池。
    public static ExecutorService newCachedThreadPool()
    // 创建一个可缓存的线程池，调用execute将重用以前构造的线程（如果线程可用）。
    // 如果现有线程没有可用的，则创建一个新线   程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
    public static ExecutorService newSingleThreadExecutor()
    // 创建一个单线程化的Executor。
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
    // 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
    
使用Executor执行Runnable任务：通过Executors的以上四个静态工厂方法获得 ExecutorService实例，而后调用该实例的execute（Runnable command）方法即可

使用Executor执行Callable任务：任务分两类：一类是实现了Runnable接口的类，一类是实现了Callable接口的类。两者都可以被ExecutorService执行，但是Runnable任务没有返回值，而Callable任务有返回值。

当将一个Callable的对象传递给ExecutorService的submit方法，则该call方法自动在一个线程上执行，并且会返回执行结果Future对象。同样，将Runnable的对象传递给ExecutorService的submit方法，则该run方法自动在一个线程上执行，并且会返回执行结果Future对象，但是在该Future对象上调用get方法，将返回null

自定义线程池：可以用ThreadPoolExecutor类创建，

    import java.util.concurrent.ArrayBlockingQueue;   
    import java.util.concurrent.BlockingQueue;   
    import java.util.concurrent.ThreadPoolExecutor;   
    import java.util.concurrent.TimeUnit;   
      
    public class ThreadPoolTest{   
        public static void main(String[] args){   
            //创建等待队列   
            BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);   
            //创建线程池，池中保存的线程数为3，允许的最大线程数为5  
            ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50,TimeUnit.MILLISECONDS,bqueue);   
            //创建七个任务   
            Runnable t1 = new MyThread();   
            Runnable t2 = new MyThread();   
            Runnable t3 = new MyThread();   
            Runnable t4 = new MyThread();   
            Runnable t5 = new MyThread();   
            Runnable t6 = new MyThread();   
            Runnable t7 = new MyThread();   
            //每个任务会在一个线程上执行  
            pool.execute(t1);   
            pool.execute(t2);   
            pool.execute(t3);   
            pool.execute(t4);   
            pool.execute(t5);   
            pool.execute(t6);   
            pool.execute(t7);   
            //关闭线程池   
            pool.shutdown();   
        }   
    }   
      
    class MyThread implements Runnable{   
        @Override   
        public void run(){   
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");   
            try{   
                Thread.sleep(100);   
            }catch(InterruptedException e){   
                e.printStackTrace();   
            }   
        }   
    }
    
四种方法对比：（以Runnable和Callable为基准）

- 线程只是实现Runnable或实现Callable接口，还可以继承其他类。
- 这种方式下，多个线程可以共享一个target对象，非常适合多线程处理同一份资源的情形。
- 编程稍微复杂，如果需要访问当前线程，必须调用Thread.currentThread()方法。
- 继承Thread类的线程类不能再继承其他父类（Java单继承决定）
- 前三种的线程如果创建关闭频繁会消耗系统资源影响性能，而使用线程池可以不用线程的时候放回线程池，用的时候再从线程池取，项目开发中主要使用线程池

#### String / StringBuffer / StringBuilder
- String：创建一个字符串式，首先检查池中是否有值相同的字符串对象，如果有则不需要创建直接从池中查找到的对象引用；如果没有则新建字符串对象，返回对象引用，并将新创建的对象放入池中。
String的特性：
1. 不可变性。是指String对象一旦生成，则不能再对它进行改变。
2. 针对常量池的优化。当两个String对象拥有相同的值时，他们只引用常量池中的同一个拷贝
- StringBuffer/StringBuilder：都实现了AbstractStringBuilder抽象类
StringBuffer是线程安全的，但是StringBuilder是线程不安全的。StringBuffer的底层都有synchronize关键字。因此，StringBuffer的性能要低于StringBuilder。

应用场景：

- 在字符串内容不经常发生变化的业务场景有限使用String类。如果有大量字符串进行拼接，避免使用String与String之间的“+”操作

#### String str = new String("abc"); 创建了几个对象
一个或者两个.
如果字符串常量池中存在“abc”的话，就是一个。没有就是两个
一个是new  String 创建的一个新的对象，一个是常量“abc”对象的内容创建出的一个新的String对象，


#### 线程中sleep()和wait()的区别
sleep()方法是Thread的静态方法,提供了两种sleep的方式可让我们更灵活的控制,目的是为了使线程睡眠一段时间,自然醒后继续执行,不存在继续竞争,因为期间并没有释放同步锁.

wait()是Object内的方法,每个类都继承了这个方法,每个对象都可以调研，final修饰的并不能重载只能间接调用父类Object的。

    public final native void notify();//随机唤醒一个等待的线程
    public final native void notifyAll();//唤醒所以等待执行的线程
    // 都是Object的原生的无法重写的方法
    // 唤醒之后和其他线程共同竞争CPU
    
总结：

- sleep()不释放同步锁，而wait()释放同步锁，使得其他线程可以使用同步控制块或者方法。
- wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用。
- sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常。

### GC
#### 运行时的数据区域
线程的程序计数器，Java虚拟机栈，本地方法栈；堆；方法区（包括运行时常量池）；还有直接内存。

程序计数器：记录正在执行的虚拟机字节码指令的地址（如果正在执行的是本地方法则为空）

Java虚拟机栈：Java方法在执行的同时会创建一个栈帧用于存储局部变量表、操作数栈、常量池引用等信息。从方法调用到执行完成的过程，对应着一个栈帧在Java虚拟机栈中的出栈和入栈过程。
可以使用-Xss这个虚拟机参数来指定每个线程的Java虚拟机栈内存大小。
- 当线程请求的栈深度超过最大值，会抛出StackOverflowError异常
- 栈进行动态扩展时如果无法申请到足够内存，会抛出OutOfMemoryError异常

本地方法栈：和Java虚拟机栈类似，区别在于本地方法栈是为本地方法服务的。一般使用其他语言（比如C、C++或汇编语言），并且被编译为基于本机硬件和操作系统的程序，对待这些方法需要特别处理。

堆：所有的对象都在这里进行分配，是垃圾收集的主要区域（GC堆）。堆不需要连续的内存，并且可以动态增加其内存，增加失败会抛出OOM异常。
可以使用-Xms和Xmx这两个虚拟机参数来指定一个程序的堆内存大小的初始值和最大值。

方法区：用于存放已被加载的类信息、常量、静态变量、即时编译器编译的代码等数据。不需要连续内存，可以动态扩展，失败会抛OOM异常。
HotSpot把它当成永久代来进行垃圾回收。但是难以确定永久代的大小，并且每次Full GC之后永久代的大小都会改变，所以会经常抛出OOM异常。
方法区是一个JVM规范，永久代和元空间只不过使用实现方式。JDK1.8之后，永久代的数据被分到了堆和元空间中；元空间存储类的元信息，静态变量和常量池等放入堆中。

运行时常量池：Class文件中的常量池会在类加载后被放入这个区域，除了编译期生成的常量。还可以动态生成，比如string.intern()

#### 如果判断一个对象是否可被回收
- 引用计数法：增加一个引用计数器+1；引用失效时计数器-1。引用计数为0可以被回收。但无法处理循环引用
    
    
    Test a = new Test();
    Test b = new Test();
    a.instance = b;
    b.instance = a;
    a = null;
    b = null;

- 可达性分析：以GC Roots为起始点进行搜索，可达的对象都是存活的，不可达的对象可以被回收。

    GC Roots主要包括：
    
    - 虚拟机栈中局部变量表中引用的对象
    - 本地方法栈中JNI中引用的对象
    - 方法区中类静态属性引用的对象
    - 方法区中的常量引用的对象
    
类卸载条件，要满足三条，但是即便满足也不一定会被卸载

- 该类的所有实例都被回收，此时堆中不存在该类的任何实例
- 加载该类的ClassLoader已经被回收
- 该类对应的Class对象没有在任何地方被引用，也就无法在任何地方通过发射访问该类方法

#### 四种引用类型
强引用：被强引用关联的对象不会被回收。Object obj = new Object();

软引用：内存不够的情况下才被回收。oftReference<Object> sf = new SoftReference<Object>(obj);

弱引用：一定会被回收，只能存活到下次垃圾回收发生之前。WeakReference<Object> wf = new WeakReference<Object>(obj);

虚引用：一个对象的虚引用存在与否，不会对其生存时间造成音响。设置需引用的唯一目的就是在这个对象被回收时收到一个系统通知。PhantomReference<Object> pf = new PhantomReference<Object>(obj, null);

#### 垃圾回收算法
- 标记-清除：会对对象进行回收，并取消标志位。对于回收后的分块和前一个空闲分块连续的，需要合并这两个分块。然后连接到“空闲链表”上，之后进行分配遍历这个空闲链表即可。

不足：效率不高，会产生大量不连续的内存碎片。

- 标记-整理：所有存活对象移向一端，然后直接清理掉边界以外的内存。

不足：需要大量的移动操作，处理效率低。

- 复制：内存划为两半，一块快用完时将还存活的对象复制到另一块上，然后直接清空这一半。

不足：内存的利用率低，只能利用一半。

- 分代收集：当代商业虚拟机采用的方法。一般将堆分为新生代和老生代。新生代一般使用复制算法，老年代使用标记清除或者标记整理。

#### 垃圾收集器
主要包括Serial、ParNew、Parallel Scavenge （新生代） 、CMS、Serial Old、Parallel Old（老年代）和G1

- Serial 串行，简单高效，在单个CPU环境下，没有线程交互的开销有着最高的单线程手机效率。是Client场景下默认的新生代收集器

- ParNew Server场景下的默认新生代收集器，Serial的多线程版本，只有他能够和CMS配合使用。

- Parallel Scavenge收集器，多线程，尽可能缩短垃圾收集时用户线程的停顿时间，而它的目标是达到一个可控制的吞吐量，因此它被称为“吞吐量优先”收集器。
缩短停顿时间是以牺牲吞吐量和新生代空间来换取的：新生代空间变小，垃圾回收变得频繁，导致吞吐量下降。通过一个开关参数打开 GC 自适应的调节策略（GC Ergonomics）

- Serial Old Serial 收集器的老年代版本，也是给 Client 场景下的虚拟机使用。Server 场景下作为 CMS 收集器的后备预案，在并发收集发生 Concurrent Mode Failure 时使用。JDK 1.5 以及之前版本（Parallel Old 诞生以前）中与 Parallel Scavenge 收集器搭配使用

- Parallel Old Parallel Scavenge 收集器的老年代版本。

- CMS （Concurrent Mark Sweep）Mark Sweep 指的是标记 - 清除算法。
    
    - 初始标记：仅仅只是标记一下 GC Roots 能直接关联到的对象，速度很快，需要停顿。
    - 并发标记：进行 GC Roots Tracing 的过程，它在整个回收过程中耗时最长，不需要停顿。
    - 重新标记：为了修正并发标记期间因用户程序继续运作而导致标记产生变动的那一部分对象的标记记录，需要停顿。
    - 并发清除：不需要停顿。
缺点：吞吐量低；无法处理浮动垃圾。意味着 CMS 收集不能像其它收集器那样等待老年代快满的时候再回收。如果预留的内存不够存放浮动垃圾，就会出现 Concurrent Mode Failure，这时虚拟机将临时启用 Serial Old 来替代 CMS。
标记 - 清除算法导致的空间碎片，往往出现老年代空间剩余，但无法找到足够大连续空间来分配当前对象，不得不提前触发一次 Full GC

- G1 面向服务端应用的垃圾收集器G1 可以直接对新生代和老年代一起回收。G1 把堆划分成多个大小相等的独立区域（Region），新生代和老年代不再物理隔离。
引入 Region 的概念，从而将原来的一整块内存空间划分成多个的小空间，使得每个小空间可以单独进行垃圾回收。使得可预测的停顿时间模型成为可能
通过记录每个 Region 垃圾回收时间以及回收所获得的空间（这两个值是通过过去回收的经验获得），并维护一个优先列表，每次根据允许的收集时间，优先回收价值最大的 Region。
每个 Region 都有一个 Remembered Set，用来记录该 Region 对象的引用对象所在的 Region。通过使用 Remembered Set，在做可达性分析的时候就可以避免全堆扫描。
步骤：
    - 初始标记
    - 并发标记
    - 最终标记：为了修正在并发标记期间因用户程序继续运作而导致标记产生变动的那一部分标记记录，虚拟机将这段时间对象变化记录在线程的 Remembered Set Logs 里面，最终标记阶段需要把 Remembered Set Logs 的数据合并到 Remembered Set 中。这阶段需要停顿线程，但是可并行执行。
    - 筛选回收：首先对各个 Region 中的回收价值和成本进行排序，根据用户所期望的 GC 停顿时间来制定回收计划。此阶段其实也可以做到与用户程序一起并发执行，但是因为只回收一部分 Region，时间是用户可控制的，而且停顿用户线程将大幅度提高收集效率。
空间整合：这意味着运行期间不会产生内存空间碎片。

可预测的停顿：指定在一个长度为 M 毫秒的时间片段内，消耗在 GC 上的时间不得超过 N 毫秒。

#### Minor GC 和 Full GC
- Minor GC 回收新生代，因为新生代对象存活时间很短，因此 Minor GC 会频繁执行，执行的速度一般也会比较快。
- Full GC 回收老年代和新生代，老年代对象其存活时间长，因此 Full GC 很少执行，执行速度会比 Minor GC 慢很多。

#### 内存分配策略
1. 对象优先在 Eden 分配。大多数情况下，对象在新生代 Eden 上分配，当 Eden 空间不够时，发起 Minor GC。

2. 大对象直接进入老年代。

3. 长期存活的对象进入老年代

4. 动态对象年龄判定

5. 空间分配担保。虚拟机先检查老年代最大可用的连续空间是否大于新生代所有对象总空间，如果条件成立的话，那么 Minor GC 可以确认是安全的。
不成立的话虚拟机会查看 HandlePromotionFailure 的值是否允许担保失败，如果允许那么就会继续检查老年代最大可用的连续空间是否大于历次晋升到老年代对象的平均大小，如果大于，将尝试着进行一次 Minor GC；如果小于，或者 HandlePromotionFailure 的值不允许冒险，那么就要进行一次 Full GC

#### Full GC的触发条件
1. 调用 System.gc()只是建议虚拟机执行 Full GC，但是虚拟机不一定真正去执行。

2. 老年代空间不足

3. 空间分配担保失败

4. JDK 1.7 及以前的永久代空间不足，当系统中要加载的类、反射的类和调用的方法较多时，永久代可能会被占满，在未配置为采用 CMS GC 的情况下也会执行 Full GC。如果经过 Full GC 仍然回收不了，那么虚拟机会抛出 java.lang.OutOfMemoryError。

5. Concurrent Mode Failure执行 CMS GC 的过程中同时有对象要放入老年代，而此时老年代空间不足（可能是 GC 过程中浮动垃圾过多导致暂时性的空间不足），

#### 类加载
生命周期：加载、验证、准备、解析、初始化、使用和卸载。前五个是类加载的过程。

- 加载：通过类的完全限定名称获取定义该类的二进制字节流。将该字节流表示的静态存储结构转换为方法区的运行时存储结构。在内存中生成一个代表该类的 Class 对象，作为方法区中该类各种数据的访问入口。
- 验证：确保 Class 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
- 准备：类变量是被 static 修饰的变量，准备阶段为类变量分配内存并设置初始值，使用的是方法区的内存。
- 解析：将常量池的符号引用替换为直接引用的过程。
- 初始化：初始化阶段才真正开始执行类中定义的 Java 程序代码。初始化阶段是虚拟机执行类构造器 <clinit>() 方法的过程。
<clinit>() 是由编译器自动收集类中所有类变量的赋值动作和静态语句块中的语句合并产生的，编译器收集的顺序由语句在源文件中出现的顺序决定。特别注意的是，静态语句块只能访问到定义在它之前的类变量，定义在它之后的类变量只能赋值，不能访问。
虚拟机会保证一个类的 <clinit>() 方法在多线程环境下被正确的加锁和同步，虚拟机会保证一个类的 <clinit>() 方法在多线程环境下被正确的加锁和同步，
#### 类初始化时机
1. 主动引用。下列五种情况必须对类进行初始化，遇到new、getstatic、putstatic、invokestatic这四条字节码指令，要初始化没有进行初始化过的类；使用java.lang.reflect包的方法对类进行反射调用的时候；初始化一个类的时候，发现其弗雷还没有进行初始化；虚拟机启动时，用户指定要执行的类（main方法的那个类）；
使用 JDK 1.7 的动态语言支持时，如果一个 java.lang.invoke.MethodHandle 实例最后的解析结果为 REF_getStatic, REF_putStatic, REF_invokeStatic 的方法句柄，
2. 被动引用，除上述的五种场景都是被动引用。例子：子类引用父类的静态字段，不会导致子类初始化；数组定义来引用类，不会触发此类的初始化；常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。

#### 类与类加载器
两个类相等，需要类本身相等，并且使用同一个类加载器进行加载。这是因为每一个类加载器都拥有一个独立的类名称空间。

包括类的 Class 对象的 equals() 方法、isAssignableFrom() 方法、isInstance() 方法的返回结果为 true，也包括使用 instanceof 关键字做对象所属关系判定结果为 true。

#### 类加载器分类
启动类加载器：（Bootstrap ClassLoader）此类加载器负责将存放在 <JRE_HOME>\lib 目录中的，或者被 -Xbootclasspath 参数所指定的路径中的，并且是虚拟机识别的（仅按照文件名识别，如 rt.jar，名字不符合的类库即使放在 lib 目录中也不会被加载）类库加载到虚拟机内存中。

扩展类加载器（Extension ClassLoader）由 ExtClassLoader（sun.misc.Launcher$ExtClassLoader）实现的。它负责将 <JAVA_HOME>/lib/ext 或者被 java.ext.dir 系统变量所指定路径中的所有类库加载到内存中，开发者可以直接使用扩展类加载器。

应用程序类加载器（Application ClassLoader）这个类加载器是由 AppClassLoader（sun.misc.Launcher$AppClassLoader）实现的。由于这个类加载器是 ClassLoader 中的 getSystemClassLoader() 方法的返回值，因此一般称为系统类加载器。它负责加载用户类路径（ClassPath）上所指定的类库，开发者可以直接使用这个类加载器，如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器。

#### 双亲委派模型
该模型要求除了顶层的启动类加载器外，其它的类加载器都要有自己的父类加载器。父子关系通过组合关系来实现。
1. 类加载器首先将类加载请求转发到父类加载器，只有当父类加载器无法完成时才尝试自己加载。
2. 具有一种带有优先级的层次关系，从而使得基础类得到统一。比如你没法自己实现一个String类或者Object类，会先加载父类加载器中的类。

#### 设计模式
- 单例：确保一个类只有一个实例，并提供该实例的全局访问点。

#### Retrofit
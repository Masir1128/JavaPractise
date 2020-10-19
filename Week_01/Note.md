# 笔记
1、自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论

操作步骤：

1、新建java工程，并编写以下代码

```java
public class hello {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int sum = a+b;
        for(int i = 0 ; i<b;i++){
            if(i == 2){
                System.out.println("i = 2");
                break;
            }else {
                System.out.println("当前i值为"+i+"  sum的值为"+sum);
            }
        }

    }
}

```

2.查看字节码

```java
Microsoft Windows [版本 10.0.18363.1139]
(c) 2019 Microsoft Corporation。保留所有权利。
F:\极客大学\Java训练营\Code\Hello\out\production\Hello>javap -v hello
Classfile /F:/极客大学/Java训练营/Code/Hello/out/production/Hello/hello.class
  Last modified 2020年10月16日; size 943 bytes
  SHA-256 checksum 1faa758469529f02ea3bd8e206fd6c6f9c613552f6aeedd309ac31b46c99f11e
  Compiled from "hello.java"
public class hello
  minor version: 0
  major version: 52
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #12                         // hello
  super_class: #13                        // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #13.#34        // java/lang/Object."<init>":()V
   #2 = Fieldref           #35.#36        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #37            // i = 2
   #4 = Methodref          #38.#39        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #40            // java/lang/StringBuilder
   #6 = Methodref          #5.#34         // java/lang/StringBuilder."<init>":()V
   #7 = String             #41            // 当前i值为
   #8 = Methodref          #5.#42         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #9 = Methodref          #5.#43         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  #10 = String             #44            //   sum的值为
  #11 = Methodref          #5.#45         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #12 = Class              #46            // hello
  #13 = Class              #47            // java/lang/Object
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               LocalVariableTable
  #19 = Utf8               this
  #20 = Utf8               Lhello;
  #21 = Utf8               main
  #22 = Utf8               ([Ljava/lang/String;)V
  #23 = Utf8               i
  #24 = Utf8               I
  #25 = Utf8               args
  #26 = Utf8               [Ljava/lang/String;
  #27 = Utf8               a
  #28 = Utf8               b
  #29 = Utf8               sum
  #30 = Utf8               StackMapTable
  #31 = Class              #26            // "[Ljava/lang/String;"
  #32 = Utf8               SourceFile
  #33 = Utf8               hello.java
  #34 = NameAndType        #14:#15        // "<init>":()V
  #35 = Class              #48            // java/lang/System
  #36 = NameAndType        #49:#50        // out:Ljava/io/PrintStream;
  #37 = Utf8               i = 2
  #38 = Class              #51            // java/io/PrintStream
  #39 = NameAndType        #52:#53        // println:(Ljava/lang/String;)V
  #40 = Utf8               java/lang/StringBuilder
  #41 = Utf8               当前i值为
  #42 = NameAndType        #54:#55        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #43 = NameAndType        #54:#56        // append:(I)Ljava/lang/StringBuilder;
  #44 = Utf8                 sum的值为
  #45 = NameAndType        #57:#58        // toString:()Ljava/lang/String;
  #46 = Utf8               hello
  #47 = Utf8               java/lang/Object
  #48 = Utf8               java/lang/System
  #49 = Utf8               out
  #50 = Utf8               Ljava/io/PrintStream;
  #51 = Utf8               java/io/PrintStream
  #52 = Utf8               println
  #53 = Utf8               (Ljava/lang/String;)V
  #54 = Utf8               append
  #55 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #56 = Utf8               (I)Ljava/lang/StringBuilder;
  #57 = Utf8               toString
  #58 = Utf8               ()Ljava/lang/String;
{
  public hello();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lhello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=5, args_size=1
         0: iconst_1
         1: istore_1
         2: iconst_3
         3: istore_2
         4: iload_1
         5: iload_2
         6: iadd
         7: istore_3
         8: iconst_0
         9: istore        4
        11: iload         4
        13: iload_2
        14: if_icmpge     75
        17: iload         4
        19: iconst_2
        20: if_icmpne     34
        23: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        26: ldc           #3                  // String i = 2
        28: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        31: goto          75
        34: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        37: new           #5                  // class java/lang/StringBuilder
        40: dup
        41: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
        44: ldc           #7                  // String 当前i值为
        46: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        49: iload         4
        51: invokevirtual #9                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        54: ldc           #10                 // String   sum的值为
        56: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        59: iload_3
        60: invokevirtual #9                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        63: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        66: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        69: iinc          4, 1
        72: goto          11
        75: return
      LineNumberTable:
        line 3: 0
        line 4: 2
        line 5: 4
        line 6: 8
        line 7: 17
        line 8: 23
        line 9: 31
        line 11: 34
        line 6: 69
        line 15: 75
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           11      64     4     i   I
            0      76     0  args   [Ljava/lang/String;
            2      74     1     a   I
            4      72     2     b   I
            8      68     3   sum   I
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 11
          locals = [ class "[Ljava/lang/String;", int, int, int, int ]
          stack = []
        frame_type = 22 /* same */
        frame_type = 250 /* chop */
          offset_delta = 40
}
SourceFile: "hello.java"

```


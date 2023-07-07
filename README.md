# JavaOne

This is my very first Java project! I recently completed a showcase project for my fundamentals of programming course in college. The main goal was to demonstrate the basics of programming, more was forbidden 🙄. It wasn't anything extraordinary, to be honest. I even had to use a pre-existing compiler and development environment like Replit as per the requirement for the project. 

However, now I'm determined to take this project further and delve deeper into Java. I want to explore object-oriented programming (OOP) in Java, building upon my existing knowledge of OOP, as well as advanced Java concepts, and even create my own simple compiling environment. This will be my initial foray into the language, and I'm excited to begin a genuine Java project. I plan to embark on more Java projects in the future, but let's start with this one—JavaOne!


## ⚒️ Java Compiling Environment

Ever had trouble installing Java packages and dealing with annoying errors on your local machine? YAH Fear not! That's why I had to go with Makefile and Dockerfile combo!

I wanted to create separate environments for running and developing my simple Java project without the headaches. By using Docker, we can avoid installing Java dependencies on our local machine and sidestep potential compatibility issues.

Lemme quickly introduce it:

### 🐳 The Dockerfile
Instead of creating separate Dockerfiles for production and development, I've used a single Dockerfile and implemented a multi-stage build approach to make things easier to manage. This way, we can handle both development and production environments within a single file. You can read more about that in [docker docs](https://docs.docker.com/build/building/multi-stage/).

### 📜 The Makefile
I didn't do much on it, just to build and run the images with a few commands like ``make dev`` for development and ``make run`` for production, I can effortlessly manage and switch between environments.


## 🚧 Java Compilation Process

### ⚙️ Strict OOP Methodology
Java is known for being a strict object-oriented programming (OOP) language, and this is evident in how its compiler operates. The Java compiler is quite particular about the structure of the files it accepts. It requires files to be organized in a way that includes classes, and when it compiles these files, it converts them into the ``.class`` file extension.

This strictness in adhering to OOP principles is essential in the context of Java. It ensures that the code is organized and follows the principles of encapsulation, inheritance, 
and polymorphism. Each file in Java typically holds a different class, like even the main function must be encapsulated within a class. This might seem a bit extra, but it's the secret behind Java's compilation process and the functionality of JAR files and the JVM.

Now you may wonder, Why this strict OOP style does even matter, mixing both procedural and object-oriented styles will look great like C++? 

Well, Java's commitment to OOP ensures code organization, modularity, and maintainability. Making it easier to update, test and maintain the classes for big applications. Plus, this strictness fuels advanced concepts like frameworks, libraries, and dependency injection, helping you build flexible, scalable, and robust applications.


### Simple Compile
To compile a Java program, we use the ``javac`` command followed by the name of the Java source file. ``javac Main.java``, the command compiles the Java source code into bytecode, represented by the ``.class`` files. i.e. ``Main.class``.

After compilation, we can execute the program using the ``java`` command followed by the name of the class containing the main method. For instance, if our class with the main method is called Main, we would run ``java Main`` to execute the program.

And that's it. Can't be further complicated, but now ..

### Large Project Compile
Working on larger Java projects with multiple files, it's common to create a JAR (Java ARchive) file. Think of it as a cool bundle that holds all our compiled ``.class`` files and other essential resources together in one place. It's like packing everything up for convenience!

To create the JAR file named myproject.jar and include all the ``.class`` files in the current directory, we can run the following command: `` jar cfm myproject.jar Manifest.txt -C bin . ``

The ``jar`` command is our go-to tool for creating JAR files. The ``c`` option tells it to create a fresh new archive. The ``f`` option lets us specify the name of the JAR file we want to create. In this case, it's called ``myproject.jar``. The ``m`` option is exciting! It points to a special file called the manifest file. This file is named ``Manifest.txt`` in this command line. The ``-C`` option is like a teleporter. It takes us to the bin directory, where our compiled files reside.

By the way, let's talk about the manifest file! It's an important part of our JAR file. Think of it as an ID card that introduces our Java application. It contains vital information, like which class holds the main function, which is the entry of the program. In this case, the content of a Manifest.txt file should be: ``Main-Class: Main``. This ensures that when we run the JAR file, the correct class will be launched as the entry point of our application.

### 🖥️ Java Virtual Machine (JVM)
Now Let's Go a bit deeper, As has been mentioned before, in simple cases, like standalone programs, java does have a two-step compilation process to run our code. 

First, the ``javac`` command compiles our Java source code into bytecode, a low-level representation of the program. Then comes the exciting part! The Java Virtual Machine (JVM) enters the stage when we use the ``java`` command. The JVM is like a virtual computer that executes our bytecode, translating it into machine-specific instructions on the fly. This allows Java programs to be platform-independent, running on any system with a compatible JVM. 

And there are actually a few reasons behind using the bytecode step, 

Firstly, By compiling Java source code into bytecode, Java achieves its famous 'write once, run anywhere' capability. The bytecode is not tied to any specific hardware or operating system, making it portable across different platforms. 

Secondly, the bytecode acts as a layer of abstraction between the high-level Java code and the underlying hardware. It allows for various optimizations and enhancements to be applied during runtime by the JVM, like for instance, improving the performance and managing the memory, like a built-in garbage collector, and avoiding other security vulnerabilities as well!

However, some programming languages like C can skip the intermediate bytecode step because they are compiled directly into machine code specific to the target system. This direct compilation allows C to achieve closer interaction with the underlying hardware, making it suitable for low-level programming tasks. Java's bytecode step, on the other hand, strikes a balance between platform independence and runtime optimizations, making it a popular choice for building robust and portable applications.

By the way, did you notice? It's called JVM, Java Virtual Machine, VIRTUAL MACHINE! Who would have thought, right? It's all about  ``Write once, run anywhere``, and no need to know more... But one second, How does it create a virtual machine to run code? It sounds crazy, doesn't it? Well, it's not about creating a whole new virtual operating system! Like what I thought :) 

The reason behind the name was that, as has been mentioned before it acts as an abstraction layer between Java programs and hardware/operating systems, lets breaks that down:

1- Hardware Abstraction:
- JVM shields Java programs from hardware specifics.
- Provides a consistent interface for Java programs to run on different hardware platforms.
- Enables execution on any system with a compatible JVM, regardless of specific hardware configurations.

2- Operating System Abstraction:
- JVM abstracts operating system details.
- Provides a uniform interface for Java programs to interact with the OS.
- Allows Java programs to be developed and run on different operating systems without modifications.

The name kinda makes sense now, JVM takes care of translating Java bytecode to appropriate instructions and system calls for the underlying hardware and OS, which makes ``Write once, run anywhere`` real. 


## 🧩 OOP Concepts Used
In this simple project, I've embraced basic inheritance and the versatile Template data structure. But that's not all! Whenever I stumble upon a new OOP concept in Java, I dive right in. This project will be my playground, where I can freely explore and experiment with Java. It's my go-to place whenever I want to venture into the realm of Java and try out new things.


## 📍Resources
- [How JVM Works – JVM Architecture?](https://www.geeksforgeeks.org/jvm-works-jvm-architecture/)
- [What is JVM?](https://www.infoworld.com/article/3272244/what-is-the-jvm-introducing-the-java-virtual-machine.html#:~:text=The%20JVM%20is%20a%20virtual,your%20program%20is%20running%20on.)
- [Java Virtual Machine](https://www.w3schools.in/java/java-virtual-machine)
- [Java and Makefiles](https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html)
- [Minimalistic Java Makefile](https://gist.github.com/the-mikedavis/23a4c0fc4e2338c5535c3b2245257c83)
- [Making a Java Makefile](https://stackoverflow.com/questions/29184999/making-a-java-makefile)
- [Compiling Java custom packages](https://www.webucator.com/article/how-to-compile-packages-in-java/)
- [Docker Multi-stage builds](https://docs.docker.com/build/building/multi-stage/)





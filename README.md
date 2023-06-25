# JavaOne

This is my very first Java project! I recently completed a showcase project for my fundamentals of programming course in college. The main goal was to demonstrate the basics of programming, more was forbidden 🙄. It wasn't anything extraordinary, to be honest. I even had to use a pre-existing compiler and development environment like Replit as per the requirement for the project. 

However, now I'm determined to take this project further and delve deeper into Java. I want to explore object-oriented programming (OOP) in Java, building upon my existing knowledge of OOP, as well as advanced Java concepts, and even create my own simple compiling environment. This will be my initial foray into the language, and I'm excited to begin a genuine Java project. I plan to embark on more Java projects in the future, but let's start with this one—JavaOne!


## Compiling and Development Environment


## Java Compilation Process

### Strict OOP Methodology
Java is known for being a strict object-oriented programming (OOP) language, and this is evident in how its compiler operates. The Java compiler is quite particular about the structure of the files it accepts. It requires files to be organized in a way that includes classes, and when it compiles these files, it converts them into the ``.class`` file extension.

This strictness in adhering to OOP principles is essential in the context of Java. It ensures that the code is organized and follows the principles of encapsulation, inheritance, 
and polymorphism. Each file in Java typically holds a different class, contributing to a modular and maintainable codebase.

### Simple Compile
To compile a Java program, we use the ``javac`` command followed by the name of the Java source file. ``javac MyProgram.java``, the command compiles the Java source code into bytecode, represented by the ``.class`` files.

After compilation, we can execute the program using the java command followed by the name of the class containing the main method. For instance, if our class with the main method is called Main, we would run ``java Main`` to execute the program.

And that's it. Can't be further complicated, but now ..

### Large Project Compile
Working on larger Java projects with multiple files, it's common to create a JAR (Java ARchive) file. Think of it as a cool bundle that holds all our compiled ``.class`` files and other essential resources together in one place. It's like packing everything up for convenience!

To create the JAR file named myproject.jar and include all the .class files in the current directory, we can run the following command: `` jar cfm myproject.jar Manifest.txt -C bin . ``

The ``jar`` command is our go-to tool for creating JAR files. The ``c`` option tells it to create a fresh new archive. The ``f`` option lets us specify the name of the JAR file we want to create. In this case, it's called ``myproject.jar``. The ``m`` option is exciting! It points to a special file called the manifest file. This file, named Manifest.txt in this command line. The -C option is like a teleporter. It takes you to the bin directory, where your compiled files reside.

By the way, let's talk about the manifest file! It's an important part of your JAR file. Think of it as an ID card that introduces your Java application. It contains vital information, like which class holds the main function, which is the entry of the program. In this case, the content of a Manifest.txt file should be: ``Main-Class: Main``. This ensures that when we run the JAR file, the correct class will be launched as the entry point of our application.


## Code Structure



## OOP Concepts Used



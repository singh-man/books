A
=

Running the Workshop Applets and Example
----------------------------------------

Programs

> In this appendix we discuss the details of running the Workshop
> applets and the example programs.

-   The Workshop applets are graphics-based demonstra- tion programs
    that show what trees and other data structures look like.

-   The example programs, whose code is shown in the text, present
    runnable Java code.

> We also discuss the Sun Microsystems Java 2 Standard Edition (J2SE)
> Software Development Kit (SDK), which you can use not only to run the
> applets and example programs in this book but to modify the example
> programs and to write your own programs.
>
> Downloadable versions of this book's applets and example programs are
> available on the Sams Web site:
> [www.samspublishing.com.](http://www.samspublishing.com/) Log on, and
> use the book's International Standard Book Number (ISBN) to access the
> book's Web page, where you'll find a link to the down- loads.

#### The Workshop Applets

> An *applet* is a special kind of Java program that is easy to send
> over the Internet's World Wide Web. Because Java applets are designed
> for the Internet, they can run on any computer platform that has an
> appropriate Web browser or applet viewer.

##### IN THIS APPENDIX

-   The Workshop Applets

-   The Example Programs

-   The Sun Microsystem's Software Development Kit

-   Multiple Class Files

-   Other Development Systems

> 730 **APPENDIX A** Running the Workshop Applets and Example Programs
>
> In this book, the Workshop applets provide dynamic, interactive
> graphics-based demonstrations of the concepts discussed in the text.
> For example, Chapter 8, "Binary Trees," includes a Workshop applet
> that shows a tree in the applet window. Clicking the applet's buttons
> will show the steps involved in inserting a new node into the tree,
> deleting an existing node, traversing the tree, and so on. Other chap-
> ters include appropriate Workshop applets.
>
> You can run the Workshop applets immediately after downloading them,
> using most popular Web browsers. This includes the current versions of
> Microsoft Internet Explorer and Netscape Communicator. Commercial Java
> development products also have an applet viewer utility that runs
> applets. You can also run the Workshop applets with the appletviewer
> utility included with the SDK.
>
> Here's how to run the applets with a typical Web browser. Working
> offline, select Open from the File menu and navigate to the
> appropriate directory. Each Workshop applet consists of a subdirectory
> containing several files with the .class extension and one file with
> the .html extension. Open the .html file. The applet should appear on
> the screen.

#### The Example Programs

> The example programs are intended to show as simply as possible how
> the data structures and algorithms discussed in this book can be
> implemented in Java. These example programs consist of Java
> *applications* (as opposed to applets). Java applica- tions are not
> meant to be sent over the Web, but instead run as normal programs on a
> specific machine.
>
> Java applications can run in either *console mode* or graphics mode.
> For simplicity, our example programs run in console mode, which means
> that output is displayed as text and input is performed by the user
> typing at the keyboard. In the Windows environment the console mode
> runs in an MS-DOS box. There is no graphics display in console mode.
>
> The source code for the example programs is presented in the text of
> the book. Source files, consisting of the same text as in the book,
> can be downloaded from the Sams Web site.

#### The Sun Microsystem's Software Development Kit

> Both the Workshop applets and the example programs can be executed
> using utility programs that are part of Sun's SDK. The SDK can be
> downloaded from Sun's Web site: [www.sun.com.](http://www.sun.com/)
> Look for the Java 2 Standard Edition (J2SE) Software Development Kit.
> This is a large download, but it gives you everything you need not
> only to run the applets and programs in this book, but to develop your
> own Java applets and applications.
>
> The Sun Microsystem's Software Development Kit 731

##### Command-line Programs

> The SDK operates in text mode, using the command line to launch its
> various programs. In Windows, you'll need to open an MS-DOS box to
> obtain this command line. Click the Start button, and find the program
> called MS-DOS Prompt. It may be in the Accessories folder, and it may
> be called something else, like Command Prompt.
>
> Then, in MS-DOS, use the cd (for Change Directory) command to move to
> the appro- priate subdirectory on your hard disk, where either a
> Workshop applet or an example program is stored. Then execute the
> applet or program using the appropriate SDK utility as detailed below.

##### Setting the Path

> In Windows, the location of the SDK utility programs should be
> specified in a PATH statement in the autoexec.bat file so they can be
> accessed conveniently from within any subdirectory. This PATH
> statement may be placed automatically in your autoexec.bat file when
> you run the setup program for the SDK. Otherwise, use the Notepad
> utility to insert the line
>
> SET PATH=C:\\JDK1.4.0\\BIN;
>
> into the autoexec.bat file, following any other SET PATH commands.
> You'll find autoexec.bat in your root directory. Close the MS-DOS box
> and open a new one to activate this new path. (Modify the version
> number and directory name as necessary.)

##### Viewing the Workshop Applets

> To use the SDK to run the Workshop applets, first use the cd command
> in MS-DOS to navigate to the desired subdirectory. For example, to
> execute the Array workshop applet from Chapter 2, "Arrays," move to
> its directory:
>
> C:\\\>cd javaapps C:\\javaapps\>cd chap02 C:\\javaapps\\chap02\>cd
> Array
>
> Then use the appletviewer utility from the SDK to execute the applet's
> .html file:
>
> C:\\javaapps\\chap02\\Array\>appletviewer Array.html
>
> The applet should start running. (Sometimes an applet takes a while to
> load, so be patient.) The applet's appearance should be close to the
> screen shots shown in the text. It won't look exactly the same because
> every applet viewer and browser inter- prets HTML and Java format
> somewhat differently.
>
> 732 **APPENDIX A** Running the Workshop Applets and Example Programs
>
> As we noted, you can also use most Web browsers to execute the
> applets.

##### Operating the Workshop Applets

> Each chapter gives instructions for operating specific Workshop
> applets. In general, remember that in most cases you'll need to
> repeatedly click a single button to carry out an operation. Each press
> of the Ins button in the Array Workshop applet, for example, causes
> one step of the insertion process to be carried out. Generally, a
> message is displayed telling what's happening at each step.
>
> You should complete each operation---that is, each sequence of button
> clicks---before clicking a different button to start a different
> operation. For example, keep clicking the Find button until the item
> with the specified key is located, and you see the message Press any
> button. Only then should you switch to another operation involv- ing
> another button, such as inserting a new item with the Ins button.
>
> The sorting applets from Chapter 3, "Simple Sorting," and Chapter 7,
> "Advanced Sorting," have a Step button with which you can view the
> sorting process one step at a time. They also have a Run mode in which
> the sort runs at high speed without additional button clicks. Just
> click the Run button once and watch the bars sort themselves. To
> pause, you can click the Step button at any time. Running can be
> resumed by clicking the Run button again.
>
> It's not intended that you study the code for the Workshop applets,
> which is mostly concerned with the graphic presentation. Hence, source
> listings are not provided.

##### Running the Example Programs

> Each example program consists of a subdirectory containing a .java
> file and a number of .class files. The .java file is the source file,
> which also appears in the text. It must be compiled before you can run
> it. The .class files are compiled and ready to run if you have a Java
> interpreter.
>
> You can use the Java interpreter from Sun's SDK to run the example
> programs directly from the .class files. For each program, one .class
> file ends with the letters App, for application. It's this file that
> must be invoked with java.
>
> From an MS-DOS prompt, go to the appropriate subdirectory (using the
> cd command) and find this App file. For example, for the insertSort
> program of Chapter 3, go to the InsertSort subdirectory for Chapter 3.
> (Don't confuse the directory holding the applets with the directory
> holding the example programs.) You'll find a
>
> .java file and several .class files. One of these is
> insertSortApp.class. To execute the program, enter
>
> C:\\chap03\\InsertSort\>java insertSortApp

Multiple Class Files 733

> Don't type a file extension after the filename. The insertSort program
> should run, and you'll see a text display of unsorted and sorted data.
> In some example programs you'll see a prompt inviting you to enter
> input, which you type at the keyboard.

##### Compiling the Example Programs

> You can experiment with the example programs by modifying them and
> then compiling and running the modified versions. You can also write
> your own applica- tions from scratch, compile them, and run them. To
> compile a Java application, you use the javac program, invoking the
> example's .java file. For example, to compile the insertSort program,
> you would go to the insertSort directory and enter
>
> C:\\chap03\\insertSort\>javac insertSort.java
>
> This time you do need to add the .java file extension. This command
> will compile the .java file into as many .class files as there are
> classes in the program. If there are errors in the source code, you'll
> see them displayed on the screen.

##### Editing the Source Code

> Many text editors are appropriate for modifying the .java source files
> or writing new ones. For example, you can invoke an MS-DOS editor
> called edit from the DOS command line, and Windows includes the
> Notepad editor. Many commercial text editors are available as well.
>
> Don't use a fancy word processor, such as Microsoft Word, for editing
> source files. Word processors typically generate output files with
> strange characters and format- ting information, which the Java
> interpreter won't understand.

##### Terminating the Example Programs

> You can terminate any running console-mode program, including any of
> the example programs, by pressing the ç-c key combination (the Control
> key and the C key pressed at the same time). Some example programs
> have a termination proce- dure that's mentioned in the text, such as
> pressing Â at the beginning of a line, but for the others you must
> press ç-c.

#### Multiple Class Files

> Often several Workshop applets, or several example programs, will use
> .class files with the same names. Note, however, that these files may
> not be identical. The applet or example program may not work if the
> wrong class file is used with it, even if the file has the correct
> name.
>
> 734 **APPENDIX A** Running the Workshop Applets and Example Programs
>
> Invoking the wrong file should not normally be a problem because all
> the files for a given program are placed in the same subdirectory.
> However, if you move files by hand, be careful not to inadvertently
> copy a file to the wrong directory. Doing this may cause problems that
> are hard to trace.

#### Other Development Systems

> There are many other Java development systems besides Sun's SDK.
> Products are available from Symantec, Microsoft, Borland, and so on.
> Sun itself has a Java devel- opment system called Sun ONE Studio 4 (it
> was formerly called Forte). These prod- ucts are generally faster and
> more convenient to use than the SDK. They typically combine all
> functions---editing, compiling, and execution---in a single window.
>
> For use with the example programs in this book, such development
> systems should be able to handle Java version 1.4.0 or later. Many
> example programs (specifically, those that include user input) cannot
> be compiled with products designed for earlier versions of Java.
> (However, with minor modifications, some of which are mentioned in
> Chapter 1, "Overview," the .java files can be made to compile with
> older develop- ment systems.)

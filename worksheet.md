# Task 0

Clone this repository (well done!)

# Task 1

Take a look at the two repositories:

  * (A) https://bitbucket.org/altmattr/personalised-correlation/src/master/
  * (B) https://github.com/Whiley/WhileyCompiler

And answer the following questions about them:

  * These repositories are at two different websites - github and bitbucket - what are these sites?  What service do they provide? Which is better?

Github & GitBucket is a developer platform that allows you collaborate on and share files.

  * Who made the last commit to repository A?

Matthew Roberts (2022-08-18)

  * Who made the first commit to repository A?

Jon Mountjoy (2014-08-11)

  * Who made the first and last commits to repository B? 

DavePierce (20120-11-22, 2022-08-11)

  * Are either/both of these projects active at the moment? 🤔 If not, what do you think happened?

The WhileyCompiler states 'preparing next release' but due to the extended absense of commits, it is unlikely the project is actually active. 

The personalised correlation also has had little edits since 2022 and chances are the project is either done or abandoned.


  * 🤔 Which file in each project has had the most activity?

Whiley - build.num 691
Master - app.py 32


# Task 2

The repository you just cloned is a VSCode project, so lets work with it.  It currently will print "Hello World" message to the console when run.

You will find "Run" and "Debug" commands over the `main` method.  Try them out.  You can also trigger them with `F5` for "Debug" and `Ctrl-F5` for "Run"

Modify the application so that instead it prints

~~~~~
Red vs. Blue
~~~~~


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("~~~~~");
        System.out.println("Red vs. Blue");
        System.out.println("~~~~~");
    }
}

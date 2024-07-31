# Task 0

Clone this repository (well done!)

# Task 1

Take a look at the two repositories:

  * (A) https://bitbucket.org/altmattr/personalised-correlation/src/master/
  * (B) https://github.com/Whiley/WhileyCompiler

And answer the following questions about them:

  * These repositories are at two different websites - github and bitbucket - what are these sites?  What service do they provide? Which is better?
  > GitHub and Bitbucket are both cloud based services offering hosting of git repositories as well as a user-friendly web front end to aid in visualising the contents of those repositories. Both sites also offer CI/CD pipeline services to automate the build and deployment of software. Neither is necessarily better than the other.

  * Who made the last commit to repository A?
  > Matthew Roberts <matthew.roberts@mq.edu.au>
  * Who made the first commit to repository A?

  > Jon Mountjoy <jon@heroku.com>

  * Who made the first and last commits to repository B?
  > DavePearce <dave01001110@gmail.com>

  * Are either/both of these projects active at the moment? 🤔 If not, what do you think happened?
  > A: most recent commit is Thu Aug 18 04:45:08 2022 +0000
  > B: most recent commit is Thu Aug 11 10:10:28 2022 +1200
  > So in the case of both projects, no, these projects are not currently active. The people writing these project have probably moved on to do something else.

  * 🤔 Which file in each project has had the most activity?
  > Some search via your favourite search engine should get you some suggestions.
  > There are at least two ways of answering this, either by the largest number of commits:
  ```
  git config diff.renamelimit 0
  git log --name-only --pretty=format: |sort|uniq -c|sort -rg|head  
  ```
  > A: 32 app.py
  > B: 696 build.num
  > or probably a better indication is to see how many lines of text have changed:
  ```
  git diff --stat $(git log --all|grep commit|tail -n1|sed -e 's/commit //')|sort -k3rn|head -n1
  ```
  > A: static/data/forces.csv                             | 23588 +++++++++++++++++++
  > B: src/main/java/wyil/lang/WyilFile.java              | 7790 ++++++++++++++++++++ 

# Task 2

The repository you just cloned is a VSCode project, so lets work with it.  It currently will print "Hello World" message to the console when run.

You will find "Run" and "Debug" commands over the `main` method.  Try them out.  You can also trigger them with `F5` for "Debug" and `Ctrl-F5` for "Run"

Modify the application so that instead it prints

~~~~~
Red vs. Blue
~~~~~

# Task 3

Draw a 20 by 20 grid on a 720x720 window.  Each cell in the grid should be 35 pixels high and wide and the grid should be drawn 10 pixels off the top and left borders of the screen.  To do this, you should use the `Graphics` class from the Java libraries.  Be sure to consult the tips video for this task (it is a link in iLearn).  Without it, you will be very confused.

# Task 4

The "grid" has no identity - it is just drawn.  Later on we will need to do lots of things "with" this grid.  We will modify it and adjust it and ask it questions.  Our task here is to refactor the program to give this grid an identity.  We will create an object to represent the grid and will give that object its own `paint` method for drawing the grid.

We will also need to give an identity to each "cell" of the grid and make each cell responsible for it's own painting to the screen.

Modify the program to make these things happen.  Make a `Grid` class and a `Cell` class and organise them in a sensible way.  What fields and methods should each class have?

# Task 5

Anything that is a `JFrame` or `JPanel` can find out the position of the mouse using `getMousePosition`.  Modify your program so that mousing over a cell will "highlight" it.  Highlighted cells should be drawn in grey.  You may have to think about how you will get the mouse position from the place you can read it, to the place it is needed (the `paint` method of a `Cell` object).

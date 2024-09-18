# Major Creative Work

Your major creative work is worth 60% of your unit total and is made up of three components:
* Milestone 1: 10%
* **Milestone 2**: 25%
* Milestone 3: 25%

# Milestone 2

Seph Frasos, the founder of the famous Congo online book store has begun expanding his business to sell other/non-book items. Customers browse and shop using a local client on their PC. A barebones variant of this client is used for development, which has recently had Sephs interns working on the new expansion. Unfortunately these interns have made a mess of things, leaving you to address the issues.

In its current state, the client performs all of the new necesssary functionality. It is however a hard to maintain code base which you will refactor and address other issues in. As you work on this milestone you should aim to apply the appropriate ideas taught in both the lectures and workshops while maintaining the clients current functionality.

All of your work should exist within the `student` directory within `src`.

## Data Files
The program reads a stock list, which specifies the path of the data files for each stocked product. Most of these are valid, however one invalid entry is made as part of the development test suite to test the programs behaviour if a data file fails to be read.

These files are read by `StockReader.java` and `DataReader.java`. Specific lines in these files should NOT be modified, and have been labelled as such. This is related to retrieving the values from the data files (not a topic of COMP2000). You may however need to make a small modification around the DO NOT MODIFY lines in regards to composing the data.

## The user interface
The source code for the user interface is provided, however no modification is needed to perform the tasks listed below. It is present for the curious.

## Task 1:

Within the provided code, a number of methods exist which are not guaranteed to return a value. Your task is to identify these methods, and to modify them such that it is clear that the returned value may or may not be valid. The goal is to indicate to any future developers that they *must* check the methods output.

## Task 2:

The program currently crashes when certain errors occur. The cause of this appears to be exception related. Find the root cause, and address it by stopping the program from crashing, and instead displaying some indication that something has gone wrong.

## Task 3: Duplicate data structures storing stock information

The interns at Congo have made a poor attempt at implementing the functionality to support the new products. They have largely done this by copy-pasting a lot of code, and have created an `ItemInterface` that allows the duplicate code to work with the UI.

Your goal is to identify the code that is a result of the over-zealous copy-pasting, and combine them in such a way that there is minimal code duplication. In this task you may end up with classes that are not longer used/needed, and as such you should delete them to tidy up the project.

# Submission

You must submit a zipped archive of your code. Your marker will download you zip file, open it in VSCode and run it from there. Please don't submit unnecessary temporary files (such as .class files) in your zip file. So you should:
* Delete any temporary files
* Rename the parent folder to match your student ID
* Upload the zip

e.g. if your student ID is 45678912 then the folder structure should look like:

```
45678912
|-- data
|   |-- stock
|   |-- *.data
|-- src
|   |-- student
|   |   |-- *.java
|   |-- userinterface
|   |   |-- *.java
|-- README.md
```

# Important notes
* Submitted code ***must*** compile. if the code does not compile and/or run you will receive a mark of zero.
* Submissions must be in a **zip** file, not rar or any other archive format and must follow the structure described above.
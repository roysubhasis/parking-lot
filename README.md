# parking_lot
Design and coding for a customized parking-lot.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

# Prerequisites
You need Git and Maven, Java and Unix in your system to See source code, Build and run project using shell script

# Git Clone
You need to do Git clone manually to get this project first in your local.
This code has been kept in a public git repo and can be accessed without id/pw.
Command: git clone <repository url>

# Build 
Maven - Dependency Management
Need Maven to build the build, as it is using pom file.
Go inside the project folder(where pom.xml resides) and run "mvn clean install"

# Run
Go inside folder "parking_lot\bin" and run the script. First you need to run "setup.sh" file.
  1. Run "setup.sh". This script will do "git pull" first in your local and the do a maven build.
  2. Run "run_functional_tests.sh". This file internal reads "file_input.txt" and execute the projects
  3. Run "parking_lot.sh". This file will run the project in interactive mode.
     User need to give the following commands to check the output.
     Sample Commands below:
      create_parking_lot 3
      park KA-01-HH-1234 White
      park KA-01-HH-9999 White
      park KA-01-BB-0001 Black
      leave 2
      status
      park KA-01-HH-1234 White
      park KA-01-BB-0001 Black
      registration_numbers_for_cars_with_colour White
      slot_numbers_for_cars_with_colour Black
      slot_number_for_registration_number KA-01-HH-1234
      slot_number_for_registration_number MH-04-AY-1111

# Version
Using a sample initial version 1.0.0

# Author
Subhasis Roy

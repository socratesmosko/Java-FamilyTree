# Java FamilyTree

Welcome to my family tree visualization application in JAVA! As a computer science student, I have developed this project as part of my course on Data Structures & Algorithms.

This JAVA application is designed to read, process, search, and visualize family trees. The application assumes that the names of the faces are all different from each other and can be used as unique identifiers.

The first step is to encode the tree into a CSV format file, including only gender (male, female) and relationships (father, mother, husband). All other relations will follow from the logic of the application.

Once the file is created, the application will load the data into an appropriate data structure in the computer's main memory. It will then put the people in lexical order and write a line for each one in one text file (name and gender only).

The main feature of the application is its ability to find the relationship between two individuals. The application will take two names as input and find the relation of the first to the second, including father, mother, son, daughter, brother, sister, cousins, husband, wife, grandparents, grandson, granddaughter, nephew, niece, uncle, aunt, or not related.

Each relationship is implemented in a separate method that will be called in sequence until the relationship of the individuals is found.

![baratheon-family-tree-game-of-thrones-1833432](https://user-images.githubusercontent.com/119309614/222029882-fda131ea-9baa-467d-8aa8-bdd02b340fcb.jpg)

# Project definition - IN PROGRESS

Target for the project is to implement two different maze creation algorithms. The algorithms I have chosen are Binary Tree and Depth First Search. Binary tree was chosen as it was my first thought how to generate mazes and to depict them. DFS came about after searching on the topic.

## Binary tree

As mentioned in [1], Binary Tree is stateless, straightforward and fast algorithm. It does produce mazes with certain characteristics that are specific for binary tree. It is quite interesting idea that the binary tree can be used to depict the maze.

## DFS

Depth First Search is familiar algorithm from TIRA and in this project it wil be used for the opposite. Instead of finding the route it will create the route. DFS uses a stack in as a part of the algorithm. According to [1] it is also quite easy to implement. It will be intesting to compare the maze characteristics between DFS and Binary Tree


## Program input

Expected user input for the program are maze size and probably the starting point. The latter needs to be considered during the implementation.


## Time complexity
Time complexity for Binary Tree is O(h), where h is the height of the tree.
Time complexity for DFS is O(n), where n is the number of cells. E.g. in a maze of n rows and m columns O(n*m).

## References

[1] [Maze generation algorithms](https://medium.com/analytics-vidhya/maze-generations-algorithms-and-visualizations-9f5e88a3ae37)


## Additional information

    Opinto-ohjelma johon kuulun: tietojenkäsittelytieteen kandidaatti (TKT)

Projektin dokumentaatiossa käytetty kieli: englanti´´´

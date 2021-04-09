# Week 3 report

## This week, and the week after easter

Week started (on Saturday) with implementing testing framework using GitHub Actions. Test framework implementation continued on JUnit and Codecov. Both are now working and run as a part of GitHub Actions CI. One badge for successfully completing all tests (JUnit, Checkstyle) and one badge to display Codecov status. Both are visible on "main page".

As I started to work on DFS generator I quickly noticed that I need to refactor my code. Binary Tree (BT) does work differently than DFS and I cannot reuse much. Also class structure, method placement, does not make sense >> refactoring needed. That has been started, but not finished.

For DFS, I created my own implementation of stack - MyStack - which I plan to use as part of DFS recursion. Also class Cell is created for this purpose and to be placed in MyStack.

After I finished DFS implementation without MyStack is time to say goodbye to MyStack and Cell classes. Luckily there is a another way to implement recursion through all unvisited neighbours. Is it faster? I don't know. Is it cleaner? Probably. Is it "more sophisticated"? Well, no. I'll leave MyStack implmentation (do not delete) in case there is still need for it.


### Test actions implemented:
- [x] Checkstyle
- [x] JUnit
- [x] Codecov

### Maze generators
First working versions of BinaryTree and Depth-First Search maze generators done. Produces text based mazes.

Examples of 7x7 maze, where ```@``` is the start and ```!``` is the finish.

#### Binary Tree
```
###############
#@............#
#.###.#.###.#.#
#...#.#...#.#.#
#.###########.#
#...........#.#
#.###.#######.#
#...#.......#.#
#.#.#.#.###.###
#.#.#.#...#...#
#.#.#.#####.###
#.#.#.....#...#
#.#.###.#.#.#.#
#.#...#.#.#.#!#
###############
```

#### Depth-First Search
```
###############
#@............#
#.#.###########
#.#.#.........#
###.#.#######.#
#...#.....##..#
#.#######.#####
#.......#.#...#
#.#####.#.###.#
#.#.#...#.....#
#.#.#.#######.#
#...#.......#.#
###.#######.#.#
#.........#..!#
###############
```




## Next steps


## Time spent

| Task | Working time |
|------|--------------|
| GH Actions | 1 |
| Checkstyle | 0.5 |
| JUnit | 0.5 + 2 + 0.5|
| Codecov | 0.5 |
| Binary tree | 1 + 2 + 0.5 + 4|
| Stack implementation | 1 |
| Total | 8 |

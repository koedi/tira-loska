package domain;

import loska.domain.Maze;
import loska.domain.DFS;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

public class DFSTest {

    Maze maze;
    DFS dfs;

    public DFSTest() {
    }

    @Before
    public void setUp() {
        maze = new Maze(7, 7);
        dfs = new DFS(maze);
    }

    @After
    public void tearDown() {
    }

}
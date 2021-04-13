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


    @Test
    public void generatorTest() {
        dfs.generate();

        assertEquals(maze.getCell(1, 1), '@');
        assertEquals(maze.getCell(13, 13), '!');
    }

    @Test
    public void toStringTest() {
        Maze m = new Maze(1, 1);
        DFS dfs = new DFS(m);
        assertEquals(dfs.toString(), "###\n###\n###\n");
    }

}
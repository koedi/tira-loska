package domain;

import loska.domain.Maze;
import loska.domain.BinaryTree;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;


/**
 * Tests for Maze class
 */

public class BinaryTreeTest {

    Maze maze;
    BinaryTree bt;

    public BinaryTreeTest() {
    }

    @Before
    public void setUp() {
        maze = new Maze(7, 7);
        bt = new BinaryTree(maze);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void generatorTest() {
        maze = new Maze(2, 2);
        bt = new BinaryTree(maze);

        bt.generate();
        assertEquals(maze.getCell(1, 1), '@');
        assertEquals(maze.getCell(3, 3), '!');
    }

    @Test
    public void addPathTestToFirstCellWest() {
        bt.addPath(1, 1, 1);
        assertEquals(maze.getCell(1, 1), '#');
    }

    @Test
    public void addPathTestToFirstCellNorth() {
        bt.addPath(1, 1, 0);
        assertEquals(maze.getCell(1, 1), '#');
    }

    @Test
    public void addPathToNorth() {
        bt.addPath(3, 3, 0);
        assertEquals(maze.getCell(3, 3), '.');
        assertEquals(maze.getCell(2, 3), '.');
    }

    @Test
    public void addPathToWest() {
        bt.addPath(3, 3, 1);
        assertEquals(maze.getCell(3, 3), '.');
        assertEquals(maze.getCell(3, 2), '.');
    }

    @Test
    public void addPathToLastCellNorth() {
        bt.addPath(13, 13, 0);
        assertEquals(maze.getCell(13, 13), '.');
        assertEquals(maze.getCell(12, 13), '.');
    }    

    @Test
    public void addPathToLastCellWest() {
        bt.addPath(13, 13, 1);
        assertEquals(maze.getCell(13, 13), '.');
        assertEquals(maze.getCell(13, 12), '.');
    }

    @Test
    public void addPathJumpNorthToWest() {
        bt.addPath(1, 3, 0);
        assertEquals(maze.getCell(1, 3), '.');
        assertEquals(maze.getCell(1, 2), '.');
    }

    @Test
    public void addPathJumpWestToNorth() {
        bt.addPath(3, 1, 1);
        assertEquals(maze.getCell(3, 1), '.');
        assertEquals(maze.getCell(2, 1), '.');
    }

    @Test
    public void toStringTest() {
        Maze m = new Maze(1, 1);
        BinaryTree bt = new BinaryTree(m);
        assertEquals(bt.toString(), "###\n###\n###\n");
    }

}
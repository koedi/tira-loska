package domain;

import loska.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;


/**
 * Tests for Maze class
 */

public class MazeTest {

    Maze maze;

    public MazeTest() {
    }

    @Before
    public void setUp() {
        maze = new Maze(7, 7);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mazeConstructorTestCorrect() {
        Maze m = new Maze(3, 3);
        assertEquals(m.getHeight(), 2 * 3 + 1);
    }

    @Test
    public void mazeConstructorTestCorrect2() {
        Maze m = new Maze(3, 6);
        assertEquals(m.getWidth(), 2 * 6 + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mazeConstructorTestIncorrect() {
        Maze m = new Maze(-1, 3);
    }

    @Test
    public void mazeTestGetHeight() {
        assertEquals(maze.getHeight(), 15);
    }

    @Test
    public void mazeTestGetOrigHeight() {
        assertEquals(maze.getOrigHeight(), 7);
    }

    @Test
    public void mazeTestGetWidth() {
        assertEquals(maze.getWidth(), 15);
    }

    @Test
    public void mazeTestGetOrigWidth() {
        assertEquals(maze.getOrigWidth(), 7);
    }

    @Test
    public void mazeTestSetCellGetCell() {
        maze.setCell(4, 4, 'k');
        assertEquals(maze.getCell(4, 4), 'k');
    }




/*
    @Test
    public void addPathTestToFirstCellWest() {
        maze.addPath(1, 1, 1);
        assertEquals(maze.getCell(1, 1), '#');
    }

    @Test
    public void addPathTestToFirstCellNorth() {
        maze.addPath(1, 1, 0);
        assertEquals(maze.getCell(1, 1), '#');
    }

    @Test
    public void addPathToNorth() {
        maze.addPath(3, 3, 0);
        assertEquals(maze.getCell(3, 3), '.');
        assertEquals(maze.getCell(2, 3), '.');
    }

    @Test
    public void addPathToWest() {
        maze.addPath(3, 3, 1);
        assertEquals(maze.getCell(3, 3), '.');
        assertEquals(maze.getCell(3, 2), '.');
    }

    @Test
    public void addPathToLastCellNorth() {
        maze.addPath(13, 13, 0);
        assertEquals(maze.getCell(13, 13), '.');
        assertEquals(maze.getCell(12, 13), '.');
    }    

    @Test
    public void addPathToLastCellWest() {
        maze.addPath(13, 13, 1);
        assertEquals(maze.getCell(13, 13), '.');
        assertEquals(maze.getCell(13, 12), '.');
    }

    @Test
    public void addPathJumpNorthToWest() {
        maze.addPath(1, 3, 0);
        assertEquals(maze.getCell(1, 3), '.');
        assertEquals(maze.getCell(1, 2), '.');
    }

    @Test
    public void addPathJumpWestToNorth() {
        maze.addPath(3, 1, 1);
        assertEquals(maze.getCell(3, 1), '.');
        assertEquals(maze.getCell(2, 1), '.');
    }
*/
    @Test
    public void toStringTest() {
        Maze m = new Maze(1, 1);
        assertEquals(m.toString(), "###\n###\n###");
    }
}
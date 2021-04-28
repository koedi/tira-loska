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

    @Test
    public void toStringTest() {
        Maze m = new Maze(1, 1);
        assertEquals(m.toString(), "###\n###\n###");
    }

    @Test
    public void testCheckMazeFalse() {
        Maze m = new Maze(2,2);
        m.setCell(1, 1, '@');
        m.setCell(1, 2, '.');
        m.setCell(1, 3, '.');
        m.setCell(3, 1, '.');
        m.setCell(3, 2, '.');
        m.setCell(3, 3, '!');

        assertEquals(m.checkMaze(), false);
    }

    @Test
    public void testCheckMazeTrue() {
        Maze m = new Maze(2,2);
        m.setCell(1, 1, '@');
        m.setCell(1, 2, '.');
        m.setCell(1, 3, '.');
        m.setCell(2, 1, '.');
        m.setCell(3, 1, '.');
        m.setCell(3, 2, '.');
        m.setCell(3, 3, '!');

        assertEquals(m.checkMaze(), true);
    }

    @Test
    public void testCheckMazeTrue2() {
        Maze m = new Maze(2,2);
        m.setCell(1, 1, '@');
        m.setCell(1, 3, '.');
        m.setCell(2, 1, '.');
        m.setCell(2, 3, '.');
        m.setCell(3, 1, '.');
        m.setCell(3, 2, '.');
        m.setCell(3, 3, '!');

        assertEquals(m.checkMaze(), true);
    }

    @Test
    public void testCheckMazeTrue3() {
        Maze m = new Maze(2,2);
        m.setCell(1, 1, '@');
        m.setCell(1, 2, '.');
        m.setCell(1, 3, '.');
        m.setCell(2, 3, '.');
        m.setCell(3, 1, '.');
        m.setCell(3, 2, '.');
        m.setCell(3, 3, '!');

        assertEquals(m.checkMaze(), true);
    }





}
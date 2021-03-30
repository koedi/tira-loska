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
    public void addPathTestWithNorth() {
        maze.addPath(1, 1, 1);
    }



}
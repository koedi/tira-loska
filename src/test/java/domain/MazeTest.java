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

    public MazeTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mazeConstructorTest() {
        Maze m = new Maze(3, 3);
        assertEquals(m.getHeight(), 2 * 3 + 1);
    }
}
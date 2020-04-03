package it.polimi.ingsw.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    private Worker worker;
    private Cell cell1;
    private Cell cell2;

    @BeforeEach
    void setUp() {
        cell1 = new Cell(0, 0);
        cell2 = new Cell(0, 1);
        worker = new Worker(cell1);
    }

    @Test
    void testGetters() {
        assertEquals(worker.getCell(), cell1);
    }

    /**
     * Check the hasMovedUp method with movements in a higher cell.
     * Expect true
     */
    @Test
    void checkMoveUp() {
        cell2.setLevel(1);

        worker.move(cell2);
        assertTrue(worker::hasMovedUp);
    }

    /**
     * Check the hasMovedUp method with movements in a same level or lower cell.
     * Expect false
     */
    @Test
    void checkNoMoveUp() {
        worker.move(cell2);
        assertFalse(worker::hasMovedUp);
        worker.move(cell1);
        assertFalse(worker::hasMovedUp);

        cell1.setLevel(1);

        worker.move(cell2);
        assertFalse(worker::hasMovedUp);
    }

    /**
     * Check the move method.
     * Expect to find a worker in the destination cell.
     */
    @Test
    void checkDoMove() {
        worker.move(cell2);
        assertEquals(worker.getCell(), cell2);
    }

}
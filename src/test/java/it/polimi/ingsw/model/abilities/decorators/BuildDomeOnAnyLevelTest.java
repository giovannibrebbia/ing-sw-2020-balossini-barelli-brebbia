package it.polimi.ingsw.model.abilities.decorators;

import it.polimi.ingsw.model.Board;
import it.polimi.ingsw.model.TestConstants;
import it.polimi.ingsw.model.Turn;
import it.polimi.ingsw.model.Worker;
import it.polimi.ingsw.model.abilities.DefaultAbilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BuildDomeOnAnyLevelTest {

    private Board board;
    private BuildDomeOnAnyLevel abilities;
    private Turn turn;

    @BeforeEach
    void setUp() {
        board = new Board(TestConstants.BOARD_TEST_ROWS, TestConstants.BOARD_TEST_COLUMNS);
        Worker worker1 = new Worker(0, board.getCellFromCoords(0, 0));
        Worker worker2 = new Worker(1, board.getCellFromCoords(1, 0));

        Map<Worker, Boolean> otherWorkers = new HashMap<>();
        otherWorkers.put(worker2, false);

        abilities = new BuildDomeOnAnyLevel(new DefaultAbilities());
        turn = new Turn(worker1, otherWorkers, (cell) -> board.getNeighborings(cell), cell -> board.isPerimeterSpace(cell));
    }

    /**
     * Check that a worker with this ability can build a dome on a low level
     */
    @Test
    void checkCheckCanBuildDome() {
        assertFalse(abilities.checkCanBuildDome(turn, board.getCellFromCoords(1, 1)));

        // The worker needs to move before being able to build
        abilities.doMove(turn, board.getCellFromCoords(0, 0));

        assertTrue(abilities.checkCanBuildDome(turn, board.getCellFromCoords(1, 1)));
    }

    /**
     * Check tha a worker with this ability can't build a dome in an occupied cell or in a cell already domed
     */
    @Test
    void checkCanNotBuildDome() {
        board.getCellFromCoords(1, 1).setDoomed(true);

        assertFalse(abilities.checkCanBuildDome(turn, board.getCellFromCoords(1, 1)));
        assertFalse(abilities.checkCanBuildDome(turn, board.getCellFromCoords(1, 0)));
    }

}
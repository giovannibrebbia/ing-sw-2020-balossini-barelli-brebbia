package it.polimi.ingsw.model.gamestates;

import it.polimi.ingsw.common.Coordinates;
import it.polimi.ingsw.common.event.PlayerTurnStartEvent;
import it.polimi.ingsw.common.event.WorkerSpawnEvent;
import it.polimi.ingsw.common.event.request.RequestWorkerSpawnEvent;
import it.polimi.ingsw.model.*;

import java.util.*;

public class PreWorkersGame extends AbstractGameState {

    /**
     * The maximum number of workers per player
     */
    private final int maxWorkers;

    /**
     * The current player index (refers to getPlayers())
     */
    private int playerIndex;

    /**
     * The next worker id
     * Each worker must have a unique id
     */
    private int nextWorkerId;

    public PreWorkersGame(ModelEventProvider provider, Board board, List<Player> players, int maxWorkers) {
        this(provider, board, players, maxWorkers, false);
    }

    public PreWorkersGame(ModelEventProvider provider, Board board, List<Player> players, int maxWorkers, boolean alreadySorted) {
        super(provider, board, players);

        this.maxWorkers = maxWorkers;

        if (!alreadySorted) {
            List<Player> sortedPlayers = new LinkedList<>(getPlayers());
            sortedPlayers.sort(Comparator.comparingInt(Player::getAge));
            sortPlayers(sortedPlayers);
        }

        getModelEventProvider().getPlayerTurnStartEventObservable().notifyObservers(
                new PlayerTurnStartEvent(getCurrentPlayer().getName())
        );
        getModelEventProvider().getRequestWorkerSpawnEventObservable().notifyObservers(
                new RequestWorkerSpawnEvent(getCurrentPlayer().getName(), getAvailablePositions())
        );
    }

    @Override
    public Game.ModelResponse spawnWorker(Coordinates position) {
        if (!getAvailablePositions().contains(position)) {
            // Invalid cell selected
            return Game.ModelResponse.INVALID_PARAMS;
        }


        Cell cell = getBoard().getCell(position);
        Worker worker = new Worker(nextWorkerId, cell);
        nextWorkerId++;

        Player player = getCurrentPlayer();
        player.addWorker(worker);

        getModelEventProvider().getWorkerSpawnEventObservable().notifyObservers(
                new WorkerSpawnEvent(player.getName(), worker.getId(), toCoordinates(cell))
        );

        Player next = getCurrentPlayer();
        if (next.equals(player)) {
            // Notify the current player that a new worker can be placed
            getModelEventProvider().getRequestWorkerSpawnEventObservable().notifyObservers(
                    new RequestWorkerSpawnEvent(player.getName(), getAvailablePositions())
            );
        }

        return Game.ModelResponse.ALLOW;
    }

    @Override
    public Player getCurrentPlayer() {
        Player currentPlayer = getPlayers().get(playerIndex);

        if (currentPlayer.getWorkers().size() < maxWorkers) {
            return currentPlayer;
        }

        playerIndex++;
        currentPlayer = getPlayers().get(playerIndex);

        getModelEventProvider().getPlayerTurnStartEventObservable().notifyObservers(
                new PlayerTurnStartEvent(currentPlayer.getName())
        );
        getModelEventProvider().getRequestWorkerSpawnEventObservable().notifyObservers(
                new RequestWorkerSpawnEvent(currentPlayer.getName(), getAvailablePositions())
        );
        return currentPlayer;
    }

    @Override
    public AbstractGameState nextState() {
        for (Player player : getPlayers()) {
            if (player.getWorkers().size() < maxWorkers) {
                return this;
            }
        }

        return new OngoingGame(getModelEventProvider(), getBoard(), getPlayers());
    }

    /**
     * The list of available cells where a new Worker can be placed
     * @return The list of cells
     */
    private List<Coordinates> getAvailablePositions() {
        List<Cell> cells = getBoard().getCells();

        for (Player player : getPlayers()) {
            for (Worker other : player.getWorkers()) {
                cells.remove(other.getCell());
            }
        }

        return toCoordinatesList(cells);
    }

    private List<Coordinates> toCoordinatesList(List<Cell> cells) {
        List<Coordinates> coordinates = new ArrayList<>();

        for (Cell cell : cells) {
            coordinates.add(toCoordinates(cell));
        }

        return coordinates;
    }

    private Coordinates toCoordinates(Cell cell) {
        return new Coordinates(cell.getX(), cell.getY());
    }

}

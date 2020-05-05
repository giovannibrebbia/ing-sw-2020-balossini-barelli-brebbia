package it.polimi.ingsw.view;

import it.polimi.ingsw.common.IViewEventProvider;
import it.polimi.ingsw.common.Observable;
import it.polimi.ingsw.common.Observer;
import it.polimi.ingsw.common.event.*;

public class ViewEventProvider implements IViewEventProvider {

    /**
     * Observable for RequestChallengerSelectGodsEvent
     */
    private final Observable<PlayerChallengerSelectGodsEvent> playerChallengerSelectGodsEventObservable = new Observable<>();

    /**
     * Observable for PlayerChooseGodEvent
     */
    private final Observable<PlayerChooseGodEvent> playerChooseGodEventObservable = new Observable<>();

    /**
     * Observable for PlayerEndTurnEvent
     */
    private final Observable<PlayerEndTurnEvent> playerEndTurnEventObservable = new Observable<>();

    /**
     * Observable for WorkerBuildBlockEvent
     */
    private final Observable<WorkerBuildBlockEvent> workerBuildBlockEventObservable = new Observable<>();

    /**
     * Observable for WorkerBuildDomeEvent
     */
    private final Observable<WorkerBuildDomeEvent> workerBuildDomeEventObservable = new Observable<>();

    /**
     * Observable for WorkerForceEvent
     */
    private final Observable<WorkerForceEvent> workerForceEventObservable = new Observable<>();

    /**
     * Observable for WorkerMoveEvent
     */
    private final Observable<WorkerMoveEvent> workerMoveEventObservable = new Observable<>();

    /**
     * Observable for WorkerSpawnEvent
     */
    private final Observable<WorkerSpawnEvent> workerSpawnEventObservable = new Observable<>();

    @Override
    public void registerPlayerChallengerSelectGodsEventObserver(Observer<PlayerChallengerSelectGodsEvent> observer) {
        playerChallengerSelectGodsEventObservable.register(observer);
    }

    @Override
    public void registerPlayerChooseGodEventObserver(Observer<PlayerChooseGodEvent> observer) {
        playerChooseGodEventObservable.register(observer);
    }

    @Override
    public void registerPlayerEndTurnEventObserver(Observer<PlayerEndTurnEvent> observer) {
        playerEndTurnEventObservable.register(observer);
    }

    @Override
    public void registerWorkerBuildBlockEventObserver(Observer<WorkerBuildBlockEvent> observer) {
        workerBuildBlockEventObservable.register(observer);
    }

    @Override
    public void registerWorkerBuildDomeEventObserver(Observer<WorkerBuildDomeEvent> observer) {
        workerBuildDomeEventObservable.register(observer);
    }

    @Override
    public void registerWorkerForceEventObserver(Observer<WorkerForceEvent> observer) {
        workerForceEventObservable.register(observer);
    }

    @Override
    public void registerWorkerMoveEventObserver(Observer<WorkerMoveEvent> observer) {
        workerMoveEventObservable.register(observer);
    }

    @Override
    public void registerWorkerSpawnEventObserver(Observer<WorkerSpawnEvent> observer) {
        workerSpawnEventObservable.register(observer);
    }

    public Observable<PlayerChallengerSelectGodsEvent> getPlayerChallengerSelectGodsEventObservable() {
        return playerChallengerSelectGodsEventObservable;
    }

    public Observable<PlayerChooseGodEvent> getPlayerChooseGodEventObservable() {
        return playerChooseGodEventObservable;
    }

    public Observable<PlayerEndTurnEvent> getPlayerEndTurnEventObservable() {
        return playerEndTurnEventObservable;
    }

    public Observable<WorkerBuildBlockEvent> getWorkerBuildBlockEventObservable() {
        return workerBuildBlockEventObservable;
    }

    public Observable<WorkerBuildDomeEvent> getWorkerBuildDomeEventObservable() {
        return workerBuildDomeEventObservable;
    }

    public Observable<WorkerForceEvent> getWorkerForceEventObservable() {
        return workerForceEventObservable;
    }

    public Observable<WorkerMoveEvent> getWorkerMoveEventObservable() {
        return workerMoveEventObservable;
    }

    public Observable<WorkerSpawnEvent> getWorkerSpawnEventObservable() {
        return workerSpawnEventObservable;
    }

}

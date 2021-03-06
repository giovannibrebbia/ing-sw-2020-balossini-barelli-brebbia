package it.polimi.ingsw.common;

import it.polimi.ingsw.common.event.*;
import it.polimi.ingsw.common.event.lobby.LobbyGameStartEvent;
import it.polimi.ingsw.common.event.lobby.LobbyRoomUpdateEvent;
import it.polimi.ingsw.common.event.lobby.LobbyUpdateEvent;
import it.polimi.ingsw.common.event.request.*;

/**
 * The provider that handles the registration of model events
 *
 * Model events are events sent by a model (in the client)
 */
public interface IModelEventProvider {

    /**
     * Register the observer for LobbyUpdateEvent in the related observable
     * @param observer The Observer
     */
    void registerLobbyUpdateEventObserver(Observer<LobbyUpdateEvent> observer);

    /**
     * Register the observer for LobbyRoomUpdateEvent in the related observable
     * @param observer The Observer
     */
    void registerLobbyRoomUpdateEventObserver(Observer<LobbyRoomUpdateEvent> observer);

    /**
     * Register the observer for LobbyGameStartEvent in the related observable
     * @param observer The Observer
     */
    void registerLobbyGameStartEventObserver(Observer<LobbyGameStartEvent> observer);

    /**
     * Register the observer for RequestPlayerPingEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestPlayerPingEventObserver(Observer<RequestPlayerPingEvent> observer);

    /**
     * Register the observer for RequestPlayerChallengerSelectGodsEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestPlayerChallengerSelectGodsEventObserver(Observer<RequestPlayerChallengerSelectGodsEvent> observer);

    /**
     * Register the observer for RequestPlayerChooseGodEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestPlayerChooseGodEventObserver(Observer<RequestPlayerChooseGodEvent> observer);

    /**
     * Register the observer for RequestPlayerChallengerSelectFirstEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestPlayerChallengerSelectFirstEventObserver(Observer<RequestPlayerChallengerSelectFirstEvent> observer);

    /**
     * Register the observer for RequestPlayerEndTurnEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestPlayerEndTurnEventObserver(Observer<RequestPlayerEndTurnEvent> observer);

    /**
     * Register the observer for RequestWorkerBuildBlockEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestWorkerBuildBlockEventObserver(Observer<RequestWorkerBuildBlockEvent> observer);

    /**
     * Register the observer for RequestWorkerBuildDomeEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestWorkerBuildDomeEventObserver(Observer<RequestWorkerBuildDomeEvent> observer);

    /**
     * Register the observer for RequestWorkerForceEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestWorkerForceEventObserver(Observer<RequestWorkerForceEvent> observer);

    /**
     * Register the observer for RequestWorkerMoveEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestWorkerMoveEventObserver(Observer<RequestWorkerMoveEvent> observer);

    /**
     * Register the observer for RequestWorkerSpawnEvent in the related observable
     * @param observer The Observer
     */
    void registerRequestWorkerSpawnEventObserver(Observer<RequestWorkerSpawnEvent> observer);

    /**
     * Register the observer for PlayerChallengerSelectGodsEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerChallengerSelectGodsEventObserver(Observer<PlayerChallengerSelectGodsEvent> observer);

    /**
     * Register the observer for PlayerChooseGodEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerChooseGodEventObserver(Observer<PlayerChooseGodEvent> observer);

    /**
     * Register the observer for PlayerChallengerSelectFirstEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerChallengerSelectFirstEventObserver(Observer<PlayerChallengerSelectFirstEvent> observer);

    /**
     * Register the observer for PlayerLoseEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerLoseEventObserver(Observer<PlayerLoseEvent> observer);

    /**
     * Register the observer for PlayerTurnStartEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerTurnStartEventObserver(Observer<PlayerTurnStartEvent> observer);

    /**
     * Register the observer for PlayerWinEvent in the related observable
     * @param observer The Observer
     */
    void registerPlayerWinEventObserver(Observer<PlayerWinEvent> observer);

    /**
     * Register the observer for WorkerBuildBlockEvent in the related observable
     * @param observer The Observer
     */
    void registerWorkerBuildBlockEventObserver(Observer<WorkerBuildBlockEvent> observer);

    /**
     * Register the observer for WorkerBuildDomeEvent in the related observable
     * @param observer The Observer
     */
    void registerWorkerBuildDomeEventObserver(Observer<WorkerBuildDomeEvent> observer);

    /**
     * Register the observer for WorkerForceEvent in the related observable
     * @param observer The Observer
     */
    void registerWorkerForceEventObserver(Observer<WorkerForceEvent> observer);

    /**
     * Register the observer for WorkerMoveEvent in the related observable
     * @param observer The Observer
     */
    void registerWorkerMoveEventObserver(Observer<WorkerMoveEvent> observer);

    /**
     * Register the observer for WorkerSpawnEvent in the related observable
     * @param observer The Observer
     */
    void registerWorkerSpawnEventObserver(Observer<WorkerSpawnEvent> observer);

}

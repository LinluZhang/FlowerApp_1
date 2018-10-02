package suwu.flowerapp.blservice.event;

import suwu.flowerapp.exception.EventDoesNotExistException;
import suwu.flowerapp.parameters.event.EventAddParameters;
import suwu.flowerapp.response.event.EventAddResponse;
import suwu.flowerapp.response.event.EventDeleteResponse;
import suwu.flowerapp.response.event.EventLoadResponse;
import suwu.flowerapp.response.event.EventWithIdLoadResponse;
import suwu.flowerapp.exception.EventDoesNotExistException;
import suwu.flowerapp.parameters.event.EventAddParameters;

public interface EventBlService {
    /**
     * load all events
     *
     * @return
     */
    EventLoadResponse loadEvents();

    /**
     * load all events with their ids
     *
     * @return
     */
    EventWithIdLoadResponse loadEventsWithId();

    /**
     * delete the event by id
     *
     * @param eventId
     * @return
     */
    EventDeleteResponse deleteEvent(int eventId) throws EventDoesNotExistException;

    /**
     * add event
     *
     * @param eventAddParameters
     * @return
     */
    EventAddResponse addEvent(EventAddParameters eventAddParameters);
}

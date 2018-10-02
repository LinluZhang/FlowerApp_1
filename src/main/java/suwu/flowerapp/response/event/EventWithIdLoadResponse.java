package suwu.flowerapp.response.event;

import suwu.flowerapp.response.Response;

import java.util.List;

public class EventWithIdLoadResponse extends Response {
    private List<EventItem> eventItems;

    public EventWithIdLoadResponse() {
    }

    public EventWithIdLoadResponse(List<EventItem> eventItems) {
        this.eventItems = eventItems;
    }

    public List<EventItem> getEventItems() {
        return eventItems;
    }

    public void setEventItems(List<EventItem> eventItems) {
        this.eventItems = eventItems;
    }
}

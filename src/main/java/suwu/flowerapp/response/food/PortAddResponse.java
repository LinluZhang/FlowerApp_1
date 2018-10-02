package suwu.flowerapp.response.food;

import suwu.flowerapp.response.Response;

public class PortAddResponse extends Response {
    private int id;

    public PortAddResponse() {
    }

    public PortAddResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

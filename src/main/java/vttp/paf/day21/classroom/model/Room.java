package vttp.paf.day21.classroom.model;

public class Room {
    private int id;
    private String type;
    private float price;

    public Room(int id, String type, float price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

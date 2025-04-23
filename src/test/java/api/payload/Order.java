package api.payload;

public class Order {

    int id ;
    int petid;
    int quantity;
    String shipDatee;
    String []  status;
    boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDatee() {
        return shipDatee;
    }

    public void setShipDatee(String shipDatee) {
        this.shipDatee = shipDatee;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}

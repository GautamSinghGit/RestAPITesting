package RestAssuredDemo;

public class Address {

    private int flat;
    private String building;

    public Address(int flat , String building){
        this.flat = flat;
        this.building = building;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}

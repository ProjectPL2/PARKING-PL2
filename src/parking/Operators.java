package parking;

public class Operators {
    
    private int id;
    private String name;

    public Operators(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public void addCustomer(String place){
        Station.addCustomer(place);
    }
    
    public void removeCustomer(String place){
        Station.removeCustomer(place);
    }
}

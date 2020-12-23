package parking;


import java.util.HashMap;

public class Station {
    
    private static HashMap<String,Boolean> spots;

    public Station() {
        spots = new HashMap<>();
    }
    
    protected static void creatParking(int numberOfFloors,int spotsInFloor){
        for (int i = 0; i < numberOfFloors; i++) {
            for (int j = 1; j <= spotsInFloor; j++) {
                spots.put(""+(char)(i+65)+""+j,true);
            }
        }
    }
    
    public static void addCustomer(String place){
        spots.replace(place, Boolean.FALSE);
    }
    
    public static void removeCustomer(String place){
        spots.replace(place, Boolean.TRUE);
    }
    
}

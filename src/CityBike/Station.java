package CityBike;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Station {

    private int stationId;
    private String location;
    private ArrayList<Bike> bikes;
    private static final int maxBikeZahl=5;



    public Station(int stationId, String location) {
        this.stationId = stationId;
        this.location = location;
        this.bikes= new ArrayList<>();
    }

    public int getStationId() {
        return stationId;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    public static int getMaxBikeZahl() {
        return maxBikeZahl;
    }


    //Create a method of the Station class, addBike()
    public boolean addBike(Bike bikeObj){
        if (this.getMaxBikeZahl()==this.bikes.size()){
            System.out.println("\nThe station "+this.getLocation()+" is full! Please go to another Place to return!");
            return false;
        }else{
            this.bikes.add(bikeObj);
            return true;
        }
    }

//Method to remove the rented bike from the station
    public void removeRentedBike(Bike bikeObj) {
        for (int x=0;x<this.bikes.size();x++) {                    //loop is running bis x<loop size
            if (bikes.get(x).getBikeID()==bikeObj.getBikeID()){
                this.bikes.remove(x);                              //remove bike von station
            }
        }
    }



    public static void rentBike(Bike bikeX, Station stationY,User userZ){   //user rents bike x from station y)

        userZ.UserRentsBike(bikeX);
        stationY.removeRentedBike(bikeX);

        System.out.println("\nUser "+userZ.getUserFirstName()+"  "+userZ.getUserSurname()+" is now renting bike ID: "
                +bikeX.getBikeID()+" from Station "+stationY.getLocation()+"  rent Start: "+userZ.getBikeRentStartAct(bikeX));


    }

    public static void returnBike(Bike bikeX, Station stationY,User userZ){
        if (stationY.addBike(bikeX)){
            userZ.userReturnsBike(bikeX);
            LocalDateTime actualRentEnd= LocalDateTime.now();
            userZ.setBikeRentEnd(bikeX);
            System.out.println("\nUser "+userZ.getUserFirstName()+"  "+userZ.getUserSurname()+" has returned bike ID: "
                    +bikeX.getBikeID()+" to Station "+stationY.getLocation()+"   Time of Return: "
                    +actualRentEnd);
        }
    }


    public void printStationInfo(){
        System.out.println("\nStation ID:"+this.stationId+"   Station Location: "+this.location);
        System.out.println("--------------------------------------------------------------------");
        if (this.bikes.size()==0){
            System.out.println("There are no bikes at this Station right now!");
        }else{
            for (Bike element:this.bikes) {
                System.out.println("BikeID: "+element.getBikeID()+"   Colour:  "+element.getColour());
            }
        }
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", location='" + location + '\'' +
                ", bikes=" + bikes+"  size of bikes "+bikes.size() +
                '}';
    }
}

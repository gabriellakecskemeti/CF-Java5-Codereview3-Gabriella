package CityBike;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class User {

    private int userId;
    private String userFirstName;
    private String userSurname;
    private ArrayList<Bike> userRentedBikes;

    private static int numberForUser=0;  //user get also automatic ID number

    //array list for tracking of renting times, the element of this array List will not be deleted
    //if the user returns the bike, this is like a history about the renting activities of this user.
    private ArrayList<Rent> rentTracking;


    public User(String userFirstName, String userSurname) {
        numberForUser++;
        this.userId = numberForUser;          //user get also automatic ID number like in case of bikes
        this.userFirstName = userFirstName;
        this.userSurname = userSurname;
        this.userRentedBikes=new ArrayList<>();
        this.rentTracking = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Bike> getUserRentedBikes() {
        return userRentedBikes;
    }

    public void setUserRentedBikes(ArrayList<Bike> userRentedBikes) {
        this.userRentedBikes = userRentedBikes;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void UserRentsBike(Bike bikeObj){
        this.userRentedBikes.add(bikeObj);
        //tracking of rent time
        //LocalDateTime.parse("")
        rentTracking.add(new Rent(bikeObj.getBikeID(), LocalDateTime.now(),null));
        //System.out.println(rentTracking);
    }

    public void userReturnsBike(Bike bikeObj){
        this.userRentedBikes.remove(bikeObj);

        //tracking of rent time
        if (!setBikeRentEnd(bikeObj)){
            System.out.println("There is something wrong. I could not find your Rent Time Information!");
        }
    }

    //method add timestamp in rent tracking to the rentend
    public boolean setBikeRentEnd(Bike bikeObj){
        for (Rent element:this.rentTracking) {
            //System.out.println(element);
            if(element.getBikeID()== bikeObj.getBikeID() && element.getRentEnd()==null){
                element.setRentEnd(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    //Method lists the user data and the rented bikes and the rent start
    public void listUserInfo(){
        System.out.println("\nUser ID: "+this.userId+"  Name:   "+this.userFirstName+" "+this.userSurname+"     has following Bikes:");
        if (this.userRentedBikes.size()==0){
            System.out.println("       This user has no rented bikes right now");
        }else{
            for (Bike element:this.userRentedBikes) {
                System.out.print(element.printBikeString()+"  Rent started at:"+getBikeRentStartAct(element));
            }
        }
    }

    //give back the start date from opened Rent item
    public LocalDateTime getBikeRentStartAct(Bike bikeObj){
        for (Rent element:this.rentTracking) {
            if(element.getBikeID()== bikeObj.getBikeID() && element.getRentEnd()==null){
                return element.getRentStart();
            }
        }
        System.out.println("There is something wrong. I could not find your RentStart!");
        return null;
    }

    //Method finds rentend based on rent start in rent tracking , not used right now
    public LocalDateTime getBikeRentEnd(Bike bikeObj,LocalDateTime rentstart){
        this.listRentTracking();
        for (Rent element:this.rentTracking) {

            if(element.getBikeID()== bikeObj.getBikeID() && element.getRentStart().equals(rentstart)){
                return element.getRentEnd();
            }
        }
        System.out.println("There is something wrong. I could not find your RentStart!");
        return null;
    }


    public ArrayList<Rent> getRentTracking() {
        return rentTracking;
    }

    public void setRentTracking(ArrayList<Rent> rentTracking) {
        this.rentTracking = rentTracking;
    }

    public void listRentTracking(){
        System.out.println("\nRent tracking of: "+this.userFirstName+"  "+this.userSurname);
        for (Rent x:this.rentTracking) {
            System.out.println("Bike ID: "+x.getBikeID()+"  rent start: "+x.getRentStart()
                    +" rent end: "+x.getRentEnd());
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userVorName='" + userFirstName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                '}';
    }
}

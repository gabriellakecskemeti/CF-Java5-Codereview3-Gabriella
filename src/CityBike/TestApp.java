package CityBike;

import java.util.*;

public class TestApp {

    public static void main(String[] args) {

//Create 8 or more Bike objects in your main().
        Bike b1=new Bike("red");
        Bike b2=new Bike("blue");
        Bike b3=new Bike("white");
        Bike b4=new Bike("black");
        Bike b5=new Bike("yellow");
        Bike b6=new Bike("orange");
        Bike b7=new Bike("green");
        Bike b8=new Bike("brown");


// put all existing Bikes in a HashMap that uses bikeID as a source for the key value.
        HashMap<Integer,Bike> allBikes =new HashMap<>();

        allBikes.put(b1.getBikeID(), b1);
        allBikes.put(b2.getBikeID(), b2);
        allBikes.put(b3.getBikeID(), b3);
        allBikes.put(b4.getBikeID(), b4);
        allBikes.put(b5.getBikeID(), b5);
        allBikes.put(b6.getBikeID(), b6);
        allBikes.put(b7.getBikeID(), b7);
        allBikes.put(b8.getBikeID(), b8);

        System.out.println("Printing all items of hash map");
       for(Map.Entry m : allBikes.entrySet()){
           Bike bikeobj = (Bike)m.getValue();
            System.out.println("Key of Map: "+ m.getKey()+"   Bike ID: "+bikeobj.getBikeID()+"   "+bikeobj.getColour());
        }


//Create 3 Station objects in your main() and put them in a HashMap - allStations (better name than Station)
        Station s1= new Station(1,"Vorgarten Straße 7");
        Station s2= new Station(2,"Schweden Platz 3");
        Station s3= new Station(3,"Maria Hilfe Straße 38");



        HashMap<Integer,Station> allStations =new HashMap<>();
        allStations.put(s1.getStationId(),s1);
        allStations.put(s2.getStationId(),s2);
        allStations.put(s3.getStationId(),s3);

        //put 3 bikes in Station1, and put 4 bikes in Station2 (composition: Station has bikes)
        s1.addBike(b1);
        s1.addBike(b2);
        s1.addBike(b3);
        s1.addBike(b8);

        s2.addBike(b4);
        s2.addBike(b5);
        s2.addBike(b6);
        s2.addBike(b7);

        //Printing the created station data
        s1.printStationInfo();
        s2.printStationInfo();
        s3.printStationInfo();


        //create 4 Users
        User user1= new User("Peter","Koller");
        User user2= new User("Katrin","Müller");
        User user3= new User("Falco","Mahr");
        User user4= new User("Andrea","Mayer");

        ArrayList<User> allUsers =new ArrayList<>(); //creating ArrayList to list all users
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        allUsers.add(user4);

        listAllUsers(allUsers);


        Station.rentBike(b3,s1,user1);
        Station.rentBike(b1,s1,user1);  //user1 rents second bike
        s1.printStationInfo();

        Station.returnBike(b3,s2,user1);


        user1.listRentTracking();       //rent tracking of user1

        Station.rentBike(b2,s1,user2);
        Station.returnBike(b2,s2,user2);  //Station is full!
        Station.returnBike(b2,s3,user2);

        user2.listRentTracking();       //rent tracking of user1

    }

    public static void listAllUsers(ArrayList<User> allUsers) {
        for (User element : allUsers) {
            element.listUserInfo();
        }
    }



}

package CityBike;

public class Bike {

    private int bikeID;
    private String colour;
    private static int number=0;


    public Bike(String colour) {
        number=number+1;
        this.bikeID=number;
        this.colour = colour;
    }

    public int getBikeID() {
        return bikeID;
    }

    public String getColour() {
        return colour;
    }



    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public void printBike(){
        System.out.println("Bike ID: "+this.getBikeID()+"  Colour: "+this.getColour());

    }
    public String printBikeString(){
        return "Bike ID: "+this.getBikeID()+"  Colour: "+this.getColour();

    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID=" + bikeID +
                ", colour='" + colour + '\'' +
                '}';
    }
}

package CityBike;

import java.sql.Date;
import java.time.LocalDateTime;

public class Rent {
    //private int userId;
    private int bikeID;
    private LocalDateTime rentStart;
    private LocalDateTime rentEnd;



    public Rent(int bikeID, LocalDateTime rentStart, LocalDateTime rentEnd) {
        this.bikeID = bikeID;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public LocalDateTime getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDateTime rentStart) {
        this.rentStart = rentStart;
    }

    public LocalDateTime getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        this.rentEnd = rentEnd;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "bikeID=" + bikeID +
                ", rentStart=" + rentStart.getHour()+":"+rentStart.getMinute() +
                ", rentEnd=" + rentEnd +
                '}';
    }
}

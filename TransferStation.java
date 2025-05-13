
import java.util.ArrayList;

public class TransferStation extends Station {

    public final ArrayList<Station> otherStations;

    public TransferStation(String line, String name) {
        super(line, name);
        this.otherStations = new ArrayList<>();
    }

    public void addTransferStationNext(Station station) {
        station.prev = this;
        otherStations.add(station);
    }
    
    public void addTransferStationPrev(Station station) {
        station.next = this;
        otherStations.add(station);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("\n\tTransfers: \n");
        for (Station station : otherStations) {
            s.append("\t");
            s.append(station.toString());
            s.append("\n");
        }
        return s.toString();
    }

}
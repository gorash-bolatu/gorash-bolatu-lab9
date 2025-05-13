
import java.util.ArrayList;

public class TransferStation extends Station {

    private final ArrayList<Station> transfers;

    public TransferStation(String line, String name) {
        super(line, name);
        this.transfers = new ArrayList<>();
    }

    public void addTransferStationNext(Station station) {
        station.prev = this;
        transfers.add(station);
    }
    
    public void addTransferStationPrev(Station station) {
        station.next = this;
        transfers.add(station);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append("\n\tTransfers: \n");
        for (Station station : transfers) {
            s.append("\t");
            s.append(station.toString());
            s.append("\n");
        }
        return s.toString();
    }

}
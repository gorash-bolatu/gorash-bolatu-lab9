public class Station {

    private String line;
    private String name;
    private boolean inService;
    public Station prev, next;

    public Station(String line, String name) {
        this.line = line;
        this.name = name;
        this.inService = true;
    }

    public Station(String line) {
        this.line = line;
    }

    public void switchAvailable() {
        this.inService = !this.inService;
    }

    public boolean isAvailable() {
        return inService;
    }

    public void addNext(Station station) {
        this.next = station;
        station.prev = this;
    }

    public void addPrev(Station station) {
        this.prev = station;
        station.next = this;
    }

    public boolean equals(Station station) {
        return this.line.equals(station.line) && this.name.equals(station.name);
    }

    public void connect(Station station) {
        this.addNext(station);
    }

    public int tripLength(Station dest) {
        if (this.equals(dest))
            return 0;
        Station n = this.next;
        if (n == null)
            return -1; // dead end
        if (n.equals(dest))
            return 1;
        if (n instanceof EndStation)
            return -1; // dead end
        if (n instanceof TransferStation) {
            TransferStation transfer = (TransferStation) n;
            for (Station s : transfer.otherStations) {
                if (!s.line.equals(this.line) && s.prev == transfer) {
                    int result = s.tripLength(dest);
                    if (result != -1)
                        return result + 2;
                }
            }
        }
        int result = n.tripLength(dest);
        if (result == -1)
            return -1;
        return result + 1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getClass().getName().toUpperCase());
        s.append(" ");
        s.append(this.name);
        s.append(": ");
        s.append(this.line);
        s.append(" line, in service: ");
        s.append(this.inService);
        s.append(", previous station: ");
        s.append((prev == null) ? "none" : prev.name);
        s.append(", next station: ");
        s.append((next == null) ? "none" : next.name);
        return s.toString();
    }

}
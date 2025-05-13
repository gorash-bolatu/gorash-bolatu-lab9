public class Station {

    String line;
    String name;
    boolean isAvailable;
    Station prev, next;

    public Station(String line, String name) {
        this.line = line;
        this.name = name;
    }

    public void switchAvailable() {
        this.isAvailable = !this.isAvailable;
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getClass().getName().toUpperCase());
        s.append(" ");
        s.append(this.name);
        s.append(": ");
        s.append(this.line);
        s.append(" line, in service: ");
        s.append(this.isAvailable);
        s.append(", previous station: ");
        s.append((prev == null) ? "none" : prev.name);
        s.append(", next station: ");
        s.append((next == null) ? "none" : next.name);
        return s.toString();
    }

}
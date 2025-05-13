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
    }

    public void addPrev(Station station) {
        this.prev = station;
    }

    public boolean equals(Station station) {
        return this.line.equals(station.line) && this.name.equals(station.name);
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
        s.append(prev.name);
        s.append(", next station: ");
        s.append(next.name);
        return s.toString();
    }

}
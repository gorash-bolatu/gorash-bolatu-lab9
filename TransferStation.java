public class TransferStation extends Station {

    public TransferStation(String line, String name) {
        super(line, name);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("\n\tTransfers: \n");
        return s.toString();
    }

}
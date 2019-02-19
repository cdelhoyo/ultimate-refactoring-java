package signatureChange;

public class Id {

    private final int id;

    public Id(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return this.id == 12345;
    }
}

public class Disk {
    private int size;

    public Disk(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}


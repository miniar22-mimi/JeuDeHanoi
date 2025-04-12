import java.util.Stack;

public class Tower {
    private Stack<Disk> disks;

    public Tower() {
        disks = new Stack<>();
    }

    public void push(Disk disk) {
        disks.push(disk);
    }

    public Disk pop() {
        return disks.pop();
    }

    public Disk peek() {
        return disks.peek();
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public Stack<Disk> getDisks() {
        return disks;
    }
}


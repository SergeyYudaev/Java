package GeekBrainHW6;

public abstract class Animals {
    protected double runDistance;
    protected double jumpDistance;
    protected int swimDistance;

    void run(double runDistance) {
        this.runDistance = runDistance;
        System.out.println("Animal is running");
    }

    void jump(double jumpDistance) {
        this.jumpDistance = jumpDistance;
        System.out.println("Animal is jumping");
    }

    void swim(int swimDistance) {
        this.swimDistance = swimDistance;
        System.out.println("Animal is swimming");
    }


    public void resultOutput(Object obj, double distance, String operation, boolean result) {
        System.out.println(obj.toString() + " is " + operation + " for distance: " + distance + ", result: " + result);
    }
}

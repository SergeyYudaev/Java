package GeekBrainHW6;

class Dog extends Animals {
    double maxRunDistance = 500;
    final double maxJumpDistance = 0.5;
    final int maxSwimDistance = 10;
    String name;

    @Override
    public String toString() {
        return this.name;
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    void run(double distance) {
        maxRunDistance = 10 * Math.ceil(Math.random() * Math.pow(10, 2));
        boolean result = false;
        if (distance <= maxRunDistance) result = true;
        resultOutput(this, distance, "running", result);
        System.out.println(this.name + " can run for  " + maxRunDistance + " meters");
    }

    @Override
    void jump(double distance) {
        boolean result = false;
        if (distance <= maxJumpDistance) result = true;
        resultOutput(this, distance, "jumping", result);
    }

    @Override
    void swim(int distance) {
        boolean result = false;
        if (distance <= maxSwimDistance) result = true;
        resultOutput(this, distance, "swimming", result);

    }
}

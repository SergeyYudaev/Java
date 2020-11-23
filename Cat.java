package GeekBrainHW6;

class Cat extends Animals {
    final int maxRunDistance = 200;
    final int maxJumpDistance = 2;
    String name;

    @Override
    public String toString() {
        return this.name;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    void run(double distance) {
        boolean result = false;
        if (distance <= maxRunDistance) result = true;
        resultOutput(this, distance, "running", result);
    }

    @Override
    void jump(double distance) {
        boolean result = false;
        if (distance <= maxJumpDistance) result = true;
        resultOutput(this, distance, "jumping", result);
    }

    @Override
    void swim(int distance) {
        System.out.println(this.getClass().getSimpleName() + " can`t swim");
    }
}

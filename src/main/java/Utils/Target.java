package Utils;

public   class Target {

    private int targetSteps = 10_000;

    public Target() {
    }

    public int getTargetSteps() {
        return targetSteps;
    }

    public void changeTarget(int newTarget) {
        if (newTarget == targetSteps || newTarget > 0 & newTarget < targetSteps || newTarget > targetSteps ) {
            targetSteps = newTarget;
        } else {
            System.out.println("некорректное значение");
        }
    }

    @Override
    public String toString() {
        return "Цель за день " +
                " составляет " + targetSteps +
                " шагов ";
    }
}







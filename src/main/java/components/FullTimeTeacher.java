package components;

public class FullTimeTeacher extends Teacher {
    private int yearsExperience;
    private static double percentage = 1.1;
    private static double baseSalary = 1000;

    public FullTimeTeacher(String name, int yearsExperience) {
        super(name);
        this.yearsExperience = yearsExperience;
    }

    @Override
    public double calculateSalary() {
        double salary = baseSalary * (yearsExperience * percentage);
        return salary;
    }
}

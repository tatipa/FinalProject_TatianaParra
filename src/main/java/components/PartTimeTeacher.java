package components;

public class PartTimeTeacher extends Teacher {
    private int hoursXWeek;
    private static double baseSalary = 800;

    public PartTimeTeacher(String name, int hoursXWeek) {
        super(name);
        this.hoursXWeek = hoursXWeek;
    }

    @Override
    public double calculateSalary() {
        double salary = baseSalary*hoursXWeek;
        return salary;
    }
}

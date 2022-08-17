package payroll;

public interface EmployeeFactory {
    public static final int COMMISSIONED = 1;
    public static final int HOURLY = 2;
    public static final int SALARIED = 3;

    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}
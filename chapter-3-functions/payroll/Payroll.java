package payroll;

public class Payroll {
    public static void main(String[] args) {
        EmployeeFactory factory = new EmployeeFactoryImpl();
        Employee employee;
        try {
            employee = factory.makeEmployee(new EmployeeRecord(EmployeeFactory.COMMISSIONED));
            System.out.println(calculatePay(employee));
        } catch (InvalidEmployeeType e) {
            e.printStackTrace();
        }
    }

    public static Money calculatePay(Employee e) {
        return e.calculatePay();
    }
}

package payroll;

public class HourlyEmployee extends Employee {

    public HourlyEmployee(EmployeeRecord r) {
    }

    @Override
    public boolean isPayDay() {
        return false;
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public void deliveryPay(Money pay) {
        
    }

}

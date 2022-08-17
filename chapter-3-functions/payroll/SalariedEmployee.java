package payroll;

public class SalariedEmployee extends Employee {

    public SalariedEmployee(EmployeeRecord r) {
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

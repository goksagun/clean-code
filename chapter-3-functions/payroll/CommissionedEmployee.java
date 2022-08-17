package payroll;

public class CommissionedEmployee extends Employee {

    public CommissionedEmployee(EmployeeRecord r) {
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

package payroll;

public class Payroll {
    private static final int COMMISSIONED = 1;
    private static final int HOURLY = 2;
    private static final int SALARIED = 3;

    public static void main(String[] args) {
        try {
            System.out.println(new Payroll().calculatePay(new Employee(COMMISSIONED)));
        } catch (InvalidEmployeeType e) {
            e.printStackTrace();
        }
    }

    public Money calculatePay(Employee e) throws InvalidEmployeeType {
        switch (e.type) {
            case COMMISSIONED:
                return calculateCommissionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default:
                throw new InvalidEmployeeType(e.type);
        }
    }

    private Money calculateCommissionedPay(Employee e) {
        return null;
    }

    private Money calculateHourlyPay(Employee e) {
        return null;
    }

    private Money calculateSalariedPay(Employee e) {
        return null;
    }
}

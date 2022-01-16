package exercise04.entities;

public class Individual extends TaxPayer{
    private Double healthSpenditures;

    private static final Double INCOME_LIMIT = 20000.00;

    public Individual(String name, Double annualIncome, Double healthSpenditures) {
        super(name, annualIncome);
        this.healthSpenditures = healthSpenditures;
    }

    public Double getHealthSpenditures() {
        return healthSpenditures;
    }

    public void setHealthSpenditures(Double healthSpenditures) {
        this.healthSpenditures = healthSpenditures;
    }

    @Override
    public Double tax() {
        double deduction = 0.0;
        if (healthSpenditures > 0.0){
            deduction = healthSpenditures * 0.5;
        }
        if (getAnnualIncome() < INCOME_LIMIT){
            return getAnnualIncome() * 0.15 - deduction;
        } else {
            return getAnnualIncome() * 0.25 - deduction;
        }
    }
}

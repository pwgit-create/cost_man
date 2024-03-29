package handler.response.model;

import handler.response.base.ResponseModelBase;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BudgetResponseModel extends ResponseModelBase {

    private BigDecimal amountUsed;
    private BigDecimal limit;
    private String unit;
    private LocalDate startDate;
    private LocalDate endDate;


    public BudgetResponseModel(LocalDateTime ldt, BigDecimal amountUsed, BigDecimal limit, String unit,
                               LocalDate startDate,LocalDate endDate) {
        super(ldt);
        this.amountUsed = amountUsed;
        this.limit = limit;
        this.unit = unit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BigDecimal getAmountUsed() {
        return amountUsed;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean IsBudgetOverDue(){

     return amountUsed.compareTo(limit) > 0;
    }

    public Double GetPercentageLeft(){

        MathContext mathContext = new MathContext(5);

     return amountUsed.divide(limit, mathContext).doubleValue();
    }
    public Double GetRemainingPercentage(){

        System.out.println("GetPercentageLeft -> "+GetPercentageLeft());


     return 1.0 - GetPercentageLeft();
    }



    @Override
    public String toString() {
        return "BudgetResponse{" +
                "ldt=" + timeOfResponse +
                ", amountUsed=" + amountUsed +
                ", limit=" + limit +
                ", unit='" + unit + '\'' +
                '}';
    }
}

package Accounting;

public class Accounting {
    private double totalSales = 0;
    private int amountSales = 0;
    private double totalProfit = 0;

    public void setTotalSales(double total_sell){
        this.totalSales += total_sell;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setAmountSales() {
        this.amountSales += 1;
    }

    public int getAmountSales() {
        return amountSales;
    }

    public void setTotalProfit(double profit){
        this.totalProfit += profit;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}

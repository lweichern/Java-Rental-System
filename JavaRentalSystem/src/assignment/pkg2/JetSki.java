/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author SV
 */
public class JetSki extends RentalItem{
    
    private double horsepower;
    
    public JetSki(){
        super();
        horsepower = 0;
    }
    
    public JetSki(int id, double ratePerDay, int numOfDays, double horsepower){
        super(id, ratePerDay, numOfDays);
        this.horsepower = horsepower;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }
    
    @Override
    public double calculateRental(){
        if (horsepower<= 250){
            double total = (super.getRatePerDay()*super.getNumOfDays());
            return total;
        }
        else{
            double total =((super.getRatePerDay()*1.5)*super.getNumOfDays());
            return total;
        }
    }
    
}

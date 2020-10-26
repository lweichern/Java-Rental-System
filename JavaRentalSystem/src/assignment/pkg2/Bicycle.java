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
public class Bicycle extends RentalItem{
    
    private String type;
    
    public Bicycle(){
        super();
        type = null;
    }
    
    public Bicycle(int id, double ratePerDay, int numOfDays, String type){
        super(id, ratePerDay, numOfDays);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public double calculateRental(){
        
        if(type.equals("Mountain")){
            return ((super.getRatePerDay()+10)*super.getNumOfDays());
        }
        else if(type.equals("Kids")){
            return ((super.getRatePerDay()/2)*super.getNumOfDays());
        }
        else{
            return (super.getRatePerDay()*super.getNumOfDays());
        }
    }
}

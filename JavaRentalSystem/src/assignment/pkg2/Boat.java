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
public class Boat extends RentalItem{
    
    private int capacity;
    
    public Boat(){
        super();
        capacity = 0;
    }
    
    public Boat(int id, double ratePerDay, int numOfDays, int capacity){
        super(id, ratePerDay, numOfDays);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double calculateRental(){

        if(capacity >= 10){
            
            return (((super.getRatePerDay()+50)*super.getNumOfDays()));
            
        }
        else{
            return (super.getRatePerDay()*super.getNumOfDays());
        }
    }
    
    
    
}

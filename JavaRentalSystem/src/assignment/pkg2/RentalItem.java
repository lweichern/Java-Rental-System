/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;


public abstract class RentalItem {
    
    //Variables
    private int id;
    private double ratePerDay;
    private int numOfDays;
    
    //Default Constuctor
    public RentalItem(){
        id = 00;
        ratePerDay = 0;
        numOfDays = 0;       
    }
    
    //Non-Default Constructor
    public RentalItem(int id, double ratePerDay, int numOfDays){
        this.id =id;
        this.ratePerDay = ratePerDay;
        this.numOfDays = numOfDays;
    }
    
    //Set & Get for id
    public void setId(int id){
        this.id =id;
    }
    public int getId(){
        return id;
    }
    
    //Set & Get for ratePerDay
    public void setRatePerDay(double ratePerDay){
        this.ratePerDay = ratePerDay;
    }
    public double getRatePerDay(){
        return ratePerDay;
    }
    
    //Set & Get for numOfDays
    public void setNumOfDays(int numOfDays){
        this.numOfDays = numOfDays;
    }
    public int getNumOfDays(){
        return numOfDays;
    }
    
    //Calcualte Rental
    public double calculateRental(){
        return 0;
    }
    
}

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
import java.util.*;
public class Rental {
    
    private int id;
    private Customer CusObj = new Customer();
    private ArrayList <RentalItem> rentalItems  = new ArrayList();
    
    public Rental(){
        id = 0;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer NewCus) {
        this.CusObj = NewCus;
    }

    public void addRentalItems(RentalItem item) {
        rentalItems.add(item);
    }
    
    public void removeRentalItems(int item) {
        this.rentalItems.remove(item);
    }
    
    public double calculateTotalRental(int arraysize){

        double total = 0;
        for (int i = 0 ;i<arraysize;i++){
            total = total + rentalItems.get(i).calculateRental();
        }
        return total;
    }
    
    public static void main(String args[]){
        
        Scanner read = new Scanner(System.in);
        //This Arraylist is to add the Rental Object to
        ArrayList <Rental> rentalarray  = new ArrayList<>();
        
        OUTER:  
        do {
            
            try {
                //Adding a customer
                System.out.println("What would you like to do?");
                System.out.println("---------------------------------------------");
                System.out.println("1. Add Customer");
                System.out.println("2. Add Rental Item");
                System.out.println("3. Remove Rental Item");
                System.out.println("4. Display All Rental Items and Details");
                System.out.println("5. Display One Rental Items and Details");
                System.out.println("0. Exit");
                System.out.println("---------------------------------------------");
                System.out.print("Your Selection: ");
                int temp = read.nextInt();           
                System.out.println("");
                read.nextLine();
                
                switch (temp) {
                    case 1:
                    //Adding a new Customer
                        
                        Customer CusObj = new Customer();
                        Rental newrental = new Rental();
                        
                        
                        System.out.println("You Have choosen to Add a new Customer\n");
                        System.out.print("Name: ");
                        CusObj.setName(read.nextLine());
                        System.out.print("Contact Number: ");
                        CusObj.setContactNo(read.nextLine());
                        
                        newrental.setCustomer(CusObj);
                        rentalarray.add(newrental);
                        
                        break;
                        
                    case 2:
                    //Adding a new Rental Item
                        if(rentalarray.isEmpty()){
                            System.out.println("\nNo Customers Are found for item to be rented to\nPlease Create Customer First\n");
                            break;
                        }else{
                            //Ask User which Item to add
                            System.out.println("You Have Choosen to Add a new Rental Item\n");
                            System.out.println("What Type of Item would you like to add\n1. Boat\n2. Bicycle\n3. JetSki");
                            System.out.print("Item: ");
                            int itemnum = read.nextInt();
                            System.out.println("");
                                if (itemnum == 1){
                                    //Adding a boat
                                    Boat boat = new Boat();
                                    
                                    System.out.println("Enter Boat Details");                            
                                    System.out.println();
                                    System.out.print("Boat Item Id: ");
                                    boat.setId(read.nextInt());
                                    System.out.print("Rental Rate per Day: $200\n");
                                    boat.setRatePerDay(200);
                                    System.out.print("Number of Days of Rental: ");
                                    boat.setNumOfDays(read.nextInt());
                                    System.out.print("Set Boat Capacity: ");
                                    boat.setCapacity(read.nextInt());
                                    
                                    RentalItem newboat = boat;
                                    //Asking to add to a customer 
                                    System.out.println("\nWhich Customer Does this Rental Item Belong to\nAvailable Customers");
                                    for (int i = 0 ; i < rentalarray.size(); i++){
                                        System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                                    }
                                    System.out.print("\nCustomer Number: ");
                                    int choice = read.nextInt();
                                    rentalarray.get((choice-1)).addRentalItems(newboat);

                                    System.out.println("\nBoat is Added to Customer "+rentalarray.get((choice-1)).CusObj.getName()+"\n");
                                }
                                else if(itemnum == 2){
                                    //Adding a Bike
                                    Bicycle bike = new Bicycle();

                                    System.out.println("Enter Bicycle Details");                            
                                    System.out.println();
                                    System.out.print("Bicycle Item Id: ");
                                    bike.setId(read.nextInt());
                                    System.out.print("Rental Rate per Day: $25\n");
                                    bike.setRatePerDay(25);
                                    System.out.print("Number of Days of Rental: ");
                                    bike.setNumOfDays(read.nextInt());read.nextLine();
                                    System.out.println("Set Type of Bicycle: ");
                                    System.out.print("\nTypes of Bicycles Available\n1. Regular\n2. Mountain\n3. Kids\nChoose Bike: ");
                                    int biketype = read.nextInt();
                                    //Displaying The different types of bikes available
                                    do{
                                        if(biketype == 1){
                                            System.out.println("Regular Bike has been Choosen");
                                            bike.setType("Regular");
                                            break;
                                        }else if(biketype == 2){
                                            System.out.println("Mountain Bike has been Choosen");
                                            bike.setType("Mountain");
                                            break;
                                        }else if(biketype == 3){
                                            System.out.println("Kids Bike has been Choosen");
                                            bike.setType("Kids");
                                            break;
                                        }else{
                                            System.out.println("\nThe Bike choosen is Invalid \nTry Again");
                                            System.out.print("\nTypes of Bicycles Available\n1. Regular\n2. Mountain\n3. Kids\nChoose Bike: ");
                                            biketype = read.nextInt();  
                                        }
                                    }while(biketype != 1||biketype != 2 || biketype != 3);
                                    
                                    RentalItem newbike = bike;
                                    //Asking to add to a customer 
                                    System.out.println("\nWhich Customer Does this Rental Item Belong to\nAvailable Customers");
                                    for (int i = 0 ; i < rentalarray.size(); i++){
                                        System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                                    }
                                    System.out.print("\nCustomer Number: ");
                                    int choice = read.nextInt();
                                    rentalarray.get((choice-1)).addRentalItems(newbike);

                                    System.out.println("\nBicycle is Added to Customer "+rentalarray.get((choice-1)).CusObj.getName()+"\n");
                                }
                                else if(itemnum == 3){
                                    //Adding a JetSki
                                    JetSki jetski = new JetSki();

                                    System.out.println("Enter JetSki Details");
                                    System.out.println();
                                    System.out.print("JetSki Item Id: ");
                                    jetski.setId(read.nextInt());
                                    System.out.print("Rental Rate per Day: $60\n");
                                    jetski.setRatePerDay(60);
                                    System.out.print("Number of Days of Rental: ");
                                    jetski.setNumOfDays(read.nextInt());read.nextLine();
                                    System.out.print("Set Horsepower of JetSki: ");
                                    jetski.setHorsepower(read.nextDouble());

                                    RentalItem newjetski = jetski;
                                    //Asking to add to a customer 
                                    System.out.println("\nWhich Customer Does this Rental Item Belong to\nAvailable Customers");
                                    for (int i = 0 ; i < rentalarray.size(); i++){
                                        System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                                    }
                                    System.out.print("\nCustomer Number: ");
                                    int choice = read.nextInt();
                                    rentalarray.get((choice-1)).addRentalItems(newjetski);

                                    System.out.println("JetSki is Addedto Customer "+rentalarray.get((choice-1)).CusObj.getName()+"\n");

                                }
                                else{
                                    System.out.println("Invalid Selection");
                                }
                                /*
                                System.out.println("Which Customer Does this Rental Item Belong to\nAvailable Customers");
                                for (int i = 0 ; i < rentalarray.size(); i++){
                                    System.out.println(rentalarray.indexOf(i)+". "+rentalarray.get(i).CusObj.getName()+"\n");
                                }
                                System.out.print("\n Customer Number: ");
                                int choice = read.nextInt();
                                rentalarray.get(choice).rentalItems.add(obj);
                                */
                                break;
                        }
                        
                    case 3:
                        //Remove Rental Item
                        if(rentalarray.isEmpty()){
                            System.out.println("\nNo Customers Found\n");
                            break;
                        }
                        else{
                            //Asking To remove a rental Item or a customer alltogether
                            OUTERdelete:
                            do{
                                System.out.println("You have choosen to remove a Rental Item\n1. Remove Customer & Rental Items\n2. Remove Rental Items Only\n0. Cancel");
                                System.out.println("Choice: ");
                                int remove = read.nextInt();
                                
                                if(remove == 1){
                                    System.out.println("You Have Choosen to Remove a Customer and Thier Rented Items");
                                    System.out.println("\nSelect Customer\nAvailable Customers");
                                    for (int i = 0 ; i < rentalarray.size(); i++){
                                        System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                                    }
                                    System.out.print("\nCustomer Number: ");
                                    int choice = read.nextInt();
                                    System.out.println("Customer: "+rentalarray.get(choice-1).CusObj.getName()+" Will now be Removed");
                                    rentalarray.remove(choice-1);
                                    break;
                                }
                                else if(remove == 2){
                                    System.out.println("You Have Choosen to Remove an Existing Rental Item\n");
                                    System.out.println("\nSelect Customer\nAvailable Customers");
                                    for (int i = 0 ; i < rentalarray.size(); i++){
                                        System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                                    }
                                    System.out.print("\nCustomer Number: ");
                                    int choice = read.nextInt();
                                    System.out.println("Customer That you have choosen is: "+rentalarray.get(choice-1).CusObj.getName());
                                    System.out.println("\nThe Rental Items By this Customer are: ");
                                    int listsize = rentalarray.get((choice-1)).rentalItems.size();
                                    for(int i = 0; i < listsize; i++){
                                    System.out.println((i+1)+". "+rentalarray.get((choice-1)).rentalItems.get(i).getId());
                                    }
                                    if(rentalarray.get(choice-1).rentalItems.isEmpty()){
                                        System.out.println("There Are no Items Rented by this Customer!\n");
                                        break;
                                    }else{
                                    System.out.print("Which Item would You like to delete\nSelection: ");
                                    int index = read.nextInt();
                                    rentalarray.get(choice-1).removeRentalItems(index-1);
                                    break;
                                    }
                                }
                                else if(remove == 0){
                                    System.out.println("Deleting canceled");
                                    break OUTERdelete;
                                }
                                else{
                                    System.out.println("\nInvalid Input\n");
                                }
                            }while(true);
                            break;
                        }
                    case 4:
                        //Display All Rental Items and Details
                        if(rentalarray.isEmpty()){
                            System.out.println("\nNo Customers Found\n");
                            break;
                        }
                        else{
                            System.out.println("You Have Choosen to View All Existing Rental Items & Details");

                            System.out.printf("%20s %18s %16s %17s %16s %18s","Customer Name", "Contatct Number", "Boats Rented","Bicycles Rented", "JetSkis Rented", "Total Rental Cost");
                            System.out.println("\n========================================================================================================================");

                            for (int i = 0 ; i < rentalarray.size(); i++){
                                int numOfBoats = 0;
                                int numOfBikes = 0;
                                int numOfJetSki = 0;

                                for (int item = 0;item < (rentalarray.get(i).rentalItems.size()); item++){

                                    if(rentalarray.get(i).rentalItems.get(item).getClass() == Boat.class){
                                        numOfBoats++;
                                    }
                                    if(rentalarray.get(i).rentalItems.get(item).getClass() == Bicycle.class){
                                        numOfBikes++;
                                    }
                                    if(rentalarray.get(i).rentalItems.get(item).getClass() == JetSki.class){
                                        numOfJetSki++;
                                    }
                                }
                                double totalrental = rentalarray.get(i).calculateTotalRental((rentalarray.get(i).rentalItems.size()));

                                System.out.printf("%20s %18s %16s %17s %16s %18s",rentalarray.get(i).CusObj.getName(),rentalarray.get(i).CusObj.getContactNo(), numOfBoats, numOfBikes, numOfJetSki, "$"+totalrental+"\n");
                            }
                            System.out.println("========================================================================================================================\n");
                            break;
                        }
                    case 5:
                        //Display One Rental Items and Details
                        if(rentalarray.isEmpty()){
                            System.out.println("\nNo Customers Found\n");
                            break;
                        }
                        else{
                            System.out.println("You Have Choosen to View Only one Rental Item\n");
                            System.out.println("Select Customer to view the Details");
                            System.out.println("\nAvailable Customers");
                            for (int i = 0 ; i < rentalarray.size(); i++){
                                System.out.println((i+1)+". "+rentalarray.get(i).CusObj.getName());
                            }
                            System.out.print("\nCustomer Number: ");
                            int choice = read.nextInt();
                            
                            if(rentalarray.get(choice-1).rentalItems.isEmpty()){
                                System.out.println("\nThis Customer has no rented Items!\n");
                                break;
                            }
                            else{
                                System.out.println("You have Choosen to view Customer: "+rentalarray.get(choice-1).CusObj.getName()+"\n");
                                System.out.println("=====================================================================");
                                System.out.println("Name: "+rentalarray.get(choice-1).CusObj.getName()+"\nContact Number: "+rentalarray.get(choice-1).CusObj.getContactNo());
                                System.out.println("-----------------------------------");
                                for (int item = 0;item < (rentalarray.get(choice-1).rentalItems.size()); item++){
                                        if(rentalarray.get(choice-1).rentalItems.get(item).getClass() == Boat.class){
                                            System.out.println("Boat Id: "+rentalarray.get(choice-1).rentalItems.get(item).getId());
                                            System.out.println("Days Rented: "+rentalarray.get(choice-1).rentalItems.get(item).getNumOfDays());
                                            System.out.println("Rate Per Day: "+rentalarray.get(choice-1).rentalItems.get(item).getRatePerDay());
                                            System.out.println("Total Rental: "+rentalarray.get(choice-1).rentalItems.get(item).calculateRental());
                                            System.out.println();
                                        }

                                        if(rentalarray.get(choice-1).rentalItems.get(item).getClass() == Bicycle.class){
                                            System.out.println("Bicycle Id: "+rentalarray.get(choice-1).rentalItems.get(item).getId());
                                            System.out.println("Days Rented: "+rentalarray.get(choice-1).rentalItems.get(item).getNumOfDays());
                                            System.out.println("Rate Per Day: "+rentalarray.get(choice-1).rentalItems.get(item).getRatePerDay());
                                            System.out.println("Total Rental: "+rentalarray.get(choice-1).rentalItems.get(item).calculateRental());
                                            System.out.println();
                                        }

                                        if(rentalarray.get(choice-1).rentalItems.get(item).getClass() == JetSki.class){
                                            System.out.println("JetSki Id: "+rentalarray.get(choice-1).rentalItems.get(item).getId());
                                            System.out.println("Days Rented: "+rentalarray.get(choice-1).rentalItems.get(item).getNumOfDays());
                                            System.out.println("Rate Per Day: "+rentalarray.get(choice-1).rentalItems.get(item).getRatePerDay());
                                            System.out.println("Total Rental: "+rentalarray.get(choice-1).rentalItems.get(item).calculateRental());
                                            System.out.println();
                                        }
                                }
                                System.out.println("-----------------------------------");
                                System.out.println();
                                System.out.println();
                                break;
                            }
                        }
                        
                        
                    case 0:
                        //Exit
                        System.out.println("=====================");
                        System.out.println("Program will now exit");
                        break OUTER;
                        
                    default:
                        System.out.println("Selection is Invalid");
                        break;
                }
            //catch Statements to check whats wrong
            }catch(InputMismatchException inputerror) {
                System.out.println("\nInput is Wrong!\nProgram will now restart\n");
                read.next();
            }
            catch (IndexOutOfBoundsException arrayerror){
                System.out.println("\nThe List Item is not Available\n");
            }
            catch (Exception unknown){
                System.out.println("\nSomething Unknown has happened\n");
                System.out.println("Error Message: "+unknown.toString()+"\n");
                System.out.println();
            }
        } while (true);
        
    }
    
    
}

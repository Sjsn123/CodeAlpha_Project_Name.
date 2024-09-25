
/*Create a personal portfolio showcasing your skills,
projects, and resume. Use HTML for structure, CSS
for styling, and add a touch of JavaScript for
interactivity.
Hotel Reservation System
Build a hotel reservation system where users can
search for available rooms, make reservations, and view
booking details. Include features like room
categorization and payment processing. */



import java.util.*;
import java.time.LocalDate;
import java.time.Period;

    // This class is specifically for Hotel sign in or register for customers.
class Hotel_SignUp_Login{
    Scanner sc = new Scanner(System.in);
    String  userInput, passwordInput,choice;
    private  ArrayList<String> Cutomer_Username = new ArrayList<>();
    private  ArrayList<String> Customer_password = new ArrayList<>();
   
    
    /**
     * 
     * @param checkCondition
     * @return
     * This below function is used to check conditions for the whole users if user want to do osmething or not as per the request comes out.
     */
     
    boolean checkCondition(String choice){
        if(choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("y")||choice.equalsIgnoreCase("ye")){
            return true;
        }
        else{
            return false;
        }
    }
    //This below function used to store details of persons who sign up or register in the system. 
    private void addLoginDetails(String user_name, String pass){
        this.Cutomer_Username.add(user_name);
        this.Customer_password.add(pass);

    }
    /**
     * @param displayMessage this will contain the message to be displayed on the terminal.
    * @description This function will be used to  display any message 
    **/ 
    void printMessage(String displayMessage) {
        System.out.println(displayMessage);
    }
    // This function below will be used to sign up and is the first step before you login.
    public boolean signup(){
        System.out.println("Enter the user_name.\nLength of username should be more than 8 characters.");
      
        userInput = sc.nextLine();
        

        while(userInput.length()<8) {
            System.out.println("\nUsername should be at least 8 or more than 8 characters long.");
            System.out.println("Enter the Username.");
            userInput = sc.nextLine();
            
        }
        System.out.println();
        System.out.println("Enter the password.");
        System.out.println("Length of Password should be more than 8 characters long.");
         passwordInput = sc.nextLine();
       
        while(passwordInput.length()<8){
            System.out.println("Password should be at least 8 or more than 8 characters long.");
            System.out.println("Enter the password.");
            passwordInput = sc.nextLine();
            
        }
        System.out.println();
        System.out.println("Successfully Registered.");
        System.out.println("Please enter the same details again when redirected to login page.");
        System.out.println();
        addLoginDetails(userInput, passwordInput);
       if(login()){
        return true;
       }
       else{
        return false;
       }

    }
    
    /*This below function is used to update your username and password in case the users fails to login. */
    private boolean update_sign(){

        for(int i=0;i<Customer_password.size();i++){
            System.out.println("Enter the user_name.");
             System.out.println("Length of username should be more than 8 characters.");

             userInput = sc.nextLine();
             System.out.println();
            while(userInput.length()<8){
            System.out.println("Username should be at least 8 or more than 8 characters long.");
            System.out.println("Enter the UserName again.");
            userInput = sc.nextLine();
        }
        System.out.println();
        System.out.println("Enter the password.");
        System.out.println("Length of password should be more than 8 characters.");
         passwordInput = sc.nextLine();
        System.out.println();
        while(passwordInput.length()<8){
            System.out.println("Password should be at least 9 characters long.");
        System.out.println("Enter the password.");
         passwordInput = sc.next();
        }
        System.out.println();
        System.out.println("Successfully Registered New user and Password.");
        System.out.println("Please enter the same details again when redireted to login page.");
        System.out.println();
        Cutomer_Username.set(i, userInput);
        Customer_password.set(i, passwordInput);
        addLoginDetails(userInput, passwordInput);
        login();
        break;
        }
        return true;
    }
    //This below function is used to log in first in the system. 
    public boolean login(){
         int attempts =4;
         
        System.out.println("Enter the user name.");
        System.out.println("Length of Username should be more than 8 characters.");
        userInput = sc.nextLine();
        
        while(userInput.length()<8){
            System.out.println("\nUsername should be at least 8 or more than 8 characters long");
        System.out.println("Enter the username");
         userInput = sc.nextLine();
        
        }
        System.out.println();
        System.out.println("Enter the password");
        System.out.println("Length of password should be more than 8 characters.");
         passwordInput = sc.nextLine();
 
        while(passwordInput.length()<8){
            System.out.println("\nPassword should be at least 8 or more than 8 characters long");
        System.out.println("Enter the password");
         passwordInput = sc.nextLine();
         sc.nextLine();
        }
        System.out.println();
        if(Customer_password.isEmpty()&& Cutomer_Username.isEmpty()){
            System.out.println("\nDear Customer, there is no user registered on this Id.");
            System.out.println("If you want to signup.");
            System.out.println("Please Tell Yes or no.");
             choice= sc.nextLine();
            System.out.println();
            if(checkCondition(choice)){
               
              if(signup())
              return true;
            }
           
            else{
                    return false;
            }
        }
        
        for (int i = 0; i < Cutomer_Username.size(); i++) {
         if(Cutomer_Username.get(i).equals(userInput)&& Customer_password.get(i).equals(passwordInput)){
            System.out.println("\nLogin Successfull Hooraayyyy!!\nWelcome to the Hotel Booking system.\n");
            System.out.println("Please Do not share the username and password.");
            System.out.println();
            return true;
        }
        break;
    }
         
            while(attempts>0){
             
                attempts--;
                System.out.println("Wrong Input given.");
                System.out.println("Only "+attempts+ " attempts left");
                System.out.println();
                System.out.println("Enter the user name.\nLength of Username should be more than 8 characters.");
                userInput =sc.nextLine();

                while(userInput.length()<8){
                    System.out.println("Username should be at least 8 or more than 8 characters long");
                System.out.println("Enter the username");
                 userInput = sc.nextLine();
                 
                }
                System.out.println();
                System.out.println("Enter the password");
                System.out.println("Length of password should be more than 8 characters.");
                 passwordInput = sc.nextLine();
               
         
                while(passwordInput.length()<8){
                    System.out.println("Password should be at least 8 or more than 8 characters long");
                System.out.println("Enter the password");
                 passwordInput = sc.nextLine();
                 
                }
                for (int i = 0; i < Cutomer_Username.size(); i++) {
                    if(Cutomer_Username.get(i).equals(userInput)&& Customer_password.get(i).equals(passwordInput)){
                       System.out.println("\nLogin Successfull Hooraayyyy!!\nWelcome to the Hotel Booking system.\n");
                       System.out.println("Please Do not share the username and password.");
                       System.out.println();
                       return true;
                   }
                   break;
               }
                System.out.println();
                if(attempts==1){
                    System.out.println("If you have forgotten the input do you want to change it.");
                    System.out.println("Please enter yes or no");
                    choice= sc.nextLine();
                    System.out.println();
                    if(checkCondition(choice)){
                     if(update_sign())
                     return true;
                     break;
                     }
                     else{
                         System.out.println("Terminating the program");
                     return false;
                     }
                 }
            }
            return true;
    }
    
}
// This below class is for handling all the operations for ex data entered by user and it also inherits the login class.

class HotelBooking extends  Hotel_SignUp_Login{
    protected static Scanner sc = new Scanner(System.in);
    protected static Random ra = new Random();
   protected int total_room_remain;
   protected int new_room_available;
   private int room,days;
   private List<Integer> rooms = new ArrayList<>();
    String check_in,check_out,choice;
   protected double newprice_ac;
   protected double newprice_non_ac;
   protected   Double updated_price;
    private  Set<Integer> uniqueRoomNumbers = new HashSet<>();
   private List<String> Room_category = Arrays.asList("Single","Double","Suite");
   private List<Double> Room_price = Arrays.asList(30.0 , 80.0 , 150.0);
   private List<String> Room_type = Arrays.asList("A.C","Non- A.C");
   private List<Integer> Room_available = Arrays.asList(100,200,150);
   private List<Integer> Food_price = Arrays.asList(30,40,60);

    private ArrayList<String> Customer_Name_Adults = new ArrayList<>();
    private ArrayList<Integer> Customer_Age_Adult = new ArrayList<>();
    private static ArrayList<String> Customer_Phone_No_Adult = new ArrayList<>();
    private ArrayList<String> Customer_Gmail = new ArrayList<>();
    private ArrayList<String> Customer_Addhar_No_Adult = new ArrayList<>();
    private ArrayList<String> Customer_Name_Children = new ArrayList<>();
    private ArrayList<Integer> Customer_Age_Children = new ArrayList<>();
    private ArrayList<String> Customer_AadharNo_Children = new ArrayList<>();

    /* This below function is storing the information of Adults. */
    private void customer_info_Adult(String Adult_name, int Adult_age,String Adult_Phone,String Gmail,String Aadhaar_id_Adult){
        this.Customer_Name_Adults.add(Adult_name);
        this.Customer_Age_Adult.add(Adult_age);
        this.Customer_Phone_No_Adult.add(Adult_Phone);
        this.Customer_Gmail.add(Gmail);
        this.Customer_Addhar_No_Adult.add(Aadhaar_id_Adult);
    }
   
    /*   This below information is  storing the information of children. */
    private void customer_info_Children(String Name_Child,int Age_child, String Adhar_Child){
        this.Customer_Name_Children.add(Name_Child);
        this.Customer_Age_Children.add(Age_child);
        this.Customer_AadharNo_Children.add(Adhar_Child);
    }

    /* This below functions is used to avail food for Single type bed customers. */
    private void food_single(String type){
        int room_number_single;
         System.out.println("\nDear Customer, Do you want to to avail food also." );
           System.out.println("Please tell yes or no.");
            choice = sc.next();
    System.out.println();
       if(checkCondition(choice)){

                   if(type.equals("AC")){
                    System.out.println("The price of food is $30.0");
                     updated_price = newprice_ac+ (30*room*days);
                    System.out.print("Dear Customer, you have been allocated: ");
                    while(room!=0){
                               do{
                               room_number_single = ra.nextInt(100,200);
                               }while(!uniqueRoomNumbers.add(room_number_single));
                          System.out.print(room_number_single);
                          if(room>1)
                          System.out.print(",");
                           room--;
                        }
                           System.out.println(" room numbers at $" +updated_price+" with AC and Food.");
                   }
                    else if(type.equals("Non AC")){
                        System.out.println("The price of food is $30.0");
                         updated_price = newprice_non_ac+ (30*room*days);
                        System.out.print("Dear Customer, you have been allocated: ");
                        while(room!=0){
                                   do{
                                   room_number_single = ra.nextInt(100,200);
                                   }while(!uniqueRoomNumbers.add(room_number_single));
                              System.out.print(room_number_single);
                              if(room>1)
                              System.out.print(",");
                               room--;
                            }
                               System.out.println(" room numnbers at $" +updated_price+ " with Food but not AC.");
                    }

    }
    else if(checkCondition(choice)){

        if(type.equals("AC")){
                        updated_price = newprice_ac;
                        System.out.print("Dear Customer, you have been allocated: ");
                        while(room!=0){
                            do{
                            room_number_single = ra.nextInt(100,200);
                            }while(!uniqueRoomNumbers.add(room_number_single));
                       System.out.print(room_number_single);
                       if(room>1)
                       System.out.print(",");
                        room--;
                        }
                        System.out.println(" room nummbers at $" +updated_price+ " with AC but not Food.");
       }

         else if(type.equals("Non AC")){
            updated_price = newprice_non_ac;
                            System.out.print("Dear Customer, you have been allocated: ");
                 while(room!=0){
                            do{
                            room_number_single = ra.nextInt(100,200);
                            }while(!uniqueRoomNumbers.add(room_number_single));
                       System.out.print(room_number_single);
                       if(room>1)
                       System.out.print(",");

                        room--;
                       
                     }
                        System.out.println(" room nummbers at $" +updated_price+" with no Food and AC." );
                          
             }
     }

        System.out.println();
        display_Customer_Info();
        System.out.println();
 }
     /*This below function is used as hcoice type for AC or Non AC in single type bed. */
    private void ac_or_non_ac_single(){
    System.out.println("Enter what type of room is your preferene");
    System.out.println("1. Please Enter 1 for AC.");
    System.out.println("2. Please Enter 2 for Non AC.");
    int i=0;
    int choice1 = sc.nextInt();
    System.out.println();
   if(choice1 ==1){
    System.out.println("You have chosen AC Room.");
     newprice_ac = (Room_price.get(i)+ 30)*room*days; 
     System.out.println("Dear Customer you have booked for: "+room+" Single Type AC rooms at $"+newprice_ac+" from "+ check_in+" to "+check_out+" for "+days +" days.");
     System.out.println();
     food_single("AC");
   }
   else if(choice1==2){
    System.out.println("You have chosen Non AC Room");
    newprice_non_ac = Room_price.get(i)*room*days;
    System.out.println("Dear Customer you have booked for: "+room+" Single Type Non AC rooms at $"+newprice_non_ac+" from "+ check_in+" to "+check_out+" for "+days +" days.");
    System.out.println();
    food_single("Non AC");
   }

   }
    /*This below function is used for customers who has choosen Singe type bed.*/
   private void single_room(){
    int i=0;
    System.out.println("Please Enter the number of rooms you want");
    room = sc.nextInt();
    while(room==0){
        System.out.println("Number of rooms should not be 0.");
        System.out.println("Please Enter the number of rooms you want");
        room = sc.nextInt();
    }
    rooms.add(room);
    System.out.println("Please enter the check in date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_in = sc.next();
     while(check_in.length()==0 ||  !check_in.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_in = sc.next();
        }

        System.out.println();
    System.out.println("Please enter the check out date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_out = sc.next();
     while(check_in.length()==0||  !check_out.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_out = sc.next();
        }
        date();
       
    System.out.println();
     total_room_remain = Room_available.get(i)-room;
     Room_available.set(i, total_room_remain);
    if(total_room_remain >= room){
        System.out.println("Dear Customer you have booked for: "+room+" Single Type rooms."+" from "+ check_in+" to "+check_out +" for "+days +" days.");
        System.out.println();
        totalNoOfPersons();
        System.out.println();
        ac_or_non_ac_single();
    
    }
    else{
        System.out.println("Sorry we do not have enough rooms");
    }

   }
   //* This below function is used to avail food for Double type bed customers. */
   private void food_double(String type1){
    int room_number_double;
    System.out.println("Dear Customer, Do you want to to avail food also." );
      System.out.println("Please tell yes or no.");
       choice = sc.next();
System.out.println();
  if(checkCondition(choice)){

              if(type1.equals("AC")){
               System.out.println("The price of food is $40.0");
                updated_price = newprice_ac+ (40*room*days);
               System.out.print("Dear Customer, you have been allocated: ");
               while(room!=0){
                          do{
                          room_number_double = ra.nextInt(201,400);
                          }while(!uniqueRoomNumbers.add(room_number_double));
                     System.out.print(room_number_double);
                     if(room>1)
                     System.out.print(",");
                      room--;
                   }
                      System.out.println(" room numbers at $" +updated_price+" with Food and AC.");
              }
               else if(type1.equals("Non AC")){
                   System.out.println("The price of food is $40.0");
                    updated_price = newprice_non_ac+ (40*room*days);
                   System.out.print("Dear Customer, you have been allocated: ");
                   while(room!=0){
                              do{
                              room_number_double = ra.nextInt(201,400);
                              }while(!uniqueRoomNumbers.add(room_number_double));
                         System.out.print(room_number_double);
                         if(room>1)
                         System.out.print(",");
                          room--;
                       }
                          System.out.println(" room numbers at $" +updated_price +" with Food but not AC.");
               }

}
else if(checkCondition(choice)){

   if(type1.equals("AC")){
    updated_price = newprice_ac;
                   System.out.print("Dear Customer, you have been allocated: ");
                   while(room!=0){
                       do{
                       room_number_double = ra.nextInt(201,400);
                       }while(!uniqueRoomNumbers.add(room_number_double));
                  System.out.print(room_number_double);
                  if(room>1)
                  System.out.print(",");
                   room--;
                   }
                   System.out.println(" room nummbers at $" +updated_price+" with AC but no Food.");
  }

    else if(type1.equals("Non AC")){
        updated_price = newprice_non_ac;
                       System.out.print("Dear Customer, you have been allocated: ");
            while(room!=0){
                       do{
                       room_number_double = ra.nextInt(201,400);
                       }while(!uniqueRoomNumbers.add(room_number_double));
                  System.out.print(room_number_double);
                  if(room>1)
                  System.out.print(",");

                   room--;
                  
                }
                   System.out.println(" room nummbers at $" +updated_price+ " with Non AC and No Food.");
                     
        }
}

    System.out.println();
    display_Customer_Info();
    System.out.println();
   }
  /*This below function is used as choice type for AC or Non AC in double type bed. */
   private void ac_or_non_ac_double(){
    System.out.println("Enter what type of room is your preferene");
    System.out.println("1. Please Enter 1 for AC");
    System.out.println("2. Please Enter 2 for Non AC");
    int i=1;
    int choice1 = sc.nextInt();
   if(choice1 ==1){
    System.out.println("You have chosen AC Room");
     newprice_ac = (Room_price.get(i)+ 45)*room*days; 
     System.out.println("Dear Customer you have booked for: "+room+" Double Type rooms with AC at $"+newprice_ac+" from "+ check_in+" to "+check_out+" for "+days +" days.");
     System.out.println();
     food_double("AC");
   }
   else if(choice1==2){
    System.out.println("You have chosen Non AC Room");
    newprice_non_ac = Room_price.get(i)*room*days;
    System.out.println("Dear Customer you have booked for: "+room+" Double Type rooms with Non AC at $"+newprice_non_ac+" from "+ check_in+" to "+check_out+" for "+days +" days.");
    System.out.println();
    food_double("Non AC");
   }
  }
   /*This below function is used for customers who has choosen Double type bed.*/
  private void double_room(){
    int i=1;
    System.out.println("Dear Customer, Enter the number of rooms you want");
    room = sc.nextInt();
    while(room==0){
        System.out.println("Number of rooms should not be 0.");
        System.out.println("Please Enter the number of rooms you want");
        room = sc.nextInt();
    }
    rooms.add(room);
    System.out.println("Please enter the check in date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_in = sc.next();
     while(check_in.length()==0 ||  !check_in.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_in = sc.next();
        }

        System.out.println();
    System.out.println("Please enter the check out date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_out = sc.next();
     while(check_in.length()==0||  !check_out.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_out = sc.next();
        }
        date();
    System.out.println();
     total_room_remain = Room_available.get(i)-room;
     Room_available.set(i, total_room_remain);
    if(total_room_remain >= room){
        System.out.println("Dear Customer you have booked for: "+room+" Double Type room from "+ check_in+" to "+check_out+" for "+days +" days.");
        System.out.println();
        totalNoOfPersons();
        System.out.println();
        ac_or_non_ac_double();
   
    
    }
    else{
        System.out.println("Sorry we do not have enough rooms");
    }
   }
/*This below function is used to remove the list or simply remove data when to cancel the ticket. */
   private void remove_list(String phone){
    if(Customer_Phone_No_Adult.contains(phone)){
        int index = phone.indexOf(phone);
        Customer_Phone_No_Adult.remove(index);
        Customer_Addhar_No_Adult.remove(index);
        Customer_Name_Adults.remove(index);
        Customer_Age_Adult.remove(index);
        Customer_Gmail.remove(index);
        if(!Customer_Name_Children.isEmpty()){
        Customer_Name_Children.remove(index);
        Customer_Age_Children.remove(index);
        Customer_AadharNo_Children.remove(index);
        }
        }
        else{
            System.out.println("Sorry we do not have any customer with this phone number");
            System.exit(0);
        }
        

    }
 
/*This below function is used to cancel the ticket of customers.*/
   private void cancel_ticket(){
    System.out.println("Do you want to cancel the ticket.");
    System.out.println(" Please enter yes or no.");
    choice= sc.next();
    if(checkCondition(choice)){
        System.out.println("Please enter your Phone Number");
        String phone = sc.next();
        System.out.println("Dear Customer, your ticket has been cancelled.");
        System.out.println("Thank you for choosing us.");
        remove_list(phone);
        System.exit(0);
        }
   }
 /* This below functions is used to avail food for Suite type bed customers. */
private void food_suite(String type2){
    int room_number_suite;
    System.out.println("Dear Customer, Do you want to to avail food also." );
      System.out.println("Please tell yes or no.");
       choice = sc.next();
System.out.println();
  if(checkCondition(choice)){

              if(type2.equals("AC")){
               System.out.println("The price of food is $60.0 per day");
                updated_price = newprice_ac+ (60*room*days);
               System.out.print("Dear Customer, you have been allocated: ");
               while(room!=0){
                          do{
                          room_number_suite = ra.nextInt(401,550);
                          }while(!uniqueRoomNumbers.add(room_number_suite));
                     System.out.print(room_number_suite);
                     if(room>1)
                     System.out.print(",");
                      room--;
                   }
                      System.out.println(" room numbers at $" +updated_price+" with Food and AC");
              }
               else if(type2.equals("Non AC")){
                   System.out.println("The price of food is $60.0");
                    updated_price = newprice_non_ac+ (60*room*days);
                   System.out.print("Dear Customer, you have been allocated: ");
                   while(room!=0){
                              do{
                              room_number_suite = ra.nextInt(401,550);
                              }while(!uniqueRoomNumbers.add(room_number_suite));
                         System.out.print(room_number_suite);
                         if(room>1)
                         System.out.print(",");
                          room--;
                       }
                          System.out.println(" room numbers at $" +updated_price+ " with Food but not AC");
               }

}
else if(checkCondition(choice)){

   if(type2.equals("AC")){
    updated_price = newprice_ac;
                   System.out.print("Dear Customer, you have been allocated: ");
                   while(room!=0){
                       do{
                       room_number_suite = ra.nextInt(401,550);
                       }while(!uniqueRoomNumbers.add(room_number_suite));
                  System.out.print(room_number_suite);
                  if(room>1)
                  System.out.print(",");
                   room--;
                   }
                   System.out.println(" room nummbers at $" +updated_price + " with AC but No Food.");
  }

    else if(type2.equals("Non AC")){
        updated_price = newprice_non_ac;
                       System.out.print("Dear Customer, you have been allocated: ");
            while(room!=0){
                       do{
                       room_number_suite = ra.nextInt(401,550);
                       }while(!uniqueRoomNumbers.add(room_number_suite));
                  System.out.print(room_number_suite);
                  if(room>1)
                  System.out.print(",");

                   room--;
                  
                }
                   System.out.println(" room nummbers at $" +updated_price+" with No Food and AC.");
                     
        }
}

    System.out.println();
    display_Customer_Info();
    System.out.println();
}
 /*This below function is used to choice type for AC or Non AC in Suite type bed. */
   private void ac_or_non_ac_suite(){
    
    System.out.println("Enter what type of room is your preferene");
    System.out.println("1. Please Enter 1 for AC");
    System.out.println("2. Please Enter 2 for Non AC");
    int i=2;
    int choice1 = sc.nextInt();
    System.out.println();
   if(choice1 ==1){
    System.out.println("You have chosen AC Room");
     newprice_ac = (Room_price.get(i)+ 65)*room*days; 
     System.out.println("Dear Customer you have booked for: "+room+" Suite Type rooms with AC at $"+newprice_ac+" from "+ check_in+" to "+check_out +" for "+days +" days.");
     System.out.println();
     food_suite("AC");
   }
   else if(choice1==2){
    System.out.println("You have chosen Non AC Room");
    newprice_non_ac = Room_price.get(i)*room*days;
    System.out.println("Dear Customer you have booked for: "+room+" Suite Type rooms with Non AC at $"+newprice_non_ac+" from "+ check_in+" to "+check_out +" for "+days +" days.");
    System.out.println();
    food_suite("Non AC");
   }
   }
   /*This below function is used for customers who has choosen Suite type bed.*/
   private void suite_room(){
 int i=2;
    System.out.println("Dear Customer, Enter the number of rooms you want");
    room = sc.nextInt();
    while(room==0){
        System.out.println("Number of rooms should not be 0.");
        System.out.println("Please Enter the number of rooms you want");
        room = sc.nextInt();
    }
    rooms.add(room);
    System.out.println();
    System.out.println("\nPlease enter the check in date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_in = sc.next();
     while(check_in.length()==0 ||  !check_in.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_in = sc.next();
        }

        
    System.out.println("\nPlease enter the check out date of yours. ");
    System.out.println("Write in DD-MM-YYYY format. ");
     check_out = sc.next();
     while(check_in.length()==0||  !check_out.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)[0-9]{2}$")){
        System.out.println("The format should be DD-MM-YYYY. ");
        check_out = sc.next();
        }
        date();
    System.out.println();
     total_room_remain = Room_available.get(i)-room;
     Room_available.set(i, total_room_remain);
    if(total_room_remain >= room){
        System.out.println("Dear Customer you have booked for: "+room+" Suite Type rooms from "+check_in+" to "+check_out +" for "+days +" days.");
        System.out.println();
        totalNoOfPersons();
        System.out.println();
        ac_or_non_ac_suite();
    }
    else{
        System.out.println("Sorry we do not have enough rooms");
    }
   }
   
/*    This below function is used to provide the number of days from the check in date to checkout date*/
   private void date(){
    String[] checkInParts = check_in.split("-");
int day = Integer.parseInt(checkInParts[0]);
int month = Integer.parseInt(checkInParts[1]);
int year = Integer.parseInt(checkInParts[2]);
LocalDate checkInDate = LocalDate.of(year, month, day);

String[] checkOutParts = check_out.split("-");
int checkoutDay = Integer.parseInt(checkOutParts[0]);
int checkoutMonth = Integer.parseInt(checkOutParts[1]);
int checkoutYear = Integer.parseInt(checkOutParts[2]);
LocalDate checkOutDate = LocalDate.of(checkoutYear, checkoutMonth, checkoutDay);

Period period = Period.between(checkInDate, checkOutDate);
days = period.getDays();
   }

/* This below function is used for asking for preference which type of room does the user want to book.*/
   public void roomToBeBooked(){
    while(true){
        System.out.println("\nYou are eligible to book rooms. ");
    System.out.println("Do you want to book it. Please tell yes or no. ");
         choice = sc.next();
        System.out.println();
        if(checkCondition(choice)){
    System.out.println("Dear Customer please tell which type of room is your preference.");
    System.out.println();
    System.out.println("1. Enter 1 for Single Type.");
    System.out.println("2. Enter 2 for Double Type");
    System.out.println("3. Enter 3 for Suite Type.");
    int choice1 = sc.nextInt();
    System.out.println();
    switch (choice1) {
        case 1:
            single_room();      
            break;
        
            case 2:
            double_room();       
            break;

            case 3:
            suite_room();
            break;
        default:
        System.out.println("\nWrong Choice");
            break;
    }
    }
    else{
        System.out.println("\nThank you for your time.");
        System.out.println("Thank you for visiting for Hotel Rooms booking System.");
        System.exit(0);
        }
}
   }
/*This below function is used to add the total no persons. */ 
   public void totalNoOfPersons(){
    System.out.println("\nEnter the number of Adults.");
    System.out.println("Number of Adults should not be 0.");
    int adults = sc.nextInt();
    while(adults==0){
        System.out.println("\nNumber of Adults should not be 0.");
        adults = sc.nextInt();
    }
    System.out.println("\nEnter the number of Children.");
    int children = sc.nextInt();

   people_database(adults,children);
}
/*THis below function is used to add the names and other details of the customer*/
   private void people_database(int Adults,int Children){

    while(Adults!=0 || Children!=0){

    System.out.println("\nEnter the name of the Adult.");
    sc.nextLine();
    String adult_name = sc.nextLine();
   
    while(adult_name.isBlank()){
        System.out.println("\nPlease enter a valid name");
        adult_name = sc.nextLine();
        
    }
    

    System.out.println("\nEnter the Age of an Adult");
    int adult_age = sc.nextInt();
    sc.nextLine();
    while(adult_age<=0){
        if (adult_age==0) {
            System.out.println("\nAge should be a positive number.");
            adult_age = sc.nextInt();
            sc.nextLine();
            break;
        }
        System.out.println("\nAge should be greater than 0");
        adult_age = sc.nextInt();
        sc.nextLine();
        }

        System.out.println();

    System.out.println("Enter the Phone Number.");
    System.out.println("The phone number should consists of 10 digits");
    String adult_phone = sc.next();
    while(adult_phone.length()!=10){
        System.out.println("Please enter a valid phone number");
        adult_phone = sc.next();
        }
        
        System.out.println();

    System.out.println("Please Enter the Email. Spaces between are not allowed. Ex pal 123@gmail.com");
    System.out.println(" Use anything except for giving spaces in between.");
    System.out.println("Email should end with @gmail.com. and length should be between 10 to 35 characters.");
    String adult_email = sc.next();

    while(!adult_email.endsWith("@gmail.com") ){
        System.out.println("Email should end with @gmail.com.");
        adult_email = sc.nextLine();
    }
    while (adult_email.length()>35) {
        System.out.println("Email should be between 10 to 35 characters.");
        adult_email = sc.nextLine(); 
    }

    System.out.println();
   
    System.out.println("Dear Customer, Please give your Aadhaar ID for verification.");
    System.out.println("The Aadhar Id should be of 12 Characters Long.");
    String Aadhaar_id_Adult = sc.nextLine();
    while(Aadhaar_id_Adult.length()!=12){
        System.out.println("Please enter a valid Aadhaar ID");
        Aadhaar_id_Adult = sc.nextLine();
    }
    String child_name;
    int child_age;
    String Aadhaar_id_Children;
    System.out.println();
    if(Children>0){
    System.out.println("Enter the name of the Child.");
    
     child_name = sc.nextLine();
     
        while (child_name.length()==0) {
            System.out.println("Enter the name of the Child.");
             child_name = sc.nextLine();
            
        }
      
        System.out.println();

    System.out.println("Enter the Age of the Child.");
     child_age = sc.nextInt();
    
    while(child_age<=0){
        if (child_age==0) {
            System.out.println("Age should be a positive number.");
            child_age = sc.nextInt();
            
            break;
            }
            System.out.println("Age should be greater than 0");
            child_age = sc.nextInt();
            sc.nextLine();
    }
    System.out.println();

    System.out.println("Dear Customer, Please give your Childrens Aadhaar ID for verification.");
    System.out.println("The Aadhar Id should be of 12 Characters Long.");
     Aadhaar_id_Children = sc.nextLine();
    while(Aadhaar_id_Children.length()!=12){
        System.out.println("Please enter a valid Aadhaar ID");
        Aadhaar_id_Children = sc.nextLine();
    }
    customer_info_Children(child_name, child_age, Aadhaar_id_Children);
    Children--;
    System.out.println();
    }
    customer_info_Adult(adult_name, adult_age, adult_phone, adult_email, Aadhaar_id_Adult);
    Adults--;
   
    
    }
    System.out.println("Please fill in the remaining details");
   System.out.println();
   }

/*   This below function is used to display the customer information for both children and adults.*/
  public void  display_Customer_Info(){
    int i=0;
    System.out.println("Your Booking details are as follows:");
    int total_rooms =0;
    for(int new_rooms:rooms){
        total_rooms+=new_rooms;
    }
   int new_room = total_rooms;
    // Only when for Adults
        if(Customer_Name_Children.isEmpty() && Customer_Age_Children.isEmpty() && Customer_Age_Children.isEmpty()){
            System.out.printf("\n%-16s | %-5s | %-10s |%-25s | %-12s | %-11s| %-9s | %-9s | %-12s \n ","Name","Age","Phone No","Gmail"," Adhar Id","Rooms Book","Check In","Check Out","Price in $");
            System.out.println();
            for( i =0;i<Customer_Name_Adults.size();i++){
            System.out.printf("\n%-16s | %-5d | %-8s |%-25s | %-12s | %-11d| %-9s | %-8s| %-5.2f \n",Customer_Name_Adults.get(i),Customer_Age_Adult.get(i),Customer_Phone_No_Adult.get(i),Customer_Gmail.get(i),Customer_Addhar_No_Adult.get(i),new_room,check_in,check_out,updated_price); 
        }
        
    }
    else{
        // For adults
        System.out.printf("\n\n%-18s | %-5s | %-11s |%-25s | %-12s |  %-11s| %-9s | %-9s | %-5s  \n"," Name"," Age"," Phone","Gmail"," Adhar Id","Rooms Book","Check In","Check out","Price in $");
        System.out.println();
        for(i =0;i<Customer_Name_Adults.size();i++){
            System.out.printf("\n%-18s | %-5d | %-11s |%-25s | %-12s | %-11d| %-9s | %-9s | %-5.2f \n",Customer_Name_Adults.get(i),Customer_Age_Adult.get(i),Customer_Phone_No_Adult.get(i),Customer_Gmail.get(i),Customer_Addhar_No_Adult.get(i),new_room,check_in,check_out,updated_price); 
        }
        System.out.println();
        // For children
        System.out.printf("\n%-18s | %-17s | %-9s | %-13s ","Guardians Name","Child Name","ChildAge","Child AdharId");
        System.out.println();
        for(i =0;i<Customer_Name_Children.size();i++){
                System.out.printf("\n%-18s | %-18s| %-9d | %-13s \n",Customer_Name_Adults.get(i),Customer_Name_Children.get(i),Customer_Age_Children.get(i),Customer_AadharNo_Children.get(i)); 
            }
   }
   System.out.println();
   cancel_ticket();
}
/* This below function is used to diplay the number of rooms in hotel shanti.*/ 
   public void display_hotel_Shanti(){
    System.out.println("The data for the Hotel Shanti are stored as");
    System.out.printf("%-17s | %-20s | %-10s | %-10s","Rooms Category","Rooms Original Price","Rooms Available","Food Price");
    System.out.println();

    for(int i=0;i<Room_category.size()|| i<Room_type.size();i++){
        System.out.printf("%-17s | %-20s | %-15s |%-10s ",Room_category.get(i),Room_price.get(i),Room_available.get(i),Food_price.get(i));
        System.out.println();
    }
    System.out.println();
   }

}

/* This below is main class and where the main method is being called. */
public class Hotel_Reservation_System {
    public static void main(String[] args) {
        String userChoice;
        int choice;
        HotelBooking ht = new HotelBooking();
       Hotel_SignUp_Login hotelObject = new Hotel_SignUp_Login();
        Scanner sc = new Scanner(System.in);
       
        
       hotelObject.printMessage("\nWelcome to Hotel Reservation System"); 
        System.out.println("Would you like to book a room? Please enter yes(Yes/yes) or no(No/no).");
        userChoice = sc.next();
        System.out.println();
        if(userChoice.equalsIgnoreCase("yes")||userChoice.equalsIgnoreCase("y")||userChoice.equalsIgnoreCase("ye")){
            
            System.out.println("Please proeed to login before booking.");
            System.out.println("1. Please Enter 1 to Login if already Signup.");
            System.out.println("2. Please Enter 2 to Signup.");
             choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                
                   if(ht.login()){
                    ht.display_hotel_Shanti();
                       ht.roomToBeBooked();
                       System.out.println();
                   } 
                    break;
                case 2:
                if(ht.signup()){
                    ht.display_hotel_Shanti();
                    ht.roomToBeBooked();
                    System.out.println();
                   
                }
                break;
                default:
                System.out.println("Invalid choice");
                    break;
            }
    }
    else if(userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("n")){
        System.out.println("Thank you for visiting our Hotels Website");
        System.exit(0);
    }
}
}
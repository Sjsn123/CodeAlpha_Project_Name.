/*A Simple Banking Application in Java is an ideal project
for coding beginners. It covers fundamental concepts
like the Scanner class for input, strings, loops, methods,
and conditional statements. This project involves basic
banking operations such as deposits, withdrawals,
checking balances, and exiting the program.*/



import java.util.*;

class bank_login{
    Scanner sc = new Scanner(System.in);
    String choice;
    ArrayList<String> Cutomer_Username = new ArrayList<>();
    ArrayList<String> Customer_password = new ArrayList<>();

     /**
     * 
     * @param checkCondition
     * @return
     */
     
   static  boolean checkCondition(String choice){
        if(choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("yep") || choice.equalsIgnoreCase("y")){
            return true;
        }
        else{
            return false;
        }
    }
    private void customer_login_signup(String user_name, String pass){
        this.Cutomer_Username.add(user_name);
        this.Customer_password.add(pass);

    }
    public boolean signup(){
        System.out.println("Enter the user_name. ");
        System.out.println("The user name shoudld be atleast 8 characters long. ");
        String user = sc.nextLine();
       
        while(user.length()<8 ){
            System.out.println();
            System.out.println("Enter the user_name");
            System.out.println("Username should be at least 9 characters long");
         user = sc.nextLine();
      
        }
        System.out.println();
        System.out.println("Enter the password");
        System.out.println("Password should be at least 9 characters long");
        String pass = sc.nextLine();
       
        while(pass.length()<8){
            System.out.println();
            System.out.println("Enter the password");
            System.out.println("Password should be at least 9 characters long");
         pass = sc.nextLine();
        
        }
        System.out.println();
        System.out.println("Successfully Registered");
        System.out.println("Please enter the same details again to login");
        System.out.println();
        customer_login_signup(user, pass);
        if(login()){
            return true;
        }
        else{
            return false;
        }
       
    }
    
    public boolean update_sign(){

        for(int i=0;i<Customer_password.size();i++){
        System.out.println("Enter the user_name");
        System.out.println("Username should be at least 9 characters long");
        String user = sc.nextLine();
       
        while(user.length()<8){
            
            System.out.println("\nEnter the user_name");
            System.out.println("Username should be at least 9 characters long");
            sc.nextLine();
         user = sc.nextLine();
        }
        System.out.println();
        System.out.println("Enter the password");
        System.out.println("Password should be at least 9 characters long");
        String pass = sc.nextLine();
        
        while( pass.length()<8){
            System.out.println();
            System.out.println("Enter the password");
            System.out.println("Password should be at least 9 characters long");
         pass = sc.nextLine();
         
        }
        System.out.println();
        System.out.println("Successfully Registered New user and Password.");
        System.out.println("Please enter the same details again to login");
        System.out.println();
        Cutomer_Username.set(i, user);
        Customer_password.set(i, pass);
        customer_login_signup(user, pass);
        login();
        break;
        }
        return true;
    }
    // This  below functions is used to login in the system. 
    public boolean login(){
        int attempts =4;
        String user,pass;
       System.out.println("Enter the user name.");
       System.out.println("Length of Username should be more than 8 characters.");
       user = sc.nextLine();
       
       while(user.length()<8){
           System.out.println("\nUsername should be at least 8 or more than 8 characters long");
       System.out.println("Enter the username");
        user = sc.nextLine();
        
       }
       System.out.println();
       System.out.println("Enter the password");
       System.out.println("Length of password should be more than 8 characters.");
        pass = sc.nextLine();
      

       while(pass.length()<8){
           System.out.println("\nPassword should be at least 8 or more than 8 characters long");
       System.out.println("Enter the password");
        pass = sc.nextLine();
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
        if(Cutomer_Username.get(i).equals(user)&& Customer_password.get(i).equals(pass)){
           System.out.println("\nLogin Successfull Hooraayyyy!!");
           System.out.println("Welcome to the Hotel Booking system");
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
               System.out.println("Enter the user name.");
               System.out.println("Length of Username should be more than 8 characters.");
               user = sc.nextLine();
               
               while(user.length()<8){
                   System.out.println("Username should be at least 8 or more than 8 characters long");
               System.out.println("Enter the username");
                user = sc.nextLine();
                
               }
               System.out.println();
               System.out.println("Enter the password");
               System.out.println("Length of password should be more than 8 characters.");
                pass = sc.nextLine();
              
        
               while(pass.length()<8){
                   System.out.println("Password should be at least 8 or more than 8 characters long");
               System.out.println("Enter the password");
                pass = sc.nextLine();
               
               }
               for (int i = 0; i < Cutomer_Username.size(); i++) {
                if(Cutomer_Username.get(i).equals(user)&& Customer_password.get(i).equals(pass)){
                   System.out.println("\nLogin Successfull Hooraayyyy!!");
                   System.out.println("Welcome to the Hotel Booking system");
                   System.out.println("Please Do not share the username and password.");
                   System.out.println();
                   return true;
               }
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

// This below is the main Bank class where all the bannk operations are being performed and it also inherits Login class.
class Bank extends bank_login{
       static Scanner sc = new Scanner(System.in);
        static Random ra = new Random();
        static String choice;
        static int userchoice;
        private static  ArrayList<String> Customer_Name = new ArrayList<>();        //Stores the Name
        private static  ArrayList<Integer> Customer_Age = new ArrayList<>();        //Stores the Age
        private static  ArrayList<Integer> Customer_Amount= new ArrayList<>();      //Stores the Amount
        private static  ArrayList<String> Customer_Id = new ArrayList<>();          //Stores the Custommer Unique Id
        private static  ArrayList<String> Customer_Phone_No = new ArrayList<>();        //Stores the Phone No
        private  static ArrayList<String> Customer_Aadhar_No = new ArrayList<>();       //Stores the Aadhar No
        private static  ArrayList<String> Customer_Address = new ArrayList<>();         //Stores the Address
        private static  ArrayList<Integer> index = new ArrayList<>();       // stores the digits of phone which are masked.
        private static  char[] phoneNoArray ; // Created a phone array
 
/* This below function is storing the information of Adults. */
    @SuppressWarnings("static-access")
    private static  void customer_Info(String Id, String Name, int Age,int Amt,String Phone_no ,String Aadhar_No,String Address){
        Customer_Id.add(Id);
        Customer_Name.add(Name);
        Customer_Age.add(Age);
        Customer_Amount.add(Amt);
        Customer_Phone_No.add(Phone_no);
        Customer_Aadhar_No.add(Aadhar_No);
        Customer_Address.add(Address);
    }
     
    /*This below function Removes the customer's whole data as entered by user through the unique customer id */
    private static void remove_Customer(String Id){
        for(int i=0;i<Customer_Id.size();i++){
            if(Customer_Id.get(i).equals(Id)){
                Customer_Id.remove(i);
                Customer_Name.remove(i);
                Customer_Age.remove(i);
                Customer_Amount.remove(i);
                Customer_Phone_No.remove(i);
                Customer_Aadhar_No.remove(i);
                Customer_Address.remove(i);
                System.out.println("\nThe data has been successfully removed");
                System.out.println();
            break;
            }
        }
    }
   
   /*This below function Removes all the lists of the Bank Database */ 
    private static void customer_remove_List(){
        System.out.println("\nEnter what you want to remove");
        System.out.println("1. Row");
        System.out.println("2. All List");
        int userchoice = sc.nextInt();
        if(Customer_Id.isEmpty() && Customer_Name.isEmpty() && Customer_Amount.isEmpty()&& Customer_Age.isEmpty() && Customer_Phone_No.isEmpty() && Customer_Aadhar_No.isEmpty()){
            System.out.println("\nList is empty.");
            System.out.println("You might need to add a user or customer.");
            System.out.println("Do you want to add it.\nPlease Enter Yes or No.");
             choice = sc.nextLine();
            if(checkCondition(choice) ){
                create_Account();
            }
            else{
                System.exit(0);
            }
        }
        if(userchoice == 1){
            System.out.println("\nEnter the Customer Id you want to remove");
            String ID = sc.nextLine();
           remove_Customer(ID);
            }
            else if(userchoice==2){
                Customer_Name.clear();
                Customer_Age.clear();
                Customer_Amount.clear();
                Customer_Id.clear();
                Customer_Phone_No.clear();
                Customer_Aadhar_No.clear();
                Customer_Address.clear();
            }
            else{
                System.out.println("\nInvalid choice");

            }
    }

    /*This below function is used to withdraw the amount of the customer. */
    private static void customer_withdraw_amount(){
        if(Customer_Amount.isEmpty()){
            System.out.println("\nThe balance is Empty. No data is present. You are being directed to main creation Account");
            System.out.println();
            create_Account();
        }
        else{
        System.out.println("\nDo you want to Withdraw the Amoount ");
        System.out.println("Tell either yes or no.");
        sc.nextLine();
       choice = sc.nextLine();
        if(checkCondition(choice)){
            System.out.println("\nEnter your Id Sir/Madam.");
            System.out.println("Do you want to check your Id.Write Only yes or no");
                choice = sc.nextLine();
                if(checkCondition(choice)){
                    display();
                    System.out.println("\nEnter your Id Sir/Madam");
                    String Id = sc.nextLine();
                    System.out.println("\nEnter your Name Sir/Madam");
                    String Name = sc.nextLine();
                    for(int i =0;i<Customer_Name.size();i++){
        
                        if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equals(Name)){
                            System.out.println("\nYou are eligible to Withdraw the Amount");
                            System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                            int amount = sc.nextInt();
                            while( (Customer_Amount.get(i) - amount)<500){
                                System.out.println("\nYou are not eligible to Withdraw the Amount");
                                System.out.println("The minimum balance should be Rs 500");
                                System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                                 amount = sc.nextInt();
                            
                            }
                          
                            Customer_Amount.set(i, Customer_Amount.get(i) - amount);
                            System.out.println("\nWithdrawal Successful");
                            System.out.print("\nDear Customer, Your Account has been Successfully Debited by: ");
                            System.out.println(" Rs. "+amount);
                            System.out.print("\nYour Current Balance is:");
                            System.out.println(Customer_Amount.get(i));
                        
                    }
                    else{
                        while(!Customer_Id.get(i).equals(Id)&& !Customer_Name.get(i).equals(Name)){
                            System.out.println("\nWrong input given");
                            System.out.println("\nEnter your Id Sir/Madam");
                             Id = sc.nextLine();
                            System.out.println("\nEnter your Name Sir/Madam");
                            sc.nextLine();
                             Name = sc.nextLine();
                        }
                    }
                    }
                }
                else{
                    System.out.println("\nEnter your Id Sir/Madam");
            String Id = sc.nextLine();
            System.out.println("\nEnter your Name Sir/Madam");
            sc.nextLine();
            String Name = sc.nextLine();
            for(int i =0;i<Customer_Name.size();i++){

                if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                    System.out.println("\nYou are eligible to Withdraw the Amount");
                    System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                    int amount = sc.nextInt();
                    Customer_Amount.set(i, Customer_Amount.get(i) - amount);
                    System.out.println("\nWithdrawal Successful");
                    System.out.print("\nDear Customer, Your Account has been Successfully Debited by: ");
                    System.out.println(" Rs. "+amount);
                    System.out.println("\nYour Current Balance is:");
                    System.out.println(Customer_Amount.get(i));
                }
            }
        }
            
    }
    else{
        update();
    }
}
    }
   
/* This below function is used to update ethe age of the customer. */

    private static void update_cutomer_age(){
        
        System.out.println("\nEnter your Name Sir/Madam");
        sc.nextLine();
        String Name = sc.nextLine();
        System.out.println("\nEnter your Id Sir/Madam");
        String Id = sc.nextLine();
        int i=0;
        while (!Customer_Id.get(i).equals(Id) && !Customer_Name.get(i).equalsIgnoreCase(Name) ) {
            System.out.println(" Wrong Input given. Enter again");
            System.out.println("\nEnter your Name Sir/Madam");
            sc.nextLine();
            Name = sc.nextLine();
            System.out.println("\nEnter your Id Sir/Madam");
             Id = sc.nextLine();
        }
        System.out.println("\nEnter your New Age Sir/Madam.");
        int Age = sc.nextInt();
       
            if(Customer_Age.isEmpty()){
                System.out.println("\nThe list of Age is Empty. You are being diverted to main Creation Account");
                create_Account();
            }
        
        else{
       if(Age>=18){
       
            if(Customer_Name.get(i).equals(Name) && Customer_Id.get(i).equals(Id)){
                Customer_Age.set(i,Age);
                System.out.println("\nAge Updated Successfully");
                return;
                }
        
            
        }
    
        else{
            System.out.println("\nYou are not eligible to open a bank account!");
    }
}
    }
   
/*This below function is used to update the aadhar number of the customer. */
    private static void update_cutomer_Aadhar_No(){
       if(Customer_Aadhar_No.isEmpty()){
        System.out.println("\nThere is no Aadhar Number in the list. You are being redirected to main Account.");
        create_Account();
       }
       else{
        System.out.println("\nDear Custmer Enter your Customer Unique Id");
        sc.nextLine();
        String Id = sc.nextLine();
        for(int i=0;i<Customer_Id.size();i++){
            if(Customer_Id.get(i).equals(Id)){
                System.out.println("\nEnter your name");
               
                String Name = sc.nextLine();
                System.out.println("\nEnter your New Aadhar Number");
                String Aadhar_No = sc.nextLine();
                
                while(Aadhar_No.length()!=12){
                    System.out.println("\nDear Sir/Madam, Enter your Aadhar No. The Aadhar No should be of 12 Digits.");
                 Aadhar_No = sc.nextLine();
                }
               
                    if(Customer_Aadhar_No.get(i).equals(Aadhar_No)){
                        System.out.println("Your Aadhar No is already registered.");
                    }
                    else{
                        Aadhar_No= masked_private_aadhar(Aadhar_No);
                        Customer_Aadhar_No.set(i,Aadhar_No);
                        System.out.println("Aadhar No Updated Successfully");
                        customer_Id_update(Name);
                    }
                
            }
        }
       
    }
    }
  
    /*This below function is used to update the customer address. */
    private static void update_cutomer_Address(){
        System.out.println("Enter your Name Sir/Madam");
        sc.nextLine();
        String Name = sc.nextLine();
        System.out.println("Enter your Id Sir/Madam");
        String Id = sc.nextLine();
        int i=0;
        while (!Customer_Id.get(i).equals(Id) && !Customer_Name.get(i).equalsIgnoreCase(Name) ) {
            System.out.println(" Wrong Input given. Enter again");
            System.out.println("Enter your Name Sir/Madam");
            Name = sc.nextLine();
            System.out.println("Enter your Id Sir/Madam");
             Id = sc.nextLine();
             
        }
        System.out.println("Enter your New Address Sir/Madam.");
        sc.nextLine();
        String Address = sc.nextLine();
        
        Customer_Address.set(i,Address);
        if(Customer_Address.isEmpty()){
            System.out.println("You might need to add a address. You are being directed to creation account.");
            create_Account();
        }
        else{
            if(Customer_Name.get(i).equals(Name) && Customer_Id.get(i).equals(Id)){
                Customer_Address.set(i,Address);
                System.out.println("Address Updated Successfully");
                return;
                }
        }
    }
/* This below function is used to update the phone number of the cutomer.*/
      private static void update_customer_phone_no(){
       
       
        if(Customer_Id.isEmpty()){
            System.out.println("Customer Id is not found.");
            System.out.println("You have been transferred to main Account.\n");
            create_Account();
        }
        else{
            System.out.println("Enter the customer id to update phone number");
            String Id = sc.nextLine();
        int index = Customer_Id.indexOf(Id);
        if(index != -1){
            System.out.println("Enter the new phone number");
            String Phone_no = sc.nextLine();
            while(Phone_no.length()!=10){
                System.out.println("Enter the new phone number. The Phone no you entered should consist of 10 digits.");
                 Phone_no = sc.nextLine();
                 
            }
            Customer_Phone_No.set(index,Phone_no);
            masked_private_PhoneNo(Phone_no);
            System.out.println("Phone number updated successfully");
            }
        }
          
    }
    
   /*This below function is used to update the customer Unique Id */
    private static void customer_Id_update(String Name){
        System.out.println("Please wait a moment Sir/Madam! Your Unique Customer Id is being Generated");
        String aadhar_no;
        for(int i=0;i<Customer_Aadhar_No.size();i++){
            if(Customer_Name.get(i).equals(Name)){
                 aadhar_no = Customer_Aadhar_No.get(i);
                 String key = Name.substring(0, 3) + "_" + aadhar_no.substring(aadhar_no.length() - 4);
                 Customer_Id.set(i, key);
        }
       
    }
    }
   
    /* This below fucntion is used to update the customer name.*/
    private static void update_customer_name(){
      
        if(Customer_Id.isEmpty()){
            System.out.println("Customer Id is not found");
            System.out.println("You have been transferred to main Account");
            create_Account();
        }
        else{
            System.out.println("Enter the customer id to update the name");
            String id = sc.nextLine();
        int index = Customer_Id.indexOf(id);
        if(index >=0 ){
            
            System.out.println("Enter the new name");
            sc.nextLine();
            String name = sc.nextLine();
            Customer_Name.set(index,name);
            System.out.println("Name updated successfully");
            customer_Id_update(name);
        }
        else{
            System.out.println("Wrong Input Given");
        }
    }
        
    }
  
/* This beow function is used to call all the other main update methods.*/
    public static void update(){
        while (true) {
            System.out.println();
        System.out.println("Do you want to update or remove your name or any other private credentials");
        System.out.println("Tell either yes or no.");
        choice = sc.next();
        System.out.println();
        if(choice.equalsIgnoreCase("yes") ||choice.equalsIgnoreCase("y")||choice.equalsIgnoreCase("yep")){
            System.out.println();
            System.out.println("What do you want to update Dear Customer. Please tell:");
            System.out.println("1. Create Account.");
            System.out.println("2. Update Name.");
            System.out.println("3. Update Phone No.");
            System.out.println("4. Update Aadhar No.");
            System.out.println("5. Update Age.");
            System.out.println("6. Update Address");
            System.out.println("7. Withdraw Amuont.");
            System.out.println("8. Deposit Amount.");
            System.out.println("9. Remove List.");
            System.out.println("10. Exit");
             userchoice = sc.nextInt();
            System.out.println();
            switch (userchoice) {
                case 1:
                create_Account();
                display();
                break;
                case 2: 
                update_customer_name();
                display();
                break;
                case 3:
                update_customer_phone_no();
                display();
                break;
                case 4:
               update_cutomer_Aadhar_No();
                display();
                break;
                case 5:
                update_cutomer_age();
                display();
                break;
                case 6: 
                update_cutomer_Address();
                display();
                break;
                
                case 7:
                customer_withdraw_amount();
                display();
                break;
                
                case 8:
                customer_add_amount();
               display();
               break;
               case 9:
               customer_remove_List();
               display();
               break;

               case 10:
               System.exit(0);  
               break;
                default:
                    break;
            }
            
        }
        else{
            System.out.println("Thank you for using our services");
            break;
        }
        
        }
    }
 
    /* This below function is used to unmask the phone number which is being masked for security purposes.*/
    private static String unmaskPhoneNumber(String originalPhoneNo){
    while (!originalPhoneNo.matches("\\d+")) {
    System.out.println("Sir/Madam ! The phone number you entered is not appropriate.");
    System.out.println("Please enter it again.");
    System.out.println("Please Enter your Phone Number. The phone number consists of 10 digits");
    originalPhoneNo = sc.nextLine(); // Get the original phone number from the user again
    phoneNoArray = originalPhoneNo.toCharArray();
    index.clear(); // Clear the indices list

    for (int i = 0; i < phoneNoArray.length; i++) {
        if (i >= 3 && i < phoneNoArray.length - 3) {
            index.add(i); // Store the indices of the digits to be replaced
        }
    }

    for (int i = index.size() - 1; i >= 0; i--) {
        phoneNoArray[index.get(i)] = originalPhoneNo.charAt(index.get(i)); // Unmask the phone number
    }

    originalPhoneNo = new String(phoneNoArray); // Update the original phone number
   
}
return originalPhoneNo;
}

/* This below fucntion is used to provide an otp when the user enter his/her phone number.*/
   private static void otp(String mobile_no){
   String mobile_no_unmask =unmaskPhoneNumber(mobile_no);
  
   for(int i =0;i< Customer_Phone_No.size();i++){
     while(mobile_no.matches(mobile_no_unmask)){
    System.out.println("\nAn Otp of 6 digits has been sent to your Mobile no\n");
    int otp_int = ra.nextInt(100000,999999);
    String otp = String.valueOf(otp_int);
    System.out.println("Your OTP is "+otp);
    System.out.println("\nEnter the Otp Sir/Madam");
    String enteredOtp = sc.nextLine();
    if (enteredOtp.equals(otp)) {
        System.out.println("\nOTP Verification Successful.");
        break;
    }
    else{
        System.out.println("\nPlease Enter the OTP again");
        System.out.println("Enter the Otp Sir/Madam");
         enteredOtp = sc.nextLine();
        if (enteredOtp.equals(otp)) {
            System.out.println("\nOTP Verification Successful.");
        }
        System.out.println("\nA new OTP has been sent in your mobile Number.");
        otp(mobile_no);
    }
}

   }
  
}

/* This below function is used to add or deposit the amunt into the cutomer bank account.*/
    private static void customer_add_amount(){
        System.out.println("Do you want to Add or Deposit some the Amoount ");
        System.out.println("Tell either yes or no.");
        choice = sc.nextLine();
        
        if(checkCondition(choice)){
            System.out.println("To deposit amount please verify your aadhar id.");
            System.out.println("\nFor Verification purposes, Do you want to check your Aadhar Id.\nWrite Only yes or no");
           
                 choice = sc.nextLine();
                if(checkCondition(choice)) {
                    System.out.println();
                    display();
                    System.out.println("\nEnter the last 4 digits of you Aadhar Number");
                    String aadharLast4Digits = sc.nextLine();
                    if (aadharLast4Digits.matches("\\d{4}")) {
                        System.out.println("\nEnter your Phone no");
                        String mobile_no = sc.nextLine();
                        int i =0,j=3;
                      while((mobile_no.length()!=10) || (Customer_Phone_No.get(i).equals(mobile_no) && j>=1)){
                        System.out.println("Your phone number does not match. Please write again.");
                        System.out.println("Only"+i+"attempts left");
                         mobile_no = sc.nextLine();
                         j--;
                         break;
                      }
                       otp(mobile_no);
                       System.out.println("\nEnter your Id Sir/Madam");
                       String Id = sc.nextLine();
                       while ( !Customer_Id.get(i).equals(Id)) {
                        System.out.println("Wrong Input given");
                        System.out.println("Enter your ID again ");
                       Id = sc.nextLine();
                    }
                       System.out.println("\nEnter your Name Sir/Madam.");
                     
                       String Name = sc.nextLine();
                       while ( !Customer_Name.get(i).equals(Name)) {
                        System.out.println("Wrong Input given.");
                        System.out.println("Enter your Name again.\n ");
                        Name = sc.nextLine();
                    }
                       for( i =0;i<Customer_Name.size();i++){
           
                           if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                               System.out.println("\nYou are eligible to deposit the Amount");
                               System.out.println(" Dear Customer! Please enter the Amount you want to Deposit:");
                               int amount = sc.nextInt();
                               sc.nextLine();
                               Customer_Amount.set(i, Customer_Amount.get(i) + amount);
                               System.out.println("\nDeposit Successful");
                               System.out.print("\nDear Customer, Your Account has been Successfully Credited by: ");
                               System.out.println(" Rs. "+amount);
                               System.out.print("\nYour Current Balance is:");
                               System.out.println("Rs. "+Customer_Amount.get(i));
                               System.out.println();
                               display();
                               update();
                               }
                           else{
                               System.out.println("\nYou are not eligible to deposit the Amount");
                           }}
                        }
                        else{
                            System.out.println("Your Mobile Number is not in our Database");
                        }
                    
                    } 
                  else  if(checkCondition(choice)) {
                       
                        System.out.println("Enter the last 4 digits of you Aadhar Number");
                        String aadharLast4Digits = sc.nextLine();
                        if (aadharLast4Digits.matches("\\d{4}")) {
                            System.out.println("Enter your Phone no");
                            String mobile_no = sc.nextLine();
                            int i =0,j=1;
                      while((mobile_no.length()!=10) || (Customer_Phone_No.get(i).equals(mobile_no) && j>=3)){
                        System.out.println("Your phone number does not match. Please write again.");
                        System.out.println("Only"+i+"attempts left");
                         mobile_no = sc.nextLine();
                         j--;
                         break;
                      }
                            otp(mobile_no);
                            System.out.println("Enter your Id Sir/Madam");
                           
                            String Id = sc.nextLine();
                            while ( !Customer_Id.get(i).equals(Id)) {
                                System.out.println("Wrong Input given");
                                System.out.println("Enter your ID again ");
                               Id = sc.nextLine();
                            }
                            System.out.println("Enter your Name Sir/Madam");
                            
                            String Name = sc.nextLine();
                            while (!Customer_Name.get(i).equals(Name)) {
                                System.out.println("Wrong Input given");
                                System.out.println("Enter your Name again ");
                                Name = sc.nextLine();
                            }
                for( i =0;i<Customer_Name.size();i++){
    
                    if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                        System.out.println("You are eligible to deposit the Amount");
                        System.out.println(" Dear Customer! Please enter the Amount you want to Deposit:");
                        int amount = sc.nextInt();
                        Customer_Amount.set(i, Customer_Amount.get(i) + amount);
                        System.out.println("Deposit Successful");
                        System.out.print("Dear Customer, Your Account has been Successfully Credited by: ");
                        System.out.println(" Rs. "+amount);
                        System.out.print("Your Current Balance is:");
                        System.out.println("Rs. "+Customer_Amount.get(i));
                       display();
                       update();
                    }
                    else{
                        System.out.println("Missing or Wrong information");
                    }
                }
            }
            } 
            else{
                System.out.println("Invalid Input");
            }

  }
  else{
    update();
  }
}

    /* This below function is used to mask the phone number for security purposes.*/
    private static String masked_private_PhoneNo(String phone){
    char[] phoneNoArray = phone.toCharArray();
    for (int i = 3; i < phoneNoArray.length - 3; i++) {
        phoneNoArray[i] = '*'; // Replace digits with * characters
    }
    String maskedPhone = new String(phoneNoArray);
    return maskedPhone;
}
    
        /* This below function is used to mask the Aadhar number for security purposes.*/
    private static String masked_private_aadhar(String Aadhar){
    String maskedAadhar = Aadhar;

    while (!maskedAadhar.matches("\\d+")) {
        System.out.println("Sir/Madam ! The Aadhar number you entered is not appropriate.");
        System.out.println("Please enter it again.");
        System.out.println("Please Enter your Aadhar no Number. The Aadhar number consists of 12 digits");
        maskedAadhar = sc.nextLine();
    }
    maskedAadhar = Aadhar.substring(0, 8).replaceAll("\\d", "*") + Aadhar.substring(8);
    return maskedAadhar;

}
   
/* This below function is used to create an account of the customer.*/
        private static void create_Account(){
           
             /* Take the Country as input loop continues till India is not entered. */
             System.out.println("\nDear Customer, Please Enter your country. ");
             System.out.println("Only India is accepted. If not from India write no. ");
             String Country = sc.nextLine();
             
             Country= Country.toUpperCase();
             if(Country.equalsIgnoreCase("no")||Country.equalsIgnoreCase("n")){
                System.out.println();
                System.out.println("Sorry, we do not support your country.");
                System.out.println("Please contact our customer care for further assistance.");
                System.out.println("Thank you for your interest in our services.");
                System.exit(0);
             }
             while(!Country.equalsIgnoreCase("INDIA")){
                System.out.println();
                 System.out.println("Sorry Dear Customer, You are not eligible to create your Account.");
                 System.out.println("This system works only for Indian People.");
                 System.out.println("Please Enter your country Sir/Madam.");
              Country = sc.nextLine();
              Country= Country.toUpperCase();
             System.out.println();
             if(Country.equalsIgnoreCase("India")){
                System.out.println();
                 System.out.println("Dear Sir/Madam ! You are eligible to create your Account");
             }
            
             break;
            
             }
                /* Take the name as input loop continues till the name is not entered  */
                System.out.println("\nPlease Enter your Name Sir/Madam:");
                
                String name = sc.nextLine();
                
                System.out.println();
                if (name.isEmpty()) {
                    System.out.println("Please Enter your Name Sir/Madam:");
                    name = sc.nextLine();
                    sc.nextLine();
                }
              
                /* Take the Age as input loop continues till age is not greater than 18. */
                System.out.println("\nPlease Enter your Age Sir/Madam:");
                int age = sc.nextInt();
                
                while(age<18){
                    System.out.println("To open the Bank Account the minimum age should be 18 or 18+ ");
                    System.out.println("Please Enter your Age Sir/Madam:");
                     age = sc.nextInt();
                }
               System.out.println();
                /* Take the Deposit Amount as input loop continues till amount is not greater than or equal to 500 . */
                System.out.println("Please Deposit Rs 500 or above for your minimum balance");
                int amount = sc.nextInt();
                System.out.println();
               while(amount<500){
                System.out.println("Sir/Madam ! Please enter the amount equal to or more 500 Rupees");
                System.out.println("Please Deposit Rs 500 or above for your minimum balance");
                 amount = sc.nextInt();
               }
               System.out.println();
               /* Take the Phone No as input loop continues till Phone no lenght is notequal to 10. */
               System.out.println("Please Enter your phone number.It is of 10 digits: +91");
              sc.nextLine();
               String phone_no = sc.nextLine();
               
                while (phone_no.length()!=10) {
                    System.out.println("\n Dear Customer ! The phone number you entered is not appropriate.");
                    System.out.println("Please enter it again.\nPlease Enter your phone number in 10 digits: +91");
                 phone_no = sc.nextLine();
                }
                phone_no = masked_private_PhoneNo(phone_no); // it will make the phone no confidential

                /* Take the Aadhar No as input loop continues till Aadhar no lenght is notequal to 10. */
                System.out.println();
                System.out.println("\nPlease Enter your Aadhar Number.");
                System.out.println("The addhar number consists of 12 digits.");
                    String aadhar_no = sc.nextLine();
               
                    while (aadhar_no.length()!=12) {
                        System.out.println("\nSir/Madam ! The Aadhar number you entered is not appropriate.");
                        System.out.println("Please enter it again.\nPlease Enter your Aadhar Number. The addhar number consists of 12 digits");
                       
                        aadhar_no = sc.nextLine();
                    }
                aadhar_no= masked_private_aadhar(aadhar_no); // it will make the aadhaar no confidential.
              
           
            System.out.println("\nPlease wait a moment ! Your Unique Customer Id is being Generated.");
            System.out.println("\nEnter your Address");
                
            String address = sc.nextLine();
               
                // System.out.println();
                String key = name.substring(0, 3) + "_" + aadhar_no.substring(aadhar_no.length() - 4);
               System.out.println();
                customer_Info(key,name, age, amount,phone_no,aadhar_no,address);
                display();
                System.out.println();
                customer_add_amount();
                
            }
          
        /* This below function is used to caarry all the min purpose for the banking application.*/
        public static void process() {
                 System.out.println("\nDo you want to deposit the amount");
                 System.out.println("Please Tell either yes or no.");
                 sc.nextLine();
                 choice = sc.nextLine();
                   
                    if(checkCondition(choice)){
                        System.out.println("\nDear Sir/Madam ! Please enter your name ");
                        
                        String name1 = sc.nextLine();
                        
                        if(Customer_Id.isEmpty() && Customer_Name.isEmpty()){
                            System.out.println("\nDear Sir/Madam There is no account being created in your name.");
                            System.out.println("\nDo you want to create a new Account");
                            System.out.println("Please Tell either yes or no.");
                           choice = sc.nextLine();
                            if(checkCondition(choice)){
                                create_Account();
                            }
                            else{
                                System.out.println("Thank you for visiting our Bank");
                                System.exit(0);
                            }
                        }
                        else {
                                for(int i=0;i<Customer_Name.size();i++){
                                    if(name1.equals(Customer_Name.get(i))){
                                    customer_add_amount();
                            
                                    }
                                 }
                    
                        }
            }
            else{
                System.out.println("Thank you for visiting our Bank");
                System.exit(0);
            }
        
        }
               
    /* This below function is used to display the data stored in the database.*/
        public static void display(){
                    System.out.printf("%-20s | %-26s | %-17s | %-9s | %-13s | %-15s | %-30s %n", "Cust_Id", "Cust_Name", "Cust_Deposit_Amt", "Cust_Age","Cust_Phone_No","Cust_Aadhar_No","Cust_Address");
                System.out.println();
                    for(int i = 0; i < Customer_Name.size(); i++){
                        System.out.printf("%-20s | %-26s | %-17s | %-9s | %-13s | %-15s |%-30s %n", Customer_Id.get(i), Customer_Name.get(i), Customer_Amount.get(i), Customer_Age.get(i),Customer_Phone_No.get(i),Customer_Aadhar_No.get(i),Customer_Address.get(i));
                    }   
                   
                    if(Customer_Id.isEmpty() && Customer_Name.isEmpty() && Customer_Amount.isEmpty()&& Customer_Age.isEmpty() && Customer_Phone_No.isEmpty() && Customer_Aadhar_No.isEmpty() && Customer_Address.isEmpty()){
                        System.out.println("List is empty.");
                        System.out.println("You might need to add a user or customer.");
                       
                        System.out.println("\nDo you want to add it.");
                        System.out.println("Please Tell Yes or No.");
                        sc.nextLine();
                        choice = sc.nextLine();
                        System.out.println();
                        if(checkCondition(choice)){
                            create_Account();
                            
                        }
                        else{
                            System.exit(0);
                        }
                }
            }

/* This below function is used to provide the main menu functions when login.*/
            public void menu(){
                System.out.println("Enter what you want to do:-");
                System.out.println(" 1. Enter 1 to Deposit Amount.");
                System.out.println(" 2. Enter 2 to Display Data.");
                System.out.println(" 3. Enter 3 to Update Customer's data.");
                System.out.println(" 4. Enter 4 to Exit.");
                int userchoice = sc.nextInt();
                switch(userchoice){
                    case 1:
                    process();
                    break;
        
                    case 2:
                    
                    display();
                    
                    break;
                    
                    case 3:
                    update();
                    break;
        
                    case 4:
                    System.out.println("Thank you for visiting our Bank");
                    System.exit(0);
                    break;
                }
            }
        }


        /* This below is main class and where the main method is being called. */
public class Banker {
    
    public static void main(String[] args) {
        String choice;
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        System.out.println("\nWelcome to the Banking System..");
        System.out.println("Dear Customer,Do you want to Create an account. Yes or No ?");
        choice = sc.nextLine();
        if(bank.checkCondition(choice)) {
            System.out.println();
            System.out.println("1. Please Enter 1 to Login if already Signup.");
            System.out.println("2.Please Enter 2 to Signup.");
            int userchoice = sc.nextInt();
            System.out.println();
            switch (userchoice) {
                case 1:
                   if(bank.login()){
                       bank.menu();
                   } 
                    break;
                case 2:
                if(bank.signup()){
                    bank.menu();
                }
                break;
                default:
                System.out.println("Invalid choice");
                    break;
            }
        }
        else if(choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")){
            System.out.println("Thank you for visiting our Bank");
            System.exit(0);
        }
       
    }}


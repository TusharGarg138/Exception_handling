class Main{
    public static void checkName(String name) throws NameException{
        if(name==null || name.trim().isEmpty()){ // check if string is empty or not
            throw new NameException("invalid name .");
        }
        else if(name.matches(".*\\d.*")){// check if there is any numer or not
            throw new NameException("Name should not contain numbers only String");
        }
        else if (name.trim().length() < 2) {// no single alphabet is allowed
            throw new NameException("Name must be at least 2 characters long.");
        }
        else{
            System.out.println("Name Accepted: "+ name);// when every thing is correct
        }
    }

    public static void checkBatch(String batch) throws BatchException {
        String[] years = batch.split("-"); // changing the string into integer
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);

        if (!batch.matches("\\d{4}-\\d{4}")) {// cheching if the batch is in correct format or not
            throw new BatchException("Invalid format!!!");

        } else if (start >= end) { // starting year should not be greater than end year
            throw new BatchException("Start year must be before end year.");

        } else if (end - start != 4) {// degree must of 4 years
            throw new BatchException("Batch duration must be exactly 4 years.");
        }
        else {
            System.out.println("batch Accepted: " + batch);
        }
    }
    public static void checkBranch(String branch) throws BranchException  {
        if (branch == null || branch.trim().isEmpty()) {
            throw new BranchException("Branch cannot be empty.");  // Throw exception if empty
        }
        else if (!branch.matches("[a-zA-Z]+")) {
            throw new BranchException("Branch should only contain alphabets."); // checks if branch is only alphabet
        }
        else{
            System.out.println("Branch is: " + branch);
        }
    }

    public static void checkPRN(String prn, String batch) throws PrnException{

        String[] years = batch.split("-"); // changing the string into integer
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);

        int prnYear = Integer.parseInt(prn.substring(0, 2));// extracting the year of student from prn
        int Year = 2000 + prnYear;


        if(prn.length()!= 11){
            throw new PrnException("PRN should be 11 digits");// it checks the length that PRN should be 11 digits

        }
        else if(!prn.matches("\\d{11}")){
            throw new PrnException("Only digits are allowed"); // In PRN only digits are allowed
        }
        else if (Year != start) {
            throw new PrnException("PRN year (" + Year + ") does not match batch starting year (" + start + ").");
            // checking that PRN year and batch are same or not
        }
        else{
            System.out.println("PRN Accepted: "+ prn);
        }
    }

    public static void main(String args[]){
        try{
            checkName("Tushar garg");// it checks not empty, non-numeric, should be more than 2 character

            String batch = "2023-2027";

            checkBatch(batch);// correct format , duration 4 year , correct yaer input

            checkBranch("AIML");// empty or not , only alphabets

            checkPRN("23070126138",batch);// lenght of prn, only digits, batch year should be equal to prn year

        }catch(NameException e){
            System.out.println(e);

        } catch(BatchException e) {
            System.out.println(e);
        }
        catch(BranchException e){
            System.out.println(e);
        }
        catch(PrnException e){
            System.out.println(e);
        }
    }
}

// branch prn
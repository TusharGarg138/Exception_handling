class Main{
    public static void checkName(String name) throws NameException{
        if(name==null || name.trim().isEmpty()){
            throw new NameException("invalid name .");
        }
        else if(name.matches(".*\\d.*")){
            throw new NameException("Name should not contain numbers only String");
        }
        else if (name.trim().length() < 2) {
            throw new NameException("Name must be at least 2 characters long.");
        }
        else{
            System.out.println("Name Accepted "+ name);
        }
    }

    public static void main(String args[]){
        try{
            checkName("Tushar garg"); // it checks not empty, non-numeric, should be more than 2 character
        }catch(NameException e){
            System.out.println(e);
        }
    }
}
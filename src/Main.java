class Main{
    public static void checkName(String name) throws NameException{
        if(name==null || name.trim().isEmpty()){
            throw new NameException("invalid name .");
        }

        else{
            System.out.println("Name Accepted "+ name);
        }
    }

    public static void main(String args[]){
        try{
            checkName("123"); // empty name column done
        }catch(NameException e){
            System.out.println(e);
        }
    }
}
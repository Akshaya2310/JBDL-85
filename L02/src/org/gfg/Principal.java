package org.gfg;

public class Principal {

    private String name;
    private Long empId;

//private static Principal INSTANCE = new Principal("Rahul",123l);

    private static Principal INSTANCE;

    private Principal(String name, Long empId) {
        this.name = name;
        this.empId = empId;
    }

    public synchronized static Principal getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Principal("Rahul",123l);
        }
        return INSTANCE;
    }
    public void manageSchool(){

    }

    public void manageStaff(){

    }
}

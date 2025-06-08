package org.gfg;

public enum Admin {
    ADMIN("AMIT",12l);

    private String name;
    private Long empId;


    Admin(String name, Long empId) {
        this.name = name;
        this.empId = empId;
    }

    public void manageOrg(){
        /*

         */
    }

    public void manageInfra(){
        /*

         */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }
}

package utils;

import pages.*;

public class PageInitialiser {


    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static SearchEmployeePage searchEmployeePage;
    public static EmployeeDetailsPage employeeDetailsPage;
    public static CreateEmployeeLoginDetailsPage createEmployeeLoginDetailsPage;
    public static AddEmployeeMembershipDetailsPage addEmployeeMembershipDetailsPage;

    public static void initializePageObjects(){
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        searchEmployeePage = new SearchEmployeePage();
        employeeDetailsPage = new EmployeeDetailsPage();
        createEmployeeLoginDetailsPage = new CreateEmployeeLoginDetailsPage();
        addEmployeeMembershipDetailsPage = new AddEmployeeMembershipDetailsPage();


    }

}
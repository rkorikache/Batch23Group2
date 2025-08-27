package utils;

import Pages.EmployeeDetailsPage;
import pages.AddEmployeePage;
import pages.LoginPage;
import pages.SearchEmployeePage;

public class PageInitialiser {


    public static LoginPage LoginPage;
    public static addEmployeePage addEmployeePage;
    public static searchEmployeePage searchEmployeePage;


    public static void initializePageObjects(){
        LoginPage = new LoginPage();
        addEmployeePage = new addEmployeePage();
        searchEmployeePage = new searchEmployeePage();
        EmployeeDetailsPage = new EmployeeDetailsPage();


    }

}
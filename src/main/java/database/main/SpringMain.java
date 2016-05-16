package database.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {

        // Can leave this class here for testing access to the database
        // Will save you time, by allowing you to run this class alone and retrieve the
        // database query.

        // Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        // Get the EmployeeDAO Bean
        // CustomerDAO customerDAO = ctx.getBean("customerDAO", CustomerDAO.class);

        // Customer emp1 = customerDAO.getByWebQuoteReferenceNumber("C15482084J");
        // System.out.println("Customer Retrieved::"+emp1);

        // System.out.println("==================================");
        // System.out.println("reference policy number
        // :"+customerDAO.retrievePolicyNumberAndDatOfBirth().getRefencePolicyNumber());
        // System.out.println("reference policy number :"+customerDAO.retrievePolicyNumberAndDatOfBirth().getDateOfBirth());

        // Customer c = customerDAO.retrievePolicyNumberAndDatOfBirth();
        // System.out.println("reference number " + c.getRefencePolicyNumber());
        // System.out.println("Date of birth " + c.getDateOfBirth());

        // System.out.println("Policy Number and date of birth:"+emp2);
        ctx.close();

        System.out.println("DONE");
    }

}
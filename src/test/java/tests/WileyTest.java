package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.StudentsPage;
import pages.section.HeaderSection;

import java.util.List;

public class WileyTest extends BaseTest{
    private String site;
    private String[] header = {"home","subjects","about wiley", "contact us", "help"};
    private String[] resources = {"Students", "Authors", "Instructors", "Librarians", "Societies", "Conferences", "Booksellers", "Corporations", "Institutions"};
    //Task says 8 but found 7 on the page
    private String[] resourcesFor = {"Authors", "Librarians", "Booksellers", "Instructors", "Students" , "Societies", "Corporate Partners"};
    //Task says www.wiley but found eu.wiley
    private String studentsUrl = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";

    @BeforeMethod
    @Parameters({"site"})
    public void setParameters(String site){
        this.site=site;
      }


    public void run() {
        driver.get(site);
        HomePage hPage = new HomePage();
        HeaderSection headerNav = new HeaderSection();

        //Comparing links from the header
        for(int a = 0; a<hPage.getNavLinks().size(); a++){
            List<String> actualLinks = hPage.getNavLinks();
            softAssert.assertTrue(actualLinks.get(a).equalsIgnoreCase(header[a]),"Failed to compare: "+actualLinks.get(a) + " and " + header[a]);
        }

        //Check resources count
        softAssert.assertTrue(hPage.getResLinks().size() == resources.length);
        for(int a = 0; a<hPage.getResLinks().size(); a++){
            List<String> actualLinks = hPage.getResLinks();
            softAssert.assertTrue(actualLinks.get(a).equals(resources[a]),"Failed to compare: "+actualLinks.get(a) + " and " + resources[a]);
        }
        hPage.navigateToStudents();
        //Validate url
        softAssert.assertTrue(driver.getCurrentUrl().equals(studentsUrl), "Url is not correct! " +driver.getCurrentUrl());
        //Validate header
        StudentsPage sPage = new StudentsPage();
        softAssert.assertTrue(sPage.getHeader().equals(resources[0]));
        //Validate count of left side links
        softAssert.assertTrue(sPage.getLeftSideLinksCount() == 7, "Count is other then expected to be!");
        //Validate left side links
        for(int a = 0; a<sPage.getLeftSideLinks().size(); a++){
            List<String> actualLinks = sPage.getLeftSideLinks();
            softAssert.assertTrue(actualLinks.get(a).equals(resourcesFor[a]),"Failed to compare: "+actualLinks.get(a) + " and " + resourcesFor[a]);
        }
        //Check students link is selected (active)
        softAssert.assertTrue(sPage.isStudentsSelected(),"Link is not selected");
        softAssert.assertTrue(sPage.isStudentHasDifStyle(), "Link has the same style");
        softAssert.assertTrue(sPage.isClickable(),"Link is still clickable");
        headerNav.returnToHome();
        hPage.applySubcsr(null);
        //Switch to alert and check string
        softAssert.assertTrue(hPage.isAlertPresent(), "Alert missed!");
        softAssert.assertTrue(hPage.validateAlert().equals("Please enter email address"));
        //
        hPage.closeAlert();
        hPage.applySubcsr("test/test.test");
        softAssert.assertTrue(hPage.validateAlert().equals("Invalid email address."));
        hPage.closeAlert();
        hPage.performSearch("for dummies");
        SearchResultPage sePage = new SearchResultPage();
        softAssert.assertTrue(sePage.checkBooksList() > 0,"Search result is empty!");
        sePage.selectRandomItem();
        //Validate selected item title
        ProductPage pdPage= new ProductPage();
        softAssert.assertTrue(sePage.getTitle().equals(pdPage.getProductTitle()),"Titles are not the same");
        headerNav.returnToHome();
        String pageUrl=hPage.clickInst();
        System.out.println(pageUrl);
        softAssert.assertTrue(pageUrl.equals("https://edservices.wiley.com/"),"URL is not the same");


    }
}

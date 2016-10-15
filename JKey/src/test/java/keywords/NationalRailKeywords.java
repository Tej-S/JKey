package keywords;

import pageobjects.NationalRailHomePage;

public class NationalRailKeywords {
    NationalRailHomePage keywords;

    public void searchNatRail(String firststring, String secondstring, String exitmessage) {
        System.out.println("Test of reading keyword!");
        keywords = new NationalRailHomePage();
        keywords.enterTextFrom(firststring);
        keywords.enterTextTo(secondstring);
        keywords.selectGo();

        System.out.print(exitmessage);
    }
}

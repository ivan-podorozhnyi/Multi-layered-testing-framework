package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentsTablePage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RefreshMainTest {

    private Specification specification;

    @BeforeClass
    public void setUp() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
        specification = Specification.get();

    }

    @AfterClass
    public void tearDown() {
      WebDriverUtils.stop();
    }


    @Test
    public void refreshMainPageTest() {
        MainPage main = new MainPage();
        specification.For(main.returnButton().
                getFilterMenuPage().
                getCategoryFilterDropDown())
                .valueIsMatched("All").next().
                For(main.getFilterMenuPage().
                        getStatusFilterDropDown()).
                valueIsMatched("All").next().
                For(main.getCommentsTablePage()).
                pageNumberMatch("1").next().


                For(main.getCommentsTablePage().
                        selectCommentWithCommentNumber(new Comment().setCommentId("1"))).next().
                For(main.getCommentsTablePage().
                        selectCommentWithCommentNumber(new Comment().setCommentId("9"))).next().
                For(main.getFilterMenuPage().filterCategory("Cat1").filterStatus("Active").
                applyButton().getCommentsTablePage().
                        changeSortingByNumber().
                        setPageNumber("2").
                getMainPage().returnButton().
                        getCommentsTablePage()).
                allCommentsAreNotChecked().next().

                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat1").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("Active").next().
                For(main.getCommentsTablePage()).commOnPageAreSortInAscOrderByNumb().
                pageNumberMatch("2").next().
                For(main.getFilterMenuPage().
                        filterCategory("Cat3").applyButton().
                        getCommentsTablePage()).pageNumberMatch("1").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                commOnPageAreSortInAscOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().
                        getStatusFilterDropDown()).
                valueIsMatched("Active").next().

                For(main.getFilterMenuPage().filterStatus("Inactive").
                        applyButton().
                        getCommentsTablePage()).
                pageNumberMatch("1").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                commOnPageAreSortInAscOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive").next().

                For(main.getCommentsTablePage().
                        selectCommentWithCommentNumber(new Comment().setCommentId("1"))).next().
                For(main.getCommentsTablePage().
                        selectCommentWithCommentNumber(new Comment().setCommentId("9"))).next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").next().
                For(main.getCommentsTablePage()).allCommentsAreNotChecked().
                commOnPageAreSortInAscOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive").next().

                For(main.getCommentsTablePage().
                        selectAllCommentsOnPage()).next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                allCommentsAreNotChecked().
                commOnPageAreSortInAscOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                allCommentsAreNotChecked().
                commOnPageAreSortInAscOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().
                        getStatusFilterDropDown()).
                valueIsMatched("InActive").next().

                For(main.getCommentsTablePage().
                        changeSortingByNumber()).
                pageNumberMatch("1").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                allCommentsAreNotChecked().
                commOnPageAreSortInDescOrderByNumb().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive").next().

                For(main.getCommentsTablePage()
                        .changeSortingByText()).
                pageNumberMatch("1").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                allCommentsAreNotChecked().
                commOnPageAreSortInAscOrderByText().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive").next().

                For(main.getCommentsTablePage().
                        changeSortingByActiveStatus()).
                pageNumberMatch("1").next().
                For(main.returnButton().getCommentsTablePage()).
                pageNumberMatch("1").
                allCommentsAreNotChecked().
                commOnPageAreSortInAscOrderByAct().next().
                For(main.getFilterMenuPage().getCategoryFilterDropDown()).
                valueIsMatched("Cat3").next().
                For(main.getFilterMenuPage().getStatusFilterDropDown()).
                valueIsMatched("InActive");

        
        specification.check();
    }
}

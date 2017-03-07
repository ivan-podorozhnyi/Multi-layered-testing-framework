package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentsTablePage;

import java.util.NoSuchElementException;


public class CommentsTableCriteria implements ISpecification {

    private CommentsTablePage commentsTablePage;
    private Specification specification;

    private CommentsTableCriteria(CommentsTablePage commentsTablePage, Specification specification) {
        this.commentsTablePage = commentsTablePage;
        this.specification = specification;


    }

    public static CommentsTableCriteria get(CommentsTablePage commentsTablePage, Specification specification) {
        return new CommentsTableCriteria(commentsTablePage ,specification);
    }


    public CommentsTableCriteria pageNumberMatch(String pageNumber) {
        boolean isPassed = commentsTablePage.getPageNumber().equals(pageNumber);
        specification.add(isPassed,buildError(ErrorConstants.WRONG_PAGE, pageNumber,
                                                commentsTablePage.getPageNumber()));
        return this;
    }



    public CommentsTableCriteria isPageExists(String page) {
        boolean isPassed = commentsTablePage.isPageExists(page);
        specification.add(isPassed, buildError(ErrorConstants.WRONG_PAGE, true, isPassed));
        return this;
    }

    public CommentsTableCriteria isPageNotExists(String page) {
        boolean isPassed = !commentsTablePage.isPageExists(page);
        specification.add(isPassed, buildError(ErrorConstants.WRONG_PAGE, true, isPassed));
        return this;
    }




    public CommentsTableCriteria commOnPageAreSortInAscOrderByNumb()
    {
        boolean isPassed = commentsTablePage.isCommSortByActInAscOrderOnPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }

    public CommentsTableCriteria commOnPageAreSortInDescOrderByNumb()
    {
        boolean isPassed = commentsTablePage.isCommSortByNumbInDescOrderOnPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }

    public CommentsTableCriteria commOnPageAreSortInAscOrderByText()
    {
        boolean isPassed = commentsTablePage.isCommSortByCommTextInAscOrderonPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }

    public CommentsTableCriteria commOnPageAreSortInDescOrderByText()
    {
        boolean isPassed = commentsTablePage.isCommSortByCommTextInDescOrderonPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }

    public CommentsTableCriteria commOnPageAreSortInAscOrderByAct()
    {
        boolean isPassed = commentsTablePage.isCommSortByActInAscOrderOnPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }

    public CommentsTableCriteria commOnPageAreSortInDescOrderByAct()
    {
        boolean isPassed = commentsTablePage.isCommSortByActInDescOrderOnPage();
        specification.add(isPassed, buildError(ErrorConstants.WRONG_SORTING, true, isPassed));
        return this;
    }



    public CommentsTableCriteria allCommentsAreWithActiveStatus(boolean status) {
        boolean isPassed = commentsTablePage.isAllCommentsWithStatus(status);
        specification.add(isPassed, buildError(ErrorConstants.WRONG_COMM_STATUS, status,isPassed));
        return this;

    }

    public CommentsTableCriteria allCommentsAreWithCategory(Category category) {
        boolean isPassed = commentsTablePage.isAllCommentsWithCategory(category);
        specification.add(isPassed, buildError(ErrorConstants.WRONG_COM_CAT,category,isPassed));
        return this;
    }

    public CommentsTableCriteria allCommentsAreNotChecked() {
        boolean isPassed = !commentsTablePage.isAllCommAreUnchecked();
        specification.add(isPassed, buildError(ErrorConstants.COMM_IS_CHECK, true ,isPassed));
        return this;
    }

    public CommentsTableCriteria isCommentExistsOnTheTable(Comment comment) {
        boolean isPassed = false;
        try
        {
            commentsTablePage.getCommentFromTableByNumber(comment.getCommentId());
            isPassed = true;
        } catch (NoSuchElementException e) {
            isPassed = false;
        } finally {
            specification.add(isPassed, buildError(ErrorConstants.NO_COMMENT,
                                                    comment.getCommentId(), false));
        }
        return this;
    }

    public CommentsTableCriteria isCommentNotExistsOnTheTable(Comment comment) {
        boolean isPassed = false;
        try
        {
            commentsTablePage.getCommentFromTableByNumber(comment.getCommentId());
        } catch (NoSuchElementException e) {
            isPassed = true;
        } finally {
            specification.add(isPassed, buildError(ErrorConstants.IS_COMMENT,
                    comment.getCommentId(), false));
        }
        return this;

    }

    private String buildError(String error, Object exp, Object act) {
       StringBuilder errorStringBuilder = new StringBuilder();
        errorStringBuilder.append(error);
        errorStringBuilder.append(ErrorConstants.EXPECTED);
        errorStringBuilder.append(exp);
        errorStringBuilder.append(ErrorConstants.ACTUAL);
        errorStringBuilder.append(act);
        return errorStringBuilder.toString();
    }


    @Override
    public Specification next() {
        return specification;
    }
}

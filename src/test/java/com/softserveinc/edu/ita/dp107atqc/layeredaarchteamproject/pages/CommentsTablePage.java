package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

import java.util.*;
import java.util.stream.Collectors;


public final class CommentsTablePage {

    private CommentTablePageUIMap map;

    public CommentsTablePage() {
        map = new CommentTablePageUIMap();
    }

    public MainPage getMainPage() {
        return new MainPage();
    }

    public CommentsTablePage setNextPage() {
        Link nextPageCand = map.getPages().get(map.getPages().size() - 1);
        if (nextPageCand.getText().contains(">")) {
            nextPageCand.click();
            map.reInitElements();
        }
        return this;

    }

    public CommentsTablePage setPreviousPage() {
        Link prevPageCand = map.getPages().get(0);
        if (prevPageCand.getText().contains("<")) {
            prevPageCand.click();
            map.reInitElements();
        }
        return this;
    }


    public boolean isPageExists(String pageNumber) {
        for (Link link : map.getPages()) {
            if (link.getText().equals(pageNumber) || pageNumber.equals(getPageNumber())) {
                return true;
            }
        }
        return false;
    }


    public boolean isNotLastPage() {
        map.reInitElements();
        boolean isPageLast = false;
        if (map.getRows().getSize() < 10) {
            return true;
        }
        List<Link> pagesLinks = map.getPages();
        Link lastPageLink = pagesLinks.get(pagesLinks.size() - 1);
        isPageLast = getPageNumber().equals(lastPageLink.getText());
        if (!isPageLast && !lastPageLink.getText().equals(">")) {
            int pageNumber = Integer.parseInt(getPageNumber());
            int linkPageNumber = Integer.parseInt(lastPageLink.getText());
            isPageLast = pageNumber > linkPageNumber;
        }
        return isPageLast;
    }

    public String getPageNumber() {
        Iterator<Link> pages = map.getPages().iterator();
        int prevPageNumber = 0;
        while (pages.hasNext()) {
            String nextPage = pages.next().getText();
            if (nextPage.equals("<")) {
                continue;
            }
            int nextPageNumber = Integer.parseInt(nextPage);
            if ((nextPageNumber - prevPageNumber) > 1) {
                return (prevPageNumber + 1) + "";
            }
            prevPageNumber = nextPageNumber;
        }
        return (prevPageNumber + 1) + "";
    }

    public CommentsTablePage setPageNumber(String pageNumber) {

        for (Link link : map.getPages()) {
            if (link.getText().equals(pageNumber)) {
                map.reInitElements();
                link.click();
                return this;
            }
        }
        throw new NoSuchElementException("No such element");
    }

    public Comment getCommentFromTableByNumber(String number) {
        if (!map.isRowCountZero()) {
            while (!isNotLastPage()) {
                for (int i = 0; i < map.getRows().getSize(); i++) {
                    if (map.getCommentNumberLabels().get(i).getValue().equals(number)) {
                        return getCommentFromRow(i);
                    }
                }
                setNextPage();
                map.reInitElements();
            }
            for (int i = 0; i < map.getRows().getSize(); i++) {
                if (map.getCommentNumberLabels().get(i).getValue().equals(number)) {
                    return getCommentFromRow(i);
                }
            }
        }
        throw new NoSuchElementException("No such element");
    }

    public List<Comment> getAllComments() {
        List<Comment> allComments = new ArrayList<>();
        while (!isNotLastPage()) {
            allComments.addAll(getAllCommentsFromPage());
            setNextPage();
            map.reInitElements();
        }
        allComments.addAll(getAllCommentsFromPage());
        return allComments;
    }

    public List<Comment> getAllCommentsWithActiveStatus(boolean isCommentActive) {
        List<Comment> allComments = new ArrayList<>();
        while (!isNotLastPage()) {
            allComments.addAll(getAllCommWithActStatOnPage(isCommentActive));
            setNextPage();
            map.reInitElements();
        }
        allComments.addAll(getAllCommWithActStatOnPage(isCommentActive));
        return allComments;
    }

    public boolean isAllCommentsWithStatus(boolean status) {
        List<Comment> allComments = getAllComments();
        for (Comment comment : allComments) {
            if (comment.isActive() != status) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllCommentsWithCategory(Category category) {
        List<Comment> allComments = getAllComments();
        for (Comment comment : allComments) {
            if (!comment.getCategories().contains(category)) {
                return false;
            }
        }
        return true;
    }

    public List<Comment> getAllCommentsWithSpecCat(Category category) {
        List<Comment> allComments = new ArrayList<>();
        while (!isNotLastPage()) {
            allComments.addAll(getAllCommWithCatOnPage(category));
            setNextPage();
            map.reInitElements();
        }
        allComments.addAll(getAllCommWithCatOnPage(category));
        return allComments;

    }

    private List<Comment> getAllCommentsFromPage() {
        List<Comment> comments = new ArrayList<>();
        if (!map.isRowCountZero()) {
            for (int i = 0; i < map.getRows().getSize(); i++) {
                comments.add(getCommentFromRow(i));
            }
        }
        return comments;
    }


    private List<Comment> getAllCommWithActStatOnPage(boolean isCommentActive) {
        List<Comment> comments = new ArrayList<>();
        if (!map.isRowCountZero()) {
            for (int i = 0; i < map.getRows().getSize(); i++) {
                Comment commentCandidate = getCommentFromRow(i);
                if (commentCandidate.isActive() == isCommentActive) {
                    comments.add(commentCandidate);
                }
            }
        }
        return comments;
    }

    private List<Comment> getAllCommWithCatOnPage(Category category) {
        List<Comment> comments = new ArrayList<>();
        if (!map.isRowCountZero()) {
            for (int i = 0; i < map.getRows().getSize(); i++) {
                Comment commentCandidate = getCommentFromRow(i);
                if (commentCandidate.getCategories().contains(category)) {
                    comments.add(commentCandidate);
                }
            }
        }
        return comments;
    }


    public CommentsTablePage selectCommentWithCommentNumber(Comment comment) {
        if (!map.isRowCountZero()) {
            while (!isNotLastPage()) {
                for (int i = 0; i < map.getRows().getSize(); i++) {
                    String currentCommentId = map.getCommentNumberLabels().get(i).getValue();
                    if (currentCommentId.equals(comment.getCommentId())) {
                        map.getCheckBoxes().get(i).check();
                        return this;
                    }
                }
                setNextPage();
                map.reInitElements();
            }
            for (int i = 0; i < map.getRows().getSize(); i++) {
                String currentCommentId = map.getCommentNumberLabels().get(i).getValue();
                if (currentCommentId.equals(comment.getCommentId())) {
                    map.getCheckBoxes().get(i).check();
                    return this;
                }
            }
        }
        throw new NoSuchElementException("No such element");
    }

    public CommentsTablePage selectAllCommentsOnPage() {
        if (!map.isRowCountZero()) {
            for (CheckBox checkbox : map.getCheckBoxes()) {
                if (!checkbox.isSelected()) {
                    checkbox.check();
                }
            }
        }
        return this;
    }

    public CommentsTablePage deselectAllCommentsOnPage() {
        if (!map.isRowCountZero()) {
            for (CheckBox checkbox : map.getCheckBoxes()) {
                if (checkbox.isSelected()) {
                    checkbox.unCheck();
                }
            }
        }
        return this;
    }


    public boolean isCommentSelected(Comment comment) {
        if (!map.isRowCountZero()) {
            while (!isNotLastPage()) {
                for (int i = 0; i < map.getRows().getSize(); i++) {
                    String currentCommentId = map.getCommentNumberLabels().get(i).getValue();
                    if (currentCommentId.equals(comment.getCommentId())) {
                        return map.getCheckBoxes().get(i).isSelected();
                    }
                }
                setNextPage();
                map.reInitElements();
            }
            for (int i = 0; i < map.getRows().getSize(); i++) {
                String currentCommentId = map.getCommentNumberLabels().get(i).getValue();
                if (currentCommentId.equals(comment.getCommentId())) {
                    return map.getCheckBoxes().get(i).isSelected();
                }
            }
        }

        throw new NoSuchElementException("No such element");

    }

    private Comment getCommentFromRow(int row) {
        String commNumber = map.getCommentNumberLabels().get(row).getValue();
        String commText = map.getCommentTextLabels().get(row).getValue();
        String commActiveString = map.getCommentActiveLabels().get(row).getValue();
        boolean isCommentActive = !commActiveString.equals("V");
        String catText = map.getCommentCategoryLabels().get(row).getValue();
        List<String> categStrList = Arrays.stream(catText.split(";")).collect(Collectors.toList());
        List<Category> categoryList = new ArrayList<>();
        for (String category : categStrList) {
            categoryList.add(new Category(category.trim()));
        }
        return new Comment(commNumber, commText, isCommentActive, categoryList);
    }

    public CommentsTablePage changeSortingByNumber() {
        map.getSortByNumberLink().click();
        map.reInitElements();
        return this;
    }

    public boolean isAllCommAreUnchecked() {
        for (CheckBox checkbox : map.getCheckBoxes()) {
            if (checkbox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public CommentsTablePage changeSortingByText() {
        map.getSortByCommentTextLink().click();
        map.reInitElements();
        return this;
    }

    public CommentsTablePage changeSortingByActiveStatus() {
        map.getSortByActiveStatusLink().click();
        map.reInitElements();
        return this;
    }

    public CommentsTablePage changeSortingByCategory() {
        map.getSortByCategoriesLink().click();
        return this;
    }

    public boolean isCommSortByNumbInAscOrderOnPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (current.getCommentId().compareTo(previous.getCommentId()) < 0) {
                return false;
            }
            previous = current;
        }
        return true;

    }

    public boolean isCommSortByNumbInDescOrderOnPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (current.getCommentId().compareTo(previous.getCommentId()) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }


    public boolean isCommSortByCommTextInAscOrderonPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (current.getCommentText().compareTo(previous.getCommentText()) < 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public boolean isCommSortByCommTextInDescOrderonPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (current.getCommentText().compareTo(previous.getCommentText()) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public boolean isCommSortByActInAscOrderOnPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        if (!previous.isActive()) {
            return false;
        }
        /*last active marker is true when subsequent comments in the list
         after last active comm are inactive, false otherwise*/
        boolean lastActiveCommentMarker = false;
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (Boolean.compare(previous.isActive(), current.isActive()) > 0) {
                /*switch flag when inactive comment after active is found*/
                lastActiveCommentMarker = !lastActiveCommentMarker;
                /*if flag has been switched more than once return false*/
                if (!lastActiveCommentMarker) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

    public boolean isCommSortByActInDescOrderOnPage() {
        Iterator<Comment> comments = getAllCommentsFromPage().iterator();
        Comment previous = comments.next();
        if (previous.isActive()) {
            return false;
        }
        /*last inactive marker is true when subsequent comments in the list
         after last inactive comm are inactive, false otherwise*/
        boolean lastInActCommentMarker = false;
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (Boolean.compare(previous.isActive(), current.isActive()) < 0) {
                /*switch flag when active comment after inactive is found*/
                lastInActCommentMarker = !lastInActCommentMarker;
                /*if flag has been switched more than once return false*/
                if (!lastInActCommentMarker) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

}

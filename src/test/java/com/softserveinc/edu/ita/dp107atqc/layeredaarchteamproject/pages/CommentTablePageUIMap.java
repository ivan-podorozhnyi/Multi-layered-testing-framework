package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LinkElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.TableElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Table;
import org.openqa.selenium.TimeoutException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CommentTablePageUIMap {
    private Link sortByNumberLink;
    private Link sortByCommentTextLink;
    private Link sortByActiveStatusLink;
    private Link sortByCategoriesLink;
    private Table rows;
    private List<CheckBox> checkBoxes;
    private List<Label> numbers;
    private List<Label> text;
    private List<Label> active;
    private List<Label> categories;
    private List<Link> pages;
    private boolean isRowCountZero = false;

    public CommentTablePageUIMap() {
        /*init table rows first*/
        getRows();
    }

    public Link getSortByNumberLink() {
        if (sortByCommentTextLink == null) {
            this.sortByNumberLink = LinkElement.
                    getByCss(".webgrid-header >th:nth-child(2) > a");
        }
        return sortByNumberLink;
    }

    public Link getSortByCommentTextLink() {
        if (sortByCommentTextLink == null) {
            this.sortByCommentTextLink = LinkElement.
                    getByCss(".webgrid-header >th:nth-child(3) > a");
        }
        return sortByCommentTextLink;
    }

    public Link getSortByActiveStatusLink() {
        if (sortByActiveStatusLink == null) {
            this.sortByActiveStatusLink = LinkElement.
                    getByCss(".webgrid-header >th:nth-child(4) > a");
        }
        return sortByActiveStatusLink;
    }

    public Link getSortByCategoriesLink() {
        if (sortByCategoriesLink == null) {
            this.sortByCategoriesLink = LinkElement
                    .getByCss("webgrid-header >th:nth-child(5) > a");
        }
        return sortByCategoriesLink;
    }

    public List<Link> getPages() {
        Table table = TableElement.getByCss(".webgrid-footer > td > a");
        if (pages == null) {
            pages = new ArrayList<>();
            for (int i = 1; i <= table.getSize(); i++)
                pages.add(LinkElement.getByCss("td > a:nth-child(" + i + ")"));

        }
        return pages;
    }

    public Table getRows() {
        if (rows == null) {
            try {
                this.rows = TableElement.getByCss("table > tbody > tr");

            } catch (TimeoutException e) {
                rows = TableElement.getByCss("body > div > footer");
                isRowCountZero = true;
            }

        }
        return rows;
    }

    public List<CheckBox> getCheckBoxes() {
        if (isRowCountZero) {
            return Collections.emptyList();
        }
            if (checkBoxes == null) {
                int rowsCount = getRows().getSize();
                checkBoxes = new ArrayList<>();
                for (int i = 1; i <= rowsCount; i++) {
                    checkBoxes.add(CheckBoxElement
                            .getByCss("tr:nth-child(" + i + ")>.checkedcolumn>input[type='checkbox']"));
                }
            }
        return checkBoxes;
    }

    public List<Label> getCommentNumberLabels() {
        if (isRowCountZero) {
            return Collections.emptyList();
        }
        if (numbers == null) {
            int rowsCount = getRows().getSize();
            numbers = new ArrayList<>();
            for (int i = 1; i <= rowsCount; i++) {
                numbers.add(LabelElement
                        .getByCss("tr:nth-child(" + i + ") > .numbercolumn"));
            }
        }
        return numbers;
    }

    public List<Label> getCommentTextLabels() {
        if (isRowCountZero) {
            return Collections.emptyList();
        }
        int rowsCount = getRows().getSize();
        if (text == null) {
            text = new ArrayList<>();
            for (int i = 1; i <= rowsCount; i++) {
                text.add(LabelElement
                        .getByCss("tr:nth-child(" + i + ") > .textcolumn"));
            }
        }
        return text;
    }

    public List<Label> getCommentActiveLabels() {
            if (isRowCountZero) {
                return Collections.emptyList();
            }
            if (active == null) {
                int rowsCount = getRows().getSize();
                active = new ArrayList<>();
                for (int i = 1; i <= rowsCount; i++) {
                    active.add(LabelElement
                            .getByCss("tr:nth-child(" + i + ") > .inactivecolumn"));
                }
            }
        return active;
    }

    public List<Label> getCommentCategoryLabels() {
            if (isRowCountZero) {
                return Collections.emptyList();
            }
            if (categories == null) {
                int rowsCount = getRows().getSize();
                categories = new ArrayList<>();
                for (int i = 1; i <= rowsCount; i++) {
                    categories.add(LabelElement
                            .getByCss("tr:nth-child(" + i + ") > .categorycolumn"));
                }
            }
        return categories;
    }

    public boolean isRowCountZero() {
        return isRowCountZero;
    }

    public void reInitElements() {
        sortByNumberLink = null;
        sortByCommentTextLink = null;
        sortByActiveStatusLink = null;
        sortByCategoriesLink = null;
        rows = null;
        checkBoxes = null;
        numbers = null;
        text = null;
        active = null;
        categories = null;
        pages = null;
        isRowCountZero = false;
    }
}

package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;


public class CommentCriteria implements ISpecification{
    private Comment comment;
    private Specification specification;

    public CommentCriteria(Comment comment, Specification specification) {
        this.comment = comment;
        this.specification = specification;
    }

    public static CommentCriteria get(Comment comment, Specification specification) {
        return new CommentCriteria(comment, specification);
    }

    public CommentCriteria commentsNameIsMatched(String name) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = name.equals(comment.getCommentText());
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append(name);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append(comment.getCommentText());
        }
        specification.add(isMatch, appendError.toString());
        return this;
    }

    public CommentCriteria commentsNumberIsMatched(String number) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = number.equals(comment.getCommentId());
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append(number);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append(comment.getCommentId());
        }
        specification.add(isMatch, appendError.toString());
        return this;
    }

    public CommentCriteria commentsStatusIsMatched(boolean status) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = (status == comment.isActive());
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append("Comment is active - " + status);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append("Comment is active - " + comment.isActive());
        }
        specification.add(isMatch, appendError.toString());
        return this;
    }
//    public CommentCriteria commentsCategoriesAreMatched(List<Category> commCat) {
//        StringBuilder appendError = new StringBuilder();
//        boolean isMatch = commCat.equals(comment.getCategories());
//        if (!isMatch) {
//            appendError.append(ErrorConstants.MISMATCH);
////            appendError.append(ErrorConstants.EXPECTED);
////            appendError.append(comment.getCommentId());
////            appendError.append(ErrorConstants.ACTUAL);
////            appendError.append(number);
//        }
//        specification.add(isMatch, appendError.toString());
//        return this;
//    }

    public CommentCriteria commentsNotContainCategories(String category) {
//        List<String> commentsContainCategories = new ArrayList<>();
//        for (int i = 0; i < comment.getCategories().size();i++){
//            commentsContainCategories.add(comment.getCategories().toString());
//        }
   // public CommentCriteria commentsCategoriesAreMatched(List<Category> commCat) {

        StringBuilder appendError = new StringBuilder();
        boolean notContains = !comment.getCategories().contains(new Category(category));
        if (!notContains) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append("Comment contains category " + category);
        }
        specification.add(notContains, appendError.toString());
        return this;
    }

    public CommentCriteria commentsContainCategory(String Category) {
        boolean isCategoryContains = comment.getCategories().contains(new
                Category(Category));
        specification.add(isCategoryContains, buildError(ErrorConstants
                .COM_CAT_NOT_CONTAINS + Category, true , isCategoryContains));
        return this;
    }

    public CommentCriteria commentsNotContainCategory(String Category) {
        boolean isCategoryContains = comment.getCategories().contains(new
                Category(Category));
        specification.add(!isCategoryContains, buildError(ErrorConstants
                .COM_CAT_CONTAINS + Category, false , isCategoryContains));
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
        return this.specification;
    }
}

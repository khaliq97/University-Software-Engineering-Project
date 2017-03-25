package project.Database.Review;

import java.io.Serializable;

/**
 * Created by Osama Khaliq
 * Version (23/03/2016)
 *
 * Responsible for creating, getting and setting a Review object
 * Manipulated the reviews ArrayList in HRDatabase
 */
public class Review implements Serializable {

    public String getStaffNumber() {
        return staffNumber;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public String getManagerDirectorName() {
        return managerDirectorName;
    }

    public String getSecondManagerDirectorName() {
        return secondManagerDirectorName;
    }

    public String getObjectives() {
        return objectives;
    }

    public String getAchievement() {
        return achievement;
    }

    public String getPreview() {
        return preview;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public String getRecommendation() {
        return recommendation;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String year;
    private String staffNumber;
    private String name;

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setManagerDirectorName(String managerDirectorName) {
        this.managerDirectorName = managerDirectorName;
    }

    public void setSecondManagerDirectorName(String secondManagerDirectorName) {
        this.secondManagerDirectorName = secondManagerDirectorName;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public void setRevieweeSignature(String revieweeSignature) {
        this.revieweeSignature = revieweeSignature;
    }

    public void setManagerDirectorSignature(String managerDirectorSignature) {
        this.managerDirectorSignature = managerDirectorSignature;
    }

    public void setSecondReviewerSignature(String secondReviewerSignature) {
        this.secondReviewerSignature = secondReviewerSignature;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    private String section;
    private String managerDirectorName;
    private String secondManagerDirectorName;
    private String objectives;
    private String achievement;
    private String preview;
    private String reviewComments;
    private String recommendation;
    private String revieweeSignature;
    private String managerDirectorSignature;
    private String secondReviewerSignature;

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    private String dateSigned;

    public boolean isSigned() {
        return signed;
    }

    private boolean signed;


    public Review(String year, String staffNumber, String name, String section, String managerDirectorName, String secondManagerDirectName,
                  String objectives, String achievements, String preview, String reviewComments, String recommendation, String revieweeSignature, String managerDirectorSignature, String secondReviewerSignature, String dateSigned, boolean signed) {
        this.year = year;
        this.staffNumber = staffNumber;
        this.name = name;
        this.section = section;
        this.managerDirectorName = managerDirectorName;
        this.secondManagerDirectorName = secondManagerDirectName;
        this.objectives = objectives;
        this.achievement = achievements;
        this.preview = preview;
        this.reviewComments = reviewComments;
        this.recommendation = recommendation;
        this.revieweeSignature = revieweeSignature;
        this.managerDirectorSignature = managerDirectorSignature;
        this.secondReviewerSignature = secondReviewerSignature;
        this.dateSigned = dateSigned;
        this.signed = signed;
        //( ͡° ͜ʖ ͡°)
    }

    public String getRevieweeSignature() {
        return revieweeSignature;
    }


    public String getManagerDirectorSignature() {
        return managerDirectorSignature;
    }


    public String getSecondReviewerSignature() {
        return secondReviewerSignature;
    }


    public String getDateSigned() {
        return dateSigned;
    }

}

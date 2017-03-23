package project.Database.Review;

import java.io.Serializable;

/**
 * Created by osamakhaliq on 21/03/17.
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

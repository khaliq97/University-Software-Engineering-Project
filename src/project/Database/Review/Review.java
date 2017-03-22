package project.Database.Review;

import java.io.Serializable;

/**
 * Created by osamakhaliq on 21/03/17.
 */
public class Review implements Serializable{

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getManagerDirectorName() {
        return managerDirectorName;
    }

    public void setManagerDirectorName(String managerDirectorName) {
        this.managerDirectorName = managerDirectorName;
    }

    public String getSecondManagerDirectorName() {
        return secondManagerDirectorName;
    }

    public void setSecondManagerDirectorName(String secondManagerDirectorName) {
        this.secondManagerDirectorName = secondManagerDirectorName;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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


    public Review(String year, String staffNumber, String name, String section, String  managerDirectorName,String secondManagerDirectName,
                       String objectives, String achievements, String preview, String reviewComments, String recommendation)
    {
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
    }

}

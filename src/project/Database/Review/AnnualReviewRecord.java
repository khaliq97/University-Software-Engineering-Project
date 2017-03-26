package project.Database.Review;
import java.io.Serializable;
/**
 * Created by osamakhaliq on 21/03/17.
 */
public class AnnualReviewRecord implements Serializable {
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
    private boolean signed;

    /**
     * Constructor for class AnnualReviewRecord
     * @param year year of review record
     * @param staffNumber staff number of the employee
     * @param name name of the employee
     * @param section section that the employee works in
     * @param managerDirectorName manager or director name
     * @param secondManagerDirectName second manager or director name
     * @param objectives objectives accomplished by employee
     * @param achievements achievements of employee
     * @param preview previews of employee
     * @param reviewComments review comments of employee
     * @param recommendation recommendation for the employee
     * @param revieweeSignature reviewee signature
     * @param managerDirectorSignature manager or director signature
     * @param secondReviewerSignature second manager or director signature
     * @param dateSigned date review record is created
     * @param signed signed or unsigned review record
     */
    public AnnualReviewRecord(String year, String staffNumber, String name, String section, String managerDirectorName, String secondManagerDirectName,
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
    /**
     * Returns User's Staff Number
     * @return staffNumber
     */
    public String getStaffNumber() {
        return staffNumber;
    }
    /**
     * Returns User's Name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns User's Section
     * @return section
     */
    public String getSection() {
        return section;
    }
    /**
     * Returns User's Manager Directer Name
     * @return managerDirectorName
     */
    public String getManagerDirectorName() {
        return managerDirectorName;
    }
    /**
     * Returns User's Second Manager Director Name
     * @return secondManagerDirectorName
     */
    public String getSecondManagerDirectorName() {
        return secondManagerDirectorName;
    }
    /**
     * Returns User's Objectives
     * @return objectives
     */
    public String getObjectives() {
        return objectives;
    }
    /**
     * Returns User's Achievements
     * @return achievement
     */
    public String getAchievement() {
        return achievement;
    }
    /**
     * Returns User's Preview
     * @return preview
     */
    public String getPreview() {
        return preview;
    }
    /**
     * Returns User's Reviewer Comments
     * @return reviewComments
     */
    public String getReviewComments() {
        return reviewComments;
    }
    /**
     * Returns User's Recommendation
     * @return recommendation
     */
    public String getRecommendation() {
        return recommendation;
    }
    /**
     * Returns User's Year
     * @return year
     */
    public String getYear() {
        return year;
    }
    /**
     * Returns User's Signature
     * @return revieweeSignature
     */
    public String getRevieweeSignature() {
        return revieweeSignature;
    }
    /**
     * Returns ManagerDirector Signature
     * @return managerDirectorSignature
     */
    public String getManagerDirectorSignature() {
        return managerDirectorSignature;
    }
    /**
     * Returns secondReviewerSignature Signature
     * @return secondReviewerSignature
     */
    public String getSecondReviewerSignature() {
        return secondReviewerSignature;
    }
    /**
     * Returns dateSigned
     * @return dateSigned
     */
    public String getDateSigned() {
        return dateSigned;
    }

    public boolean isSigned() {
        return signed;
    }

    /**
     * Sets staffNumber
     * @param staffNumber staffNumber to set
     */
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    /**
     * Sets name
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets section
     * @param section section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Sets managerDirectorName
     * @param managerDirectorName managerDirectorName to set
     */
    public void setManagerDirectorName(String managerDirectorName) {
        this.managerDirectorName = managerDirectorName;
    }

    /**
     * Sets secondManagerDirectorName
     * @param secondManagerDirectorName secondManagerDirectorName to set
     */
    public void setSecondManagerDirectorName(String secondManagerDirectorName) {
        this.secondManagerDirectorName = secondManagerDirectorName;
    }

    /**
     * Sets objectives
     * @param objectives objectives to set
     */
    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    /**
     * Sets achievement
     * @param achievement achievement to set
     */
    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    /**
     * Sets preview
     * @param preview preview to set
     */
    public void setPreview(String preview) {
        this.preview = preview;
    }

    /**
     * Sets reviewComments
     * @param reviewComments
     */
    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    /**
     * Sets recommendation
     * @param recommendation recommendation to set
     */
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * Sets revieweeSignature
     * @param revieweeSignature revieweeSignature to set
     */
    public void setRevieweeSignature(String revieweeSignature) {
        this.revieweeSignature = revieweeSignature;
    }

    /**
     * Sets managerDirectorSignature
     * @param managerDirectorSignature managerDirectorSignature to set
     */
    public void setManagerDirectorSignature(String managerDirectorSignature) {
        this.managerDirectorSignature = managerDirectorSignature;
    }

    /**
     * Sets secondReviewerSignature
     * @param secondReviewerSignature secondReviewerSignature to set
     */
    public void setSecondReviewerSignature(String secondReviewerSignature) {
        this.secondReviewerSignature = secondReviewerSignature;
    }

    /**
     * Sets signed
     * @param signed to set
     */
    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}
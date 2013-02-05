package edu.lcu.masterfollies.domain;

import java.io.Serializable;

public class Results implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.judge_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer judgeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.club_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer clubId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.question_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer questionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.points
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer points;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column results.notes
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private String notes;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.id
     *
     * @return the value of results.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.id
     *
     * @param id the value for results.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.judge_id
     *
     * @return the value of results.judge_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getJudgeId() {
        return judgeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.judge_id
     *
     * @param judgeId the value for results.judge_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.club_id
     *
     * @return the value of results.club_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getClubId() {
        return clubId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.club_id
     *
     * @param clubId the value for results.club_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.question_id
     *
     * @return the value of results.question_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.question_id
     *
     * @param questionId the value for results.question_id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.points
     *
     * @return the value of results.points
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.points
     *
     * @param points the value for results.points
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column results.notes
     *
     * @return the value of results.notes
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public String getNotes() {
        return notes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column results.notes
     *
     * @param notes the value for results.notes
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
}
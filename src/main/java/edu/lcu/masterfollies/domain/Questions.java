package edu.lcu.masterfollies.domain;

import java.io.Serializable;

public class Questions implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questions.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questions.question
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private String question;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questions.desc
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    private String desc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questions.id
     *
     * @return the value of questions.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questions.id
     *
     * @param id the value for questions.id
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questions.question
     *
     * @return the value of questions.question
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questions.question
     *
     * @param question the value for questions.question
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questions.desc
     *
     * @return the value of questions.desc
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column questions.desc
     *
     * @param desc the value for questions.desc
     *
     * @mbggenerated Tue Feb 05 11:54:28 CST 2013
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}
package edu.lcu.masterfollies.domain;

public class Questions {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questions.id
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column questions.question
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    private String question;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column questions.id
     *
     * @return the value of questions.id
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
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
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
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
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
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
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }
}
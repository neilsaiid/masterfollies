package edu.lcu.masterfollies.domain;

public class ClubNames {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_names.id
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_names.club_name
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    private String clubName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_names.id
     *
     * @return the value of club_names.id
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_names.id
     *
     * @param id the value for club_names.id
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_names.club_name
     *
     * @return the value of club_names.club_name
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    public String getClubName() {
        return clubName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_names.club_name
     *
     * @param clubName the value for club_names.club_name
     *
     * @mbggenerated Thu Jan 17 19:19:16 CST 2013
     */
    public void setClubName(String clubName) {
        this.clubName = clubName == null ? null : clubName.trim();
    }
}
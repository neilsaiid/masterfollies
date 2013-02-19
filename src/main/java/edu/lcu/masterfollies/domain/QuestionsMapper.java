package edu.lcu.masterfollies.domain;

import edu.lcu.masterfollies.domain.Questions;
import edu.lcu.masterfollies.domain.QuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int countByExample(QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int deleteByExample(QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int insert(Questions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int insertSelective(Questions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    List<Questions> selectByExampleWithBLOBs(QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    List<Questions> selectByExample(QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    Questions selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int updateByExampleSelective(@Param("record") Questions record, @Param("example") QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int updateByExampleWithBLOBs(@Param("record") Questions record, @Param("example") QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int updateByExample(@Param("record") Questions record, @Param("example") QuestionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int updateByPrimaryKeySelective(Questions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questions
     *
     * @mbggenerated Mon Feb 18 11:04:41 CST 2013
     */
    int updateByPrimaryKeyWithBLOBs(Questions record);
}
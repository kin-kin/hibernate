package jp.gr.java_conf.kk.dao.entity;
// Generated 2018/03/10 19:09:05 by Hibernate Tools 5.2.9.Final


import java.util.Date;

/**
 * Entity class for account role table.
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 *         
 */
public class AccountRole  implements java.io.Serializable {


     /**
      * record ID (primary key, automatically generated)
     */
     private Integer recordId;
     /**
      * name (not null, unique)
     */
     private String name;
     /**
      * create date (not null)
     */
     private Date createDate;
     /**
      * update date (not null)
     */
     private Date updateDate;

    public AccountRole() {
    }

    public AccountRole(String name, Date createDate, Date updateDate) {
       this.name = name;
       this.createDate = createDate;
       this.updateDate = updateDate;
    }
   
    /**       
     *      * record ID (primary key, automatically generated)
     */
    public Integer getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
    /**       
     *      * name (not null, unique)
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * create date (not null)
     */
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**       
     *      * update date (not null)
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}



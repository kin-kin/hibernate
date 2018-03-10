package jp.gr.java_conf.kk.dao.entity;
// Generated 2018/03/10 19:09:05 by Hibernate Tools 5.2.9.Final


import java.util.Date;

/**
 * Entity class for account table.
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 *         
 */
public class Account  implements java.io.Serializable {


     /**
      * record ID (primary key, automatically generated)
     */
     private Integer recordId;
     /**
      * account ID (not null)
     */
     private String accountId;
     /**
      * account role record ID (not null)
     */
     private Integer accountRoleRecordId;
     /**
      * password (not null)
     */
     private String password;
     /**
      * name (not null)
     */
     private String name;
     /**
      * E-mail
     */
     private String email;
     /**
      * last login date
     */
     private Date lastLoginDate;
     /**
      * create date (not null)
     */
     private Date createDate;
     /**
      * update date (not null)
     */
     private Date updateDate;

    public Account() {
    }

	
    public Account(String accountId, Integer accountRoleRecordId, String password, String name, Date createDate, Date updateDate) {
        this.accountId = accountId;
        this.accountRoleRecordId = accountRoleRecordId;
        this.password = password;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Account(String accountId, Integer accountRoleRecordId, String password, String name, String email, Date lastLoginDate, Date createDate, Date updateDate) {
       this.accountId = accountId;
       this.accountRoleRecordId = accountRoleRecordId;
       this.password = password;
       this.name = name;
       this.email = email;
       this.lastLoginDate = lastLoginDate;
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
     *      * account ID (not null)
     */
    public String getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    /**       
     *      * account role record ID (not null)
     */
    public Integer getAccountRoleRecordId() {
        return this.accountRoleRecordId;
    }
    
    public void setAccountRoleRecordId(Integer accountRoleRecordId) {
        this.accountRoleRecordId = accountRoleRecordId;
    }
    /**       
     *      * password (not null)
     */
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * name (not null)
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * E-mail
     */
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * last login date
     */
    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }
    
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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



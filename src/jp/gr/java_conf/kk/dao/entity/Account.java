package jp.gr.java_conf.kk.dao.entity;
// Generated 2018/03/04 14:10:28 by Hibernate Tools 5.2.9.Final


import java.util.Date;

/**
 * Entity class for account table
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 *         
 */
public class Account  implements java.io.Serializable {


     /**
      * account ID (automatically generated)
     */
     private Integer accountId;
     /**
      * ID
     */
     private String id;
     /**
      * password
     */
     private String password;
     /**
      * name
     */
     private String name;
     /**
      * E-mail
     */
     private String email;
     /**
      * role ID
     */
     private AccountRole roleId;
     /**
      * last login date
     */
     private Date lastLoginDate;
     /**
      * create date
     */
     private Date createDate;
     /**
      * update date
     */
     private Date updateDate;

    public Account() {
    }

	
    public Account(String id, String password, String name, AccountRole roleId, Date createDate, Date updateDate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.roleId = roleId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public Account(String id, String password, String name, String email, AccountRole roleId, Date lastLoginDate, Date createDate, Date updateDate) {
       this.id = id;
       this.password = password;
       this.name = name;
       this.email = email;
       this.roleId = roleId;
       this.lastLoginDate = lastLoginDate;
       this.createDate = createDate;
       this.updateDate = updateDate;
    }
   
    /**       
     *      * account ID (automatically generated)
     */
    public Integer getAccountId() {
        return this.accountId;
    }
    
    protected void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    /**       
     *      * ID
     */
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    /**       
     *      * password
     */
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * name
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
     *      * role ID
     */
    public AccountRole getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(AccountRole roleId) {
        this.roleId = roleId;
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
     *      * create date
     */
    public Date getCreateDate() {
        return this.createDate;
    }
    
    protected void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**       
     *      * update date
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    protected void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}



package jp.gr.java_conf.kk.dao.entity;
// Generated 2018/03/04 14:10:28 by Hibernate Tools 5.2.9.Final


import java.util.Date;

/**
 * Entity class for account role table
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 *         
 */
public class AccountRole  implements java.io.Serializable {


     /**
      * account role ID (automatically generated)
     */
     private Integer accountRoleId;
     /**
      * name
     */
     private String name;
     /**
      * create date
     */
     private Date createDate;
     /**
      * update date
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
     *      * account role ID (automatically generated)
     */
    public Integer getAccountRoleId() {
        return this.accountRoleId;
    }
    
    protected void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
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



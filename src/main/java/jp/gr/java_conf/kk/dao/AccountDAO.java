package jp.gr.java_conf.kk.dao;

import java.util.List;

import jp.gr.java_conf.kk.dao.entity.Account;

/**
 * DAO interface for account table.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public interface AccountDAO extends DAO<Account, Integer> {
    
    /**
     * Get entity list selected by their account ID.
     * 
     * @param accountId account ID
     * @return entity list (empty if no entity was found)
     * @throws DAOException if database access failed.
     */
    List<Account> selectByAccountId(String accountId) throws DAOException;
    
    /**
     * Get entity list selected by their account role record ID.
     * 
     * @param accountRoleRecordId account role record ID
     * @return entity list (empty if no entity was found)
     * @throws DAOException if database access failed.
     */
    List<Account> selectByAccountRoleRecordId(Integer accountRoleRecordId)
            throws DAOException;
    
}

package jp.gr.java_conf.kk.dao;

import jp.gr.java_conf.kk.dao.entity.AccountRole;

/**
 * DAO interface for account_role table.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
public interface AccountRoleDAO extends DAO<AccountRole, Integer> {
    
    /**
     * Get entity selected by the name.
     * 
     * @param name name
     * @return entity (null if no entity was found)
     * @throws DAOException if database access failed.
     */
    AccountRole selectByName(String name) throws DAOException;
    
}

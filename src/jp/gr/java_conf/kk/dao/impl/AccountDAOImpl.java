package jp.gr.java_conf.kk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jp.gr.java_conf.kk.dao.AccountDAO;
import jp.gr.java_conf.kk.dao.DAOException;
import jp.gr.java_conf.kk.dao.entity.Account;

/**
 * DAO class for account table using hibernate.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
class AccountDAOImpl
        extends DAOImpl<Account, Integer> implements AccountDAO {
    
    /**
     * Constructor.
     * 
     * @param session hibernate session
     */
    AccountDAOImpl(final Session session) {
        super(session, Account.class);
    }
    
    @Override
    public List<Account> selectAll() throws DAOException {
        List<Account> entityList = null;
        
        try {
            @SuppressWarnings("unchecked")
            final Query<Account> query = super.session.createQuery(
                "from Account as a order by a.name, a.accountId");
            entityList = query.list();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entityList;
    }
    
    @Override
    public List<Account> selectByAccountId(final String accountId)
            throws DAOException {
        List<Account> entityList = null;
        
        try {
            @SuppressWarnings("unchecked")
            final Query<Account> query = super.session.createQuery(
                "from Account as a where a.accountId = ? order by a.name");
            query.setParameter(0, accountId);
            entityList = query.list();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entityList;
    }
    
    @Override
    public List<Account> selectByAccountRoleRecordId(final Integer accountRoleRecordId)
            throws DAOException {
        List<Account> entityList = null;
        
        try {
            @SuppressWarnings("unchecked")
            final Query<Account> query = super.session.createQuery(
                "from Account as a where a.accountRoleRecordId = ? order by a.name, a.accountId");
            query.setParameter(0, accountRoleRecordId);
            entityList = query.list();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entityList;
    }
    
}

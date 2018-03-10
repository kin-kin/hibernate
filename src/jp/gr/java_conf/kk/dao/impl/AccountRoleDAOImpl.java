package jp.gr.java_conf.kk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jp.gr.java_conf.kk.dao.AccountRoleDAO;
import jp.gr.java_conf.kk.dao.DAOException;
import jp.gr.java_conf.kk.dao.entity.AccountRole;

/**
 * DAO class for account_role table using hibernate.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
class AccountRoleDAOImpl
        extends DAOImpl<AccountRole, Integer> implements AccountRoleDAO {
    
    /**
     * Constructor.
     * 
     * @param session hibernate session
     */
    AccountRoleDAOImpl(final Session session) {
        super(session, AccountRole.class);
    }
    
    @Override
    public List<AccountRole> selectAll() throws DAOException {
        List<AccountRole> entityList = null;
        
        try {
            @SuppressWarnings("unchecked")
            final Query<AccountRole> query = super.session.createQuery(
                "from AccountRole as a order by a.name");
            entityList = query.list();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entityList;
    }
    
    @Override
    public AccountRole selectByName(final String name) throws DAOException {
        AccountRole entity = null;
        
        try {
            @SuppressWarnings("unchecked")
            final Query<AccountRole> query = super.session.createQuery(
                "from AccountRole as a where a.name = ?");
            query.setParameter(0, name);
            entity = query.uniqueResult();
        } catch (final Exception e) {
            throw new DAOException(e);
        }
        
        return entity;
    }
    
}

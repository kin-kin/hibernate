package jp.gr.java_conf.kk.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jp.gr.java_conf.kk.dao.AccountDAO;
import jp.gr.java_conf.kk.dao.DAOFactory;
import jp.gr.java_conf.kk.dao.DAOSession;
import jp.gr.java_conf.kk.dao.entity.Account;

/**
 * Test class for {@link AccountDAO}.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
@RunWith(JUnit4.class)
public class AccountDAOTest {
    
    @BeforeClass
    public static void setUpBeforeClass() {
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test for {@link AccountDAO#selectAll()}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectAll() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final List<Account> entityList = target.selectAll();
            
            assertEquals(1, entityList.size());
            
            final Account entity = entityList.get(0);
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("admin", entity.getAccountId());
            assertEquals(Integer.valueOf(1), entity.getAccountRoleRecordId());
            assertEquals("admin", entity.getPassword());
            assertEquals("Administrator", entity.getName());
            assertNull(entity.getEmail());
            assertNull(entity.getLastLoginDate());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
        }
    }
    
    /**
     * Test for {@link AccountDAO#selectByPK(Integer)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByPK() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final Account entity = target.selectByPK(Integer.valueOf(1));
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("admin", entity.getAccountId());
            assertEquals(Integer.valueOf(1), entity.getAccountRoleRecordId());
            assertEquals("admin", entity.getPassword());
            assertEquals("Administrator", entity.getName());
            assertNull(entity.getEmail());
            assertNull(entity.getLastLoginDate());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertNull(target.selectByPK(Integer.valueOf(2)));
        }
    }
    
    /**
     * Test for {@link AccountDAO#selectByPKForUpdate(Integer)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByPKForUpdaate() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final Account entity = target.selectByPKForUpdate(Integer.valueOf(1));
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("admin", entity.getAccountId());
            assertEquals(Integer.valueOf(1), entity.getAccountRoleRecordId());
            assertEquals("admin", entity.getPassword());
            assertEquals("Administrator", entity.getName());
            assertNull(entity.getEmail());
            assertNull(entity.getLastLoginDate());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertNull(target.selectByPKForUpdate(Integer.valueOf(2)));
        }
    }
    
    /**
     * Test for {@link AccountDAO#selectByAccountId(String)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByAccountId() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final List<Account> entityList = target.selectByAccountId("admin");
            
            assertEquals(1, entityList.size());
            
            final Account entity = entityList.get(0);
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("admin", entity.getAccountId());
            assertEquals(Integer.valueOf(1), entity.getAccountRoleRecordId());
            assertEquals("admin", entity.getPassword());
            assertEquals("Administrator", entity.getName());
            assertNull(entity.getEmail());
            assertNull(entity.getLastLoginDate());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertEquals(0, target.selectByAccountId("test").size());
        }
    }
    
    /**
     * Test for {@link AccountDAO#selectByAccountRoleRecordId(Integer)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByAccountRoleRecordId() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final List<Account> entityList = target.selectByAccountRoleRecordId(Integer.valueOf(1));
            
            assertEquals(1, entityList.size());
            
            final Account entity = entityList.get(0);
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("admin", entity.getAccountId());
            assertEquals(Integer.valueOf(1), entity.getAccountRoleRecordId());
            assertEquals("admin", entity.getPassword());
            assertEquals("Administrator", entity.getName());
            assertNull(entity.getEmail());
            assertNull(entity.getLastLoginDate());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertEquals(0, target.selectByAccountRoleRecordId(Integer.valueOf(2)).size());
        }
    }
    
    /**
     * Test for {@link AccountDAO#selectCountAll()}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectCountAll() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final long count = target.selectCountAll();
            
            assertEquals(1, count);
        }
    }
    
    /**
     * Test for {@link AccountDAO#insert(Account)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testInsert() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            final Date lastLoginDate = new Date();
            final Date createDate = lastLoginDate;
            final Date updateDate = lastLoginDate;
            final Account entity = new Account();
            entity.setAccountId("test");
            entity.setAccountRoleRecordId(Integer.valueOf(1));
            entity.setPassword("test");
            entity.setName("test");
            entity.setEmail("test");
            entity.setLastLoginDate(lastLoginDate);
            entity.setCreateDate(createDate);
            entity.setUpdateDate(updateDate);
            
            try {
                session.txBegin();
                
                final Integer pk = target.insert(entity);
                final Account inserted = target.selectByPK(pk);
                
                assertNotEquals(Integer.valueOf(1), inserted.getRecordId());
                assertEquals(entity.getAccountId(), inserted.getAccountId());
                assertEquals(entity.getAccountRoleRecordId(), inserted.getAccountRoleRecordId());
                assertEquals(entity.getPassword(), inserted.getPassword());
                assertEquals(entity.getName(), inserted.getName());
                assertEquals(entity.getEmail(), inserted.getEmail());
                assertEquals(entity.getLastLoginDate(), inserted.getLastLoginDate());
                assertEquals(entity.getCreateDate(), inserted.getCreateDate());
                assertEquals(entity.getUpdateDate(), inserted.getUpdateDate());
                
                //session.txCommit();
                session.txRollback();   // roll-back for test
            } catch (final DAOException e) {
                session.txRollback();
                
                throw e;
            }
        }
    }
    
    /**
     * Test for {@link AccountDAO#update(Account)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testUpdate() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            
            try {
                session.txBegin();
                
                final Account entity = target.selectByPK(Integer.valueOf(1));
                entity.setAccountId("test");
                entity.setAccountRoleRecordId(Integer.valueOf(2));
                entity.setPassword("test");
                entity.setName("test");
                entity.setEmail("test");
                entity.setLastLoginDate(new Date());
                entity.setUpdateDate(new Date());
                target.update(entity);
                session.flush();    // flush SQL
                final Account updated = target.selectByPK(entity.getRecordId());
                
                assertEquals(entity.getAccountId(), updated.getAccountId());
                assertEquals(entity.getAccountRoleRecordId(), updated.getAccountRoleRecordId());
                assertEquals(entity.getPassword(), updated.getPassword());
                assertEquals(entity.getName(), updated.getName());
                assertEquals(entity.getEmail(), updated.getEmail());
                assertEquals(entity.getLastLoginDate(), updated.getLastLoginDate());
                assertEquals(entity.getCreateDate(), updated.getCreateDate());
                assertEquals(entity.getUpdateDate(), updated.getUpdateDate());
                
                //session.txCommit();
                session.txRollback();   // roll-back for test
            } catch (final DAOException e) {
                session.txRollback();
                
                throw e;
            }
        }
    }
    
    /**
     * Test for {@link AccountDAO#delete(Account)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testDelete() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            
            try {
                session.txBegin();
                
                final Account entity = target.selectByPK(Integer.valueOf(1));
                target.delete(entity);
                session.flush();    // flush SQL
                
                assertNull(target.selectByPK(entity.getRecordId()));
                
                //session.txCommit();
                session.txRollback();   // roll-back for test
            } catch (final DAOException e) {
                session.txRollback();
                
                throw e;
            }
        }
    }
    
    /**
     * Test for {@link AccountDAO#delete(List)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testDeleteList() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountDAO target = DAOFactory.createAccountDAO(session);
            
            try {
                session.txBegin();
                
                final List<Account> entityList = new ArrayList<>();
                final Account entity = target.selectByPK(Integer.valueOf(1));
                entityList.add(entity);
                target.delete(entityList);
                session.flush();    // flush SQL
                
                assertNull(target.selectByPK(entity.getRecordId()));
                
                //session.txCommit();
                session.txRollback();   // roll-back for test
            } catch (final DAOException e) {
                session.txRollback();
                
                throw e;
            }
        }
    }
    
}

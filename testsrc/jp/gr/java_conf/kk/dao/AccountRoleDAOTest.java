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

import jp.gr.java_conf.kk.dao.DAOFactory;
import jp.gr.java_conf.kk.dao.DAOSession;
import jp.gr.java_conf.kk.dao.entity.AccountRole;

/**
 * Test class for {@link AccountRoleDAO}.
 * 
 * @author Koichi Kitamura
 * @version 1.0.0 2018/03/03
 */
@RunWith(JUnit4.class)
public class AccountRoleDAOTest {
    
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
     * Test for {@link AccountRoleDAO#selectAll()}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectAll() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            final List<AccountRole> entityList = target.selectAll();
            
            assertEquals(1, entityList.size());
            
            final AccountRole entity = entityList.get(0);
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("Administrators", entity.getName());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
        }
    }
    
    /**
     * Test for {@link AccountRoleDAO#selectByPK(Integer)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByPK() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            final AccountRole entity = target.selectByPK(Integer.valueOf(1));
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("Administrators", entity.getName());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertNull(target.selectByPK(Integer.valueOf(2)));
        }
    }
    
    /**
     * Test for {@link AccountRoleDAO#selectByName(String)}
     * 
     * @throws Exception if unexpected error occurred.
     */
    @Test
    public void testSelectByName() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            final AccountRole entity = target.selectByName("Administrators");
            
            assertEquals(Integer.valueOf(1), entity.getRecordId());
            assertEquals("Administrators", entity.getName());
            assertEquals(entity.getCreateDate(), entity.getUpdateDate());
            
            assertNull(target.selectByName("test"));
        }
    }
    
    /**
     * Test for {@link AccountRoleDAO#insert(AccountRole)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testInsert() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            final Date createDate = new Date();
            final Date updateDate = createDate;
            final AccountRole entity = new AccountRole();
            entity.setName("test");
            entity.setCreateDate(createDate);
            entity.setUpdateDate(updateDate);
            
            try {
                session.txBegin();
                
                final Integer pk = target.insert(entity);
                final AccountRole inserted = target.selectByPK(pk);
                
                assertNotEquals(Integer.valueOf(1), inserted.getRecordId());
                assertEquals(entity.getName(), inserted.getName());
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
     * Test for {@link AccountRoleDAO#update(AccountRole)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testUpdate() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            
            try {
                session.txBegin();
                
                final AccountRole entity = target.selectByPK(Integer.valueOf(1));
                entity.setName("test");
                entity.setUpdateDate(new Date());
                target.update(entity);
                session.flush();    // flush SQL
                final AccountRole updated = target.selectByPK(entity.getRecordId());
                
                assertEquals(entity.getName(), updated.getName());
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
     * Test for {@link AccountRoleDAO#delete(AccountRole)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testDelete() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            
            try {
                session.txBegin();
                
                final AccountRole entity = target.selectByPK(Integer.valueOf(1));
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
     * Test for {@link AccountRoleDAO#delete(List)}
     * 
     * @throws Exception if unexpected error occurred.s
     */
    @Test
    public void testDeleteList() throws Exception {
        try (DAOSession session = DAOFactory.openSession()) {
            final AccountRoleDAO target = DAOFactory.createAccountRoleDAO(session);
            
            try {
                session.txBegin();
                
                final List<AccountRole> entityList = new ArrayList<>();
                final AccountRole entity = target.selectByPK(Integer.valueOf(1));
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

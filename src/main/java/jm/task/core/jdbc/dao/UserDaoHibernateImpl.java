package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.disHiberFactory;
import static jm.task.core.jdbc.util.Util.hiberFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        try {
            Session session = hiberFactory().openSession();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            disHiberFactory();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction t = null;
        try {
            Session session = hiberFactory().openSession();
            t = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS `User`").executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            disHiberFactory();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction t = null;
        try {
            Session session = hiberFactory().openSession();
            User currentUser = new User();
            currentUser.setName(name);
            currentUser.setLastName(lastName);
            currentUser.setAge(age);
            t = session.beginTransaction();
            session.save(currentUser);
            t.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
            session.close();
        } catch (HibernateException e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            disHiberFactory();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction t = null;
        try {
            Session session = hiberFactory().openSession();
            t = session.beginTransaction();
            User currentUser = new User();
            currentUser.setId(id);
            session.delete(currentUser);
            t.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            disHiberFactory();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> out = null;
        try {
            Session session = hiberFactory().openSession();
            out = session.createQuery("from User").list();
            for (User usr : out) System.out.println(usr.toString());
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            disHiberFactory();
        }
        return out;
    }

    @Override
    public void cleanUsersTable() {
        Transaction t = null;
        try {
            Session session = hiberFactory().openSession();
            t = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            disHiberFactory();
        }
    }
}

package com.hibernate.test;

import com.hibernate.day01.*;
import com.hibernate.day02.JpaCustomer;
import com.hibernate.day02.JpaRole;
import com.hibernate.day02.JpaStudent;
import com.hibernate.day02.JpaTeacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;

public class HellowordTest {
    @Test
    public void testAdd(){
        //1、加载核心配置文件，默认去类路径下找hibernate.cfg.xml
        // 手动加载映射
        // configuration.addResource("com/hibernate/demo/Customer.hbm.xml");
        //3.x版本创建sessionFactory的方法
        Configuration configuration = new Configuration().configure();
        //2、读取hibernate核心配置文件，创建sessionFactory对象，过程中，会根据映射关系，在数据库中创建表
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //5.x版本创建sessionFactory的方法
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        //3、开启会话
        Session session = sessionFactory.openSession();
        //4、开启事务
        Transaction transaction = session.beginTransaction();
//        User userMapper = new User();
//        userMapper.setUsername("TOM");
//        userMapper.setAge(10);
//        userMapper.setAddress("天津");
//
//        session.save(userMapper);
        Student student = new Student();
        student.setName("小明");
        student.setAge(11);
        student.setGender(1);
        session.save(student);

        //5、提交事务
        transaction.commit();
        //6、关闭资源
        session.close();
        sessionFactory.close();

    }


    /**
     * 测试单向多对一保存（无级联操作）
     */
    @Test
    public void test1ton(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        Student tom = new Student();
        tom.setName("tom");
        tom.setAge(19);
        tom.setGender(1);
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);
        jack.setGender(1);

        Teacher teacher = new Teacher();
        teacher.setT_age(22);
        teacher.setT_name("王老师");

        session.save(teacher);
        tom.setTeacher(teacher);
        jack.setTeacher(teacher);
        session.save(tom);
        session.save(jack);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 测试单向多对一保存（级联操作）
     */
    @Test
    public void test1tonj(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        Student tom = new Student();
        tom.setName("tom");
        tom.setAge(19);
        tom.setGender(1);
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);
        jack.setGender(1);

        Teacher teacher = new Teacher();
        teacher.setT_age(22);
        teacher.setT_name("王老师");

        tom.setTeacher(teacher);
        jack.setTeacher(teacher);
        session.save(tom);
        session.save(jack);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 测试单向多对一查询
     */
    @Test
    public void test1tonq(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student tom = session.get(Student.class, "4028318176dcdf6f0176dcdf71f30001");
        System.out.println(tom);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * 测试单向1对多保存（无级联操作）
     */
    @Test
    public void testnto1(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        Student tom = new Student();
        tom.setName("tom");
        tom.setAge(19);
        tom.setGender(1);
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);
        jack.setGender(1);

        HashSet<Student> students = new HashSet<Student>();
        students.add(tom);
        students.add(jack);
        Teacher teacher = new Teacher();
        teacher.setT_age(22);
        teacher.setT_name("王老师");
        teacher.setStudents(students);

        session.save(tom);
        session.save(jack);
        session.save(teacher);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /**
     * 测试单向1对多保存（级联操作）
     */
    @Test
    public void testnto1j(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        Student tom = new Student();
        tom.setName("tom");
        tom.setAge(19);
        tom.setGender(1);
        Student jack = new Student();
        jack.setName("jack");
        jack.setAge(18);
        jack.setGender(1);

        HashSet<Student> students = new HashSet<Student>();
        students.add(tom);
        students.add(jack);
        Teacher teacher = new Teacher();
        teacher.setT_age(22);
        teacher.setT_name("王老师");
        teacher.setStudents(students);

        session.save(teacher);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * 测试单向一对多查询
     */
    @Test
    public void testnto1q(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, "4028318176dcfd700176dcfd73080002");
        System.out.println(teacher);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * 测试多对多保存
     */
    @Test
    public void testnton(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer zs = new Customer();
        zs.setC_name("张三");
        Customer ls = new Customer();
        ls.setC_name("李四");


        Role ky = new Role();
        ky.setR_name("科员");
        Role kz = new Role();
        kz.setR_name("科长");


        zs.getRoleSet().add(ky);
        ls.getRoleSet().add(ky);
        ls.getRoleSet().add(kz);

        session.save(zs);
        session.save(ls);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * 测试多对多查询
     */
    @Test
    public void testntonq(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer ls = session.get(Customer.class, "4028318176e216050176e21608970002");
        System.out.println(ls);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * JPA测试单向多对一保存（级联操作）
     */
    @Test
    public void jpatest1tonj(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        JpaStudent tom = new JpaStudent();
        tom.setName("tom");
        tom.setAge(19);
        tom.setGender(1);
        JpaStudent jack = new JpaStudent();
        jack.setName("jack");
        jack.setAge(18);
        jack.setGender(1);

        JpaTeacher teacher = new JpaTeacher();
        teacher.setT_age(22);
        teacher.setT_name("王老师");

        tom.setJpaTeacher(teacher);
        jack.setJpaTeacher(teacher);
        session.save(tom);
        session.save(jack);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    /**
     * JPA测试多对多保存
     */
    @Test
    public void jpatestnton(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        JpaCustomer zs = new JpaCustomer();
        zs.setC_name("张三");
        JpaCustomer ls = new JpaCustomer();
        ls.setC_name("李四");


        JpaRole ky = new JpaRole();
        ky.setR_name("科员");
        JpaRole kz = new JpaRole();
        kz.setR_name("科长");


        zs.getRoleSet().add(ky);
        ls.getRoleSet().add(ky);
        ls.getRoleSet().add(kz);

        session.save(zs);
        session.save(ls);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}

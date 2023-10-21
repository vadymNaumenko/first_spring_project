package com.myspringproject.database.repository;

import com.myspringproject.bpp.Auditing;
import com.myspringproject.bpp.InjectBean;
import com.myspringproject.bpp.Transaction;
import com.myspringproject.database.entity.Company;
import com.myspringproject.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    //  @Resource(name = "pool2")
//    @Autowired
//    @Qualifier("pool2")
    private ConnectionPool pool2;
    @Autowired
    private List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private Integer poolSize;

    @Autowired
    public void setPool2(ConnectionPool pool2) {
        this.pool2 = pool2;
    }

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("Find by id method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method");

    }
}

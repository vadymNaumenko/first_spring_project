package com.myspringproject.database.repository;

import com.myspringproject.bpp.InjectBean;
import com.myspringproject.database.pool.ConnectionPool;

public class CompanyRepository {
    @InjectBean
   private  ConnectionPool connectionPool;


}

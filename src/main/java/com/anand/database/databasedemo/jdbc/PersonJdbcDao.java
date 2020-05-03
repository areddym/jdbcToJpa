package com.anand.database.databasedemo.jdbc;

import com.anand.database.databasedemo.entity.PersonJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowmapper implements RowMapper<PersonJdbc> {

        @Override
        public PersonJdbc mapRow(ResultSet resultSet, int i) throws SQLException {
            PersonJdbc personJdbc = new PersonJdbc();
            personJdbc.setId(resultSet.getInt("id"));
            personJdbc.setName(resultSet.getString("name"));
            personJdbc.setLocation(resultSet.getString("location"));
            personJdbc.setBirthDate(resultSet.getTimestamp("birth_date"));
            return personJdbc;
        }
    }

    public List<PersonJdbc> findAll(){
       return jdbcTemplate.query("select * from person ",new BeanPropertyRowMapper(PersonJdbc.class));
    }

    public PersonJdbc findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id =?",new Object[] {id},new BeanPropertyRowMapper<PersonJdbc>(PersonJdbc.class));
    }

    //will return no of rows deleted
    //.update() is for delete and update and insert
    public int deleteById(int id){
        return jdbcTemplate.update
                ("delete  from person where id =?",new Object[] {id});
    }

    public int insert(PersonJdbc personJdbc) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                new Object[] { personJdbc.getId(), personJdbc.getName(), personJdbc.getLocation(),
                        new Timestamp(personJdbc.getBirthDate().getTime()) });
    }

    public int update(PersonJdbc personJdbc) {
        return jdbcTemplate.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
                new Object[] { personJdbc.getName(), personJdbc.getLocation(), new Timestamp(personJdbc.getBirthDate().getTime()),
                        personJdbc.getId() });
    }

    public List<PersonJdbc> findAllUsingCustomRowmapper(){
        return jdbcTemplate.query("select * from person ",new PersonRowmapper());
    }

    public PersonJdbc findByIdUsingCustomRowmapper(int id){
        return jdbcTemplate.queryForObject("select * from person where id =?",new Object[] {id},new PersonRowmapper());
    }


}

package com.azracas.repo;

/**
 * Created by arabbani on 11/19/16.
 */
import com.azracas.data.Person;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepo extends CrudRepository<Person, String>
{

    @Query("Select * from person where pid=?0")
    public Person fetchByPId(int pid);

}

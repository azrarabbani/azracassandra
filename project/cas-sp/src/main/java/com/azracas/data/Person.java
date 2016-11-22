package com.azracas.data;

/**
 * Created by arabbani on 11/19/16.
 */


import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("Person")
public class Person
{
    @PrimaryKey
    private Integer pId;

    private String fname;

    private String lname;

    public Integer getpId()
    {
        return pId;
    }

    public void setpId(Integer pId)
    {
        this.pId = pId;
    }


    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    @Override
    public String toString()
    {
        return "Person [pId=" + pId + ", fname=" + fname + ", lname=" + lname+ "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fname == null) ? 0 : fname.hashCode());
        result = prime * result + ((pId == null) ? 0 : pId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (fname == null)
        {
            if (other.fname != null)
                return false;
        }
        else if (!fname.equals(other.fname))
            return false;
        if (pId == null)
        {
            if (other.pId != null)
                return false;
        }
        else if (!pId.equals(other.pId))
            return false;
        return true;
    }

}

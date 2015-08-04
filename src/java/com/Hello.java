package com;

/**
 *
 * @author hudson.sales
 * @verison 1.0.0
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped
public class Hello {
    private String query;
    private List<Contato> list;

    public String search(){
        list = new Dao().query(getQuery());
        return "result.xhtml";
    }
    
    public List<String> complete(String q){
        return new Dao().auto(q);
    }

    public List<Contato> getList() {
        return list;
    }

    public void setList(List<Contato> list) {
        this.list = list;
    }  

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
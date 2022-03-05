package AAJ_design_patterns.dao;

import java.util.List;

//see also spring demo projects or EmployeeManagementSystem

public interface IDao<T> {
	
	//methods inherited from interfaces are always public
	
	T getById(int id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}

package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

public interface IGenericDao<Entity> {
	
	public boolean exists(int pk);
	
	public long count();
	
	public Entity create(Entity entity);
	
	public Entity update(Entity entity);
	
	public void delete(Entity entity);
	
	public ArrayList<Entity> findAll();
	
	public Entity findById(int id);
}
package in.cozynest.cozyapis.service;
import in.cozynest.cozyapis.model.Package;


import java.util.ArrayList;



public interface IPackageService {
	
     public long count();
	
	public Package create(Package pakage);
	
	public Package update(Package pakage);
	
	public void delete(Package pakage);
	
	public ArrayList<Package> findAll();
	
	public Package findById(int id);

}

package in.cozynest.cozyapis.service.impl;
import in.cozynest.cozyapis.model.Package;
import java.util.ArrayList;

import in.cozynest.cozyapis.dao.IPackageDao;
import in.cozynest.cozyapis.dao.impl.PackageDaoImpl;
import in.cozynest.cozyapis.service.IPackageService;
import in.cozynest.cozyapis.model.Package;

public class PackageServiceImpl implements  IPackageService {
	
	
	IPackageDao packageDao=new PackageDaoImpl();
	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return packageDao.count();
	}

	@Override
	public Package create(Package pakage) {
		// TODO Auto-generated method stub
		return packageDao.create(pakage);
	}

	@Override
	public Package update(Package pakage) {
		// TODO Auto-generated method stub
		return packageDao.update(pakage);
	}

	@Override
	public void delete(Package pakage) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Package> findAll() {
		// TODO Auto-generated method stub
		return packageDao.findAll();
	}

	@Override
	public Package findById(int id) {
		// TODO Auto-generated method stub
		return packageDao.findById(id);
	}

}

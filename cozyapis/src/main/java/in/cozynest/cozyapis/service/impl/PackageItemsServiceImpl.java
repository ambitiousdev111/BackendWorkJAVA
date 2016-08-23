package in.cozynest.cozyapis.service.impl;

import java.util.ArrayList;

import in.cozynest.cozyapis.dao.IPackageItemsDao;
import in.cozynest.cozyapis.dao.impl.PackageItemsDaoImpl;
import in.cozynest.cozyapis.model.PackageItems;
import in.cozynest.cozyapis.service.IPackageItemsService;

public class PackageItemsServiceImpl implements IPackageItemsService {
	
	IPackageItemsDao packageItemsDao=new PackageItemsDaoImpl();

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return packageItemsDao.count();
	}

	@Override
	public PackageItems create(PackageItems packageItems) {
		// TODO Auto-generated method stub
		return packageItemsDao.create(packageItems) ;
	}

	@Override
	public PackageItems update(PackageItems packageItems) {
		// TODO Auto-generated method stub
		return packageItemsDao.update(packageItems);
	}

	@Override
	public void delete(PackageItems packageItems) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PackageItems> findAll() {
		// TODO Auto-generated method stub
		return packageItemsDao.findAll();
	}

	@Override
	public PackageItems findById(int id) {
		// TODO Auto-generated method stub
		return packageItemsDao.findById(id);
	}

}

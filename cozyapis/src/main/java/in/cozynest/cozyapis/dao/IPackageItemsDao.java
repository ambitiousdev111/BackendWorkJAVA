package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.PackageItems;

public interface IPackageItemsDao {

	public boolean exists(int pk);

	public long count();

	public PackageItems create(PackageItems packageItems);

	public PackageItems update(PackageItems packageItems);

	public void delete(PackageItems packageItems);

	public ArrayList<PackageItems> findAll();

	public PackageItems findById(int id);

}

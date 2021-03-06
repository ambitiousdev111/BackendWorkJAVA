package in.cozynest.cozyapis.rest;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Package.PackageType;
import in.cozynest.cozyapis.model.Package;

public interface IPackageRest {

	public Package create(PackageType packageType, String name, String description, String imageUrl, double cost);

	public Package update(int id, String name);

	public ArrayList<Package> findAll();

	public Package findById(int id);

}

package in.cozynest.cozyapis.rest.impl;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import in.cozynest.cozyapis.annotations.AdminPath;
import in.cozynest.cozyapis.annotations.UserAdminPath;
import in.cozynest.cozyapis.exception.InternalServerErrorException;
import in.cozynest.cozyapis.exception.NotAcceptableException;
import in.cozynest.cozyapis.exception.NotFoundException;
import in.cozynest.cozyapis.model.Package;
import in.cozynest.cozyapis.model.Package.PackageType;
import in.cozynest.cozyapis.rest.IPackageRest;
import in.cozynest.cozyapis.service.IPackageService;
import in.cozynest.cozyapis.service.impl.PackageServiceImpl;


@Path("package")
@Produces("application/json")
@Consumes("application/json")
public class PackageRestImpl implements IPackageRest {
 
	IPackageService packageService=new PackageServiceImpl();
	
	@POST
	@Path("create")
	@UserAdminPath
	public Package create(@QueryParam("packageType")PackageType packageType,@QueryParam("name") String name,
			@QueryParam("description") String description, @QueryParam("imageUrl")String imageUrl,
			@QueryParam("cost") double cost) {
		if(name.equals("")||description.equals("")||imageUrl.equals(""))
			throw new NotAcceptableException("All feilds required");
		
		Package pakage=new Package();
		pakage.setName(name);
		pakage.setDescription(description);
		pakage.setImageUrl(imageUrl);
		pakage.setCost(cost);
		pakage.setPackageType(packageType);
		return packageService.create(pakage);
	}

	@PUT
	@Path("update")
	@AdminPath
	public Package update(@QueryParam("id") int id,@QueryParam("name") String name) {
		Package pakage=packageService.findById(id);
		if(pakage==null)
		throw new NotFoundException("No record found for this id");
		
		pakage.setId(id);
		pakage.setName(name);
		Package updatedPackage=packageService.update(pakage);
		if(updatedPackage==null)
			throw new InternalServerErrorException("unable to update Package");
		return updatedPackage;
	}

	@GET
	@Path("findall")
	public ArrayList<Package> findAll() {
		ArrayList<Package> pakage=packageService.findAll();
		 if(pakage==null)
			 throw new NotFoundException("No record found");
		
		return pakage;
	}

	@GET
	@Path("findbyid/{id}")
	@UserAdminPath
	public Package findById(@PathParam("id") int id) {
		Package pakage=packageService.findById(id);
		if(pakage==null)
			 throw new NotFoundException("No record found for this id");
		
		return pakage;
	}

}

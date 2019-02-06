package com.emc.resource;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.emc.entity.Category;
import com.emc.entity.Product;
import com.emc.exception.DAOException;
import com.emc.interfaces.ProductDAO;
import com.emc.service.ProductDAOImpl;


@Path("/product")
public class ProductResource {

	ProductDAO productDAO;
	
	@PostConstruct
	public void init(){
		productDAO = new ProductDAOImpl();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, 
		MediaType.APPLICATION_JSON})
	public Product getOneProduct(@PathParam("id")
					int productId) throws DAOException{
		return productDAO.getOneProduct(productId);
	}
	

	@GET
	@Produces({MediaType.APPLICATION_XML, 
		MediaType.APPLICATION_JSON})
	public List<Product> getAllProducts() throws DAOException{
		return productDAO.getAllProducts();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@PathParam("id")
		int productId) throws DAOException{
		productDAO.deleteProduct(productId);
		return "Product Deleted successfully : "+ productId; 
	}
	
	
	// localhost:8080/app/resource/product/query?min=10&max=20
	
	@GET
	@Path("/query")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getProductsByPrice(
			@QueryParam("min") Double min, 
			@QueryParam("max") Double max) 
				throws DAOException{
		
		if(min == null || max==null){
			throw new DAOException("Sorry Please Enter both param(min/max)");
		}
		
		
		return productDAO.getProductsByPrice(min, max);
		
	}
	
	
	
	
	

	@GET
	@Path("/matrix")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getProductsByPriceMatrix(
			@MatrixParam("min") Double min, 
			@MatrixParam("max") Double max) 
				throws DAOException{
		

		if(min == null || max==null){
			throw new DAOException("Sorry Please Enter both param(min/max)");
		}
		
		return productDAO.getProductsByPrice(min, max);
	}
	

	@GET
	@Path("/header")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getProductsByPriceHeader(
			@HeaderParam("min") Double min, 
			@HeaderParam("max") Double max) 
				throws DAOException{

		if(min == null || max==null){
			throw new DAOException("Sorry Please Enter both param(min/max)");
		}
		
		return productDAO.getProductsByPrice(min, max);
	}
		
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response addProduct(Product product) throws DAOException{
		
		try{
		productDAO.addProduct(product);
			return Response.ok("Record Inserted successfully").build();
		}catch(DAOException de){
			return 
				Response.status(599).entity(de.getMessage()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
	public Response updateProduct(Product product){
		try{
			productDAO.updateProduct(product);
			return Response.ok().build();
		}catch(DAOException de){
			return 
				Response.status(599).entity("Sorry Not Updated Because: "
					+de.getMessage()).build();
		}
		
	}
	
	
	
	// http://localhost:8080/app/resources/product/1/category

	
	@GET
	@Path("/{id}/category")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getCategoryForProduct (@PathParam("id") int productId) throws DAOException{
		
		long ms1 = new Date().getTime();
		Category category = productDAO.getOneProduct(productId).getCategory();
		long ms2 = new Date().getTime();
		
		Response response = Response.status(299)
					.header("DBCallTime", ms2-ms1)
					.entity(category)
					.build();
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public String addProductForm(
//			@FormParam("productName") int productId, 
//			@FormParam("productName") int productId,
//			
//			) throws DAOException{
//		productDAO.addProduct(product);
//		return "Record Inserted";
//	}
//	
	
	
	
	
	
}












package in.mindcraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyController {
	private List<Product> list=new ArrayList<>();

	public MyController() {
		list.add(new Product(101,",mark1",100));
		list.add(new Product(102,",dell",200));
		list.add(new Product(103,",mark3",300));
		
	}
	

	@RequestMapping(value="products",method=RequestMethod.GET)
	public List<Product> getProducts(){
		System.out.println("get all the products....");
		return list;
		
	}
	 
	@RequestMapping(value="products/{id}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable int id) {
		for(Product p:list) 
		{
			if(p.getPid()==id)
				return p;
		}
		return  null;
	}

	@RequestMapping(value="products",method=RequestMethod.POST)
	public List<Product> addProducts(@RequestBody Product p){
		list.add(p);
		return list;
	
	}
	
	@RequestMapping(value="products/{id}",method=RequestMethod.PUT)
	public Product updateProduct(@PathVariable int id,@RequestBody Product updatedProduct){
		for(Product p:list)
		{
			if(p.getPid()==id) {
		    p.setCost(updatedProduct.getCost());
            p.setMake(updatedProduct.getMake());
            return p;
		}
	}
		return null;
}
	
//	@RequestMapping(value="products/{id}",method=RequestMethod.DELETE)
//	public List<Product>  removeProduct(@PathVariable int id){
//			 list.remove(id);
//		return list;
//		}
	
	@RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
	public List<Product> removeProduct(@PathVariable(name = "id") int id) {
	   
	    Product productToRemove = null;
	    for (Product p : list) {
	        if (p.getPid() == id) {
	            productToRemove = p;
	            break;
	        }
	    }

	    if (productToRemove != null) {
	        list.remove(productToRemove);
	    }

	    return list;
	}
	


}
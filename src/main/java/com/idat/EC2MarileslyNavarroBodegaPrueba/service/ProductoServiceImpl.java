package com.idat.EC2MarileslyNavarroBodegaPrueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.ProductoDTORequest;
import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.ProductoDTOResponse;
import com.idat.EC2MarileslyNavarroBodegaPrueba.model.Productos;
import com.idat.EC2MarileslyNavarroBodegaPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Productos p = new Productos();
		p.setProducto(producto.getNombre());
		p.setDescripcion(producto.getDescripcionProducto());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		repository.save(p);
		
	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		
		Productos p = new Productos();
		p.setIdProducto(producto.getId());
		p.setProducto(producto.getNombre());
		p.setDescripcion(producto.getDescripcionProducto());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		
		List<ProductoDTOResponse> listar = new ArrayList<>();
		ProductoDTOResponse dto = null;
		List<Productos> p = repository.findAll();
		
		for (Productos productos : p) {
			dto = new ProductoDTOResponse();
			dto.setNombre(productos.getProducto());
			dto.setDescripcionProducto(productos.getDescripcion());
			dto.setPrecioProducto(productos.getPrecio());
			dto.setStockProducto(productos.getStock());
			dto.setId(productos.getIdProducto());
			listar.add(dto);
		}
		return listar;
		
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		
		Productos productos = repository.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto.setNombre(productos.getProducto());
		dto.setDescripcionProducto(productos.getDescripcion());
		dto.setPrecioProducto(productos.getPrecio());
		dto.setStockProducto(productos.getStock());
		dto.setId(productos.getIdProducto());
		return dto;
		
	}

}

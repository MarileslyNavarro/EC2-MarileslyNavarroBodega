package com.idat.EC2MarileslyNavarroBodegaPrueba.service;

import java.util.List;

import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.ProductoDTORequest;
import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.ProductoDTOResponse;

public interface ProductoService {

	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listarProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);
	
}

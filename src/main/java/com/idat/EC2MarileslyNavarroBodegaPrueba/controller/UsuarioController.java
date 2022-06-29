package com.idat.EC2MarileslyNavarroBodegaPrueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.UsuarioDTORequest;
import com.idat.EC2MarileslyNavarroBodegaPrueba.dto.UsuarioDTOResponse;
import com.idat.EC2MarileslyNavarroBodegaPrueba.security.JWTUtil;
import com.idat.EC2MarileslyNavarroBodegaPrueba.security.UserDetailService;

@RestController
public class UsuarioController {
	
	@Autowired
	private JWTUtil util;
	
	@Autowired
	private UserDetailService service;

	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request){
		
		UserDetails user = service.loadUserByUsername(request.getUsuario());
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
		
	}
	
}

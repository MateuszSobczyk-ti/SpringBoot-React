package pl.qone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.qone.exception.ResourceNotFoundException;
import pl.qone.model.Phone;
import pl.qone.repository.PhoneRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PhoneController {

	@Autowired
	private PhoneRepository phoneRepository;
	
	@GetMapping("/phones")
	public List<Phone> getAllPhones(){
		return phoneRepository.findAll();
	}
	
	@PostMapping("/phones")
	public Phone createPhone(@RequestBody Phone Phone) {
		return phoneRepository.save(Phone);
	}
	
	@GetMapping("/phones/{id}")
	public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
		Phone Phone = phoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Phone not exist with id: "+id));
		return ResponseEntity.ok(Phone);
	}
	
	@PutMapping("/phones/{id}")
	public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phoneDetails){
		Phone Phone = phoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Phone not exist with id: "+id));
		Phone.setProducer(phoneDetails.getProducer());
		Phone.setModel(phoneDetails.getModel());
		Phone.setSystem(phoneDetails.getSystem());
		Phone.setUrl(phoneDetails.getUrl());
		
		Phone updatedPhone = phoneRepository.save(Phone);
		return ResponseEntity.ok(updatedPhone);
	}
	
	@DeleteMapping("/phones/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePhone(@PathVariable Long id){
		Phone Phone = phoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Phone not exist with id: "+id));
		
		phoneRepository.delete(Phone);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}

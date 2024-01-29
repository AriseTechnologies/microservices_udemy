package com.arise.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonContoller {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionofPerson() {
		return new PersonV1("Umesh Manikdurge");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionofPerson() {
		return new PersonV2(new Name("Umesh", "Manikdurge"));
	}
	
	@GetMapping(path="/person", params = "version=1")
	public PersonV1 getFirstVersionofPersonRequestParam() {
		return new PersonV1("Umesh Manikdurge");
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondVersionofPersonRequestParam() {
		return new PersonV2(new Name("Umesh", "Manikdurge"));
	}
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionofPersonRequestHeader() {
		return new PersonV1("Umesh Manikdurge");
	}
	
	@GetMapping(path="/person/header",headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionofPersonRequestHeader() {
		return new PersonV2(new Name("Umesh", "Manikdurge"));
	}
	
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionofPersonHeader() {
		return new PersonV1("Umesh Manikdurge");
	}
	
	@GetMapping(path="/person/accept",produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionofPersonHeader() {
		return new PersonV2(new Name("Umesh", "Manikdurge"));
	}
}

package com.microservice.profileService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.profileService.entity.Profile;
import com.microservice.profileService.repository.ProfileRepository;
import com.microservice.profileService.response.AddressResponse;
import com.microservice.profileService.response.ProfileResponse;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;

	// @Autowired
	/*
	 * private RestTemplate restTemplate;
	 * 
	 * 
	 * @Value("${addressservice.base.url}") private String addressBaseURL;
	 * 
	 * 
	 * public ProfileService(@Value("${addressservice.base.url}") String
	 * addressBaseURL, RestTemplateBuilder builder) {
	 * this.restTemplate=builder.rootUri(addressBaseURL).build(); }
	 */

	public ProfileResponse getProfileById(int id) {

		
		Profile profile = repository.findById(id).get();
		System.out.println(id);
		/*
		 *  ProfileResponse profileResponse=new ProfileResponse();
		 * profileResponse.setId(profile.getId());
		 * profileResponse.setName(profile.getName());
		 * profileResponse.setMobileNumber(profile.getMobileNumber());
		 * profileResponse.setCountry(profile.getCountry());
		 */
		ProfileResponse profileResponse = modelMapper.map(profile, ProfileResponse.class);
		//AddressResponse addressResponse = webClient.get().uri("/address/"+id)
			//							  .retrieve().bodyToMono(AddressResponse.class).block(); //non blocking in nature ( i mean threads)
		//profileResponse.setAddressResponse(addressResponse);

		return profileResponse;
	}

	/*
	 * private AddressResponse callingAddressServiceUsingRestTemplate(int id) {
	 * return restTemplate.getForObject("/address/{id}", AddressResponse.class, id);  // blocking in nature (i mean threads)
	 * }
	 */
}

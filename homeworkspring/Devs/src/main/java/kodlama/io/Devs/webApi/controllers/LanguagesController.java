package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RequestMapping("/api/languages")
@RestController
public class LanguagesController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAll() {
		return languageService.getAll();
	}
	
	@GetMapping("/getall/{id}")
	public Language getId(@PathVariable int id) {
		return languageService.getId(id);
	}
	
	@PostMapping("/add-language")
	public void add(@RequestBody Language language) throws Exception {
		languageService.add(language);
	}
	
	@DeleteMapping("/delete-language")
	public void delete(@RequestParam int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update-language")
	public void update(@RequestBody Language language) {
		languageService.update(language);
	}

}

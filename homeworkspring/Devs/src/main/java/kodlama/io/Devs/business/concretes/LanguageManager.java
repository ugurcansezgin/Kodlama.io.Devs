package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		
		return languageRepository.getAll();
	}

	@Override
	public Language getId(int id) {
		
		return languageRepository.getId(id);
	}

	@Override
	public void add(Language language) throws Exception {
		
		for(Language pLanguage : this.languageRepository.getAll()) {
			if(pLanguage.getName() == language.getName()) {
				throw new Exception("Bu dil mevcut, tekrar girilemez!");
			}
		}
		if(language.getName() == null) {
			throw new Exception("İsim boş olamaz!");
		}
		
		languageRepository.add(language);
	}

	@Override
	public void delete(int id) {

        languageRepository.delete(id);
		
	}

	@Override
	public void update(Language language) {
		
		languageRepository.update(language);
		
	}
	
	

}

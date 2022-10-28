package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Python"));
		languages.add(new Language(3, "Java"));
	}

	@Override
	public List<Language> getAll() {
		
		return languages;
	}

	@Override
	public Language getId(int id) {
		for(Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}
	
	public boolean isExist(Language language) {
		boolean control = false;
		for(Language lang : languages) {
			if(lang.getName().equals(language.getName()) || lang.getId() == language.getId()) {
				control = true;
			}
		}
		return control;
	}

	
	public void add(Language language) {
		if(!isExist(language)) {
			if(!language.getName().equals("")) {
				languages.add(language);
			}
		}
		
	}

	
	public void delete(int id) {
		for(Language lang : languages) {
			if(lang.getId() == id) {
				languages.remove(lang);
			}
		}
		
	}

	
	public void update(Language language) {
		for(Language lang : languages) {
			if(language.getId() == lang.getId()) {
				lang.setId(language.getId());
				lang.setName(language.getName());
			}
		}
		
	}
	
}
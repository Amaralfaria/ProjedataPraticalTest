package br.com.projedata.config;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.projedata.formatters.FuncionarioFormatter;
import br.com.projedata.repositories.FuncionarioRepository;
import br.com.projedata.repositories.FuncionarioRepositoryImpl;
import br.com.projedata.services.FuncionarioReportService;
import br.com.projedata.services.FuncionarioReportServiceImpl;
import br.com.projedata.services.FuncionarioService;
import br.com.projedata.services.FuncionarioServiceImpl;
import br.com.projedata.utils.Constants;

public class AppContext {
	private Map<Class<?>, Object> services = new HashMap<Class<?>, Object>();

	public AppContext() {
		super();
	}
	
	public void init() {
		services.put(FuncionarioRepository.class, new FuncionarioRepositoryImpl());
		services.put(FuncionarioService.class, new FuncionarioServiceImpl(this.getService(FuncionarioRepository.class)));
		services.put(DateTimeFormatter.class, DateTimeFormatter.ofPattern(Constants.DATE_TIME_PATTERN_BR));
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.forLanguageTag(Constants.LOCALE_LANGUAGE_TAG_BR));
		numberFormat.setMaximumFractionDigits(Constants.FRACTION_DIGITS);
	    numberFormat.setMinimumFractionDigits(Constants.FRACTION_DIGITS);
		services.put(NumberFormat.class, numberFormat);
		services.put(FuncionarioFormatter.class, new FuncionarioFormatter(this.getService(DateTimeFormatter.class), this.getService(NumberFormat.class)));
		services.put(FuncionarioReportService.class, new FuncionarioReportServiceImpl(this.getService(FuncionarioFormatter.class)));
		
		DatabaseInitializer databaseInitializer = new DatabaseInitializer(this.getService(FuncionarioRepository.class));

		databaseInitializer.init();
	}
	
	public <T> T getService(Class<T> type) {
        return type.cast(services.get(type));
    }
	
}

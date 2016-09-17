package com.epam.dccomics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.epam.dccomics.domain.Battle;
import com.epam.dccomics.domain.DCHero;
import com.epam.dccomics.domain.FightingOpponentPair;
import com.epam.dccomics.propertywrappers.WinnerOfFightingStrategyWrapper;
import com.epam.dccomics.strategy.WinnerOfFightingStrategyImpl;

@Configuration
@Lazy
@Import({ DcHeroesConfiguration.class })
public class DcBattlesConfiguration {

	@Autowired
	private Environment env;

	@Bean
	@Scope("prototype")
	public WinnerOfFightingStrategyImpl winnerOfFightingStrategy() {
		int minRoundOfFights = Integer.parseInt(env.getProperty("dccomics.fights.min-round-number"));
		int maxRoundOfFights = Integer.parseInt(env.getProperty("dccomics.fights.max-round-number"));
		WinnerOfFightingStrategyWrapper winnerOfFightingStrategyWrapper = new WinnerOfFightingStrategyWrapper(minRoundOfFights, maxRoundOfFights);
		WinnerOfFightingStrategyImpl winnerOfFightingStrategy = new WinnerOfFightingStrategyImpl(winnerOfFightingStrategyWrapper);
		return winnerOfFightingStrategy;
	}

	@Bean
	public FightingOpponentPair supermanAgainstBatman(@Qualifier("superman") DCHero superman,
			@Qualifier("batman") DCHero batman) {
		FightingOpponentPair supermanAgainstBatman = new FightingOpponentPair(superman, batman);
		return supermanAgainstBatman;
	}

	@Bean
	public FightingOpponentPair supermanAgainstLexLutor(@Qualifier("superman") DCHero superman,
			@Qualifier("lexLutor") DCHero lexLutor) {
		FightingOpponentPair supermanAgainstLexLutor = new FightingOpponentPair(superman, lexLutor);
		return supermanAgainstLexLutor;
	}

	@Bean
	public FightingOpponentPair theGreenArrowAgainstZoom(@Qualifier("theGreenArrow") DCHero theGreenArrow,
			@Qualifier("zoom") DCHero zoom) {
		FightingOpponentPair theGreenArrowAgainstZoom = new FightingOpponentPair(theGreenArrow, zoom);
		return theGreenArrowAgainstZoom;
	}

	@Bean
	public FightingOpponentPair theGreenArrowAgainstLexLutor(@Qualifier("theGreenArrow") DCHero theGreenArrow,
			@Qualifier("lexLutor") DCHero lexLutor) {
		FightingOpponentPair theGreenArrowAgainstLexLutor = new FightingOpponentPair(theGreenArrow, lexLutor);
		return theGreenArrowAgainstLexLutor;
	}

	@Bean
	public Battle battle1(@Qualifier("supermanAgainstBatman") FightingOpponentPair supermanAgainstBatman) {
		Battle battle1 = new Battle(supermanAgainstBatman);
		battle1.setWinnerOfFightingStrategy(winnerOfFightingStrategy());
		return battle1;
	}

	@Bean
	public Battle battle2(@Qualifier("supermanAgainstLexLutor") FightingOpponentPair supermanAgainstLexLutor,
			@Qualifier("winnerOfFightingStrategy") WinnerOfFightingStrategyImpl winnerOfFightingStrategy) {
		Battle battle2 = new Battle(supermanAgainstLexLutor);
		battle2.setWinnerOfFightingStrategy(winnerOfFightingStrategy);
		return battle2;
	}

	@Bean
	public Battle battle3(@Qualifier("theGreenArrowAgainstZoom") FightingOpponentPair theGreenArrowAgainstZoom) {
		Battle battle3 = new Battle(theGreenArrowAgainstZoom);
		battle3.setWinnerOfFightingStrategy(winnerOfFightingStrategy());
		return battle3;
	}

	@Bean
	public Battle battle4(
			@Qualifier("theGreenArrowAgainstLexLutor") FightingOpponentPair theGreenArrowAgainstLexLutor) {
		Battle battle4 = new Battle(theGreenArrowAgainstLexLutor);
		battle4.setWinnerOfFightingStrategy(winnerOfFightingStrategy());
		return battle4;
	}

}

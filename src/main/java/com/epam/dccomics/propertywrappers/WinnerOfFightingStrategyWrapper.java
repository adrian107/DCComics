package com.epam.dccomics.propertywrappers;

/**
 * @author cadri
 *
 */
public class WinnerOfFightingStrategyWrapper {

	private int minRoundOfFights;
	private int maxRoundOfFights;

	public WinnerOfFightingStrategyWrapper(int minRoundOfFights, int maxRoundOfFights) {
		super();
		this.minRoundOfFights = minRoundOfFights;
		this.maxRoundOfFights = maxRoundOfFights;
	}

	public int getMinRoundOfFights() {
		return minRoundOfFights;
	}

	public int getMaxRoundOfFights() {
		return maxRoundOfFights;
	}

	@Override
	public String toString() {
		return "WinnerOfFightingStrategyWrapper [minRoundOfFights=" + minRoundOfFights + ", maxRoundOfFights="
				+ maxRoundOfFights + "]";
	}

}

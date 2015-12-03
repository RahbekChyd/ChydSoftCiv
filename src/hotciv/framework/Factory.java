package hotciv.framework;

public interface Factory {
	AgeStrategy ageStrategy();
	WinnerStrategy winnerStrategy();
	ActionStrategy actionStrategy();
	MapStrategy mapStrategy();
	AttackStrategy attStrategy();
}

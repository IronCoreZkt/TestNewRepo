package zkt.spring.lifeCycle;

public class FootballPlayer implements PlayerAction {
	String name;
	String team;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public void shoot() {
		System.out.println(this.name+" shoot!");
	}

	@Override
	public void pass() {
		System.out.println(this.name+" pass from side!");
	}

}

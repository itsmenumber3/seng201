package entities.monsters;

import assets.enums.RoleType;
import assets.libraries.MagicNumbers;
import exceptions.FullTeamException;
import main.Role;

import java.util.ArrayList;

public class Team implements Role {
    private MagicNumbers magicNumbers = new MagicNumbers();
    public ArrayList<Monster> team = new ArrayList<>();

    @Override
    public RoleType getRoleType() {
        return RoleType.TEAM;
    }

    public void addMonsterToTeam(Monster inputMonster) {
        try {
            if (team.size() == magicNumbers.MAXIMUM_MONSTERS_NUMBER_IN_TEAM) {
                throw new FullTeamException("Full team");
            } else {
                this.team.add(inputMonster);
            }
        } catch (FullTeamException e) {
            e.printStackTrace();
        }
    }

    public void removeMonsterFromTeam(Monster inputMonster) {
        this.team.remove(inputMonster);
    }
}

package entities.monsters;

import assets.enums.RoleType;
import assets.libraries.MagicNumbers;
import exceptions.FullTeamException;
import main.Role;

import java.util.ArrayList;

public class Team implements Role {

    // LIBRARIES ---------------------------------------------------

    private final MagicNumbers magicNumbers = new MagicNumbers();

    // LIBRARIES ---------------------------------------------------

    @Override
    public RoleType getRoleType() {
        return RoleType.TEAM;
    }

    // TEAM OF MONSTERS --------------------------------------------

    /**
     * This array list will store the team of monsters.
     */
    public ArrayList<Monster> team = new ArrayList<>();

    /**
     * This method will add the input monster object to this team.
     * @param inputMonster Monster, the new monster in question
     */
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

    /**
     * This method will add the input monster
     * @param inputMonster
     */
    public void removeMonsterFromTeam(Monster inputMonster) {
        this.team.remove(inputMonster);
    }

    // TEAM OF MONSTERS --------------------------------------------
}

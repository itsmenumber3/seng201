package entities.monsters;

import assets.enums.Rarity;
import assets.enums.RoleType;
import assets.libraries.Tools;
import assets.enums.MonsterType;

public class Dragon extends Monster {
	
    public MonsterType getMonsterType() {
        return MonsterType.DRAGON;
    }
	
    // INSTANTIATION --------------------------------------------------------

    /**
     * This method will create an instance of the class Dragon.
     * @param inputEntityName String, the name of the monster
     * @param inputEntityDescription String, the description of the monster
     * @param inputEntityRarity Rarity, the rarity of the monster
     * @param inputEntityPurchaseValue
     * @param inputEntitySellValue
     * @param inputAttackDamage
     * @param inputResistanceAbility
     * @see Rarity
     */
    public Dragon() {
    	getDragonName();
    	/*String inputEntityName, Rarity inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue,
        int inputAttackDamage, int inputResistanceAbility
        super(inputEntityName, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);*/
        this.resetMonsterHealthLevel();
        this.setMonsterAttackDamage(inputAttackDamage);
        this.setMonsterResistanceAbility(inputResistanceAbility);
    }

    // INSTANTIATION -------------------------------------------------------- 

    // Add a comment
	private String getDragonName() {
		return tools.generateRandomName(getMonsterType());
	}
}	

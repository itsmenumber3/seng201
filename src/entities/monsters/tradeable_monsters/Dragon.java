package entities.monsters.tradeable_monsters;
import assets.enums.MonsterType;
import entities.monsters.Monster;

public class Dragon extends Monster {
	
    public Dragon() {
    	this.setMonsterType(MonsterType.DRAGON);
    	super.setEntityImagePath("/assets/ui/img/dragon-final.png");
    }
	
//    // INSTANTIATION --------------------------------------------------------
//
//    /**
//     * This method will create an instance of the class Dragon.
//     * @param inputEntityName String, the name of the Dragon
//     * @param inputEntityRarity Rarity, the rarity of the Dragon
//     * @param inputEntityPurchaseValue
//     * @param inputEntitySellValue
//     * @param inputAttackDamage
//     * @param inputResistanceAbility
//     * @see Rarity
//     */
//    public Dragon(String inputEntityName, int inputEntityRarity, int inputEntityPurchaseValue, int inputEntitySellValue, int inputAttackDamage, int inputResistanceAbility) {
//        super(inputEntityName, inputEntityRarity, inputEntityPurchaseValue, inputEntitySellValue);*/
//        this.resetMonsterHealthLevel();
//        this.setMonsterAttackDamage(inputAttackDamage);
//        this.setMonsterResistanceAbility(inputResistanceAbility);
//    }
//
//    // INSTANTIATION -------------------------------------------------------- 

}	

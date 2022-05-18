package battles;

import assets.enums.BattleType;
import exceptions.UnallowedMethodException;
import main.Shop;

public class Battle {

    public Shop battleShop = new Shop();

    public void setBattleShop(Shop inputShop) {
        try {
            throw new UnallowedMethodException("unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public Shop getBattleShop() {
        return this.battleShop;
    }

    public String battleName;

    public void setBattleName(String inputBattleName) {
        this.battleName = inputBattleName;
    }

    public String getBattleName() {
        return this.battleName;
    }

    public BattleType battleType;

    public void setBattleType(BattleType inputBattleType) {
        this.battleType = inputBattleType;
    }

    public BattleType getBattleType(BattleType inputBattleType) {
        return this.battleType;
    }

    public String battleDescription;

    public void setBattleDescription(String inputBattleDescription) {
        this.battleDescription = inputBattleDescription;
    }

    public String getBattleDescription() {
        return this.battleDescription;
    }

    public int battleReward;

    public void setBattleReward(int inputBattleReward) {
        this.battleReward = inputBattleReward;
    }

    public int getBattleReward() {
        return this.battleReward;
    }
}

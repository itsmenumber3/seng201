package assets.libraries;

import battles.Battle;

public class UiTools {
	public String battleScreenImagePicker(Battle inputBattle) {
		switch(inputBattle.battleType) {
		case NINETY_MILES_BEACH:
			return "/assets/ui/img/NinetyMilesBeach.jpg";
		case LAKE_TAUPO:
			return "/assets/ui/img/LakeTaupo.jpg";
		case CANTERBURY_WETLANDS:
			return "/assets/ui/img/CanterburyWetlands.jpg";
		default:
			return "/assets/ui/img/SouthlandFarm.jpg";
		}
	}
}

package mfbridge;

public class VersionController {

	public static String _MFBlock_,_MFItem_,_bloomery_,_spadeTin_,_spadeBronze_;
	
	public static void init(){
		//ItemController
		if (PluginController.isMineFantasyNFLoaded){
			_MFBlock_ = "minefantasy.block.MFBlock";
			_MFItem_ = "minefantasy.item.MFItem";
		}else{
			_MFBlock_ = "minefantasy.block.BlockListMF";
			_MFItem_ = "minefantasy.item.ItemListMF";
		}
		//MFParts
		if (PluginController.isMineFantasyNFLoaded){
			_bloomery_="smelterBlock";
			_spadeTin_="primitiveSpadeTin";
			_spadeBronze_="spadeBronzeForged";
		}else{
			_bloomery_="smelter";
			_spadeTin_="spadeTin";
			_spadeBronze_="spadeBronze";
		}
	}
}

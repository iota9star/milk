package g.star.iota.milk.ui.menu;


import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.ui.bcy.ranking.BCYRankingPagerFragment;
import g.star.iota.milk.ui.bcy.selected.BCYSelectedFragment;
import g.star.iota.milk.ui.chinagirlol.china.ChinaGirlOLFragment;
import g.star.iota.milk.ui.cosplayla.cosplay.CosplayLaFragment;
import g.star.iota.milk.ui.gamersky.gamer.GamerSkyFragment;
import g.star.iota.milk.ui.magmoe.mag.MagPagerFragment;
import g.star.iota.milk.ui.moe005tv.moe.MOE005TVPagerFragment;
import g.star.iota.milk.ui.www005tv.www.WWW005TVFragment;

public class MenuCosplayFragment extends MenuFragment {

    @Override
    protected void handleOnMenuItemOnClick(MenuBean menu) {
        BaseActivity activity = (BaseActivity) mContext;
        BaseFragment currentFragment = null;
        switch (menu.getId()) {
            case Contracts.Menu.MENU_BCY_COS_SELECTED_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BCYSelectedFragment.newInstance(Contracts.Url.BCY_COS_SELECTED);
                activity.setTitle(Contracts.Menu.MENU_BCY_SELECTED);
                break;

            case Contracts.Menu.MENU_BCY_COS_RANKING_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BCYRankingPagerFragment.newInstance(BCYRankingPagerFragment.COS);
                activity.setTitle(Contracts.Menu.MENU_BCY_RANKING);
                break;

            case Contracts.Menu.MENU_MAG_MOE_COS_STAR_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new MagPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_MAG_MOE);
                break;
            case Contracts.Menu.MENU_WWW_005_TV_COS_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = WWW005TVFragment.newInstance(Contracts.Url.WWW_005_TV_COS);
                activity.setTitle(Contracts.Menu.MENU_WWW_005_TV);
                break;
            case Contracts.Menu.MENU_COSPLAY_LA_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = CosplayLaFragment.newInstance(Contracts.Url.COSPLAY_LA);
                activity.setTitle(Contracts.Menu.MENU_COSPLAY_LA);
                break;
            case Contracts.Menu.MENU_CHINAGIRLOL_ID_COS:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = ChinaGirlOLFragment.newInstance(Contracts.Url.CHINAGIRLOL_COS);
                activity.setTitle(Contracts.Menu.MENU_CHINAGIRLOL);
                break;
            case Contracts.Menu.MENU_MOE005TV_COS_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MOE005TVPagerFragment.newInstance(MOE005TVPagerFragment.COS);
                activity.setTitle(Contracts.Menu.MENU_MOE005TV);
                break;
            case Contracts.Menu.MENU_ACG_GAMERSKY_COS_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = GamerSkyFragment.newInstance(Contracts.Url.ACG_GAMERSKY_COS);
                activity.setTitle(Contracts.Menu.MENU_ACG_GAMERSKY);
                break;
        }
        activity.showFragment(currentFragment);
    }

    @Override
    protected List<MenuBean> getMenuList() {
        List<MenuBean> menu = new ArrayList<>();
        menu.add(new MenuBean(Contracts.Menu.MENU_MAG_MOE_COS_STAR_ID, Contracts.Menu.MENU_MAG_MOE,
                Contracts.Url.MAG_MOE_BASE, "http://mag.moe/wp-content/themes/magmoe/img/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_WWW_005_TV_COS_ID, Contracts.Menu.MENU_WWW_005_TV,
                Contracts.Url.WWW_005_TV_BASE, "http://www.005.tv/templets/muban/style/images/bannerbg.jpg", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_COSPLAY_LA_ID, Contracts.Menu.MENU_COSPLAY_LA,
                Contracts.Url.COSPLAY_LA_BASE, "http://cosplay.la/content/images/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_BCY_COS_SELECTED_ID, Contracts.Menu.MENU_BCY_SELECTED,
                Contracts.Url.BCY_BASE, "https://pubin.bcyimg.com/Image/sub-nav/logo-home-9e8a0985d6.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_BCY_COS_RANKING_ID, Contracts.Menu.MENU_BCY_RANKING,
                Contracts.Url.BCY_BASE, "https://pubin.bcyimg.com/Image/sub-nav/logo-home-9e8a0985d6.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_CHINAGIRLOL_ID_COS, Contracts.Menu.MENU_CHINAGIRLOL,
                Contracts.Url.CHINAGIRLOL_BASE, "http://www.chinagirlol.cc/template/bbf_cg/src/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_MOE005TV_COS_ID, Contracts.Menu.MENU_MOE005TV,
                Contracts.Url.MOE005TV_BASE, "http://www.005.tv/templets/muban/moe_style/image/moe_logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_ACG_GAMERSKY_COS_ID, Contracts.Menu.MENU_ACG_GAMERSKY,
                Contracts.Url.ACG_GAMERSKY_BASE, "http://image.gamersky.com/webimg13/acg/new/logo.png", null));
        return menu;
    }
}

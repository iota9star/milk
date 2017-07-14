package g.star.iota.milk.ui.menu;


import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.ui.chinagirlol.china.ChinaGirlOLPagerFragment;
import g.star.iota.milk.ui.gank.GankFragment;
import g.star.iota.milk.ui.jdlingyu.jd.JDLINGYUPagerFragment;
import g.star.iota.milk.ui.lesmao.les.LesmaoFragment;
import g.star.iota.milk.ui.mmonly.mm.MMONLYFragment;
import g.star.iota.milk.ui.mzitu.mzi.MZITUFragment;
import g.star.iota.milk.ui.rosiyy.rosi.ROSIYYFragment;
import g.star.iota.milk.ui.tngou.TGPagerFragment;
import g.star.iota.milk.ui.www192ttcom.www.WWW192TTCOMPagerFragment;
import g.star.iota.milk.ui.www94taotucom.www.WWW94TAOTUCOMFragment;
import g.star.iota.milk.ui.xiumm.xiu.XIUMMFragment;
import g.star.iota.milk.ui.xiuren.xiu.XiuRenFragment;
import g.star.iota.milk.util.ConfigUtils;

public class MenuMeiziFragment extends MenuFragment {
    @Override
    protected void handleOnMenuItemOnClick(MenuBean menu) {
        BaseActivity activity = (BaseActivity) mContext;
        BaseFragment currentFragment = null;
        switch (menu.getId()) {
            case Contracts.Menu.MENU_GANK_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = GankFragment.newInstance(Contracts.Url.GANK);
                activity.setTitle(Contracts.Menu.MENU_GANK);
                break;
            case Contracts.Menu.MENU_TNGOU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new TGPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_TNGOU);
                break;
            case Contracts.Menu.MENU_JDLINGYU_MEIZHI_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new JDLINGYUPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_JDLINGYU);
                break;

            case Contracts.Menu.MENU_LESMAO_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = LesmaoFragment.newInstance(Contracts.Url.LESMAO);
                activity.setTitle(Contracts.Menu.MENU_LESMAO);
                break;
            case Contracts.Menu.MENU_XIUMM_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = XIUMMFragment.newInstance(Contracts.Url.XIUMM);
                activity.setTitle(Contracts.Menu.MENU_XIUMM);
                break;
            case Contracts.Menu.MENU_94TAOTU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = WWW94TAOTUCOMFragment.newInstance(Contracts.Url.WWW94TAOTUCOM);
                activity.setTitle(Contracts.Menu.MENU_94TAOTU);
                break;
            case Contracts.Menu.MENU_MZITU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MZITUFragment.newInstance(Contracts.Url.MZITU);
                activity.setTitle(Contracts.Menu.MENU_MZITU);
                break;
            case Contracts.Menu.MENU_MMONLY_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MMONLYFragment.newInstance(Contracts.Url.MMONLY);
                activity.setTitle(Contracts.Menu.MENU_MMONLY);
                break;
            case Contracts.Menu.MENU_ROSIYY_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = ROSIYYFragment.newInstance(Contracts.Url.ROSIYY);
                activity.setTitle(Contracts.Menu.MENU_ROSIYY);
                break;
            case Contracts.Menu.MENU_192TT_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new WWW192TTCOMPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_192TT);
                break;
            case Contracts.Menu.MENU_XIUREN_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = XiuRenFragment.newInstance(Contracts.Url.XIUREN);
                activity.setTitle(Contracts.Menu.MENU_XIUREN);
                break;
            case Contracts.Menu.MENU_CHINAGIRLOL_ID_MZ:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new ChinaGirlOLPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_CHINAGIRLOL);
                break;
        }
        activity.showFragment(currentFragment);
    }

    @Override
    protected List<MenuBean> getMenuList() {
        List<MenuBean> menu = new ArrayList<>();
        menu.add(new MenuBean(Contracts.Menu.MENU_GANK_ID, Contracts.Menu.MENU_GANK,
                Contracts.Url.GANK_BASE, "http://gank.io/static/favicon.ico", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_TNGOU_ID, Contracts.Menu.MENU_TNGOU,
                Contracts.Url.TNGOU_BASE, "http://www.tngou.net/tnfs/common/amazeui/i/favicon.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_JDLINGYU_MEIZHI_ID, Contracts.Menu.MENU_JDLINGYU,
                Contracts.Url.JDLINGYU_BASE, "http://www.jdlingyu.moe/wp-content/uploads/2017/01/2017-01-07_20-57-14.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_LESMAO_ID, Contracts.Menu.MENU_LESMAO,
                Contracts.Url.LESMAO_BASE, "http://www.lesmao.com/static/image/common/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_XIUMM_ID, Contracts.Menu.MENU_XIUMM,
                Contracts.Url.XIUMM_BASE, "http://www.xiumm.org/themes/sense/images/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_94TAOTU_ID, Contracts.Menu.MENU_94TAOTU,
                Contracts.Url.WWW94TAOTUCOM_BASE, "http://www.94taotu.com/themes/sense/images/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_MZITU_ID, Contracts.Menu.MENU_MZITU,
                Contracts.Url.MZITU_BASE, "http://i.meizitu.net/pfiles/img/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_MMONLY_ID, Contracts.Menu.MENU_MMONLY,
                Contracts.Url.MMONLY_BASE, "http://www.mmonly.cc/skins/images/mmonly1.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_ROSIYY_ID, Contracts.Menu.MENU_ROSIYY,
                Contracts.Url.ROSIYY_BASE, "http://www.rosiyy.com/usr/themes/mm/images/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_192TT_ID, Contracts.Menu.MENU_192TT,
                Contracts.Url.WWW192TTCOM_BASE, "http://www.192tt.com/style/logo/logo.png", null));
        menu.add(new MenuBean(Contracts.Menu.MENU_CHINAGIRLOL_ID_MZ, Contracts.Menu.MENU_CHINAGIRLOL,
                Contracts.Url.CHINAGIRLOL_BASE, "http://www.chinagirlol.cc/template/bbf_cg/src/logo.png", null));
        if (!ConfigUtils.getR(aContext)) {
            menu.add(new MenuBean(Contracts.Menu.MENU_XIUREN_ID, Contracts.Menu.MENU_XIUREN,
                    Contracts.Url.XIUREN_BASE, "http://www.xiuren.org/logo.png", null));
        }
        return menu;
    }
}

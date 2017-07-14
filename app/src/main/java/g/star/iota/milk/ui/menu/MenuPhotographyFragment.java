package g.star.iota.milk.ui.menu;


import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.ui.bing.BingFragment;

public class MenuPhotographyFragment extends MenuFragment {
    @Override
    protected void handleOnMenuItemOnClick(MenuBean menu) {
        BaseActivity activity = (BaseActivity) mContext;
        BaseFragment currentFragment = null;
        switch (menu.getId()) {
            case Contracts.Menu.MENU_BING_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BingFragment.newInstance(Contracts.Url.BING);
                activity.setTitle(Contracts.Menu.MENU_BING);
                break;
        }
        activity.showFragment(currentFragment);
    }

    @Override
    protected List<MenuBean> getMenuList() {
        List<MenuBean> menu = new ArrayList<>();
        menu.add(new MenuBean(Contracts.Menu.MENU_BING_ID, Contracts.Menu.MENU_BING,
                Contracts.Url.BING_BASE, "http://cn.bing.com/s/a/hp_zh_cn.png", null));
        return menu;
    }
}

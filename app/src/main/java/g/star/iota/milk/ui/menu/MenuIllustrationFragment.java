package g.star.iota.milk.ui.menu;


import java.util.ArrayList;
import java.util.List;

import g.star.iota.milk.Contracts;
import g.star.iota.milk.base.BaseActivity;
import g.star.iota.milk.base.BaseFragment;
import g.star.iota.milk.ui.anipic.anime.AnimePictureFragment;
import g.star.iota.milk.ui.apic.a.ApicPagerFragment;
import g.star.iota.milk.ui.bcy.ranking.BCYRankingPagerFragment;
import g.star.iota.milk.ui.bcy.selected.BCYSelectedFragment;
import g.star.iota.milk.ui.booru.BooruFragment;
import g.star.iota.milk.ui.donmai.DonmaiFragment;
import g.star.iota.milk.ui.eshuushuu.ESHUUSHUUFragment;
import g.star.iota.milk.ui.gacha.GachaPagerFragment;
import g.star.iota.milk.ui.gamersky.gamer.GamerSkyPagerFragment;
import g.star.iota.milk.ui.jdlingyu.jd.JDLINGYUFragment;
import g.star.iota.milk.ui.lingyu.ling.LingYuFragment;
import g.star.iota.milk.ui.magmoe.mag.MagFragment;
import g.star.iota.milk.ui.mangadrawing.MangaDrawingHentaiPagerFragment;
import g.star.iota.milk.ui.mangadrawing.MangaDrawingPagerFragment;
import g.star.iota.milk.ui.minitokyo.MINITOKYOFragment;
import g.star.iota.milk.ui.moe005tv.moe.MOE005TVPagerFragment;
import g.star.iota.milk.ui.moeimg.moe.MoeimgFragment;
import g.star.iota.milk.ui.nijieroch.nijiero.NijieroCHFragment;
import g.star.iota.milk.ui.pangci.PANGCIFragment;
import g.star.iota.milk.ui.wallhaven.wall.WallHavenFragment;
import g.star.iota.milk.ui.www005tv.www.WWW005TVPagerFragment;
import g.star.iota.milk.ui.yuriimg.YuriImgPagerFragment;
import g.star.iota.milk.ui.zerochan.ZerochanFragment;
import g.star.iota.milk.util.ConfigUtils;

public class MenuIllustrationFragment extends MenuFragment {
    @Override
    protected void handleOnMenuItemOnClick(MenuBean menu) {
        BaseActivity activity = (BaseActivity) mContext;
        BaseFragment currentFragment = null;
        switch (menu.getId()) {
            case Contracts.Menu.MENU_YANDE_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BooruFragment.newInstance(Contracts.Url.YANDE);
                activity.setTitle(Contracts.Menu.MENU_YANDE);
                break;
            case Contracts.Menu.MENU_KONACHAN_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BooruFragment.newInstance(Contracts.Url.KONACHAN);
                activity.setTitle(Contracts.Menu.MENU_KONACHAN);
                break;
            case Contracts.Menu.MENU_LOLIBOORU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BooruFragment.newInstance(Contracts.Url.LOLIBOORU);
                activity.setTitle(Contracts.Menu.MENU_LOLIBOORU);
                break;
            case Contracts.Menu.MENU_DANBOORU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = DonmaiFragment.newInstance(Contracts.Url.DANBOORU);
                activity.setTitle(Contracts.Menu.MENU_DANBOORU);
                break;
            case Contracts.Menu.MENU_SAFEBOORU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = DonmaiFragment.newInstance(Contracts.Url.SAFEBOORU);
                activity.setTitle(Contracts.Menu.MENU_SAFEBOORU);
                break;
            case Contracts.Menu.MENU_E621_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BooruFragment.newInstance(Contracts.Url.E621);
                activity.setTitle(Contracts.Menu.MENU_E621);
                break;
            case Contracts.Menu.MENU_E926_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BooruFragment.newInstance(Contracts.Url.E926);
                activity.setTitle(Contracts.Menu.MENU_E926);
                break;
            case Contracts.Menu.MENU_WALLHAVEN_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = WallHavenFragment.newInstance(Contracts.Url.WALLHAVEN);
                activity.setTitle(Contracts.Menu.MENU_WALLHAVEN);
                break;
            case Contracts.Menu.MENU_GACHA_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new GachaPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_GACHA);
                break;
            case Contracts.Menu.MENU_BCY_ILLUST_SELECTED_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BCYSelectedFragment.newInstance(Contracts.Url.BCY_ILLUST_SELECTED);
                activity.setTitle(Contracts.Menu.MENU_BCY_SELECTED);
                break;
            case Contracts.Menu.MENU_BCY_ILLUST_RANKING_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = BCYRankingPagerFragment.newInstance(BCYRankingPagerFragment.ILLUST);
                activity.setTitle(Contracts.Menu.MENU_BCY_RANKING);
                break;
            case Contracts.Menu.MENU_MANGA_DRAWING_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new MangaDrawingPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_MANGA_DRAWING);
                break;
            case Contracts.Menu.MENU_MANGA_DRAWING_HENTAI_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new MangaDrawingHentaiPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_MANGA_DRAWING);
                break;
            case Contracts.Menu.MENU_MAG_MOE_MOE_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MagFragment.newInstance(Contracts.Url.MAG_MOE_MOE);
                activity.setTitle(Contracts.Menu.MENU_MAG_MOE);
                break;

            case Contracts.Menu.MENU_APIC_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new ApicPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_APIC);
                break;
            case Contracts.Menu.MENU_ZEROCHAN_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = ZerochanFragment.newInstance(Contracts.Url.ZEROCHAN);
                activity.setTitle(Contracts.Menu.MENU_ZEROCHAN);
                break;
            case Contracts.Menu.MENU_E_SHUUSHUU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = ESHUUSHUUFragment.newInstance(Contracts.Url.E_SHUUSHUU);
                activity.setTitle(Contracts.Menu.MENU_E_SHUUSHUU);
                break;
            case Contracts.Menu.MENU_MINITOKYO_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MINITOKYOFragment.newInstance(Contracts.Url.MINITOKYO);
                activity.setTitle(Contracts.Menu.MENU_MINITOKYO);
                break;
            case Contracts.Menu.MENU_WWW_005_TV_ACG_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new WWW005TVPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_WWW_005_TV);
                break;

            case Contracts.Menu.MENU_JDLINGYU_ACG_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = JDLINGYUFragment.newInstance(Contracts.Url.JDLINGYU_ACG);
                activity.setTitle(Contracts.Menu.MENU_JDLINGYU);
                break;
            case Contracts.Menu.MENU_LINGYU_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = LingYuFragment.newInstance(Contracts.Url.LINGYU);
                activity.setTitle(Contracts.Menu.MENU_LINGYU);
                break;
            case Contracts.Menu.MENU_MOEIMG_ID:
                activity.removeFragmentContainerChildrenViews();
                if (!ConfigUtils.getR(aContext)) {
                    currentFragment = MoeimgFragment.newInstance(Contracts.Url.MOEIMG_H);
                } else {
                    currentFragment = MoeimgFragment.newInstance(Contracts.Url.MOEIMG);
                }
                activity.setTitle(Contracts.Menu.MENU_MOEIMG);
                break;
            case Contracts.Menu.MENU_NIJIERO_CH_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = NijieroCHFragment.newInstance(Contracts.Url.NIJIERO_CH);
                activity.setTitle(Contracts.Menu.MENU_NIJIERO_CH);
                break;

            case Contracts.Menu.MENU_MOE005TV_ACG_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = MOE005TVPagerFragment.newInstance(MOE005TVPagerFragment.ACG);
                activity.setTitle(Contracts.Menu.MENU_MOE005TV);
                break;
            case Contracts.Menu.MENU_ACG_GAMERSKY_ACG_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new GamerSkyPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_ACG_GAMERSKY);
                break;
            case Contracts.Menu.MENU_PANGCI_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = PANGCIFragment.newInstance(Contracts.Url.PANGCI);
                activity.setTitle(Contracts.Menu.MENU_PANGCI);
                break;
            case Contracts.Menu.MENU_YURIIMG_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = new YuriImgPagerFragment();
                activity.setTitle(Contracts.Menu.MENU_YURIIMG);
                break;
            case Contracts.Menu.MENU_ANIME_PICTURES_ID:
                activity.removeFragmentContainerChildrenViews();
                currentFragment = AnimePictureFragment.newInstance(Contracts.Url.ANIME_PICTURES);
                activity.setTitle(Contracts.Menu.MENU_ANIME_PICTURES);
                break;
        }
        activity.showFragment(currentFragment);
    }

    @Override
    protected List<MenuBean> getMenuList() {
        List<MenuBean> menu = new ArrayList<>();
        menu.add(new MenuBean(Contracts.Menu.MENU_YANDE_ID,
                Contracts.Menu.MENU_YANDE,
                Contracts.Url.YANDE_BASE,
                "https://assets.yande.re/assets/logo_small-418e8d5ec0229f274edebe4af43b01aa29ed83b715991ba14bb41ba06b5b57b5.png",
                "https://yande.re/user/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_KONACHAN_ID,
                Contracts.Menu.MENU_KONACHAN,
                Contracts.Url.KONACHAN_BASE,
                "https://konachan.com/images/logo.png",
                "https://konachan.com/user/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_LOLIBOORU_ID,
                Contracts.Menu.MENU_LOLIBOORU,
                Contracts.Url.LOLIBOORU_BASE,
                "https://lolibooru.moe/images/logo.png",
                "https://lolibooru.moe/user/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_DANBOORU_ID,
                Contracts.Menu.MENU_DANBOORU,
                Contracts.Url.DANBOORU_BASE,
                "https://danbooru.donmai.us/favicon.ico",
                "https://danbooru.donmai.us/session/new"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_SAFEBOORU_ID,
                Contracts.Menu.MENU_SAFEBOORU,
                Contracts.Url.SAFEBOORU_BASE,
                "https://safebooru.donmai.us/favicon.ico",
                "https://safebooru.donmai.us/session/new"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_E621_ID,
                Contracts.Menu.MENU_E621,
                Contracts.Url.E621_BASE,
                "https://e621.net/images/mascot_bg/evalionfix.jpg",
                "https://e621.net/user/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_E926_ID,
                Contracts.Menu.MENU_E926,
                Contracts.Url.E926_BASE,
                "http://e926.net/images/mascot_bg/peacock.png",
                "http://e926.net/user/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_MOEIMG_ID,
                Contracts.Menu.MENU_MOEIMG,
                Contracts.Url.MOEIMG_BASE,
                "http://img.moeimg.net/wp-content/uploads/img/moeimg_pc.gif",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_WALLHAVEN_ID,
                Contracts.Menu.MENU_WALLHAVEN,
                Contracts.Url.WALLHAVEN_BASE,
                "https://alpha.wallhaven.cc/images/layout/logo.png",
                "https://alpha.wallhaven.cc/auth/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_GACHA_ID,
                Contracts.Menu.MENU_GACHA,
                Contracts.Url.GACHA_BASE,
                "http://gacha.cdn.126.net/src/image/all/logo.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_BCY_ILLUST_SELECTED_ID,
                Contracts.Menu.MENU_BCY_SELECTED,
                Contracts.Url.BCY_BASE,
                "https://pubin.bcyimg.com/Image/sub-nav/logo-home-9e8a0985d6.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_BCY_ILLUST_RANKING_ID,
                Contracts.Menu.MENU_BCY_RANKING,
                Contracts.Url.BCY_BASE,
                "https://pubin.bcyimg.com/Image/sub-nav/logo-home-9e8a0985d6.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_MANGA_DRAWING_ID,
                Contracts.Menu.MENU_MANGA_DRAWING,
                Contracts.Url.MANGA_DRAWING_BASE,
                "http://static.mangadrawing.net/themes/shinpatsu/md.jpg",
                null
        ));
        if (!ConfigUtils.getR(aContext)) {
            menu.add(new MenuBean(Contracts.Menu.MENU_MANGA_DRAWING_HENTAI_ID,
                    Contracts.Menu.MENU_MANGA_DRAWING_HENTAI,
                    Contracts.Url.MANGA_DRAWING_BASE,
                    "http://static.mangadrawing.net/themes/shinpatsu/md.jpg",
                    null
            ));
            menu.add(new MenuBean(Contracts.Menu.MENU_NIJIERO_CH_ID,
                    Contracts.Menu.MENU_NIJIERO_CH,
                    Contracts.Url.NIJIERO_CH_BASE,
                    "https://nijiero-ch.com/wp-content/themes/erosite-theme/images/pc/img_title.png",
                    null
            ));
        }
        menu.add(new MenuBean(Contracts.Menu.MENU_MAG_MOE_MOE_ID,
                Contracts.Menu.MENU_MAG_MOE,
                Contracts.Url.MAG_MOE_BASE,
                "http://mag.moe/wp-content/themes/magmoe/img/logo.png",
                null
        ));
        menu.add(new MenuBean(
                Contracts.Menu.MENU_APIC_ID,
                Contracts.Menu.MENU_APIC,
                Contracts.Url.APIC_BASE,
                "http://img.gov.com.de/2015/04/apic-in-%E6%A3%92%E6%A3%92%E7%B3%96-3-565x800.jpg",
                "http://www.apic.in/"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_ZEROCHAN_ID,
                Contracts.Menu.MENU_ZEROCHAN,
                Contracts.Url.ZEROCHAN_BASE,
                "http://s1.zerochan.net/header-1.jpg",
                "http://www.zerochan.net/login?ref=%2F"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_E_SHUUSHUU_ID,
                Contracts.Menu.MENU_E_SHUUSHUU,
                Contracts.Url.E_SHUUSHUU_BASE,
                "http://e-shuushuu.net/common/image/banner/hikari-chan5/middle.jpg",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_MINITOKYO_ID,
                Contracts.Menu.MENU_MINITOKYO,
                Contracts.Url.MINITOKYO_BASE,
                "http://static2.minitokyo.net/view/46/07/707896.jpg",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_WWW_005_TV_ACG_ID,
                Contracts.Menu.MENU_WWW_005_TV,
                Contracts.Url.WWW_005_TV_BASE,
                "http://www.005.tv/templets/muban/style/images/bannerbg.jpg",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_MOE005TV_ACG_ID,
                Contracts.Menu.MENU_MOE005TV,
                Contracts.Url.MOE005TV_BASE,
                "http://www.005.tv/templets/muban/moe_style/image/moe_logo.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_JDLINGYU_ACG_ID,
                Contracts.Menu.MENU_JDLINGYU,
                Contracts.Url.JDLINGYU_BASE,
                "http://www.jdlingyu.moe/wp-content/uploads/2017/01/2017-01-07_20-57-14.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_LINGYU_ID,
                Contracts.Menu.MENU_LINGYU,
                Contracts.Url.LINGYU_BASE,
                "http://tp.lingyu.me/bz/uploads/2016/07/www.lingyu.me_20160728125540677.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_ACG_GAMERSKY_ACG_ID,
                Contracts.Menu.MENU_ACG_GAMERSKY,
                Contracts.Url.ACG_GAMERSKY_BASE,
                "http://image.gamersky.com/webimg13/acg/new/logo.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_PANGCI_ID,
                Contracts.Menu.MENU_PANGCI,
                Contracts.Url.PANGCI_BASE,
                "https://www.pangci.cc/skin2015/logo.png",
                null
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_YURIIMG_ID,
                Contracts.Menu.MENU_YURIIMG,
                Contracts.Url.YURIIMG_BASE,
                "http://yuri.logacg.com/1707/1e7ca5bbe5e2ee9346372bc76bbc5f96.png!single.webp",
                "http://yuriimg.com/account/login"
        ));
        menu.add(new MenuBean(Contracts.Menu.MENU_ANIME_PICTURES_ID,
                Contracts.Menu.MENU_ANIME_PICTURES,
                Contracts.Url.ANIME_PICTURES_BASE,
                "https://anime-pictures.net/static/styles/first/images/back_patern.png",
                Contracts.Url.ANIME_PICTURES_BASE
        ));
        return menu;
    }
}

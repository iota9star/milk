package g.star.iota.milk.glide.integration;

import android.content.Context;

import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;

import java.io.InputStream;

import g.star.iota.milk.MyApp;

@GlideModule
public final class OkHttpLibraryGlideModule extends LibraryGlideModule {
    @Override
    public void registerComponents(Context context, Registry registry) {
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(MyApp.makeOkHttpClient()));
    }
}

package com.kevin.demoapp.di;

import com.kevin.demoapp.repository.CategoryRepository;
import com.kevin.demoapp.service.CategoryService;
import com.kevin.demoapp.util.Constants;
import com.kevin.demoapp.viewmodel.CategoryViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public Retrofit providerRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create()) //Convert response to string
                .addConverterFactory(GsonConverterFactory.create()) // Convert response to Json object
                .build();
    }

    @Provides
    @Singleton
    public CategoryService provideCategoryService(Retrofit retrofit) {
        return retrofit.create(CategoryService.class);
    }

    @Provides
    @Singleton
    public CategoryRepository provideRepository(CategoryService service) {
        return new CategoryRepository(service);
    }

}

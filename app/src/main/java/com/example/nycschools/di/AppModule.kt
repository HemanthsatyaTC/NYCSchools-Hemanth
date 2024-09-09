package com.example.nycschools.di

import android.util.Log
import com.example.nycschools.data.remote.SchoolApiDetails.BASE_URL
import com.example.nycschools.data.remote.SchoolApiInterface
import com.example.nycschools.data.repository.Repository
import com.example.nycschools.data.repository.RepositoryImplementation
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonSyntaxException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun getGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Int::class.java, object : JsonDeserializer<Int> {
                override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Int {
                    return try {
                        json.asInt
                    } catch (e: NumberFormatException) {
                        0 // default value
                    } catch (e: JsonSyntaxException) {
                        0 // default value
                    }
                }
            })
            .create()
    }

    @Provides
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    @Provides
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }
    @Provides
    fun getDetails(
        retrofit: Retrofit
    ): SchoolApiInterface {
        return retrofit.create(SchoolApiInterface::class.java)
    }

    @Provides
    fun getRepository(
        apiSchool: SchoolApiInterface
    ): Repository {
        return RepositoryImplementation(
            apiSchool = apiSchool
        )

    }
}
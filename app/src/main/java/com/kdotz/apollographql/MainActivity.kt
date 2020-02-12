package com.kdotz.apollographql

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import okhttp3.OkHttpClient
import org.jetbrains.annotations.NotNull


class MainActivity : AppCompatActivity() {

    private val BASE_URL = "http://127.0.0.1:3000/graphql"
    private lateinit var apolloClient: ApolloClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okHttpClient = OkHttpClient.Builder().build()

         apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()

//        val booksQuery = apolloClient
//            .query(BooksQuery.builder().build())
//
//        booksQuery.enqueue(object : ApolloCall.Callback<BooksQuery.Data>() {
//            override fun onResponse(response: Response<BooksQuery.Data>) {
//                val data = response.data()
//                println("DATA: " + response.data()?.books())
//            }
//
//            override fun onFailure(e: ApolloException) {
//
//            }
//        })

        apolloClient.query(BooksQuery.builder().build())
            .enqueue(object : ApolloCall.Callback<BooksQuery.Data>() {
                override fun onResponse(@NotNull response: Response<BooksQuery.Data>) {
                    println("DATA: " + response.data()?.books())
                }

                override fun onFailure(@NotNull e: ApolloException) {
                    Log.e("error", e.message, e)
                }
            })

    }

    fun getApolloClient(): ApolloClient {
        return apolloClient
    }
}

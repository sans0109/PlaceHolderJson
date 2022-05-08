package com.example.placeholderjson

import android.os.Bundle
import android.view.View
import android.view.ViewManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placeholderjson.models.Root
import com.example.placeholderjson.mvvm.UserRepository
import com.example.placeholderjson.mvvm.UserVMFactory
import com.example.placeholderjson.mvvm.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var userAdapter: UserAdapter
    lateinit var userViewModel: UserViewModel
    lateinit var userVMFactory: UserVMFactory
    lateinit var userRepository: UserRepository
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        userRepository = UserRepository()
        userVMFactory = UserVMFactory(userRepository)
        userViewModel = ViewModelProvider(
            this,
            userVMFactory)[UserViewModel::class.java]

        userViewModel.getUser()

        userViewModel.myResponse.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<Root>)
        })

    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview)
        userAdapter = UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}
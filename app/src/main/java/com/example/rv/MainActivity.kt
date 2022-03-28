package com.example.rv


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rv.adapters.Adapter_top
import com.example.rv.adapters.Adapter_down
import com.example.rv.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity(){
    private lateinit var recyclerView_top: RecyclerView
    private lateinit var recyclerView_down: RecyclerView
    private lateinit var floatingActionButton:FloatingActionButton
    private lateinit var list_top: ArrayList<Item>
    private lateinit var list_down: ArrayList<Item>
    private lateinit var onClickInterface: onClickInterface
    private lateinit var adapterTop: Adapter_top
    private lateinit var adapterDown: Adapter_down //onclick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }
        recyclerView_top=findViewById(R.id.rvOne)
        recyclerView_down=findViewById(R.id.rvTwo)
        floatingActionButton=findViewById(R.id.shuffleBtn)
       list_top= ArrayList()
        list_down=ArrayList()
        initList();
        onClickInterface = object : onClickInterface {
            override fun setClick(idx: Int) {
                list_top.add(list_down.get(idx))
                list_down.removeAt(idx)
                adapterTop.notifyDataSetChanged()
                adapterDown.notifyDataSetChanged()
            }
        }
        recyclerView_down.setLayoutManager(GridLayoutManager(applicationContext, 2))
        adapterDown = Adapter_down(applicationContext, list_down, onClickInterface)
        recyclerView_down.setAdapter(adapterDown)

        recyclerView_top.setLayoutManager(GridLayoutManager(applicationContext, 2))
        adapterTop = Adapter_top(applicationContext, list_top)
        recyclerView_top.setAdapter(adapterTop)



        floatingActionButton.setOnClickListener(View.OnClickListener {
            list_down.shuffle()
            adapterDown.notifyDataSetChanged()
        })



    }

    private fun initList() {
        list_down.add(Item(R.drawable.avocado, "Avocado"))
        list_down.add(Item(R.drawable.car, "Car"))
        list_down.add(Item(R.drawable.cat, "Cat"))
        list_down.add(Item(R.drawable.coffee, "Coffee"))
        list_down.add(Item(R.drawable.fox, "Fox"))
        list_down.add(Item(R.drawable.heart, "Heart"))
        list_down.add(Item(R.drawable.hummingbird, "Hummingbird"))
        list_down.add(Item(R.drawable.mountain, "Mountains"))
        list_down.add(Item(R.drawable.sheep, "Sheep"))
        list_down.add(Item(R.drawable.snowman, "Snowman"))
    }
}

package com.example.doodleinnovationsampleproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart_items_user_selected.*
import kotlinx.android.synthetic.main.main_activity_select_items.*
import kotlinx.android.synthetic.main.my_cart_activity.*

class MyCartActivity : AppCompatActivity(),RecyclerViewClickInterface {
    var count = 0
    var dataObj  : UserCartData =  UserCartData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_items_user_selected)
       /* btnIncreaseCart.setOnClickListener(this)
        btnDecreaseCart.setOnClickListener(this)
        cartBackBtn.setOnClickListener(this)*/

        if (intent.extras != null){
            var bundle = intent.getBundleExtra("bundle")
            var data = bundle?.getParcelable<UserCartData>("userDataObj") as UserCartData
        }

        loadData()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = RecyclerViewAdapter(loadData(),this)
        back.setOnClickListener {
            finish()
        }
    }


    private fun loadData() : ArrayList<DataObject>{
        val list = arrayListOf<DataObject>()
        var dataObject = DataObject()
        DataObject().itemName = "Guac de la Costa"
        DataObject().itemSubName = "tortilas de mais, fruit de la passion , mango"
        DataObject().itemCount = dataObject.itemCount
        list.add(dataObject)
        list.add(dataObject)
        list.add(dataObject)
        list.add(dataObject)
        list.add(dataObject)
        return  list
    }

    override fun onItemClick(obj: DataObject, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(position: Int) {
        TODO("Not yet implemented")
    }
    /* override fun onClick(p0: View?) {
         when(p0?.id){
             R.id.btnIncreaseCart ->{
                 if (count < 20)
                     count++
                 dataObj.itemCount = count.toString()
                 itemCount.text = count.toString()
             }
             R.id.btnDecreaseCart ->{
                 if (count > 0)
                     count--
                 dataObj.itemCount = count.toString()
                 itemCount.text = count.toString()
             }
             R.id.cartBackBtn ->{
                 val returnIntent = Intent()
                 var bundle = Bundle()
                 bundle.putParcelable("returnBundle",dataObj)
                 returnIntent.putExtra("resultIntent",bundle)
                 setResult(Activity.RESULT_OK,returnIntent)
                 finish()
             }
         }
         itemCount.text = count.toString()
     }*/
}
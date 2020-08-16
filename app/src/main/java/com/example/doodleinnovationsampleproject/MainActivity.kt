package com.example.doodleinnovationsampleproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_activity_select_items.*

class MainActivity : AppCompatActivity(),RecyclerViewClickInterface {
    var count = 0
    var name =  ""
    var dataObject  : DataObject? = DataObject()
    var userDataObj : UserCartData = UserCartData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_select_items)
        loadData()
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerView.adapter = RecyclerViewAdapter(loadData(),this)
        var itemsCartCount = String.format(resources.getString(R.string.cart_items), userDataObj.userCartItemCount)
        cartItemsCount.text = itemsCartCount

        viewCartTextView.setOnClickListener {
            userDataObj.userCartItemName = "Guac de la Costa"
            userDataObj.userCartItemSubName = "tortilas de mais, fruit de la passion , mango"
            userDataObj.userCartItemCount = userDataObj.userCartItemCount
            val intent = Intent(this,MyCartActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("userDataObj",userDataObj)
            intent.putExtra("bundle",bundle)
            startActivityForResult(intent,1)
            Log.e("data","count : "+dataObject?.itemCount)
            Log.e("data","itemName : "+dataObject?.itemName)
        }

      /*  btnCountDecrease.setOnClickListener(this)
        btnCountIncrease.setOnClickListener(this)
        myCart.setOnClickListener(this)
        dataObject = DataObject()*/
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
      Toast.makeText(this,"onItemClick",Toast.LENGTH_LONG).show()
    }

    override fun onLongItemClick(position: Int) {
        TODO("Not yet implemented")
    }










    /* override fun onClick(p0: View?) {
         when(p0?.id){
             R.id.btnCountIncrease ->{
                 if (count < 20)
                     count++
                 name = editText.text.toString()
                 textView.text  = name
                 dataObject?.itemCount = count.toString()
                 dataObject?.itemName = name
             }
             R.id.btnCountDecrease ->{
                 if (count > 0)
                      count--
                 dataObject?.itemCount = count.toString()
             }
             R.id.myCart ->{
                 val intent = Intent(this,MyCartActivity::class.java)
                 val bundle = Bundle()
                 bundle.putParcelable("dataObject",dataObject)
                 intent.putExtra("bundle",bundle)
                 startActivityForResult(intent,1)
                 Log.e("data","count : "+dataObject?.itemCount)
                 Log.e("data","itemName : "+dataObject?.itemName)
             }
         }
         textViewCount.text = count.toString()
     }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if (requestCode == 1){
             if (resultCode == Activity.RESULT_OK){
                 var bundle = data?.getBundleExtra("resultIntent")
                 dataObject =  bundle?.getParcelable<DataObject>("returnBundle") as DataObject
                 count = dataObject?.itemCount!!.toInt()
                 textViewCount.text = count.toString()
             }
         }
     }*/

}
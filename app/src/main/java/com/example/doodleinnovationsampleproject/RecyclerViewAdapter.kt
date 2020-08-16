package com.example.doodleinnovationsampleproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_cart_activity.view.*
import kotlinx.android.synthetic.main.recycler_row_list_items.view.*

class RecyclerViewAdapter(var items : ArrayList<DataObject>,var clickListener : RecyclerViewClickInterface) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row_list_items,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataObj = items[position]
       /* holder.itemHeaderName.text = items[position].itemName
        holder.itemSubTextName.text = items[position].itemSubName
        holder.itemHeaderCount.text = items[position].itemCount*/
        holder.initilize(items[position],clickListener)

    }



    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var dataObject : UserCartData = UserCartData()
        var count = 0
        var itemHeaderName = itemView.itemName
        var itemSubTextName = itemView.itemSubTextName
        var itemHeaderCount = itemView.itemCount
        var addItem = itemView.addItemBtn
        var itemInc = itemView.plusBtn
        var itemDec = itemView.minusBtn
        var itemCount = itemView.itemCountIncDec

        fun initilize(obj : DataObject, action: RecyclerViewClickInterface){
          /*  itemHeaderName.text = obj.itemName
            itemSubTextName.text = obj.itemSubName
            itemHeaderCount.text = obj.itemCount*/
            itemView.setOnClickListener {
                action.onItemClick(obj,adapterPosition)
            }
            if (count == 0){
                itemView.addItemBtn.visibility = View.VISIBLE
                itemView.minusBtn.visibility = View.INVISIBLE
                itemView.plusBtn.visibility = View.INVISIBLE
                itemView.itemCountIncDec.visibility = View.INVISIBLE
                addItem.setOnClickListener(this)
            }



        }

        override fun onClick(p0: View?) {
            when(p0?.id){

                R.id.addItemBtn ->{
                    if (count == 0)
                         count = 1

                    if(count > 0){
                        itemView.addItemBtn.visibility = View.INVISIBLE
                        itemView.plusBtn.visibility = View.VISIBLE
                        itemView.minusBtn.visibility = View.VISIBLE
                        itemView.itemCountIncDec.visibility = View.VISIBLE
                        itemInc.setOnClickListener(this)
                        itemDec.setOnClickListener(this)
                    }
                    itemCount.text = count.toString()
                    dataObject.userCartItemCount = count.toString()


                }
                R.id.plusBtn ->{
                    if (count < 20)
                        count++
                    itemCount.text = count.toString()
                    dataObject.userCartItemCount = count.toString()
                }
                R.id.minusBtn ->{
                    if (count > 0)
                        count--
                    if (count == 0){
                        itemView.addItemBtn.visibility = View.VISIBLE
                        itemView.minusBtn.visibility = View.INVISIBLE
                        itemView.plusBtn.visibility = View.INVISIBLE
                        itemView.itemCountIncDec.visibility = View.INVISIBLE
                        addItem.setOnClickListener(this)
                    }
                    itemCount.text = count.toString()
                    dataObject.userCartItemCount = count.toString()
                }
            }
        }


    }


}



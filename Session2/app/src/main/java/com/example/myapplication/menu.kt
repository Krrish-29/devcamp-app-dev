package com.example.myapplication

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class menu {
    fun customMenu(context: Context, view: View){
        val pop= PopupMenu(context,view)
        pop.inflate(R.menu.menu)

        pop.setOnMenuItemClickListener {
            when (it!!.itemId) {
                R.id.first -> {
                    Toast.makeText(context, "clicked first ", Toast.LENGTH_LONG).show()
                    true
                }

                R.id.second -> {
                    Toast.makeText(context, "clicked second", Toast.LENGTH_LONG).show()
                    true
                }

                R.id.third -> {
                    Toast.makeText(context, "clicked third ", Toast.LENGTH_LONG).show()
                    true
                }

                else -> false
            }
        }
            try{
                val FirstPop= PopupMenu::class.java.getDeclaredField("popUp")
                FirstPop.isAccessible=true
                val popUp=FirstPop.get(pop)
                popUp.javaClass
                    .getDeclaredMethod("showIcon", Boolean::class.java)
                    .invoke(popUp,true)
            }catch(e:Exception){

            }
            finally {
                pop.show()
            }
    }
}
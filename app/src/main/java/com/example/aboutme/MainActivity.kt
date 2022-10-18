package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //let's create a variable for binding operations
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //let's bind our data and main activity
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

      /*  val btn=findViewById<Button>(R.id.done_button)
        btn.setOnClickListener {
            addNickName(it)
        }*/
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view:View){
       /* val editText=findViewById<EditText>(R.id.nickName_edit)
        val nickNameTextView=findViewById<TextView>(R.id.nickName_text)
        nickNameTextView.text=editText.text
        editText.visibility=View.GONE
        view.visibility=View.GONE
        nickNameTextView.visibility=View.VISIBLE
        */
        binding.nickNameText.text=binding.nickNameEdit.text
        binding.nickNameEdit.visibility=View.GONE
        view.visibility=View.GONE
        binding.nickNameText.visibility=View.VISIBLE
        //also below given method can do same funcitionality as above
        //code
        /*
        binding.apply {
            nickNameText.text=binding.nickNameEdit.text
            invalidateAll()
           nickNameEdit.visibility=View.GONE

            nickNameText.visibility=View.VISIBLE
        }
        view.visibility=View.GONE
        */
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }

}
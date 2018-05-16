package com.idev.verly.kotlinapp2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


var counter =0
var total = 0
var toppingPrice=0
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        var name = etName.text.toString()
        when(v){
            btnInrement ->{
                txtDisplay.text = "${++counter}"
            }
            btnDecrement ->{
                if (counter>0){
                    txtDisplay.text = "${--counter}"
                }
            }
            btnOrder -> {
                if(name.isEmpty()){
                    Toast.makeText(this,"Please Fill Your Name First",Toast.LENGTH_SHORT).show()
                }else if(counter==0){
                    Toast.makeText(this,"Order at Least 1",Toast.LENGTH_SHORT).show()
                }else{
                    total = counter*5
                    toppingPrice = CalculateTopping(counter)
                    show(counter,name,total, toppingPrice)
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInrement.setOnClickListener(this)
        btnDecrement.setOnClickListener(this)
        btnOrder.setOnClickListener(this)
    }

    fun show(counter:Int,name:String,price:Int,topping:Int){
        txtOutput.text = "Number of Coffee: ${counter} \n" +
                "Customer Name: ${name} \n" +
                "Coffe Price: ${price} \n" +
                "Topping Price: ${topping} \n" +
                "Total: ${price+topping} \n" +
                "Thank You"

    }

    fun CalculateTopping(counter:Int):Int{
        var cprice = 0
        if (rBtnWhippedCream.isChecked){
            cprice = (counter*2)
        }else if (rBtnChocolate.isChecked){
            cprice = (counter*1)
        }
        return cprice
    }
}




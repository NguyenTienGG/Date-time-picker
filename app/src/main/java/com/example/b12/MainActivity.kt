package com.example.b12

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b12.databinding.ActivityMainBinding
import java.util.Calendar


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    val today = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnTime.setOnClickListener{

            val startHour = today.get(Calendar.HOUR_OF_DAY)
            val startMinute = today.get(Calendar.MINUTE)
            //timepicker
            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                binding.txtTime.setText("$hourOfDay:$minute")
            },startHour,startMinute,true).show()// cài đặt chọn h khi hiện thị
        }

        // date picker
        binding.btnDate.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                binding.txtDate.setText("$year/${month+1}/$dayOfMonth")

            },2002,9,6).show()
//
        }
    }
}
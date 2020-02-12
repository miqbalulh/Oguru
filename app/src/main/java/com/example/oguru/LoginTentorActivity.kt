package com.example.oguru

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.oguru.Model.TentorModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class LoginTentorActivity : AppCompatActivity() {

    lateinit var SP: SharedPreferences
    lateinit var alertDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SP = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val status = SP.getString("STATUS","")
        if(status == "login"){
            startActivity(Intent(applicationContext, DashboardTentor::class.java))
            finish()
        }

        val btnLogin = findViewById<Button>(R.id.signin_button)
        val user = findViewById<EditText>(R.id.formusername)
        val pass = findViewById<EditText>(R.id.formpassword)

        btnLogin.setOnClickListener {
            if(user.text.toString().isEmpty()){
                user.error = "Username kosong"
                user.requestFocus()
                return@setOnClickListener
            }
            if(pass.text.toString().isEmpty()){
                pass.error = "Password kosong"
                pass.requestFocus()
                return@setOnClickListener
            }
            loginAkun()
        }

    }

    private fun loginAkun(){
        val user = formusername.text.toString()
        val pass = formpassword.text.toString()
        SP = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val query = FirebaseDatabase.getInstance().reference.child("tentor").orderByChild("username").equalTo(user)
        query.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for(u in dataSnapshot.children){
                        val userBean = u.getValue(TentorModel::class.java)
                        if(userBean!!.equals(pass)){
                            val editor = SP.edit()
                            editor.putString("STATUS", "login")
                            editor.apply()

                            val intent = Intent(applicationContext, DashboardTentor::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(applicationContext, "Password salah", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else{
                    Toast.makeText(applicationContext, "Username salah", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onBackPressed() {
        alertDialog = AlertDialog.Builder(this)
        Toast.makeText(this, "Back is Clicked", Toast.LENGTH_SHORT)
        alertDialog.setTitle("Close Application")
        alertDialog.setMessage("Apakah anda mau keluar dari aplikasi ?")
            .setCancelable(false)
            .setPositiveButton("YA", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        finishAffinity()
                    }
                }
            })

            .setNegativeButton("TIDAK", object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, id: Int) {
                    dialog?.cancel()
                }
            }).create().show()
    }
}

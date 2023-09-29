package com.tp.cbon

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tp.cbon.ui.theme.CbonTheme

class MainActivity : ComponentActivity() {
    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val selectedImage: Uri? = result.data?.data
            if (selectedImage != null) {
                val inputStream = contentResolver.openInputStream(selectedImage)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                val imageView = findViewById<ImageView>(R.id.imageView)
                imageView.setImageBitmap(bitmap)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        lateinit var txtEmail : EditText
        txtEmail = findViewById(R.id.email)
        lateinit var txtPassword : EditText
        txtPassword = findViewById(R.id.password)
        val duration = Toast.LENGTH_SHORT
        lateinit var btnLogin : Button
        btnLogin = findViewById(R.id.connectButton)
        btnLogin.setOnClickListener { view ->
        var email = txtEmail.text.toString()
        var password = txtPassword.text.toString()
            var toastText="Email: $email ou mot de passe: $password sont incorrectes! "
                val intent = Intent(view.context,WelcomeActivity::class.java)
                intent.putExtra("email",email)
            if(email == "gl4@insat.tn" && password == "insat2023"){
                toastText="Bienvenue ! "
                startActivity(intent)


            }
            val toast = Toast.makeText(this,toastText , duration)
            toast.show()

        }

        val loadButton = findViewById<Button>(R.id.loadBtn)
        loadButton.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImage.launch(galleryIntent)
        }







    }
}





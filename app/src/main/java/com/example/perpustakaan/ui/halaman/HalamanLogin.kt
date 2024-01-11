package com.example.perpustakaan.ui.halaman

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.perpustakaan.R
import com.example.perpustakaan.navigation.DestinasiNavigasi
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

object DestinasiHome : DestinasiNavigasi {
    override val route = "Home"
    override val titleRes = "Pilih"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanHome(
    navController: NavController
) {
    val context = LocalContext.current
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selamat Datang",
            color = colorResource(id = R.color.brown),
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 25.dp)
        )
        Text(
            text = "Silahkan login !",
            color = colorResource(id = R.color.brown),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 50.dp, top = 20.dp)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = emailText,
            onValueChange = { emailText = it },
            label = { Text(text = "Email", color = colorResource(id = R.color.white))},
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon",
                        tint = colorResource(id = R.color.white)
                        )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                colorResource(id = R.color.white),
                focusedBorderColor = colorResource(id = R.color.white),
                unfocusedBorderColor = colorResource(id = R.color.lightgrey),
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(vertical = 5.dp)
        )
        OutlinedTextField(value = passwordText,
            onValueChange = {passwordText = it},
            label = { Text(text = "Password", color = colorResource(id = R.color.white))},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Pass Icon",
                        tint = colorResource(id = R.color.white)
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                colorResource(id = R.color.white),
                focusedBorderColor = colorResource(id = R.color.white),
                unfocusedBorderColor = colorResource(id = R.color.lightgrey),
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding( vertical = 5.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { (
                    auth.signInWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navController.navigate(DestinasiUtama.route)
                                Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                Color.White
            )
        )
        {
            Text(text = "Sign in", color = colorResource(id = R.color.black))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
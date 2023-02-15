package com.example.myapplication99974

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication99974.ui.theme.Purple500

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable

fun LoginPage(navController: NavController) {

        val context = LocalContext.current
        val scaffoldState = rememberScaffoldState()
        val emailVal = remember { mutableStateOf("") }
        val passwordVal = remember { mutableStateOf("") }

        val passwordVisiblity = remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize().background(color = Color.White), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier.background(Color.White),
                    contentAlignment = Alignment.TopCenter
                ) {

                }

                Spacer(modifier = Modifier.padding(20.dp))


                Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(25.dp))
                            .background(Color.White)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Sign In",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.padding(20.dp))


                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            OutlinedTextField(
                                value = emailVal.value,
                                onValueChange = { emailVal.value = it },
                                label = { Text(text = "Email Address", color = Color.Black) },
                                placeholder = { Text(text = "Email Address", color = Color.Black) },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(0.8f),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                                )
                            )

                            OutlinedTextField(
                                value = passwordVal.value,
                                onValueChange = { passwordVal.value = it },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Color.Black, textColor = Color.Black
                                ),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        passwordVisiblity.value = !passwordVisiblity.value
                                    }) {

                                    }
                                },
                                label = { Text(text = "Password", color = Color.Black) },
                                placeholder = { Text(text = "Password", color = Color.Black) },
                                singleLine = true,
                                visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )

                            Spacer(modifier = Modifier.padding(20.dp))

                            Button(
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                                onClick = {
                                    when {
                                        emailVal.value.isEmpty() -> {
                                            Toast.makeText(
                                                context,
                                                "Please enter email address!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                        passwordVal.value.isEmpty() -> {
                                            Toast.makeText(
                                                context,
                                                "Please enter the password!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                        else -> {
                                            Toast.makeText(
                                                context,
                                                "Logged Successfully!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                    }

                                }, modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(50.dp)
                            ) {
                                Text(text = "Sign In", fontSize = 20.sp,color = Color.Black)
                            }

                            Spacer(modifier = Modifier.padding(20.dp))

                            Text(text = "Create an Account?", color = Color.Black,
                                modifier = Modifier.clickable { navController.navigate("RegistrationPage") })

                            Spacer(modifier = Modifier.padding(20.dp))

                        }
                    }
                }

            }


        }


}


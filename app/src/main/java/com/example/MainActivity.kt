package com.example.voicechanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VoiceChangerScreen() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceChangerScreen() {
    val voices = listOf("Natural Female", "Soft Female", "Bright Female", "Deep Female")
    var selected by remember { mutableStateOf(voices[0]) }
    var number by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Ready — calling and voice conversion are not connected yet") }

    MaterialTheme {
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
            Column(
                Modifier.fillMaxSize().padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(Modifier.height(12.dp))
                Text("VOICE CHANGER", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Male → Female", color = MaterialTheme.colorScheme.primary, fontSize = 17.sp)
                Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("Choose female voice", fontWeight = FontWeight.SemiBold)
                        voices.forEach { voice ->
                            Row(
                                Modifier.fillMaxWidth().selectable(selected == voice, onClick = { selected = voice }).padding(vertical = 7.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected == voice, onClick = { selected = voice })
                                Spacer(Modifier.width(8.dp))
                                Text(voice)
                            }
                        }
                    }
                }
                OutlinedTextField(
                    value = number,
                    onValueChange = { number = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Phone number") },
                    placeholder = { Text("Enter number with country code") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true
                )
                Button(onClick = { status = "Demo only: calling service is not connected" }, modifier = Modifier.fillMaxWidth().height(52.dp)) {
                    Text("CALL")
                }
                OutlinedButton(onClick = { status = "Call ended (demo)" }, modifier = Modifier.fillMaxWidth()) { Text("END CALL") }
                Text(status, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
                Spacer(Modifier.weight(1f))
                Text("Prototype UI only • No call is placed • No audio is transformed", fontSize = 11.sp, color = MaterialTheme.colorScheme.error)
            }
        }
    }
}

package com.mridhop.waterbottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mridhop.waterbottle.ui.theme.WaterBottleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBottleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        var usedAmount by remember {
                            mutableStateOf(400)
                        }
                        val totalWaterAmount = remember {
                            2400
                        }
                        val unit = "ml"

                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = unit,
                            usedWaterAmount = usedAmount,
                            modifier = Modifier.width(256.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is: $totalWaterAmount $unit")
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = { usedAmount += 200 }) {
                            Text(text = "Drink")
                        }
                    }
                }
            }
        }
    }
}
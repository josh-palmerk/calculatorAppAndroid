package com.example.calculatorappandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
// import androidx.compose.foundation.layout.FlowRowScopeInstance.weight

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorappandroid.ui.theme.CalculatorAppAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("User")
//                    var display = DisplayBox(text = "12345")
//                    ButtonGrid()
                    AllGrids(displayText = "testing")
                    // ButtonGrid()
                }
            }
        }
    }
}
@Composable
fun AllGrids(displayText: String){
    Row(modifier = Modifier.fillMaxWidth()) {
//        DisplayBox(text = displayText)
//        ButtonGrid()
//    }
        LazyVerticalGrid(
            columns = GridCells.Fixed(1,),
            modifier = Modifier.weight(1f)
        ) {
            item {
                Text(
                    text = displayText,
                    Modifier.border(8.dp, Color.Black, RectangleShape,),
                    fontSize = 36.sp,
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)

        ) {
            item { num_button(text = "1") }
            item { num_button(text = "2") }
            item { num_button(text = "3") }
            item { num_button(text = "4") }
            item { num_button(text = "5") }
            item { num_button(text = "6") }
            item { num_button(text = "7") }
            item { num_button(text = "8") }
            item { num_button(text = "9") }
            item { num_button(text = "0") }
            item { op_button(text = "+") }
            item { op_button(text = "-") }
            item { op_button(text = "=") }
        }
    }
}
// input handler
class InputHandler() {
    var firstOperand = "";
    var secondOperand = "";
    @Composable
    fun UpdateDisplayBox(text: String){
        AllGrids(displayText = text)
    }

    fun AddNumber(number: Int){
        //secondOperand.
    }

    fun EqualsDisplay(){
        // TODO
    }
}





// composable textbox
@Composable
fun DisplayBox(text: String){
    LazyVerticalGrid(columns = GridCells.Fixed(1,),
//    modifier = Modifier.weight(1f)
    ) {
        item {Text(
            text = text,
            Modifier.border(8.dp, Color.Black, RectangleShape,),
            fontSize = 36.sp,
        )}
    }

}



//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CalculatorAppAndroidTheme {
//        Greeting("Android")
//        ButtonGrid()
//    }
//}

enum class MathOperationType {
    ADD, SUBTRACT
}

typealias MathOperation = (Double, Double) -> Double

val OpMap = mapOf<MathOperationType, MathOperation>(
    MathOperationType.ADD to {a, b -> a + b},
    MathOperationType.SUBTRACT to {a, b -> a - b}
)


@Composable
fun num_button(text: String ){
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, Color.Black),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.LightGray,
        ),
        //modifier = Modifier.weight(1f)
    ) {
        Text(text = text)

    }
}

@Composable
fun op_button(text: String ){
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, Color.Black),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.Yellow,
        )
    ) {
        Text(text = text)

    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    CalculatorAppAndroidTheme {
        num_button(text = "9")
        op_button(text = "+")
    }
}

@Composable
fun ButtonGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        item { num_button(text = "1")}
        item { num_button(text = "2")}
        item { num_button(text = "3")}
        item { num_button(text = "4")}
        item { num_button(text = "5")}
        item { num_button(text = "6")}
        item { num_button(text = "7")}
        item { num_button(text = "8")}
        item { num_button(text = "9")}
        item { num_button(text = "0")}
        item { op_button(text = "+")}
        item { op_button(text = "-")}
        item { op_button(text = "=")}
    }
}
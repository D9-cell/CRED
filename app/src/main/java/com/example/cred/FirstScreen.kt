package com.example.cred

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstBottomSheet(
    onDismiss: () -> Unit,
    showSecondBottomSheet: () -> Unit,
    showBackgroundRow: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(750.dp)
            .background(
                color = colorResource(id = R.color.firstScreenBG),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(horizontal = 16.dp)
    ) {
        // Conditionally display the background row
        if (showBackgroundRow) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Credit Amount",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "₹ 150000",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(Modifier.width(220.dp))
                IconButton(onClick = { /* Handle back action if needed */ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

            }
        }

        // Existing Title Text
        Text(
            text = "nikunj, how much do you need?",
            color = colorResource(id = R.color.heading),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.Start)
        )

        // Existing Subtitle Text
        Text(
            text = "move the dial and set any amount you need upto ₹",
            color = colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )

        // Existing Amount Display
        Text(
            text = "487891",
            color = colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )

        // Existing Card View
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularSlider(
                        modifier = Modifier.size(300.dp),
                    )
                    Column(modifier = Modifier.align(Alignment.Center)) {
                        Row {
                            Spacer(modifier = Modifier.width(40.dp))
                            Text("Credit Amount", color = Color.Gray,)
                        }
                        Text("₹ 1,50,000", style = MaterialTheme.typography.displaySmall, color = Color.Black)
                        Row {
                            Spacer(modifier = Modifier.width(38.dp))
                            Text("@1.04% monthly", color = colorResource(id = R.color.green), style = MaterialTheme.typography.bodySmall)
                        }

                    }

                }

            }
        }


        Spacer(modifier = Modifier.weight(1f))

        // Existing Button that opens second bottom sheet
        Button(
            onClick = { showSecondBottomSheet() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.firstScreenBtn),   // Background color
                contentColor = Color.White     // Text/Icon color
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Proceed to EMI selection")
        }
    }
}

@Composable
fun SecondBottomSheet(
    onDismiss: () -> Unit,
    showThirdBottomSheet: () -> Unit,
    showBackgroundRow: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(680.dp)
            .background(
                color = colorResource(id = R.color.secondScreenBG),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(horizontal = 16.dp)

    ) {

        // Conditionally display the background row
        if (showBackgroundRow) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "EMI",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "₹ 4,247 /mo",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(Modifier.width(95.dp))
                Column {
                    Text(
                        text = "duration",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "12 months",
                        color = colorResource(id = R.color.heading),
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(Modifier.width(50.dp))
                IconButton(onClick = { /* Handle back action if needed */ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

            }
        }
        // Existing Title Text
        Text(
            text = "How do you wish to repay?",
            color = colorResource(id = R.color.heading),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.Start)
        )

        // Existing Subtitle Text
        Text(
            text = "Choose one of your recommended plans or make your",
            color = colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "own",
            color =colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )

        CustomScrollableCards()

        // Existing Button Below Cards
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondScreenBG),   // Background color
                contentColor = colorResource(id = R.color.heading)     // Text/Icon color
            ),
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 8.dp)
                .height(50.dp)
                .border(2.dp, colorResource(id = R.color.customGray), RoundedCornerShape(16.dp))
        ) {
            Text("Create your own plan")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Existing Bottom Button with Rounded Top Corners
        Button(
            onClick = { showThirdBottomSheet() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.firstScreenBtn),   // Background color
                contentColor = Color.White     // Text/Icon color
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Select Your Bank Account")
        }
    }
}

@Composable
fun ThirdBottomSheet(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(610.dp)
            .background(
                color = colorResource(id = R.color.thirdScreenBG),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(horizontal = 16.dp)

    ) {
        // Existing Title Text
        Text(
            text = "Where should we send the money?",
            color = colorResource(id = R.color.heading),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.Start)
        )

        // Existing Subtitle Text
        Text(
            text = "Amount will be credit to this bank account, EMI will",
            color = colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )
        Text(
            text = "also be debited from this bank account",
            color = colorResource(id = R.color.customGray),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.Start)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Image (Picture)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp)), // Background for the Box
                contentAlignment = Alignment.Center // Center the Image inside the Box
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // Replace with your image resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(32.dp) // Set the Image size smaller than the Box
                        .background(Color.White, shape = RoundedCornerShape(8.dp)) // Image shape
                )
            }


            // Column with Two TextViews
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f) // Takes available space
            ) {
                Text(
                    text = "Paytm Payments Bank",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = "919935670475",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            // Right Image with Rounded Shape and Gray Color
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        colorResource(id = R.color.customGray),
                        shape = RoundedCornerShape(50)
                    ) // Rounded and filled with gray
            ) {
                // Optionally, add content here like an icon
            }
        }


        // Existing Button Below Cards
        Button(
            onClick = { /* Action */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.thirdScreenBG),   // Background color
                contentColor = colorResource(id = R.color.heading)     // Text/Icon color
            ),
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 8.dp)
                .height(50.dp)
                .border(2.dp, colorResource(id = R.color.customGray), RoundedCornerShape(16.dp))
        ) {
            Text("Change account")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Existing Bottom Button with Rounded Top Corners
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.thirdScreenBtn),   // Background color
                contentColor = Color.White     // Text/Icon color
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Select Your Bank Account")
        }
    }
}

@Composable
fun FirstScreen() {
    // State to control visibility of the first and second bottom sheets
    val showFirstBottomSheet = remember { mutableStateOf(true) }
    val showSecondBottomSheet = remember { mutableStateOf(false) }
    val showThirdBottomSheet = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        // Top Left IconButton
        IconButton(
            onClick = {
                // Handle left button click
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .background(
                    colorResource(id = R.color.customGray),
                    shape = RoundedCornerShape(16.dp)
                )
                .size(25.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close, // Replace with your desired icon
                contentDescription = "Back",
                tint = Color.White
            )
        }

        // Top Right IconButton
        IconButton(
            onClick = {
                // Handle right button click
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .background(
                    colorResource(id = R.color.customGray),
                    shape = RoundedCornerShape(16.dp)
                )
                .size(25.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Settings, // Replace with your desired icon
                contentDescription = "Settings",tint = Color.White
            )
        }

        // Floating Action Button to open the first bottom sheet
        FloatingActionButton(
            onClick = { showFirstBottomSheet.value = true },
            containerColor = MaterialTheme.colorScheme.primary,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text(text = "+")
        }

        // Show Custom Bottom Sheet
        if (showFirstBottomSheet.value) {

            BackHandler {
                showFirstBottomSheet.value = false
            }
            Box(
                modifier = Modifier
                    .fillMaxSize() // Cover the entire screen for outside click detection
                    .clickable(
                        onClick = {
                            showFirstBottomSheet.value = false
                        }, // Handle click outside to dismiss
                        indication = null, // Remove the default ripple effect
                        interactionSource = remember { MutableInteractionSource() } // Prevent default feedback
                    )
                    .align(Alignment.BottomCenter)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .wrapContentHeight()
                ) {
                    FirstBottomSheet(
                        onDismiss = { showFirstBottomSheet.value = false },
                        showSecondBottomSheet = { showSecondBottomSheet.value = true },
                        showBackgroundRow = showSecondBottomSheet.value // Show row only when second BottomSheet is open
                    )
                }
            }

        }

        // Show Second Bottom Sheet if the button in the first bottom sheet is clicked
        if (showSecondBottomSheet.value) {

            BackHandler {
                showSecondBottomSheet.value = false
            }
            Box(
                modifier = Modifier
                    .fillMaxSize() // Cover the entire screen for outside click detection
                    .clickable(
                        onClick = {
                            showSecondBottomSheet.value = false
                        }, // Handle click outside to dismiss
                        indication = null, // Remove the default ripple effect
                        interactionSource = remember { MutableInteractionSource() } // Prevent default feedback
                    )
                    .align(Alignment.BottomCenter)
            ) {
                // Inner Box for the SecondBottomSheet
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .wrapContentHeight()
                        .background(color = colorResource(id = R.color.firstScreenBG)) // Optional: Add background color to the sheet
                ) {
                    SecondBottomSheet(
                        onDismiss = { showSecondBottomSheet.value = false },
                        showThirdBottomSheet = { showThirdBottomSheet.value = true },
                        showBackgroundRow = showThirdBottomSheet.value
                    )
                }
            }
        }


        // Show Third Bottom Sheet if the button in the second bottom sheet is clicked
        if (showThirdBottomSheet.value) {
            // Add BackHandler to handle back button press
            BackHandler {
                showThirdBottomSheet.value = false
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = {
                        showThirdBottomSheet.value = false
                    }, // Handle click outside to dismiss
                        indication = null, // Remove the default ripple effect
                        interactionSource = remember { MutableInteractionSource() }) // Prevent default feedback
                    .align(Alignment.BottomCenter)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .wrapContentHeight()
                ) {
                    ThirdBottomSheet(onDismiss = { showThirdBottomSheet.value = false })
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstScreen() {
    FirstScreen()
}

@Composable
fun CustomScrollableCards() {
    val emiDataList = listOf(
        EmiOptions(1, 4247, 12, colorResource(id = R.color.a),true),
        EmiOptions(2, 5580, 9, colorResource(id = R.color.b),false),
        EmiOptions(3, 8240, 6, colorResource(id = R.color.c),false),
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        emiDataList.forEach { emiOption ->
            CustomCard(
                index = emiOption.index,
                amount = emiOption.amount,
                month = emiOption.month,
                onImageClick = {},
                backgroundColor = emiOption.backgroundColor,
                selected = emiOption.selected
            )
        }
    }
}

@Composable
fun CustomCard(
    index: Int,
    onImageClick: () -> Unit,
    amount: Int,
    month: Int,
    backgroundColor: Color,
    selected: Boolean
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(170.dp)
            .height(170.dp), // Adjust height as needed
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // State to track if the arrow should be shown
            var showArrow by remember { mutableStateOf(selected) }

            Spacer(modifier = Modifier.height(9.dp))
            Row {
                Box(
                    modifier = Modifier
                        .size(30.dp)// Set size to 30.dp
                        .clickable {
                            showArrow = !showArrow // Toggle arrow visibility on click
                            onImageClick() // Handle the image click action
                        }
                        .clip(RoundedCornerShape(30.dp)) // Make the Box rounder
                        .background(colorResource(id = R.color.customGray)), // Background color for visibility
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_3), // Replace with your image resource
                        contentDescription = null,
                        modifier = Modifier.size(30.dp) // Set image size to 30.dp
                    )

                    // Show right arrow if the image is clicked
                    if (showArrow) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(4.dp),// Adjust padding as needed
                            tint = backgroundColor
                        )
                    }
                }
                Spacer(modifier = Modifier.width(120.dp))
            }

            Spacer(modifier = Modifier.size(30.dp))
            Column(modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)) {
                Row() {
                    Text("₹$amount", style = MaterialTheme.typography.titleMedium, color = Color.White)
                    Text(" /mo", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text("for $month months", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                Spacer(modifier = Modifier.size(25.dp))
                Text("See calculations", style = MaterialTheme.typography.bodySmall, color = Color.White)
            }
        }
    }
}
